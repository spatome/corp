/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: DemoServiceImpl.java 
 * @Prject: api-service
 * @Package: com.hengpeng.api.service.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月20日 下午1:00:01 
 * @version: V1.0   
 */
package com.hengpeng.api.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hengpeng.api.constants.ApiConstants;
import com.hengpeng.api.entity.Account;
import com.hengpeng.api.entity.SsqOrder;
import com.hengpeng.api.entity.SsqOrderTemp;
import com.hengpeng.api.enumtype.CodeMessage;
import com.hengpeng.api.enumtype.GameType;
import com.hengpeng.api.enumtype.OrderPrintStatus;
import com.hengpeng.api.enumtype.OrderStatus;
import com.hengpeng.api.exception.SException;
import com.hengpeng.api.service.DemoService;
import com.hengpeng.api.util.ConfigParamUtil;
import com.hengpeng.api.util.LotteryUtil;

/** 
 * @ClassName: DemoServiceImpl 
 * @Description: 测试
 * @author: zhangwei
 * @date: 2017年7月20日 下午1:00:01  
 */
@Transactional
@Service
public class DemoServiceImpl extends AbstractBaseService implements DemoService {

	@Override
	public void batchCreateOrder(String issueNo, int count) throws SException {
		try {
			List<SsqOrder> saveSsqOrderList = new ArrayList<SsqOrder>();
			List<SsqOrderTemp> saveSsqOrderTempList = new ArrayList<SsqOrderTemp>();
			Date curDate = new Date();

			for (int i=0; i<count; i++) {
				String orderNo = LotteryUtil.createOrderNo(GameType.SSQ.toString(), 
						ConfigParamUtil.getProperty(ApiConstants.KXCH_CENTER_USERNAME),
						String.valueOf(serviceFactory.getSeqService().getOrderId())
						);
				//双色球entity
				SsqOrder ssqOrder = new SsqOrder();
				ssqOrder.setCompanyNo("000001");
				ssqOrder.setSsqOrderNo(orderNo);
				ssqOrder.setTicketNo(orderNo);
				ssqOrder.setIssueNo(issueNo);
				ssqOrder.setPlayType("101");
				ssqOrder.setTimes(1);
				ssqOrder.setLotterys("01,02,03,04,05,06#01");
				ssqOrder.setAmount(new BigDecimal("2.00"));
				ssqOrder.setCardNo("320000000000000000");
				ssqOrder.setRealName("校长");
				ssqOrder.setMobile("135123456789");
				ssqOrder.setStatus(OrderStatus.UNDEAL.toString());
				ssqOrder.setDescs(OrderStatus.UNDEAL.getText());
				ssqOrder.setItime(curDate);
				ssqOrder.setUtime(curDate);
				saveSsqOrderList.add(ssqOrder);
				
				//双色球临时表entity
				SsqOrderTemp ssqOrderTemp = new SsqOrderTemp();
				ssqOrderTemp.setCompanyNo("000001");
				ssqOrderTemp.setSsqOrderNo(orderNo);
				ssqOrderTemp.setTicketNo(orderNo);
				ssqOrderTemp.setIssueNo(issueNo);
				ssqOrderTemp.setPlayType("101");
				ssqOrderTemp.setTimes(1);
				ssqOrderTemp.setLotterys("01,02,03,04,05,06#01");
				ssqOrderTemp.setAmount(new BigDecimal("2.00"));
				ssqOrderTemp.setCardNo("320000000000000000");
				ssqOrderTemp.setRealName("校长");
				ssqOrderTemp.setMobile("135123456789");
				ssqOrderTemp.setStatus(OrderPrintStatus.UNPRINT.toString());
				ssqOrderTemp.setDescs(OrderPrintStatus.UNPRINT.getText());
				ssqOrderTemp.setItime(curDate);
				ssqOrderTemp.setUtime(curDate);
				saveSsqOrderTempList.add(ssqOrderTemp);

				int size = saveSsqOrderList.size();
				if (size > 0 && size % 200 == 0) {
					daoFactory.getSsqOrderMapper().batchInsert(saveSsqOrderList);
					saveSsqOrderList.clear();
				}

				int size1 = saveSsqOrderTempList.size();
				if (size1 > 0 && size1 % 200 == 0) {
					daoFactory.getSsqOrderTempMapper().batchInsert(saveSsqOrderTempList);
					saveSsqOrderTempList.clear();
				}
			}
			if(saveSsqOrderList.size()>0){
				daoFactory.getSsqOrderMapper().batchInsert(saveSsqOrderList);
			}
			if(saveSsqOrderTempList.size()>0){
				daoFactory.getSsqOrderTempMapper().batchInsert(saveSsqOrderTempList);
			}
		} catch (Exception e) {
			LOGGER.error("buySsq", e);
			throw new SException(CodeMessage.FAILURE.getCode(), "投注内部异常");
		}
	}
	
	/** 
	 * @Description: TODO
	 * @return 
	 * @see com.hengpeng.api.service.DemoService#hello() 
	 */
	@Override
	public String hello(String name) throws SException {
		Account accountQ = new Account();
		accountQ.setStatus("ACTIVE");
		accountQ.setAccountNo(name);
		List<Account> accountList = daoFactory.getAccountMapper().selectByBean(accountQ);
		for (Account account2 : accountList) {
			return account2.getCurrentBalance().toString();
		}

		return "0.00";
	}

}
