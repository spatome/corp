/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: CenterServiceImpl.java 
 * @Prject: api-task
 * @Package: com.hengpeng.api.task.service.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月8日 上午10:31:02 
 * @version: V1.0   
 */
package com.hengpeng.api.task.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hengpeng.api.enumtype.CodeMessage;
import com.hengpeng.api.exception.SException;
import com.hengpeng.api.task.common.constants.BusConstants;
import com.hengpeng.api.task.common.constants.ConfigConstants;
import com.hengpeng.api.task.common.enums.TransType;
import com.hengpeng.api.task.common.message.BonusQueryRequestMessage;
import com.hengpeng.api.task.common.message.BonusQueryResponseMessage;
import com.hengpeng.api.task.common.message.IssueQueryRequestMessage;
import com.hengpeng.api.task.common.message.IssueQueryResponseMessage;
import com.hengpeng.api.task.common.message.LotteryBuyRequestMessage;
import com.hengpeng.api.task.common.message.LotteryBuyResponseMessage;
import com.hengpeng.api.task.common.message.TicketQueryRequestMessage;
import com.hengpeng.api.task.common.message.TicketQueryResponseMessage;
import com.hengpeng.api.task.service.CenterService;
import com.hengpeng.api.task.util.MessageHttpUtil;
import com.hengpeng.api.task.util.MessageUtil;
import com.hengpeng.api.util.ConfigParamUtil;
import com.hengpeng.api.util.LotteryUtil;
import com.hengpeng.api.util.XStreamUtil;

/** 
 * @ClassName: CenterServiceImpl 
 * @Description: 彩票中心报文处理
 * @author: zhangwei
 * @date: 2017年8月8日 上午10:31:02  
 */
@Service
public class CenterServiceImpl implements CenterService {

	private final static Logger LOGGER = LoggerFactory.getLogger(CenterServiceImpl.class);

	private final static SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddHHmmss");

	/** 
	 * @Description: TODO
	 * @param issueQueryRequestMessage
	 * @return
	 * @throws SException 
	 * @see com.hengpeng.api.task.service.CenterService#getPrintIssue(com.hengpeng.api.task.common.message.IssueQueryRequestMessage) 
	 */
	@Override
	public IssueQueryResponseMessage getPrintIssue(String gameType, String issueNo, String messageSeq, String version) throws SException {
		try {
			String timestamp = SDF.format(new Date());
			String userName = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_USERNAME);
			String password = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_PASSWORD);
			String messageId = LotteryUtil.createMessageNo(userName, messageSeq);

			IssueQueryRequestMessage request = new IssueQueryRequestMessage();
			request.setId(messageId);
			request.setVersion(version);
			request.getHeader().setMessengerID(userName);
			request.getHeader().setTimestamp(timestamp);
			request.getHeader().setTransactionType(String.valueOf(TransType.TRANSTYPE_ISSUEQUERY_REQUEST.value()));
			request.getHeader().setDigest("(^SIGNTEMP^)");
			request.getBody().getIssueQuery().getIssue().setGameName(gameType);
			request.getBody().getIssueQuery().getIssue().setNumber(issueNo);

			String xmlStr = XStreamUtil.toXml(BusConstants.XML_HEAD, request);
			//包括<body></body>
			String body = StringUtils.substring(xmlStr, xmlStr.indexOf("<body>"), xmlStr.indexOf("</body>")+"</body>".length());
			String sign = MessageUtil.sign(messageId, timestamp, password, body);
			String requestXml = xmlStr.replace("(^SIGNTEMP^)", sign);
			String returnXml = MessageHttpUtil.post(String.valueOf(TransType.TRANSTYPE_ISSUEQUERY_REQUEST.value()), requestXml);

