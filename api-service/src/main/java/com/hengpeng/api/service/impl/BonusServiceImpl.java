/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: IssueServiceImpl.java 
 * @Prject: api-service
 * @Package: com.hengpeng.api.service.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月24日 下午7:17:32 
 * @version: V1.0   
 */
package com.hengpeng.api.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.hengpeng.api.constants.BusinessConstants;
import com.hengpeng.api.constants.MessageConstant;
import com.hengpeng.api.entity.Issue;
import com.hengpeng.api.entity.SsqBonus;
import com.hengpeng.api.enumtype.CodeMessage;
import com.hengpeng.api.enumtype.GameType;
import com.hengpeng.api.enumtype.IssueType;
import com.hengpeng.api.exception.SException;
import com.hengpeng.api.service.BonusService;
import com.hengpeng.api.util.DateUtil;
import com.hengpeng.api.util.ValidationUtil;
import com.hengpeng.api.vo.BonusDetailRVO;
import com.hengpeng.api.vo.BonusDetailSVO;
import com.hengpeng.api.vo.BonusQueryRVO;
import com.hengpeng.api.vo.BonusQuerySVO;
import com.hengpeng.api.vo.IssueQueryRVO;
import com.hengpeng.api.vo.IssueQuerySVO;

/**
 * @ClassName: IssueServiceImpl
 * @Description: 开奖
 * @author: zhangwei
 * @date: 2017年7月24日 下午7:17:32
 */
@Transactional
@Service
public class BonusServiceImpl extends AbstractBaseService implements BonusService {

	/**
	 * @Description: 查询奖期
	 * @param issueRVo
	 * @return
	 * @throws SException
	 * @see com.hengpeng.api.service.BonusService#queryIssue(com.hengpeng.api.vo.IssueRVo)
	 */
	@Override
	public IssueQuerySVO queryIssue(IssueQueryRVO issueQueryRVO) throws SException {
		IssueQuerySVO result = new IssueQuerySVO();

		try {
			if(StringUtils.isEmpty(issueQueryRVO.getIssueNo())){
				//默认在售
				Issue issueQ = new Issue();
				issueQ.setIssueType(IssueType.SALING.toString());
				List<Issue> issueList = daoFactory.getIssueMapper().selectByBean(issueQ);

				if(issueList.size()==0){
					throw new SException(MessageConstant.TRANSACTION_RESPONSE_CODE_1009, "奖期不存在");
				}else if(issueList.size()>1){
					LOGGER.error("=========================================");
					LOGGER.error("在售奖期超过1个");
					LOGGER.error("=========================================");
				}
				for (Issue f : issueList) {
					result.setIssueNo(f.getIssueNo());
					result.setGameType(f.getGameType());
					result.setStartTime(DateUtil.formatDate(f.getStartTime()));
					result.setStopTime(DateUtil.formatDate(f.getStopTime()));
					result.setOfficialStartTime(DateUtil.formatDate(f.getOfficialStartTime()));
					result.setOfficialStopTime(DateUtil.formatDate(f.getOfficialStopTime()));
					result.setBonusCode(f.getBonusCode());
					result.setIssueType(f.getIssueType());
				}
			}else{
				//指定奖期
				Issue issueQ = new Issue();
				issueQ.setGameType(issueQueryRVO.getGameType().toString());
				issueQ.setIssueNo(issueQueryRVO.getIssueNo());
				List<Issue> issueList = daoFactory.getIssueMapper().selectByBean(issueQ);

				if(issueList.size()==0){
					throw new SException(MessageConstant.TRANSACTION_RESPONSE_CODE_1009, "奖期不存在");
				}
				
				for (Issue f : issueList) {
					result.setIssueNo(f.getIssueNo());
					result.setGameType(f.getGameType());
					result.setStartTime(DateUtil.formatDate(f.getStartTime()));
					result.setStopTime(DateUtil.formatDate(f.getStopTime()));
					result.setOfficialStartTime(DateUtil.formatDate(f.getOfficialStartTime()));
					result.setOfficialStopTime(DateUtil.formatDate(f.getOfficialStopTime()));
					result.setBonusCode(f.getBonusCode());
					result.setIssueType(f.getIssueType());
				}
			}
		} catch (SException e) {
			LOGGER.error("queryIssue", e);
			throw e;
		} catch (Exception e) {
			LOGGER.error("queryIssue", e);
			throw new SException(CodeMessage.FAILURE.getCode(), "查询奖期内部异常");
		}

		return result;
	}

	public void verify(BonusQueryRVO bonusQueryRVO) throws SException {
		ValidationUtil.ValidationResult vr = ValidationUtil.validateEntity(bonusQueryRVO);

		if(vr.isHasErrors()){
			throw new SException(CodeMessage.FAILURE.getCode(), vr.getErrorMsg().toString());
		}
	};
	
