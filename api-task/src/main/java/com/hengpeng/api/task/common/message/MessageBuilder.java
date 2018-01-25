///**   
// * Copyright © 2017 恒朋科技. All rights reserved.
// * 
// * @Title: MessageBuilder.java 
// * @Prject: api-dhtz
// * @Package: com.hengpeng.api.dhtz.common.message 
// * @Description: TODO
// * @author: zhangwei   
// * @date: 2017年7月26日 下午5:34:10 
// * @version: V1.0   
// */
//package com.hengpeng.api.task.common.message;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Set;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import com.hengpeng.api.task.common.constants.ConfigConstants;
//import com.hengpeng.api.task.common.enums.TransType;
//import com.hengpeng.api.task.common.message.TicketQueryRequestMessage.Body.TicketQuery.Ticket;
//import com.hengpeng.api.task.util.ConfigParamUtil;
//import com.hengpeng.api.task.util.XStreamUtil;
//import com.hengpeng.api.task.util.secure.MessageSignUtil;
//
///** 
// * @ClassName: MessageBuilder 
// * @Description: 创建报文类
// * @author: zhangwei
// * @date: 2017年7月26日 下午5:34:10  
// */
//public class MessageBuilder {
//	
//	private final static Logger LOGGER = LoggerFactory.getLogger(MessageBuilder.class);
//
//	private final static SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddHHmmss");
//
//	/** 
//	 * @Description: 奖期查询
//	 * @param issueNo
//	 * @param id
//	 * @param version
//	 * @return
//	 * @throws Exception
//	 * @return: String
//	 */
//	
//	/** 
//	 * @Description: 生成消息id
//	 * @return
//	 * @return: String
//	 */
//	public static String builderMessageId(String enterpriseNo, String seq, ){
//		String seqStr = "00000000" +seq;
//		return enterpriseNo+(new SimpleDateFormat("yyyyMMdd")).format(new Date()) + seqStr.substring(seqStr.length()-8, seqStr.length());
//		return "";
//	}
//	
//	public static String createIssueQueryMessage(String issueNo, String id,	String version) throws Exception {
//		LOGGER.info("奖期查询参数：{},{},{}", issueNo, id, version);
//		String timestamp = SDF.format(new Date());
//		String userName = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_USERNAME);
//		String password = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_PASSWORD);
//		if(StringUtils.isAnyEmpty(userName, password)){
//			throw new RuntimeException(String.format("请检查配置：{},{}",ConfigConstants.KXCH_CENTER_USERNAME, ConfigConstants.KXCH_CENTER_PASSWORD));
//		}
//
//		IssueQueryRequestMessage issueQueryRequestMessage = new IssueQueryRequestMessage();
//		issueQueryRequestMessage.setId(id);
//		issueQueryRequestMessage.setVersion(version);
//		issueQueryRequestMessage.getHeader().setMessengerID(userName);
//		issueQueryRequestMessage.getHeader().setTimestamp(timestamp);
//		issueQueryRequestMessage.getHeader().setTransactionType(String.valueOf(TransType.TRANSTYPE_ISSUEQUERY_REQUEST.value()));
//		issueQueryRequestMessage.getHeader().setDigest("(^SIGNTEMP^)");
//		issueQueryRequestMessage.getBody().getIssueQuery().getIssue().setGameName("SSQ");
//		issueQueryRequestMessage.getBody().getIssueQuery().getIssue().setNumber(issueNo);
//
//		String xmlStr = XStreamUtil.toXml(issueQueryRequestMessage);
//		//包括<body></body>
//		String body = StringUtils.substring(xmlStr, xmlStr.indexOf("<body>"), xmlStr.indexOf("</body>")+"</body>".length());
//		String sign = MessageSignUtil.sign(id, timestamp, password, body);
//		String result = xmlStr.replace("(^SIGNTEMP^)", sign);
//
//		return result;
//	}
//	
//	/** 
//	 * @Description: 票查询
//	 * @param orderNos
//	 * @param id
//	 * @param version
//	 * @return
//	 * @throws Exception
//	 * @return: String
//	 */
//	public static String createOrderQueryMessage(Set<String> orderNos, String id,	String version) throws Exception {
//		LOGGER.info("票查询参数：{},{},{}", orderNos, id, version);
//		String timestamp = SDF.format(new Date());
//		String userName = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_USERNAME);
//		String password = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_PASSWORD);
//		if(StringUtils.isAnyEmpty(userName, password)){
//			throw new RuntimeException(String.format("请检查配置：{},{}",ConfigConstants.KXCH_CENTER_USERNAME, ConfigConstants.KXCH_CENTER_PASSWORD));
//		}
//
//		TicketQueryRequestMessage ticketQueryRequestMessage = new TicketQueryRequestMessage();
//		ticketQueryRequestMessage.setId(id);
//		ticketQueryRequestMessage.setVersion(version);
//		ticketQueryRequestMessage.getHeader().setMessengerID(userName);
//		ticketQueryRequestMessage.getHeader().setTimestamp(timestamp);
//		ticketQueryRequestMessage.getHeader().setTransactionType(String.valueOf(TransType.TRANSTYPE_TICKETQUERY_REQUEST.value()));
//		ticketQueryRequestMessage.getHeader().setDigest("(^SIGNTEMP^)");
//		for (String string : orderNos) {
//			Ticket ticket = new Ticket();
//			ticket.setId(string);
//			ticketQueryRequestMessage.getBody().getTicketQuery().getTicketList().add(ticket);	
//		}
//
//		String xmlStr = XStreamUtil.toXml(ticketQueryRequestMessage);
//		//包括<body></body>
//		String body = StringUtils.substring(xmlStr, xmlStr.indexOf("<body>"), xmlStr.indexOf("</body>")+"</body>".length());
//		String sign = MessageSignUtil.sign(id, timestamp, password, body);
//		String result = xmlStr.replace("(^SIGNTEMP^)", sign);
//
//		return result;
//	}
//	
//	/** 
//	 * @Description: 返奖查询
//	 * @param issueNo
//	 * @param id
//	 * @param version
//	 * @return
//	 * @throws Exception
//	 * @return: String
//	 */
//	public static String createBonusQueryMessage(String issueNo, String id,	String version) throws Exception {
//		LOGGER.info("返奖查询参数：{},{},{}", issueNo, id, version);
//		String timestamp = SDF.format(new Date());
//		String userName = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_USERNAME);
//		String password = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_PASSWORD);
//		if(StringUtils.isAnyEmpty(userName, password)){
//			throw new RuntimeException(String.format("请检查配置：{},{}",ConfigConstants.KXCH_CENTER_USERNAME, ConfigConstants.KXCH_CENTER_PASSWORD));
//		}
//
//		BonusQueryRequestMessage bonusQueryRequestMessage = new BonusQueryRequestMessage();
//		bonusQueryRequestMessage.setId(id);
//		bonusQueryRequestMessage.setVersion(version);
//		bonusQueryRequestMessage.getHeader().setMessengerID(userName);
//		bonusQueryRequestMessage.getHeader().setTimestamp(timestamp);
//		bonusQueryRequestMessage.getHeader().setTransactionType(String.valueOf(TransType.TRANSTYPE_BONUSQUERY_REQUEST.value()));
//		bonusQueryRequestMessage.getHeader().setDigest("(^SIGNTEMP^)");
//		bonusQueryRequestMessage.getBody().getBonusQuery().getIssue().setGameName("SSQ");
//		bonusQueryRequestMessage.getBody().getBonusQuery().getIssue().setNumber(issueNo);
//
//		String xmlStr = XStreamUtil.toXml(bonusQueryRequestMessage);
//		//包括<body></body>
//		String body = StringUtils.substring(xmlStr, xmlStr.indexOf("<body>"), xmlStr.indexOf("</body>")+"</body>".length());
//		String sign = MessageSignUtil.sign(id, timestamp, password, body);
//		String result = xmlStr.replace("(^SIGNTEMP^)", sign);
//
//		return result;
//	}
//	
//	/** 
//	 * @Description: 投注
//	 * @param ticketSet
//	 * @param id
//	 * @param version
//	 * @return
//	 * @throws Exception
//	 * @return: String
//	 */
//	public static String createLotteryRequestMessage(List<com.hengpeng.api.task.common.message.LotteryBuyRequestMessage.Body.LotteryRequest.Ticket> ticketList, String id, String version) throws Exception {
//		LOGGER.info("投注查询参数：{},{},{}", ticketList, id, version);
//		String timestamp = SDF.format(new Date());
//		String userName = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_USERNAME);
//		String password = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_PASSWORD);
//		if(StringUtils.isAnyEmpty(userName, password)){
//			throw new RuntimeException(String.format("请检查配置：{},{}",ConfigConstants.KXCH_CENTER_USERNAME, ConfigConstants.KXCH_CENTER_PASSWORD));
//		}
//
//		LotteryBuyRequestMessage lotteryBuyRequestMessage = new LotteryBuyRequestMessage();
//		lotteryBuyRequestMessage.setId(id);
//		lotteryBuyRequestMessage.setVersion(version);
//		lotteryBuyRequestMessage.getHeader().setMessengerID(userName);
//		lotteryBuyRequestMessage.getHeader().setTimestamp(timestamp);
//		lotteryBuyRequestMessage.getHeader().setTransactionType(String.valueOf(TransType.TRANSTYPE_LOTTERYREQUEST_REQUEST.value()));
//		lotteryBuyRequestMessage.getHeader().setDigest("(^SIGNTEMP^)");
//		lotteryBuyRequestMessage.getBody().getLotteryRequest().setTicketList(ticketList);
//
//		String xmlStr = XStreamUtil.toXml(lotteryBuyRequestMessage);
//		//包括<body></body>
//		String body = StringUtils.substring(xmlStr, xmlStr.indexOf("<body>"), xmlStr.indexOf("</body>")+"</body>".length());
//		String sign = MessageSignUtil.sign(id, timestamp, password, body);
//		String result = xmlStr.replace("(^SIGNTEMP^)", sign);
//
//		return result;
//	}
//	
///*	*//**
//	 * <pre>
//	 * 创建帐户查询消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param accountIds 用户名集合
//	 * @return 帐户查询消息包(未进行摘要)
//	 *//*
//	public static TransMessage createAccountQueryMessage(String version, long sequece, String counterId,
//			Set<String> accountIds)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				MessageConstant.TRANSTYPE_ACCOUNTQUERY_REQUEST);
//
//		// 创建消息体
//		AccountQuery body = new AccountQuery();
//		Set<Account> accounts = new HashSet<Account>();
//		for (String accountId : accountIds)
//		{
//			Account account = new Account();
//			account.setUserName(accountId);
//			accounts.add(account);
//		}
//		body.setAccount(accounts);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建投注卡充值请求消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param anteCardFill 投注卡充值信息
//	 * @return 投注卡充值请求消息包(未进行摘要)
//	 *//*
//	public static TransMessage createAnteCardFillMessage(String version, long sequece, String counterId,
//			AnteCardFill anteCardFill)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				MessageConstant.TRANSTYPE_CARDFILLREQUEST_REQUEST);
//
//		// 创建消息体
//		CardFillRequest body = new CardFillRequest();
//		body.setAnteCardFill(anteCardFill);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建销量查询消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param frontGameId 协议规定的玩法编号
//	 * @param issueName 福彩中心官方公布的奖期名
//	 * @return 销量查询消息包(未进行摘要)
//	 *//*
//	public static TransMessage createBalanceQueryMessage(String version, long sequece, String counterId,
//			String frontGameId, String issueName)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				MessageConstant.TRANSTYPE_BALANCEQUERY_REQUEST);
//
//		// 创建消息体
//		BalanceQuery body = new BalanceQuery();
//		Issue issue = new Issue();
//		issue.setGameName(frontGameId);
//		issue.setNumber(issueName);
//		body.setIssue(issue);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建返奖查询消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param frontGameId 协议规定的玩法编号
//	 * @param issueName 福彩中心官方公布的奖期名
//	 * @return 返奖查询消息包(未进行摘要)
//	 *//*
//	public static TransMessage createBonusQueryMessage(String version, long sequece, String counterId,
//			String frontGameId, String issueName)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				MessageConstant.TRANSTYPE_BONUSQUERY_REQUEST);
//
//		// 创建消息体
//		BonusQuery body = new BonusQuery();
//		Issue issue = new Issue();
//		issue.setGameName(frontGameId);
//		issue.setNumber(issueName);
//		body.setIssue(issue);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建提款查询消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param drawingIds 提款流水号集合
//	 * @return 提款查询消息包(未进行摘要)
//	 *//*
//	public static TransMessage createDrawingQueryMessage(String version, long sequece, String counterId,
//			Set<String> drawingIds)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				MessageConstant.TRANSTYPE_DRAWINGQUERY_REQUEST);
//
//		// 创建消息体
//		DrawingQuery body = new DrawingQuery();
//		Set<Drawing> drawings = new HashSet<Drawing>();
//		for (String drawingId : drawingIds)
//		{
//			Drawing drawing = new Drawing();
//			drawing.setId(drawingId);
//			drawings.add(drawing);
//		}
//		body.setDrawing(drawings);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建提款请求消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param drawings 提款信息集合
//	 * @return 提款请求消息包(未进行摘要)
//	 *//*
//	public static TransMessage createDrawingRequestMessage(String version, long sequece, String counterId,
//			Set<Drawing> drawings)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				MessageConstant.TRANSTYPE_DRAWINGREQUEST_REQUEST);
//
//		// 创建消息体
//		DrawingRequest body = new DrawingRequest();
//		body.setDrawing(drawings);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建充值查询消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param fillIds 充值流水号集合
//	 * @return 充值查询消息包(未进行摘要)
//	 *//*
//	public static TransMessage createFillQueryMessage(String version, long sequece, String counterId,
//			Set<String> fillIds)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				MessageConstant.TRANSTYPE_FILLQUERY_REQUEST);
//
//		// 创建消息体
//		FillQuery body = new FillQuery();
//		Set<Fill> fills = new HashSet<Fill>();
//		for (String fillId : fillIds)
//		{
//			Fill fill = new Fill();
//			fill.setId(fillId);
//			fills.add(fill);
//		}
//		body.setFill(fills);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建奖期查询消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param frontGameId 协议规定的玩法编号
//	 * @param issueName 福彩中心官方公布的奖期名
//	 * @return 奖期查询消息包(未进行摘要)
//	 *//*
//	public static TransMessage createIssueQueryMessage(String version, long sequece, String counterId,
//			String frontGameId, String issueName)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				MessageConstant.TRANSTYPE_ISSUEQUERY_REQUEST);
//
//		// 创建消息体
//		IssueQuery body = new IssueQuery();
//		Issue issue = new Issue();
//		issue.setGameName(frontGameId);
//		issue.setNumber(issueName);
//		body.setIssue(issue);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建订单查询消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param ticketIds 票号集合
//	 * @return 订单查询消息包(未进行摘要)
//	 *//*
//	public static TransMessage createLotteryQueryMessage(String version, long sequece, String counterId,
//			Set<String> ticketIds)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				TransType.TRANSTYPE_LOTTERYQUERY_REQUEST.value());
//
//		// 创建消息体
//		TicketQuery body = new TicketQuery();
//		Set<Ticket> tickets = new HashSet<Ticket>();
//		for (String ticketId : ticketIds)
//		{
//			Ticket ticket = new Ticket();
//			ticket.setId(ticketId);
//			tickets.add(ticket);
//		}
//		body.setTicket(tickets);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建投注请求消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param tickets 票集合
//	 * @return 投注请求消息包(未进行摘要)
//	 *//*
//	public static TransMessage createLotteryRequestMessage(String version, long sequece, String counterId,
//			Set<Ticket> tickets)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				MessageConstant.TRANSTYPE_LOTTERYREQUEST_REQUEST);
//
//		// 创建消息体
//		LotteryRequest body = new LotteryRequest();
//		body.setTicket(tickets);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建实时投注请求消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param tickets 票集合
//	 * @return 投注请求消息包(未进行摘要)
//	 *//*
//	public static TransMessage createRealtimeLotteryRequestMessage(String version, long sequece, String counterId,
//			Set<Ticket> tickets)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				MessageConstant.TRANSTYPE_REALTIMELOTTERYREQUEST_REQUEST);
//
//		// 创建消息体
//		LotteryRequest body = new LotteryRequest();
//		body.setTicket(tickets);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建投注请求消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 完整消息流水号
//	 * @param counterId 代理商编号
//	 * @param tickets 票集合
//	 * @return 投注请求消息包(未进行摘要)
//	 *//*
//	public static TransMessage createLotteryRequestMessageById(String version, String sequece, String counterId,
//			Set<Ticket> tickets)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPartById(version, sequece, counterId,
//				MessageConstant.TRANSTYPE_LOTTERYREQUEST_REQUEST);
//
//		// 创建消息体
//		LotteryRequest body = new LotteryRequest();
//		body.setTicket(tickets);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建赠金查询消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param presentIds 赠金流水号集合
//	 * @return 赠金查询消息包(未进行摘要)
//	 *//*
//	public static TransMessage createPresentQueryMessage(String version, long sequece, String counterId,
//			Set<String> presentIds)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				MessageConstant.TRANSTYPE_PRESENTQUERY_REQUEST);
//
//		// 创建消息体
//		PresentQuery body = new PresentQuery();
//		Set<Present> presents = new HashSet<Present>();
//		for (String presendId : presentIds)
//		{
//			Present present = new Present();
//			present.setId(presendId);
//			presents.add(present);
//		}
//		body.setPresent(presents);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建赠金请求消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param presents 赠金信息集合
//	 * @return 赠金请求消息包(未进行摘要)
//	 *//*
//	public static TransMessage createPresentRequestMessage(String version, long sequece, String counterId,
//			Set<Present> presents)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				MessageConstant.TRANSTYPE_PRESENTMONEY_REQUEST);
//
//		// 创建消息体
//		PresentMoney body = new PresentMoney();
//		body.setPresent(presents);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建开奖公告查询消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param frontGameId 协议规定的玩法编号
//	 * @param issueName 福彩中心官方公布的奖期名
//	 * @return 开奖公告查询消息包(未进行摘要)
//	 *//*
//	public static TransMessage createPrizeQueryMessage(String version, long sequece, String counterId,
//			String frontGameId, String issueName)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				TransType.TRANSTYPE_PRIZEQUERY_REQUEST.value());
//
//		// 创建消息体
//		PrizeQuery body = new PrizeQuery();
//		Issue issue = new Issue();
//		issue.setGameName(frontGameId);
//		issue.setNumber(issueName);
//		body.setIssue(issue);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建风险控制方式查询消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param gameName 玩法编号
//	 * @param issueNumber 奖期编号
//	 * @param playType 风险控制类型
//	 * @return 风险控制方式查询消息包(未进行摘要)
//	 *//*
//	public static TransMessage createRiskControlQueryByPlayTypeMessage(String version, long sequece, String counterId,
//			String gameName, String issueNumber, String playType)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				MessageConstant.TRANSTYPE_RISKCONTROLPLAYTYPE_REQUEST);
//
//		// 创建消息体
//		RiskControlQuery body = new RiskControlQuery();
//		body.setGameName(gameName);
//		body.setNumber(issueNumber);
//		body.setPlayType(playType);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建风险控制号码查询消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param gameName 玩法编号
//	 * @param issueNumber 奖期编号
//	 * @param anteCode 投注号码
//	 * @return 风险控制号码查询消息包(未进行摘要)
//	 *//*
//	public static TransMessage createRiskControlQueryMessage(String version, long sequece, String counterId,
//			String gameName, String issueNumber, String anteCode)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				MessageConstant.TRANSTYPE_RISKCONTROL_REQUEST);
//
//		// 创建消息体
//		RiskControlQuery body = new RiskControlQuery();
//		body.setAnteCode(anteCode);
//		body.setGameName(gameName);
//		body.setNumber(issueNumber);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建票查询消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param ticketIds 票号集合
//	 * @return 票查询消息包(未进行摘要)
//	 *//*
//	public static TransMessage createTicketQueryMessage(String version, long sequece, String counterId,
//			Set<String> ticketIds)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				MessageConstant.TRANSTYPE_TICKETQUERY_REQUEST);
//
//		// 创建消息体
//		TicketQuery body = new TicketQuery();
//		Set<Ticket> tickets = new HashSet<Ticket>();
//		for (String ticketId : ticketIds)
//		{
//			Ticket ticket = new Ticket();
//			ticket.setId(ticketId);
//			tickets.add(ticket);
//		}
//		body.setTicket(tickets);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建联合购买方案请求消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param anteId 方案编号
//	 * @param uniteAnteInfo 联合购买方案信息
//	 * @param ticket 方案票信息集合
//	 * @param buy 方案购买者信息集合
//	 * @param commision 方案佣金规则信息集合
//	 * @return 联合购买方案请求消息包(未进行摘要)
//	 *//*
//	public static TransMessage createUniteAnteMessage(String version, long sequece, String counterId, String anteId,
//			UniteAnteInfo uniteAnteInfo, Set<UniteAnteTicket> ticket, Set<UniteAnteBuy> buy,
//			Set<UniteAnteCommision> commision)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				MessageConstant.TRANSTYPE_UNITANTEREQUEST_REQUEST);
//
//		// 创建消息体
//		UniteAnteRequest body = new UniteAnteRequest();
//		body.setUniteAnteInfo(uniteAnteInfo);
//		body.setBuy(buy);
//		body.setCommision(commision);
//		body.setTicket(ticket);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建联合购买方案查询消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param anteId 方案编号
//	 * @return 联合购买方案查询消息包(未进行摘要)
//	 *//*
//	public static TransMessage createUniteAnteQueryMessage(String version, long sequece, String counterId, String anteId)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				MessageConstant.TRANSTYPE_UNITANTEQUERY_REQUEST);
//
//		// 创建消息体
//		UniteAnteQueryRequest body = new UniteAnteQueryRequest();
//		body.setCounterAnteId(anteId);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建通用的消息包属性和消息头
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param transType 交易类型
//	 * @return 仅包含消息包属性和消息头的消息包对象(未进行摘要)
//	 *//*
//	private static TransMessage createMessageCommonPart(String version, long sequece, String counterId, int transType)
//	{
//		// 按规则生成消息流水号
//		Date date = new Date();
//		String datePart = new SimpleDateFormat("yyyyMMdd").format(date);
//		StringBuffer messageId = new StringBuffer();
//		messageId.append(counterId);
//		messageId.append(datePart);
//		DecimalFormat df = new DecimalFormat("00000000");
//		messageId.append(df.format(sequece));
//
//		// 创建消息包
//		TransMessage tm = new TransMessage();
//		if (version.startsWith("0"))
//		{
//			tm.setVersion(MessageConstant.PROTOCOL_VERSION);
//		}
//		else
//		{
//			tm.setVersion(version);
//		}
//		tm.setId(messageId.toString());
//
//		// 创建消息头
//		MessageHeader header = new MessageHeader();
//		header.setMessengerID(counterId);
//		header.setTimestamp(new SimpleDateFormat("yyyyMMddHHmmss").format(date));
//		header.setTransactionType(transType);
//		tm.setHeader(header);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建通用的消息包属性和消息头
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 完整消息流水号
//	 * @param counterId 代理商编号
//	 * @param transType 交易类型
//	 * @return 仅包含消息包属性和消息头的消息包对象(未进行摘要)
//	 *//*
//	private static TransMessage createMessageCommonPartById(String version, String sequece, String counterId,
//			int transType)
//	{
//		// 创建消息包
//		TransMessage tm = new TransMessage();
//		if (version.startsWith("0"))
//		{
//			tm.setVersion(MessageConstant.PROTOCOL_VERSION);
//		}
//		else
//		{
//			tm.setVersion(version);
//		}
//		tm.setId(sequece);
//
//		// 创建消息头
//		MessageHeader header = new MessageHeader();
//		header.setMessengerID(counterId);
//		header.setTimestamp(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
//		header.setTransactionType(transType);
//		tm.setHeader(header);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建竞彩投注请求消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param tickets 票集合
//	 * @return 投注请求消息包(未进行摘要)
//	 *//*
//	public static TransMessage createMatchLotteryRequestMessage(String version, long sequece, String counterId,
//			Set<Ticket> tickets)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				TransType.TRANSTYPE_MATCH_TICKET_LOTTERY_REQUEST.value());
//		MatchTicketRequest body = new MatchTicketRequest();// 创建消息体
//		body.setTicket(tickets);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建竞彩投注请求消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param tickets 票集合
//	 * @return 投注请求消息包(未进行摘要)
//	 *//*
//	public static TransMessage createMatchOrderLotteryRequestMessage(String version, long sequece, String counterId,
//			Order order)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				TransType.TRANSTYPE_MATCH_MATCHANTEBUY_REQUEST.value());
//		OrderRequest body = new OrderRequest();// 创建消息体
//		body.getOrder().add(order);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建竞彩票查询消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param ticketIds 票号集合
//	 * @return 票查询消息包(未进行摘要)
//	 *//*
//	public static TransMessage createMatchOrderQueryMessage(String version, long sequece, String counterId,
//			String orderId)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				TransType.TRANSTYPE_MATCH_ORDER_WIN_REQUEST.value());
//		OrderQuery body = new OrderQuery();// 创建消息体
//		Order order = new Order();
//		order.setId(orderId);
//		body.getOrder().add(order);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建竞彩票查询消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param ticketIds 票号集合
//	 * @return 票查询消息包(未进行摘要)
//	 *//*
//	public static TransMessage createMatchTicketQueryMessage(String version, long sequece, String counterId,
//			Set<String> ticketIds)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				TransType.TRANSTYPE_MATCH_TICKET_QUERY_REQUEST.value());
//		// 创建消息体
//		MatchTicketQuery body = new MatchTicketQuery();
//		Set<Ticket> tickets = new HashSet<Ticket>();
//		for (String ticketId : ticketIds)
//		{
//			Ticket ticket = new Ticket();
//			ticket.setId(ticketId);
//			tickets.add(ticket);
//		}
//		body.setTicket(tickets);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建竞彩中奖文件查询查询消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param ticketIds 票号集合
//	 * @return 票查询消息包(未进行摘要)
//	 *//*
//	public static TransMessage createMatchWinFileQueryMessage(String version, long sequece, String counterId,
//			Set<MatchWinfile> winFiles)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				TransType.TRANSTYPE_MATCH_WINFILE_QUERY_REQUEST.value());
//		// 创建消息体
//		MatchWinFileQuery body = new MatchWinFileQuery();
//		body.setMatchWinfile(winFiles);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建竞彩中奖文件查询查询消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param ticketIds 票号集合
//	 * @return 票查询消息包(未进行摘要)
//	 *//*
//	public static TransMessage createMatchResultQueryMessage(String version, long sequece, String counterId,
//			Set<MatchResultVO> matchResult)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				TransType.TRANSTYPE_MATCH_MATCHRESULT_QUERY_REQUEST.value());
//		// 创建消息体
//		MatchResultQuery body = new MatchResultQuery();
//		body.setMatchResult(matchResult);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建竞彩赔率查询消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param ticketIds 票号集合
//	 * @return 票查询消息包(未进行摘要)
//	 *//*
//	public static TransMessage createMatchLossRatioQueryMessage(String version, long sequece, String counterId,
//			CodeLossRatio codeLossRatio)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				TransType.TRANSTYPE_MATCH_LOSSRATIO_QUERY_REQUEST.value());
//		// 创建消息体
//		MatchLossRatioQuery body = new MatchLossRatioQuery();
//		body.setCodeLossRatio(codeLossRatio);
//		tm.setBody(body);
//		return tm;
//	}
//
//	*//**
//	 * <pre>
//	 * 创建竞彩对阵查询消息包
//	 * </pre>
//	 * @param version 协议版本号
//	 * @param sequece 消息流水号
//	 * @param counterId 代理商编号
//	 * @param ticketIds 票号集合
//	 * @return 票查询消息包(未进行摘要)
//	 *//*
//	public static TransMessage createMatchQueryMessage(String version, long sequece, String counterId, MatchVO match)
//	{
//		// 创建通用的消息包属性和消息头
//		TransMessage tm = createMessageCommonPart(version, sequece, counterId,
//				TransType.TRANSTYPE_MATCH_MATCHQUERY_REQUEST.value());
//		// 创建消息体
//		MatchQuery body = new MatchQuery();
//		body.setMatch(match);
//		tm.setBody(body);
//		return tm;
//	}*/
//}
