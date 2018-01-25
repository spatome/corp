/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: IssueServiceImpl.java 
 * @Prject: api-task
 * @Package: com.hengpeng.api.task.service.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月8日 下午2:20:41 
 * @version: V1.0   
 */
package com.hengpeng.api.task.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hengpeng.api.constants.BusinessConstants;
import com.hengpeng.api.entity.Issue;
import com.hengpeng.api.entity.PrintIssue;
import com.hengpeng.api.entity.SysConfig;
import com.hengpeng.api.enumtype.CodeMessage;
import com.hengpeng.api.enumtype.IssueType;
import com.hengpeng.api.exception.SException;
import com.hengpeng.api.task.common.constants.BusConstants;
import com.hengpeng.api.task.common.enums.PrintIssueType;
import com.hengpeng.api.task.common.message.IssueQueryResponseMessage;
import com.hengpeng.api.task.service.IssueService;
import com.hengpeng.api.util.DateUtil;

/** 
 * @ClassName: IssueServiceImpl 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月8日 下午2:20:41  
 */
@Transactional
@Service
public class IssueServiceImpl extends AbstractBaseService implements IssueService {

	/** 
	 * @Description: 同步在售奖期
	 * 注意：如果定时任务未开启，而错过了在售将期，表PrintIssue中将不存在该奖期
	 * 实际使用中在开售奖期期间，该程序会运行，所以此现象可忽略
	 * @throws SException 
	 * @see com.hengpeng.api.task.service.IssueService#synNewPringIssue() 
	 */
	@Override
	public void synNewPringIssue() throws SException {
		try {
			PrintIssue printIssueQ = new PrintIssue();
			printIssueQ.setIssueType(PrintIssueType.SALING.getValue());
			List<PrintIssue> salingPrintIssueList = daoFactory.getPrintIssueMapper().selectByBean(printIssueQ);

			if(salingPrintIssueList.size()<=0){
				LOGGER.info("本地没有在售奖期，从中心获取");
				IssueQueryResponseMessage issueQueryResponseMessage = serviceFactory.getCenterService().getPrintIssue("SSQ", "", String.valueOf(serviceFactory.getSeqService().getMessageId()), "1.1");
				String retCode = issueQueryResponseMessage.getBody().getResponse().getCode();

				if(retCode.equals("0000")) {
					for (IssueQueryResponseMessage.Body.Response.Issue f : issueQueryResponseMessage.getBody().getResponse().getIssueList()) {
						if(PrintIssueType.SALING.getValue().equals(f.getStatus())){
							LOGGER.info("保存新奖期："+f.getNumber());
							this.saveOrUpdatePrintIssue(f);
							this.saveOrUpdateIssue(f);
							this.createBookingIssue(f);
							serviceFactory.getCacheService().setPrintIssueNo(f.getNumber(), f.toString());
						}
					}
				}
			}else{
				for (PrintIssue f : salingPrintIssueList) {
					if(StringUtils.isBlank(f.getIssueNo())){
						LOGGER.warn("中心返回奖期号是空的");
						continue;
					}

					IssueQueryResponseMessage issueQueryResponseMessage = serviceFactory.getCenterService().getPrintIssue("SSQ", f.getIssueNo(), String.valueOf(serviceFactory.getSeqService().getMessageId()), "1.1");
					String retCode = issueQueryResponseMessage.getBody().getResponse().getCode();

					if(retCode.equals("0000")) {
						IssueQueryResponseMessage.Body.Response.Issue remoteIssue = issueQueryResponseMessage.getBody().getResponse().getIssueList().get(0);

						if(!remoteIssue.toString().equals(serviceFactory.getCacheService().getPrintIssueNo(remoteIssue.getNumber()))){
							LOGGER.info("修改新奖期："+remoteIssue.getNumber());
							this.saveOrUpdatePrintIssue(remoteIssue);
							this.saveOrUpdateIssue(remoteIssue);
							serviceFactory.getCacheService().setPrintIssueNo(remoteIssue.getNumber(), remoteIssue.toString());
						}
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("synNewPringIssue", e);
			throw new SException(CodeMessage.FAILURE.getCode(), "synNewPringIssue 失败:");
		}
	}

	/** 
	 * @Description: 同步直到结束状态
	 * 此处排除1（在售）,7（已完成期结和返奖）两种状态
	 * 1状态有在售定时任务处理，7状态表示奖期已经完全结束
	 * @throws SException 
	 * @see com.hengpeng.api.task.service.IssueService#synBonusCode() 
	 */
	@Override
	public void synBonusPrintIssue() throws SException {
		try {
			List<PrintIssue> printIssueList = daoFactory.getPrintIssueMapper().selectNeedRemoteIssue();

			for (PrintIssue printIssue : printIssueList) {
				if(StringUtils.isBlank(printIssue.getIssueNo())){
					continue;
				}

				IssueQueryResponseMessage issueQueryResponseMessage = serviceFactory.getCenterService().getPrintIssue("SSQ", printIssue.getIssueNo(), String.valueOf(serviceFactory.getSeqService().getMessageId()), "1.1");
				String retCode = issueQueryResponseMessage.getBody().getResponse().getCode();

				if(retCode.equals("0000")) {
					IssueQueryResponseMessage.Body.Response.Issue remoteIssue = issueQueryResponseMessage.getBody().getResponse().getIssueList().get(0);

					if(!remoteIssue.toString().equals(serviceFactory.getCacheService().getPrintIssueNo(remoteIssue.getNumber()))){
						LOGGER.info("修改奖期："+remoteIssue.getNumber());
						this.saveOrUpdatePrintIssue(remoteIssue);
						this.saveOrUpdateIssue(remoteIssue);
						serviceFactory.getCacheService().setPrintIssueNo(remoteIssue.getNumber(), remoteIssue.toString());
					}
					
					if("7".equals(remoteIssue.getStatus())){
						//需要兑奖
						serviceFactory.getBonusService().synBonus();
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("synBonusIssue", e);
			throw new SException(CodeMessage.FAILURE.getCode(), "synBonusIssue 失败:");
		}
	}

	/** 
	 * @Description: 同步在售， 第一版功能，保存该功能
	 * 保留该功能以便手工操作：比如表sysConfig中奖期编号key_id=2017001，执行该方法一次key_id会跳到下一个奖期，直到该奖期是在售
	 * @throws SException 
	 * @see com.hengpeng.api.task.service.IssueService#sysPringIssue() 
	 */
	@Override
	public void synSalingPringIssue() throws SException {
		try {
			SysConfig sysConfig = daoFactory.getSysConfigMapper().selectByPrimaryKey("60001");
			String issueNo = sysConfig.getKeyValue();

			IssueQueryResponseMessage issueQueryResponseMessage = serviceFactory.getCenterService().getPrintIssue("SSQ", issueNo, String.valueOf(serviceFactory.getSeqService().getMessageId()), "1.1");
			String retCode = issueQueryResponseMessage.getBody().getResponse().getCode();

			if(retCode.equals("0000")) {
				IssueQueryResponseMessage.Body.Response.Issue remoteIssue = issueQueryResponseMessage.getBody().getResponse().getIssueList().get(0);

				String cacheIssue = serviceFactory.getCacheService().getPrintIssueNo(issueNo);

				if(remoteIssue.toString().equals(cacheIssue)){
				}else{
					LOGGER.info("修改奖期："+sysConfig.getKeyValue());
					this.saveOrUpdatePrintIssue(remoteIssue);
					this.saveOrUpdateIssue(remoteIssue);
					serviceFactory.getCacheService().setPrintIssueNo(issueNo, remoteIssue.toString());
				}

				if("0".equals(remoteIssue.getStatus())) {
				}else if ("1".equals(remoteIssue.getStatus())) {
				}else{
					sysConfig.setKeyValue(String.valueOf(Integer.valueOf(remoteIssue.getNumber())+1));
					daoFactory.getSysConfigMapper().updateByPrimaryKeySelective(sysConfig);
				}
			}
		} catch (Exception e) {
			LOGGER.error("sysPringIssue", e);
			throw new SException(CodeMessage.FAILURE.getCode(), "sysPringIssue 失败:");
		}
	}

	/** 
	 * @Description: 程序有并发风险，该业务可以允许
	 * @param remoteIssue
	 * @throws Exception
	 * @return: void
	 */
	public void saveOrUpdatePrintIssue(IssueQueryResponseMessage.Body.Response.Issue remoteIssue) throws Exception {
		String remoteIssueNo = remoteIssue.getNumber();
		if(StringUtils.isEmpty(remoteIssueNo)){
			return;
		}

		PrintIssue printIssueQ = new PrintIssue();
		printIssueQ.setIssueNo(remoteIssueNo);
		List<PrintIssue> printIssueList = daoFactory.getPrintIssueMapper().selectByBean(printIssueQ);

		if(printIssueList.size()<=0){
			//增加
			PrintIssue printIssueInsert = new PrintIssue();
			printIssueInsert.setBonusCode(remoteIssue.getBonusCode());
			printIssueInsert.setGameType(remoteIssue.getGameName());
			printIssueInsert.setIssueNo(remoteIssue.getNumber());
			printIssueInsert.setIssueType(remoteIssue.getStatus());
			printIssueInsert.setStartTime(DateUtil.parseFormat(remoteIssue.getStartTime()));
			printIssueInsert.setStopTime(DateUtil.parseFormat(remoteIssue.getStopTime()));
			printIssueInsert.setOfficialStartTime(DateUtil.parseFormat(remoteIssue.getOfficialStartTime()));
			printIssueInsert.setOfficialStopTime(DateUtil.parseFormat(remoteIssue.getOfficialStopTime()));
			daoFactory.getPrintIssueMapper().insertSelective(printIssueInsert);
		}else{
			for (PrintIssue printIssue : printIssueList) {
				//修改
				printIssue.setBonusCode(remoteIssue.getBonusCode());
				printIssue.setIssueType(remoteIssue.getStatus());
				printIssue.setStartTime(DateUtil.parseFormat(remoteIssue.getStartTime()));
				printIssue.setStopTime(DateUtil.parseFormat(remoteIssue.getStopTime()));
				printIssue.setOfficialStartTime(DateUtil.parseFormat(remoteIssue.getOfficialStartTime()));
				printIssue.setOfficialStopTime(DateUtil.parseFormat(remoteIssue.getOfficialStopTime()));
				daoFactory.getPrintIssueMapper().updateByPrimaryKeySelective(printIssue);
			}
		}
	}

	/** 
	 * @Description: 程序有并发风险，该业务可以允许
	 * @param remoteIssue
	 * @throws Exception
	 * @return: void
	 */
	public void saveOrUpdateIssue(IssueQueryResponseMessage.Body.Response.Issue remoteIssue) throws Exception {
		String remoteIssueNo = remoteIssue.getNumber();
		if(StringUtils.isEmpty(remoteIssueNo)){
			return;
		}

		Issue issueQ = new Issue();
		issueQ.setIssueNo(remoteIssueNo);
		List<Issue> issueList = daoFactory.getIssueMapper().selectByBean(issueQ);

		if(issueList.size()<=0){
			//增加
			Issue issueInsert = new Issue();
			issueInsert.setBonusCode(remoteIssue.getBonusCode());
			issueInsert.setGameType(remoteIssue.getGameName());
			issueInsert.setIssueNo(remoteIssue.getNumber());
			issueInsert.setIssueType(BusConstants.ISSUE_TYPE.get(remoteIssue.getStatus()));
			issueInsert.setStartTime(new Date(DateUtil.parseFormat(remoteIssue.getStartTime()).getTime()+BusinessConstants.ISSUE_START_TIME_OFFSET*1000));
			issueInsert.setStopTime(new Date(DateUtil.parseFormat(remoteIssue.getStopTime()).getTime()+BusinessConstants.ISSUE_STOP_TIME_OFFSET*1000));
			issueInsert.setOfficialStartTime(DateUtil.parseFormat(remoteIssue.getOfficialStartTime()));
			issueInsert.setOfficialStopTime(DateUtil.parseFormat(remoteIssue.getOfficialStopTime()));
			daoFactory.getIssueMapper().insertSelective(issueInsert);
		}else{
			for (Issue issue : issueList) {
				//修改
				issue.setBonusCode(remoteIssue.getBonusCode());
				issue.setIssueType(BusConstants.ISSUE_TYPE.get(remoteIssue.getStatus()));
				issue.setStartTime(new Date(DateUtil.parseFormat(remoteIssue.getStartTime()).getTime()+BusinessConstants.ISSUE_START_TIME_OFFSET*1000));
				issue.setStopTime(new Date(DateUtil.parseFormat(remoteIssue.getStopTime()).getTime()+BusinessConstants.ISSUE_STOP_TIME_OFFSET*1000));
				issue.setOfficialStartTime(DateUtil.parseFormat(remoteIssue.getOfficialStartTime()));
				issue.setOfficialStopTime(DateUtil.parseFormat(remoteIssue.getOfficialStopTime()));
				daoFactory.getIssueMapper().updateByPrimaryKeySelective(issue);
			}
		}
	}

	/** 
	 * @Description: 增加预售将期
	 * @param gameType
	 * @throws Exception
	 * @return: void
	 */
	public void addBookingIssue(String gameType) throws Exception {
		Issue issueQ = new Issue();
		issueQ.setGameType(gameType);
		issueQ.setIssueType(IssueType.BOOKING.toString());
		List<Issue> issueList = daoFactory.getIssueMapper().selectByBean(issueQ);

		if(issueList.size()<=0){
			
		}
	}

	/** 
	 * @Description: 创建预售奖期
	 * @throws SException 
	 * @see com.hengpeng.api.task.service.IssueService#createBookingIssue() 
	 */
	public void createBookingIssue(IssueQueryResponseMessage.Body.Response.Issue issue) {
		try {
			IssueQueryResponseMessage.Body.Response.Issue newIssue = (IssueQueryResponseMessage.Body.Response.Issue)BeanUtils.cloneBean(issue);
			newIssue.setNumber(String.valueOf(Integer.valueOf(newIssue.getNumber())+1));
			newIssue.setStatus(PrintIssueType.BOOKING.getValue());
			
			this.saveOrUpdateIssue(newIssue);
		} catch (Exception e) {
			LOGGER.error("创建预售奖期异常,当前在售奖期："+issue.getNumber());
		}
	}
}
