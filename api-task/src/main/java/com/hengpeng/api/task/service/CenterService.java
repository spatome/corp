/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: CenterService.java 
 * @Prject: api-task
 * @Package: com.hengpeng.api.task.service 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月8日 上午10:30:37 
 * @version: V1.0   
 */
package com.hengpeng.api.task.service;

import java.util.List;
import java.util.Set;

import com.hengpeng.api.exception.SException;
import com.hengpeng.api.task.common.message.BonusQueryResponseMessage;
import com.hengpeng.api.task.common.message.IssueQueryResponseMessage;
import com.hengpeng.api.task.common.message.LotteryBuyRequestMessage;
import com.hengpeng.api.task.common.message.LotteryBuyResponseMessage;
import com.hengpeng.api.task.common.message.TicketQueryResponseMessage;

/** 
 * @ClassName: CenterService 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月8日 上午10:30:37  
 */
public interface CenterService {

	public void sendTicket(List<LotteryBuyRequestMessage.Body.LotteryRequest.Ticket> ticketList, String messageSeq, String version) throws SException;
	
	/** 
	 * @Description: 获取奖期
	 * @param gameType
	 * @param issueNo
	 * @param messageSeq
	 * @param version
	 * @return
	 * @throws SException
	 * @return: IssueQueryResponseMessage
	 */
	public IssueQueryResponseMessage getPrintIssue(String gameType, String issueNo, String messageSeq, String version) throws SException;

	/** 
	 * @Description: 向中心投注
	 * @param ticketList
	 * @param messageSeq
	 * @param version
	 * @return
	 * @throws SException
	 * @return: LotteryBuyResponseMessage
	 */
	public LotteryBuyResponseMessage buyTicket(List<LotteryBuyRequestMessage.Body.LotteryRequest.Ticket> ticketList, String messageSeq, String version) throws SException;
	
	/** 
	 * @Description: 票查询
	 * @param orderNoSet
	 * @param messageSeq
	 * @param version
	 * @return
	 * @throws SException
	 * @return: TicketQueryResponseMessage
	 */
	public TicketQueryResponseMessage getTicket(Set<String> orderNoSet, String messageSeq, String version) throws SException;
	
	/** 
	 * @Description: 开奖
	 * @param issueNo
	 * @param messageSeq
	 * @param version
	 * @return
	 * @throws SException
	 * @return: BonusQueryResponseMessage
	 */
	public BonusQueryResponseMessage getBonus(String gameType, String issueNo, String messageSeq, String version) throws SException;
}
