/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: BaseMessage.java 
 * @Prject: api-dhtz
 * @Package: com.hengpeng.api.dhtz.common.message 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月26日 下午2:25:53 
 * @version: V1.0   
 */
package com.hengpeng.api.task.common.message;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * @ClassName: LotteryBuyRequestMessage
 * @Description: 彩票购买
 * @author: zhangwei
 * @date: 2017年7月26日 下午2:25:53
 */
@XStreamAlias("message")
public class LotteryBuyRequestMessage {
	@XStreamAsAttribute
	private String version;

	@XStreamAsAttribute
	private String id;

	private MessageHeader header;

	private Body body;

	public MessageHeader getHeader() {
		if (header == null) {
			header = new MessageHeader();
		}
		return header;
	}

	public void setHeader(MessageHeader header) {
		this.header = header;
	}

	public Body getBody() {
		if (body == null) {
			body = new Body();
		}
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public static class Body {
		private LotteryRequest lotteryRequest;

		public LotteryRequest getLotteryRequest() {
			if(lotteryRequest==null){
				lotteryRequest = new LotteryRequest();
			}
			return lotteryRequest;
		}

		public void setLotteryRequest(LotteryRequest lotteryRequest) {
			this.lotteryRequest = lotteryRequest;
		}
		
		public static class LotteryRequest {
			@XStreamImplicit
			private List<Ticket> ticketList;

			public List<Ticket> getTicketList() {
				if(ticketList==null){
					ticketList = new ArrayList<Ticket>();
				}
				return ticketList;
			}

			public void setTicketList(List<Ticket> ticketList) {
				this.ticketList = ticketList;
			}
			
			@XStreamAlias("ticket")
			public static class Ticket {
				@XStreamAsAttribute
				private String id;
				@XStreamAsAttribute
				private String playType;
				@XStreamAsAttribute
				private String money;
				@XStreamAsAttribute
				private String amount;
				private Issue issue;
				private UserProfile userProfile;
				@XStreamImplicit(itemFieldName="anteCode")
				private List<String> anteCode = new ArrayList<String>() ;
				public String getId() {
					return id;
				}
				public void setId(String id) {
					this.id = id;
				}
				public String getPlayType() {
					return playType;
				}
				public void setPlayType(String playType) {
					this.playType = playType;
				}
				public String getMoney() {
					return money;
				}
				public void setMoney(String money) {
					this.money = money;
				}
				public String getAmount() {
					return amount;
				}
				public void setAmount(String amount) {
					this.amount = amount;
				}
				public Issue getIssue() {
					if(issue==null){
						issue = new Issue();
					}
					return issue;
				}
				public void setIssue(Issue issue) {
					this.issue = issue;
				}
				public UserProfile getUserProfile() {
					if(userProfile==null){
						userProfile = new UserProfile();
					}
					return userProfile;
				}
				public void setUserProfile(UserProfile userProfile) {
					this.userProfile = userProfile;
				}
				public List<String> getAnteCode() {
					return anteCode;
				}
				public void setAnteCode(List<String> anteCode) {
					this.anteCode = anteCode;
				}
				
				public static class Issue {
					@XStreamAsAttribute
					private String gameName;
					@XStreamAsAttribute
					private String number;
					public String getGameName() {
						return gameName;
					}
					public void setGameName(String gameName) {
						this.gameName = gameName;
					}
					public String getNumber() {
						return number;
					}
					public void setNumber(String number) {
						this.number = number;
					}
				}
				
				public static class UserProfile {
					@XStreamAsAttribute
					private String userName;
					@XStreamAsAttribute
					private String cardType;
					@XStreamAsAttribute
					private String cardNumber;
					@XStreamAsAttribute
					private String mail;
					@XStreamAsAttribute
					private String mobile;
					@XStreamAsAttribute
					private String realName;
					@XStreamAsAttribute
					private String bonusPhone;
					public String getUserName() {
						return userName;
					}
					public void setUserName(String userName) {
						this.userName = userName;
					}
					public String getCardType() {
						return cardType;
					}
					public void setCardType(String cardType) {
						this.cardType = cardType;
					}
					public String getCardNumber() {
						return cardNumber;
					}
					public void setCardNumber(String cardNumber) {
						this.cardNumber = cardNumber;
					}
					public String getMail() {
						return mail;
					}
					public void setMail(String mail) {
						this.mail = mail;
					}
					public String getMobile() {
						return mobile;
					}
					public void setMobile(String mobile) {
						this.mobile = mobile;
					}
					public String getRealName() {
						return realName;
					}
					public void setRealName(String realName) {
						this.realName = realName;
					}
					public String getBonusPhone() {
						return bonusPhone;
					}
					public void setBonusPhone(String bonusPhone) {
						this.bonusPhone = bonusPhone;
					}
				}
			}
		}
	}
}
