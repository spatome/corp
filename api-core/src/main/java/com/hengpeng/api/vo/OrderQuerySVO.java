/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: Loterry.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.vo 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月24日 上午9:11:11 
 * @version: V1.0   
 */
package com.hengpeng.api.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OrderQuerySVO
 * @Description: 订单查询应答
 * @author: zhangwei
 * @date: 2017年7月24日 上午9:11:11
 */
public class OrderQuerySVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<TicketInfo> list;

	public List<TicketInfo> getList() {
		if (list == null) {
			list = new ArrayList<TicketInfo>();
		}
		return list;
	}

	public void setList(List<TicketInfo> list) {
		this.list = list;
	}

	public static class TicketInfo implements Serializable {
		private static final long serialVersionUID = 1L;

		private String ticketNo;
		private String orderNo;
		private String gameType;
		private String issueNo;
		private String playType;
		private String amount;
		private String times;
		private String status;
		private String statusDescs;
		private String dealTime;
		private String cardNo;
		private String realName;
		private String mobile;
		private String lotterys;

		public String getTicketNo() {
			return ticketNo;
		}

		public void setTicketNo(String ticketNo) {
			this.ticketNo = ticketNo;
		}

		public String getOrderNo() {
			return orderNo;
		}

		public void setOrderNo(String orderNo) {
			this.orderNo = orderNo;
		}

		public String getGameType() {
			return gameType;
		}

		public void setGameType(String gameType) {
			this.gameType = gameType;
		}

		public String getIssueNo() {
			return issueNo;
		}

		public void setIssueNo(String issueNo) {
			this.issueNo = issueNo;
		}

		public String getPlayType() {
			return playType;
		}

		public void setPlayType(String playType) {
			this.playType = playType;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}

		public String getTimes() {
			return times;
		}

		public void setTimes(String times) {
			this.times = times;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getStatusDescs() {
			return statusDescs;
		}

		public void setStatusDescs(String statusDescs) {
			this.statusDescs = statusDescs;
		}

		public String getDealTime() {
			return dealTime;
		}

		public void setDealTime(String dealTime) {
			this.dealTime = dealTime;
		}

		public String getCardNo() {
			return cardNo;
		}

		public void setCardNo(String cardNo) {
			this.cardNo = cardNo;
		}

		public String getRealName() {
			return realName;
		}

		public void setRealName(String realName) {
			this.realName = realName;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getLotterys() {
			return lotterys;
		}

		public void setLotterys(String lotterys) {
			this.lotterys = lotterys;
		}

	}
}