			return XStreamUtil.toBean(returnXml, IssueQueryResponseMessage.class);
		} catch (Exception e) {
			LOGGER.error("getPrintIssue:", e);
			throw new SException(CodeMessage.FAILURE.getCode(), e.getMessage());
		}
	}

	/** 
	 * @Description: TODO
	 * @param ticketList
	 * @param messageSeq
	 * @param version
	 * @return
	 * @throws SException 
	 * @see com.hengpeng.api.task.service.CenterService#buyTicket(java.util.List, long, java.lang.String) 
	 */
	@Override
	public LotteryBuyResponseMessage buyTicket(List<LotteryBuyRequestMessage.Body.LotteryRequest.Ticket> ticketList, String messageSeq, String version) throws SException {
		try {
			String timestamp = SDF.format(new Date());
			String userName = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_USERNAME);
			String password = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_PASSWORD);
			String messageId = LotteryUtil.createMessageNo(userName, messageSeq);

			LotteryBuyRequestMessage request = new LotteryBuyRequestMessage();
			request.setId(messageId);
			request.setVersion(version);
			request.getHeader().setMessengerID(userName);
			request.getHeader().setTimestamp(timestamp);
			request.getHeader().setTransactionType(String.valueOf(TransType.TRANSTYPE_LOTTERYREQUEST_REQUEST.value()));
			request.getHeader().setDigest("(^SIGNTEMP^)");
			request.getBody().getLotteryRequest().setTicketList(ticketList);

			String xmlStr = XStreamUtil.toXml(BusConstants.XML_HEAD, request);
			//包括<body></body>
			String body = StringUtils.substring(xmlStr, xmlStr.indexOf("<body>"), xmlStr.indexOf("</body>")+"</body>".length());
			String sign = MessageUtil.sign(messageId, timestamp, password, body);
			String requestXml = xmlStr.replace("(^SIGNTEMP^)", sign);
			String returnXml = MessageHttpUtil.post(String.valueOf(TransType.TRANSTYPE_LOTTERYREQUEST_REQUEST.value()), requestXml);

			return XStreamUtil.toBean(returnXml, LotteryBuyResponseMessage.class);
		} catch (Exception e) {
			LOGGER.error("buyTicket:", e);
			throw new SException(CodeMessage.FAILURE.getCode(), e.getMessage());
		}
	}

	/** 
	 * @Description: TODO
	 * @param orderNoSet
	 * @param messageSeq
	 * @param version
	 * @return
	 * @throws SException 
	 * @see com.hengpeng.api.task.service.CenterService#getTicket(java.util.Set, long, java.lang.String) 
	 */
	@Override
	public TicketQueryResponseMessage getTicket(Set<String> orderNoSet, String messageSeq, String version) throws SException {
		try {
			String timestamp = SDF.format(new Date());
			String userName = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_USERNAME);
			String password = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_PASSWORD);
			String messageId = LotteryUtil.createMessageNo(userName, messageSeq);

			TicketQueryRequestMessage request = new TicketQueryRequestMessage();
			request.setId(messageId);
			request.setVersion(version);
			request.getHeader().setMessengerID(userName);
			request.getHeader().setTimestamp(timestamp);
			request.getHeader().setTransactionType(String.valueOf(TransType.TRANSTYPE_TICKETQUERY_REQUEST.value()));
			request.getHeader().setDigest("(^SIGNTEMP^)");
			for (String string : orderNoSet) {
				TicketQueryRequestMessage.Body.TicketQuery.Ticket ticket = new TicketQueryRequestMessage.Body.TicketQuery.Ticket();
				ticket.setId(string);
				request.getBody().getTicketQuery().getTicketList().add(ticket);
			}

			String xmlStr = XStreamUtil.toXml(BusConstants.XML_HEAD, request);
			//包括<body></body>
			String body = StringUtils.substring(xmlStr, xmlStr.indexOf("<body>"), xmlStr.indexOf("</body>")+"</body>".length());
			String sign = MessageUtil.sign(messageId, timestamp, password, body);
			String requestXml = xmlStr.replace("(^SIGNTEMP^)", sign);
			String returnXml = MessageHttpUtil.post(String.valueOf(TransType.TRANSTYPE_TICKETQUERY_REQUEST.value()), requestXml);

			return XStreamUtil.toBean(returnXml, TicketQueryResponseMessage.class);
		} catch (Exception e) {
			LOGGER.error("getTicket:", e);
			throw new SException(CodeMessage.FAILURE.getCode(), e.getMessage());
		}
	}

	/** 
	 * @Description: TODO
	 * @param issueNo
	 * @param messageSeq
	 * @param version
	 * @return
	 * @throws SException 
	 * @see com.hengpeng.api.task.service.CenterService#getBonus(java.lang.String, long, java.lang.String) 
	 */
	@Override
	public BonusQueryResponseMessage getBonus(String gameType, String issueNo, String messageSeq, String version) throws SException {
		try {
			String timestamp = SDF.format(new Date());
			String userName = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_USERNAME);
			String password = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_PASSWORD);
			String messageId = LotteryUtil.createMessageNo(userName, messageSeq);

			BonusQueryRequestMessage request = new BonusQueryRequestMessage();
			request.setId(messageId);
			request.setVersion(version);
			request.getHeader().setMessengerID(userName);
			request.getHeader().setTimestamp(timestamp);
			request.getHeader().setTransactionType(String.valueOf(TransType.TRANSTYPE_BONUSQUERY_REQUEST.value()));
			request.getHeader().setDigest("(^SIGNTEMP^)");
			request.getBody().getBonusQuery().getIssue().setGameName(gameType.toLowerCase());
			request.getBody().getBonusQuery().getIssue().setNumber(issueNo);

			String xmlStr = XStreamUtil.toXml(BusConstants.XML_HEAD, request);
			//包括<body></body>
			String body = StringUtils.substring(xmlStr, xmlStr.indexOf("<body>"), xmlStr.indexOf("</body>")+"</body>".length());
			String sign = MessageUtil.sign(messageId, timestamp, password, body);
			String requestXml = xmlStr.replace("(^SIGNTEMP^)", sign);
			String returnXml = MessageHttpUtil.post(String.valueOf(TransType.TRANSTYPE_BONUSQUERY_REQUEST.value()), requestXml);

			return XStreamUtil.toBean(returnXml, BonusQueryResponseMessage.class);
		} catch (Exception e) {
			LOGGER.error("getBonus:", e);
			throw new SException(CodeMessage.FAILURE.getCode(), e.getMessage());
		}
	}

	/** 
	 * @Description: TODO
	 * @param gameType
	 * @param issueNo
	 * @param messageSeq
	 * @param version
	 * @throws SException 
	 * @see com.hengpeng.api.task.service.CenterService#test(java.lang.String, java.lang.String, java.lang.String, java.lang.String) 
	 */
	@Override
	public void sendTicket(List<LotteryBuyRequestMessage.Body.LotteryRequest.Ticket> ticketList, String messageSeq, String version) throws SException {
/*		try {
			String timestamp = SDF.format(new Date());
			String userName = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_USERNAME);
			String password = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_PASSWORD);
			String messageId = LotteryUtil.createMessageNo(userName, messageSeq);

			LotteryBuyRequestMessage request = new LotteryBuyRequestMessage();
			request.setId(messageId);
			request.setVersion(version);
			request.getHeader().setMessengerID(userName);
			request.getHeader().setTimestamp(timestamp);
			request.getHeader().setTransactionType(String.valueOf(TransType.TRANSTYPE_LOTTERYREQUEST_REQUEST.value()));
			request.getHeader().setDigest("(^SIGNTEMP^)");
			request.getBody().getLotteryRequest().setTicketList(ticketList);

			String xmlStr = XStreamUtil.toXml(BusConstants.XML_HEAD, request);
			//包括<body></body>
			String body = StringUtils.substring(xmlStr, xmlStr.indexOf("<body>"), xmlStr.indexOf("</body>")+"</body>".length());
			String sign = MessageUtil.sign(messageId, timestamp, password, body);
			String requestXml = xmlStr.replace("(^SIGNTEMP^)", sign);
			
			MessageAsyncHttpUtil.post(String.valueOf(TransType.TRANSTYPE_LOTTERYREQUEST_REQUEST.value()), requestXml, handlerBuyServiceImpl);
		} catch (Exception e) {
			LOGGER.error("buyTicket:", e);
			throw new SException(CodeMessage.FAILURE.getCode(), e.getMessage());
		}*/
	}
}
