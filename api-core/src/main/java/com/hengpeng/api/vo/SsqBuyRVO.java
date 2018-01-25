/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: SsqBuyRVo.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.vo 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月2日 下午5:07:34 
 * @version: V1.0   
 */
package com.hengpeng.api.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @ClassName: SsqBuyRVO
 * @Description: 双色球投注请求
 * @author: zhangwei
 * @date: 2017年8月2日 下午5:07:34
 */
public class SsqBuyRVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String enterpriseNo;
	private List<SsqTicket> list;

	public String getEnterpriseNo() {
		return enterpriseNo;
	}

	public void setEnterpriseNo(String enterpriseNo) {
		this.enterpriseNo = enterpriseNo;
	}

	public List<SsqTicket> getList() {
		if(list==null){
			list = new ArrayList<SsqTicket>();
		}
		return list;
	}

	public void setList(List<SsqTicket> list) {
		this.list = list;
	}

	public static class SsqTicket implements Serializable {
		private static final long serialVersionUID = 1L;

		@NotBlank
		private String ticketNo;
		private String orderNo;
		@NotBlank
		private String cardNo;
		@NotBlank
		private String realName;
		@NotBlank
		private String mobile;
		private String mail;
		@Length(min=7, max=7)
		private String issueNo;
		@NotBlank
		private String gameType;
		@NotBlank
		private String playType;
		private String times;
		@NotBlank
		private String lotterys;
		@NotBlank
		private String amount;

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

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public String getIssueNo() {
			return issueNo;
		}

		public void setIssueNo(String issueNo) {
			this.issueNo = issueNo;
		}

		public String getGameType() {
			return gameType;
		}

		public void setGameType(String gameType) {
			this.gameType = gameType;
		}

		public String getPlayType() {
			return playType;
		}

		public void setPlayType(String playType) {
			this.playType = playType;
		}

		public String getTimes() {
			return times;
		}

		public void setTimes(String times) {
			this.times = times;
		}

		public String getLotterys() {
			return lotterys;
		}

		public void setLotterys(String lotterys) {
			this.lotterys = lotterys;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}
	}
}