	/**
	 * @Description: 查询中奖信息
	 * @param bonusRVo
	 * @return
	 * @throws SException
	 * @see com.hengpeng.api.service.BonusService#queryBonus(com.hengpeng.api.vo.BonusRVo)
	 */
	@Override
	public BonusQuerySVO queryBonus(BonusQueryRVO bonusQueryRVO) throws SException {
		this.verify(bonusQueryRVO);
		
		BonusQuerySVO result = new BonusQuerySVO();

		try {
			if (GameType.SSQ.equals(GameType.valueOf(bonusQueryRVO.getGameType()))) {
				// 双色球
				SsqBonus ssqBonusQ = new SsqBonus();
				ssqBonusQ.setCompanyNo(StringUtils.trimToEmpty(bonusQueryRVO.getEnterpriseNo()));
				ssqBonusQ.setIssueNo(StringUtils.trimToEmpty(bonusQueryRVO.getIssueNo()));
				List<SsqBonus> ssqBonusList = daoFactory.getSsqBonusMapper().selectBonus(ssqBonusQ);

				for (SsqBonus f : ssqBonusList) {
					result.setBonusCode(StringUtils.trimToEmpty(f.getBonusCode()));
					result.setBonusCount(f.getBonusCount()==null?"0":String.valueOf(f.getBonusCount()));
					result.setBonusAmount(f.getBonusAmount()==null?"0.00":f.getBonusAmount().toString());
				}
			} else {
				throw new SException(MessageConstant.TRANSACTION_RESPONSE_MESSAGE_9999, bonusQueryRVO.getGameType() + ":未实现");
			}
		} catch (SException e) {
			LOGGER.error("queryBonus", e);
			throw e;
		} catch (Exception e) {
			LOGGER.error("queryBonus", e);
			throw new SException(CodeMessage.FAILURE.getCode(), "中奖信息内部异常");
		}

		return result;
	}

	public void verify(BonusDetailRVO bonusDetailRVO) throws SException {
		ValidationUtil.ValidationResult vr = ValidationUtil.validateEntity(bonusDetailRVO);

		if(vr.isHasErrors()){
			throw new SException(CodeMessage.FAILURE.getCode(), vr.getErrorMsg().toString());
		}
		
		if(StringUtils.isNotBlank(bonusDetailRVO.getPageSize()) && Integer.valueOf(bonusDetailRVO.getPageSize())>BusinessConstants.QUERY_BONUS_LIST_MAX_PAGE_SIZE){
			throw new SException(CodeMessage.FAILURE.getCode(), "pageSize最大"+BusinessConstants.QUERY_BONUS_LIST_MAX_PAGE_SIZE);
		}
	};

	/** 
	 * @Description: 中奖详情
	 * @param bonusListRVo
	 * @param t
	 * @return
	 * @throws SException 
	 * @see com.hengpeng.api.service.BonusService#queryBonusList(com.hengpeng.api.vo.BonusListRVo, java.lang.Object) 
	 */
	@Override
	public BonusDetailSVO queryBonusList(BonusDetailRVO bonusDetailRVO) throws SException {
		this.verify(bonusDetailRVO);
		BonusDetailSVO result = new BonusDetailSVO();

		try {
			if (GameType.SSQ.equals(GameType.valueOf(bonusDetailRVO.getGameType()))) {
				// 双色球
				Issue issueQ = new Issue();
				issueQ.setIssueNo(StringUtils.trimToEmpty(bonusDetailRVO.getIssueNo()));
				List<Issue> issueList = daoFactory.getIssueMapper().selectByBean(issueQ);

				for (Issue issue : issueList) {
					result.setBonusCode(issue.getBonusCode());	
				}

				SsqBonus ssqBonusQ = new SsqBonus();
				ssqBonusQ.setIssueNo(StringUtils.trimToEmpty(bonusDetailRVO.getIssueNo()));
				ssqBonusQ.setCompanyNo(StringUtils.trimToEmpty(bonusDetailRVO.getEnterpriseNo()));
				PageHelper.startPage(StringUtils.isEmpty(bonusDetailRVO.getPageNum())?1:Integer.valueOf(bonusDetailRVO.getPageNum()),
						StringUtils.isEmpty(bonusDetailRVO.getPageSize())?BusinessConstants.QUERY_BONUS_LIST_MAX_PAGE_SIZE:Integer.valueOf(bonusDetailRVO.getPageSize()));
				List<SsqBonus> ssqBonusList = daoFactory.getSsqBonusMapper().selectByBean(ssqBonusQ);

				for (SsqBonus f : ssqBonusList) {
					BonusDetailSVO.BonusInfo bonusInfo = new BonusDetailSVO.BonusInfo();
					bonusInfo.setOrderNo(f.getSsqOrderNo());
					bonusInfo.setPlayType(f.getPlayType());
					bonusInfo.setIsBombBonus(f.getIsBomBonus());
					bonusInfo.setBonusLevel(f.getBonusLevel());
					bonusInfo.setBonusLevelAmount(f.getBonusLevelAmount().toString());
					bonusInfo.setAmount(f.getBonusAmount().toString());

					result.getList().add(bonusInfo);
				}
			} else {
				throw new SException(MessageConstant.TRANSACTION_RESPONSE_MESSAGE_9999, bonusDetailRVO.getGameType() + ":未实现");
			}
		} catch (SException e) {
			LOGGER.error("queryBonusList", e);
			throw e;
		} catch (Exception e) {
			LOGGER.error("queryBonusList", e);
			throw new SException(CodeMessage.FAILURE.getCode(), "中奖详细信息内部异常");
		}

		return result;
	}

}
