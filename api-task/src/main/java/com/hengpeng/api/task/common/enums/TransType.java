/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: TransType.java 
 * @Prject: api-dhtz
 * @Package: com.hengpeng.api.dhtz.common.enums 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月26日 下午5:55:33 
 * @version: V1.0   
 */
package com.hengpeng.api.task.common.enums;

/**
 * 交易类型
 * 
 * @author linriqing
 * @version 1.0, 2010-2-5
 */
public enum TransType {
	/**
	 * 交易类型：彩民帐户资金查询请求 116
	 */
	TRANSTYPE_ACCOUNTQUERY_REQUEST(116, "彩民帐户资金查询请求", TransTypeDirect.IN, 516),

	/**
	 * 交易类型：彩民帐户资金查询响应 516
	 */
	TRANSTYPE_ACCOUNTQUERY_RESPONSE(516, "彩民帐户资金查询响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：销量查询请求 107
	 */
	TRANSTYPE_BALANCEQUERY_REQUEST(107, "销量查询请求", TransTypeDirect.IN, 507),

	/**
	 * 交易类型：销量查询响应 507
	 */
	TRANSTYPE_BALANCEQUERY_RESPONSE(507, "销量查询响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：奖期通知请求
	 * <p>
	 * 107
	 * </p>
	 */
	TRANSTYPE_BONUSNOTIFY_REQUEST(108, "返奖通知请求", TransTypeDirect.OUT, 508),

	/**
	 * 交易类型：奖期通知响应
	 * <p>
	 * 507
	 * </p>
	 */
	TRANSTYPE_BONUSNOTIFY_RESPONSE(508, "返奖通知响应", TransTypeDirect.IN, 599),

	/**
	 * 交易类型：返奖查询请求
	 * <p>
	 * 106
	 * </p>
	 */
	TRANSTYPE_BONUSQUERY_REQUEST(106, "返奖查询请求", TransTypeDirect.IN, 506),

	/**
	 * 交易类型：返奖查询响应
	 * <p>
	 * 506
	 * </p>
	 */
	TRANSTYPE_BONUSQUERY_RESPONSE(506, "返奖查询响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：代理商保证金查询请求
	 * <p>
	 * 131
	 * </p>
	 */
	TRANSTYPE_DEPOSITQUERY_REQUEST(132, "代理商保证金查询请求", TransTypeDirect.IN, 532),

	/**
	 * 交易类型：代理商保证金查询响应
	 * <p>
	 * 531
	 * </p>
	 */
	TRANSTYPE_DEPOSITQUERY_RESPONSE(532, "代理商保证金查询响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：提款通知请求
	 * <p>
	 * 107
	 * </p>
	 */
	TRANSTYPE_DRAWINGNOTIFY_REQUEST(112, "提款通知请求", TransTypeDirect.OUT, 512),

	/**
	 * 交易类型：提款通知响应
	 * <p>
	 * 507
	 * </p>
	 */
	TRANSTYPE_DRAWINGNOTIFY_RESPONSE(512, "提款通知响应", TransTypeDirect.IN, 599),

	/**
	 * 交易类型：提款查询请求
	 * <p>
	 * 107
	 * </p>
	 */
	TRANSTYPE_DRAWINGQUERY_REQUEST(113, "提款查询请求", TransTypeDirect.IN, 513),

	/**
	 * 交易类型：提款查询响应
	 * <p>
	 * 507
	 * </p>
	 */
	TRANSTYPE_DRAWINGQUERY_RESPONSE(513, "提款查询响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：提款请求
	 * <p>
	 * 107
	 * </p>
	 */
	TRANSTYPE_DRAWINGREQUEST_REQUEST(111, "提款请求", TransTypeDirect.IN, 511),

	/**
	 * 交易类型：提款响应
	 * <p>
	 * 507
	 * </p>
	 */
	TRANSTYPE_DRAWINGREQUEST_RESPONSE(511, "提款响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：充值通知请求
	 * <p>
	 * 107
	 * </p>
	 */
	TRANSTYPE_FILLNOTIFY_REQUEST(109, "充值通知请求", TransTypeDirect.OUT, 509),

	/**
	 * 交易类型：充值通知响应
	 * <p>
	 * 507
	 * </p>
	 */
	TRANSTYPE_FILLNOTIFY_RESPONSE(509, "充值通知响应", TransTypeDirect.IN, 599),

	/**
	 * 交易类型：充值查询请求
	 * <p>
	 * 107
	 * </p>
	 */
	TRANSTYPE_FILLQUERY_REQUEST(110, "充值查询请求", TransTypeDirect.IN, 510),

	/**
	 * 交易类型：充值查询响应
	 * <p>
	 * 507
	 * </p>
	 */
	TRANSTYPE_FILLQUERY_RESPONSE(510, "充值查询响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：奖期通知请求
	 * <p>
	 * 101
	 * </p>
	 */
	TRANSTYPE_ISSUENOTIFY_REQUEST(101, "奖期通知请求", TransTypeDirect.OUT, 501),

	/**
	 * 交易类型：奖期通知响应
	 * <p>
	 * 501
	 * </p>
	 */
	TRANSTYPE_ISSUENOTIFY_RESPONSE(501, "奖期通知响应", TransTypeDirect.IN, 599),

	/**
	 * 交易类型：奖期通知请求
	 * <p>
	 * 102
	 * </p>
	 */
	TRANSTYPE_ISSUEQUERY_REQUEST(102, "奖期查询请求", TransTypeDirect.IN, 502),

	/**
	 * 交易类型：奖期通知响应
	 * <p>
	 * 502
	 * </p>
	 */
	TRANSTYPE_ISSUEQUERY_RESPONSE(502, "奖期查询响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：投注请求结果通知接口请求
	 * <p>
	 * 136
	 * </p>
	 */
	TRANSTYPE_LOTTERYNOTIFY_REQUEST(136, "投注请求结果通知接口请求", TransTypeDirect.OUT, 536),

	/**
	 * 交易类型：投注请求结果通知接口响应
	 * <p>
	 * 536
	 * </p>
	 */
	TRANSTYPE_LOTTERYNOTIFY_RESPONSE(536, "投注请求结果通知接口响应", TransTypeDirect.IN, 599),

	/**
	 * 交易类型：投注请求
	 * <p>
	 * 103
	 * </p>
	 */
	TRANSTYPE_LOTTERYREQUEST_REQUEST(103, "投注请求", TransTypeDirect.IN, 503),

	/**
	 * 交易类型：投注响应
	 * <p>
	 * 503
	 * </p>
	 */
	TRANSTYPE_LOTTERYREQUEST_RESPONSE(503, "投注响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：投注请求结果查询接口请求
	 * <p>
	 * 137
	 * </p>
	 */
	TRANSTYPE_LOTTERYQUERY_REQUEST(137, "投注请求结果查询接口请求", TransTypeDirect.IN, 537),

	/**
	 * 交易类型：投注请求结果查询接口响应
	 * <p>
	 * 537
	 * </p>
	 */
	TRANSTYPE_LOTTERYQUERY_RESPONSE(537, "投注请求结果查询接口响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：交易类型不存在。
	 * <p>
	 * 599
	 * </p>
	 */
	TRANSTYPE_NOTSUPPORT_RESPONSE(599, "交易类型不存在", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：赠金请求
	 * <p>
	 * 114
	 * </p>
	 */
	TRANSTYPE_PRESENTMONEY_REQUEST(114, "赠金请求", TransTypeDirect.IN, 514),

	/**
	 * 交易类型：赠金响应
	 * <p>
	 * 514
	 * </p>
	 */
	TRANSTYPE_PRESENTMONEY_RESPONSE(514, "赠金响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：赠金查询请求
	 * <p>
	 * 115
	 * </p>
	 */
	TRANSTYPE_PRESENTQUERY_REQUEST(115, "赠金查询请求", TransTypeDirect.IN, 515),

	/**
	 * 交易类型：赠金查询响应
	 * <p>
	 * 515
	 * </p>
	 */
	TRANSTYPE_PRESENTQUERY_RESPONSE(515, "赠金查询响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：开奖公告通知接口请求
	 * <p>
	 * 138
	 * </p>
	 */
	TRANSTYPE_PRIZENOTIFY_REQUEST(138, "开奖公告通知接口请求", TransTypeDirect.OUT, 538),

	/**
	 * 交易类型：开奖公告通知接口响应
	 * <p>
	 * 538
	 * </p>
	 */
	TRANSTYPE_PRIZENOTIFY_RESPONSE(538, "开奖公告通知接口响应", TransTypeDirect.IN, 599),

	/**
	 * 交易类型：开奖公告查询接口请求
	 * <p>
	 * 139
	 * </p>
	 */
	TRANSTYPE_PRIZEQUERY_REQUEST(139, "开奖公告查询接口请求", TransTypeDirect.IN, 539),

	/**
	 * 交易类型：开奖公告查询接口响应
	 * <p>
	 * 539
	 * </p>
	 */
	TRANSTYPE_PRIZEQUERY_RESPONSE(539, "开奖公告查询接口响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：实时投注请求
	 * <p>
	 * 131
	 * </p>
	 */
	TRANSTYPE_REALTIMELOTTERYREQUEST_REQUEST(133, "实时投注请求", TransTypeDirect.IN, 533),

	/**
	 * 交易类型：实时投注响应
	 * <p>
	 * 531
	 * </p>
	 */
	TRANSTYPE_REALTIMELOTTERYREQUEST_RESPONSE(533, "实时投注响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：帐户注册请求
	 * <p>
	 * 130
	 * </p>
	 */
	TRANSTYPE_REGISTER_REQUEST(130, "帐户注册请求", TransTypeDirect.IN, 530),

	/**
	 * 交易类型：帐户注册响应
	 * <p>
	 * 530
	 * </p>
	 */
	TRANSTYPE_REGISTER_RESPONSE(530, "帐户注册响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：风险控制查询接口请求
	 * <p>
	 * 131
	 * </p>
	 */
	TRANSTYPE_RISKCONTROL_REQUEST(134, "风险控制查询接口请求", TransTypeDirect.IN, 534),

	/**
	 * 交易类型：风险控制查询接口响应
	 * <p>
	 * 531
	 * </p>
	 */
	TRANSTYPE_RISKCONTROL_RESPONSE(534, "风险控制查询接口响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：风险控制方式查询接口请求
	 * <p>
	 * 131
	 * </p>
	 */
	TRANSTYPE_RISKCONTROLPLAYTYPE_REQUEST(135, "风险控制方式查询接口请求", TransTypeDirect.IN, 535),

	/**
	 * 交易类型：风险控制方式查询接口响应
	 * <p>
	 * 531
	 * </p>
	 */
	TRANSTYPE_RISKCONTROLPLAYTYPE_RESPONSE(535, "风险控制方式查询接口响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：投注结果通知请求
	 * <p>
	 * 104
	 * </p>
	 */
	TRANSTYPE_TICKETNOTIFY_REQUEST(104, "投注结果通知请求", TransTypeDirect.OUT, 504),

	/**
	 * 交易类型：投注结果通知响应
	 * <p>
	 * 504
	 * </p>
	 */
	TRANSTYPE_TICKETNOTIFY_RESPONSE(504, "投注结果通知响应", TransTypeDirect.IN, 599),

	/**
	 * 交易类型：票查询请求
	 * <p>
	 * 105
	 * </p>
	 */
	TRANSTYPE_TICKETQUERY_REQUEST(105, "票查询请求", TransTypeDirect.IN, 505),

	/**
	 * 交易类型：票查询响应
	 * <p>
	 * 505
	 * </p>
	 */
	TRANSTYPE_TICKETQUERY_RESPONSE(505, "票查询响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：帐户更新请求
	 * <p>
	 * 131
	 * </p>
	 */
	TRANSTYPE_USERUPDATE_REQUEST(131, "帐户更新请求", TransTypeDirect.IN, 531),

	/**
	 * 交易类型：帐户更新响应
	 * <p>
	 * 531
	 * </p>
	 */
	TRANSTYPE_USERUPDATE_RESPONSE(531, "帐户更新响应", TransTypeDirect.OUT, 599),

	/**
	 * 提交结果查询请求
	 */
	TRANSTYPE_REQUESTLOG_QUERY_REQUEST(221, "提交结果查询请求", TransTypeDirect.IN, 721),

	/**
	 * 提交结果查询响应
	 */
	TRANSTYPE_REQUESTLOG_QUERY_RESPONSE(721, "提交结果查询响应", TransTypeDirect.OUT, 599),

	/**
	 * 查询多期奖期请求
	 */
	TRANSTYPE_ISSUES_QUERY_REQUEST(222, "查询多期奖期请求", TransTypeDirect.IN, 722),

	/**
	 * 查询多期奖期响应
	 */
	TRANSTYPE_ISSUES_QUERY_RESPONSE(722, "查询多期奖期响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：淘宝投注请求
	 * <p>
	 * 203
	 * </p>
	 */
	TRANSTYPE_TB_LOTTERYREQUEST_REQUEST(203, "淘宝投注请求", TransTypeDirect.IN, 703),

	/**
	 * 交易类型：淘宝投注响应
	 * <p>
	 * 703
	 * </p>
	 */
	TRANSTYPE_TB_LOTTERYREQUEST_RESPONSE(703, "淘宝投注响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：票查询请求
	 * <p>
	 * 205
	 * </p>
	 */
	TRANSTYPE_TB_TICKETQUERY_REQUEST(205, "淘宝票查询请求", TransTypeDirect.IN, 705),

	/**
	 * 交易类型：票查询响应
	 * <p>
	 * 705
	 * </p>
	 */
	TRANSTYPE_TB_TICKETQUERY_RESPONSE(705, "淘宝票查询响应", TransTypeDirect.OUT, 705),

	/**
	 * 交易类型：订单结果通知请求
	 * <p>
	 * 236
	 * </p>
	 */
	TRANSTYPE_TB_ORDERNOTIFY_REQUEST(236, "淘宝订单结果通知请求", TransTypeDirect.IN, 736),

	/**
	 * 交易类型：订单结果通知响应
	 * <p>
	 * 736
	 * </p>
	 */
	TRANSTYPE_TB_ORDERNOTIFY_RESPONSE(736, "订单结果通知响应", TransTypeDirect.OUT, 705),

	/**
	 * 竞彩赛事查询
	 */
	TRANSTYPE_MATCH_MATCHQUERY_REQUEST(151, "竞彩赛事查询", TransTypeDirect.IN, 551),
	/**
	 * 竞彩赛事响应
	 */
	TRANSTYPE_MATCH_MATCHQUERY_RESPONSE(551, "竞彩赛事响应", TransTypeDirect.OUT, 705),
	/**
	 * 竞彩赛果通知
	 */
	TRANSTYPE_MATCH_MATCHRESULT_NOTIFY_REQUEST(152, "竞彩赛果通知", TransTypeDirect.IN, 552),
	/**
	 * 竞彩赛果通知响应
	 */
	TRANSTYPE_MATCH_MATCHRESULT_NOTIF_RESPONSE(552, "竞彩赛果通知响应", TransTypeDirect.OUT, 705),
	/**
	 * 竞彩赛果查询
	 */
	TRANSTYPE_MATCH_MATCHRESULT_QUERY_REQUEST(153, "竞彩赛果查询", TransTypeDirect.IN, 553),
	/**
	 * 竞彩赛果查询响应
	 */
	TRANSTYPE_MATCH_MATCHRESULT_QUERY_RESPONSE(553, "竞彩赛果查询响应", TransTypeDirect.OUT, 705),
	/**
	 * 竞彩订单请求
	 */
	TRANSTYPE_MATCH_MATCHANTEBUY_REQUEST(154, "竞彩订单请求", TransTypeDirect.IN, 554),
	/**
	 * 竞彩订单请求响应
	 */
	TRANSTYPE_MATCH_MATCHANTEBUY_RESPONSE(554, "竞彩订单请求响应", TransTypeDirect.OUT, 705),
	/**
	 * 竞彩网易票投注请求
	 */
	TRANSTYPE_MATCH_TICKET_LOTTERY_NETEASY_REQUEST(173, "竞彩网易票投注请求", TransTypeDirect.IN, 573),
	/**
	 * 竞彩网易投注请求响应
	 */
	TRANSTYPE_MATCH_TICKET_LOTTERY_NETEASY_RESPONSE(573, "竞彩网易投注请求响应", TransTypeDirect.OUT, 705),
	/**
	 * 竞彩票投注请求
	 */
	TRANSTYPE_MATCH_TICKET_LOTTERY_REQUEST(174, "竞彩票投注请求", TransTypeDirect.IN, 574),
	/**
	 * 竞彩票投注请求响应
	 */
	TRANSTYPE_MATCH_TICKET_LOTTERY_RESPONSE(574, "竞彩票投注请求响应", TransTypeDirect.OUT, 705),
	/**
	 * 竞彩票结果通知请求
	 */
	TRANSTYPE_MATCH_TICKET_NOTIFY_REQUEST(175, "竞彩票结果通知请求", TransTypeDirect.IN, 575),
	/**
	 * 竞彩票结果通知响应
	 */
	TRANSTYPE_MATCH_TICKET_NOTIFY_RESPONSE(575, "竞彩票结果通知响应", TransTypeDirect.OUT, 705),
	/**
	 * 竞彩票结果查询请求
	 */
	TRANSTYPE_MATCH_TICKET_QUERY_REQUEST(176, "竞彩票结果查询请求", TransTypeDirect.IN, 576),
	/**
	 * 竞彩票结果查询响应
	 */
	TRANSTYPE_MATCH_TICKET_QUERY_RESPONSE(576, "竞彩票结果查询响应", TransTypeDirect.OUT, 705),
	/**
	 * 竞彩订单通知
	 */
	TRANSTYPE_MATCH_ORDER_NOTIFY_REQUEST(155, "竞彩订单通知", TransTypeDirect.IN, 555),
	/**
	 * 竞彩订单通知响应
	 */
	TRANSTYPE_MATCH_ORDER_NOTIFY_RESPONSE(555, "竞彩订单通知响应", TransTypeDirect.OUT, 705),
	/**
	 * 竞彩订单查询
	 */
	TRANSTYPE_MATCH_ORDER_WIN_REQUEST(156, "竞彩订单查询", TransTypeDirect.IN, 556),
	/**
	 * 竞彩订单查询响应
	 */
	TRANSTYPE_MATCH_ORDER_WIN_RESPONSE(556, "竞彩订单查询响应", TransTypeDirect.OUT, 705),
	/**
	 * 竞彩赔率查询
	 */
	TRANSTYPE_MATCH_LOSSRATIO_QUERY_REQUEST(157, "竞彩赔率查询", TransTypeDirect.IN, 557),
	/**
	 * 竞彩赔率查询响应
	 */
	TRANSTYPE_MATCH_LOSSRATIO_QUERY_RESPONSE(557, "竞彩赔率查询响应", TransTypeDirect.OUT, 705),
	/**
	 * 竞彩中奖文件查询
	 */
	TRANSTYPE_MATCH_WINFILE_QUERY_REQUEST(158, "竞彩中奖文件查询", TransTypeDirect.IN, 558),
	/**
	 * 竞彩中奖文件查询响应
	 */
	TRANSTYPE_MATCH_WINFILE_QUERY_RESPONSE(558, "竞彩中奖文件查询响应", TransTypeDirect.OUT, 705),
	/**
	 * 竞彩中奖文件明细
	 */
	TRANSTYPE_MATCH_WINFILE_BONUS_RESPONSE(559, "竞彩中奖明细文件", TransTypeDirect.OUT, 705),
	/**
	 * 大订单投注请求
	 */
	TRANSTYPE_BIG_ORDER_TICKET_REQUEST(163, "大订单投注明细交易", TransTypeDirect.IN, 563),
	/**
	 * 大订单投注请求
	 */
	TRANSTYPE_BIG_ORDER_WAGER_REQUEST(164, "大订单投注请求", TransTypeDirect.IN, 564),
	/**
	 * 大订单投注请求
	 */
	TRANSTYPE_BIG_ORDER_WAGER_RESPONSE(564, "大订单投注请求响应", TransTypeDirect.OUT, 705),
	/**
	 * 大订单投注请求
	 */
	TRANSTYPE_BIG_ORDER_NOTIFY_REQUEST(165, "大订单通知请求", TransTypeDirect.IN, 565),
	/**
	 * 大订单通知响应
	 */
	TRANSTYPE_BIG_ORDER_NOTIFY_RESPONSE(565, "大订单通知请求响应", TransTypeDirect.OUT, 705),
	/**
	 * 大订单查询请求
	 */
	TRANSTYPE_BIG_ORDER_QUERY_REQUEST(166, "大订单查询请求", TransTypeDirect.IN, 566),
	/**
	 * 大订单查询响应
	 */
	TRANSTYPE_BIG_ORDER_QUERY_RESPONSE(566, "大订单查询请求响应", TransTypeDirect.OUT, 705),
	/**
	 * 交易类型： POS机投注请求
	 * <p>
	 * 143
	 * </p>
	 */
	TRANSTYPE_POS_LOTTERY_REQUEST(143, "POS机投注请求", TransTypeDirect.IN, 543),

	/**
	 * 交易类型： POS机投注请求
	 * <p>
	 * 543
	 * </p>
	 */
	TRANSTYPE_POS_LOTTERY_RESPONSE(543, "POS机投注响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型： POS机中奖查询请求
	 * <p>
	 * 144
	 * </p>
	 */
	TRANSTYPE_POS_AwardQuery_REQUEST(144, "POS机中奖查询请求", TransTypeDirect.IN, 544),

	/**
	 * 交易类型：POS机中奖查询响应
	 * <p>
	 * 544
	 * </p>
	 */
	TRANSTYPE_POS_AwardQuery_RESPONSE(544, "POS机中奖查询响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型： POS机兑奖请求
	 * <p>
	 * 145
	 * </p>
	 */
	TRANSTYPE_POS_ENCASH_REQUEST(145, "POS机兑奖请求", TransTypeDirect.IN, 545),

	/**
	 * 交易类型：POS机兑奖响应
	 * <p>
	 * 545
	 * </p>
	 */
	TRANSTYPE_POS_ENCASH_RESPONSE(545, "POS机兑奖响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型： POS样票投注请求
	 * <p>
	 * 146
	 * </p>
	 */
	TRANSTYPE_POS_EXAMPLE_LOTTERY_REQUEST(146, "POS样票投注请求", TransTypeDirect.IN, 546),

	/**
	 * 交易类型：POS样票投注响应
	 * <p>
	 * 546
	 * </p>
	 */
	TRANSTYPE_POS_EXAMPLE_LOTTERY_RESPONSE(546, "POS样票投注响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型： POS日志消息请求
	 * <p>
	 * 147
	 * </p>
	 */
	TRANSTYPE_POS_LOG_REQUEST(147, " POS日志消息请求", TransTypeDirect.IN, 546),

	/**
	 * 交易类型：POS日志消息响应
	 * <p>
	 * 547
	 * </p>
	 */
	TRANSTYPE_POS_LOG_RESPONSE(547, "POS日志消息响应", TransTypeDirect.OUT, 599),
	/**
	 * 交易类型：POS销量兑奖统计请求
	 * <p>
	 * 148
	 * </p>
	 */
	TRANSTYPE_POS_STATIC_REQUEST(148, "POS销量兑奖统计请求", TransTypeDirect.IN, 548),

	/**
	 * 交易类型：POS销量兑奖统计响应
	 * <p>
	 * 548
	 * </p>
	 */
	TRANSTYPE_POS_STATIC_RESPONSE(548, "POS销量兑奖统计响应", TransTypeDirect.OUT, 599),
	/**
	 * 交易类型：POS开奖号码请求交易
	 * <p>
	 * 149
	 * </p>
	 */
	TRANSTYPE_POS_WINCODE_REQUEST(149, "POS开奖号码请求交易", TransTypeDirect.IN, 549),

	/**
	 * 交易类型：POS开奖号码查询请求响应
	 * <p>
	 * 549
	 * </p>
	 */
	TRANSTYPE_POS_WINCODE_RESPONSE(549, "POS开奖号码查询请求响应", TransTypeDirect.OUT, 599),

	/**
	 * 交易类型：POS投注结果查询请求
	 * <p>
	 * 168
	 * </p>
	 */
	TRANSTYPE_POS_LOTTERYRESULT_REQUEST(168, "POS投注结果查询请求", TransTypeDirect.IN, 568),

	/**
	 * 交易类型：POS投注结果查询响应
	 * <p>
	 * 568
	 * </p>
	 */
	TRANSTYPE_POS_LOTTERYRESULT_RESPONSE(568, "POS投注结果查询响应", TransTypeDirect.OUT, 599),
	/**
	 * 交易类型：POS票信息查询请求
	 * <p>
	 * 168
	 * </p>
	 */
	TRANSTYPE_POS_TICKETQUERY_REQUEST(169, "POS票信息查询请求", TransTypeDirect.IN, 569),

	/**
	 * 交易类型：POS票信息查询响应
	 * <p>
	 * 568
	 * </p>
	 */
	TRANSTYPE_POS_TICKETQUERY_RESPONSE(569, "POS票信息查询响应", TransTypeDirect.OUT, 599),
	/**
	 * 交易类型：POS软件升级版本请求
	 * <p>
	 * 120
	 * </p>
	 */
	TRANSTYPE_POS_SOFT_VERSION_REQUEST(120, "POS软件升级版本请求", TransTypeDirect.OUT, 520),

	/**
	 * 交易类型：POS软件升级版本响应
	 * <p>
	 * 520
	 * </p>
	 */
	TRANSTYPE_POS_SOFT_VERSION_RESPONSE(520, "POS软件升级版本响应", TransTypeDirect.IN, 599);
	;

	private enum TransTypeDirect {
		IN, OUT;
	}

	private TransTypeDirect direct;

	private int obverse;

	private String text;

	private int value;

	private TransType(int value, String text, TransTypeDirect direct, int obverse) {
		this.value = value;
		this.text = text;
		this.direct = direct;
		this.obverse = obverse;
	}

	/**
	 * @return 交易属于传入或传出类型
	 */
	public TransTypeDirect direct() {
		return direct;
	}

	/**
	 * @return 响应交易类型
	 */
	public int obverse() {
		return obverse;
	}

	/**
	 * @return 交易名称
	 */
	public String text() {
		return text;
	}

	/**
	 * @return 交易类型
	 */
	public int value() {
		return value;
	}
}
