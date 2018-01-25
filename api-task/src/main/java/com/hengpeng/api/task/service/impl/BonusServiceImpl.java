/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: BonusServiceImpl.java 
 * @Prject: api-task
 * @Package: com.hengpeng.api.task.service.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月9日 下午5:01:25 
 * @version: V1.0   
 */
package com.hengpeng.api.task.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hengpeng.api.entity.BonusCollection;
import com.hengpeng.api.entity.PrintIssue;
import com.hengpeng.api.entity.SsqBonus;
import com.hengpeng.api.enumtype.CodeMessage;
import com.hengpeng.api.exception.SException;
import com.hengpeng.api.task.common.message.BonusQueryResponseMessage;
import com.hengpeng.api.task.service.BonusService;

/** 
 * @ClassName: BonusServiceImpl 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月9日 下午5:01:25  
 */
@Transactional
@Service
public class BonusServiceImpl extends AbstractBaseService implements BonusService {

	/** 
	 * @Description: 兑奖
	 * @throws SException 
	 * @see com.hengpeng.api.task.service.BonusService#synBonus() 
	 */
	@Override
	public void synBonus() throws SException {
		try {
			List<PrintIssue> printIssueList = daoFactory.getPrintIssueMapper().selectNeedBonusIssue();

			if(printIssueList.size()<=0){
				return;
			}

			for (PrintIssue f : printIssueList) {
				BonusQueryResponseMessage bonusQueryResponseMessage = serviceFactory.getCenterService().getBonus("SSQ", f.getIssueNo(), String.valueOf(serviceFactory.getSeqService().getMessageId()), "1.1");
				String retCode = bonusQueryResponseMessage.getBody().getResponse().getCode();

				if("0000".equals(retCode)) {
					List<BonusQueryResponseMessage.Body.Response.BonusQueryResult.BonusItem> bonusItemList = bonusQueryResponseMessage.getBody().getResponse().getBonusQueryResult().getBonusItemList();
					BonusQueryResponseMessage.Body.Response.BonusQueryResult.Issue retIssue = bonusQueryResponseMessage.getBody().getResponse().getBonusQueryResult().getIssue();
					String bonusCode = bonusQueryResponseMessage.getBody().getResponse().getBonusQueryResult().getBonusNumber();
					String bonusTotalNum = bonusQueryResponseMessage.getBody().getResponse().getBonusQueryResult().getTotalItems();
					String bonusTotalAmt = bonusQueryResponseMessage.getBody().getResponse().getBonusQueryResult().getTotalMoney();
					
					BonusCollection bonusCollection = new BonusCollection();
					bonusCollection.setIssueNo(retIssue.getNumber());
					bonusCollection.setGameType(retIssue.getGameName());
					bonusCollection.setBonusCode(bonusCode);
					bonusCollection.setCompanyNo("999999");
					bonusCollection.setBonusCount(Integer.valueOf(bonusTotalNum));
					bonusCollection.setBonusAmount(new BigDecimal(bonusTotalAmt));
					daoFactory.getBonusCollectionMapper().insertSelective(bonusCollection);

					List<SsqBonus> saveList = new ArrayList<>();
					for (BonusQueryResponseMessage.Body.Response.BonusQueryResult.BonusItem bonusItem : bonusItemList) {
						SsqBonus ssqBonus = new SsqBonus();
						ssqBonus.setBonusCode(bonusCode);
						ssqBonus.setIssueNo(retIssue.getNumber());
						ssqBonus.setCompanyNo("999999");
						ssqBonus.setSsqOrderNo("11"+bonusItem.getTicketID());
						ssqBonus.setPlayType(bonusItem.getPlayType());
						ssqBonus.setBonusCount(Integer.valueOf(bonusItem.getSize()));
						ssqBonus.setBonusAmount(new BigDecimal(bonusItem.getMoney()));
						ssqBonus.setBonusLevel(bonusItem.getBonusLevel());
						ssqBonus.setBonusLevelAmount(new BigDecimal(bonusItem.getLevelBonusMoney()));
						ssqBonus.setIsBomBonus(bonusItem.getIsBombBonus());
						ssqBonus.setItime(new Date());
						ssqBonus.setVersion(0l);

						saveList.add(ssqBonus);
						int size = saveList.size();
						if (size > 0 && size % 200 == 0) {
							daoFactory.getSsqBonusMapper().batchInsert(saveList);
							saveList.clear();
						}
					}
					if(saveList.size()>0){
						daoFactory.getSsqBonusMapper().batchInsert(saveList);
					}

					PrintIssue printIssueUpdate = new PrintIssue();
					printIssueUpdate.setId(f.getId());
					printIssueUpdate.setIsBonus("YES");
					daoFactory.getPrintIssueMapper().updateByPrimaryKeySelective(printIssueUpdate);
				}
			}
		} catch (Exception e) {
			LOGGER.error("synBonus", e);
			throw new SException(CodeMessage.FAILURE.getCode(), "synBonus 失败:");
		}
	}
}
