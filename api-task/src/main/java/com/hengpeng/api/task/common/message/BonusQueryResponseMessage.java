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
 * @ClassName: BonusQueryResponseMessage
 * @Description: 消息类
 * @author: zhangwei
 * @date: 2017年7月26日 下午2:25:53
 */
@XStreamAlias("message")
public class BonusQueryResponseMessage {
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
		private Response response;

		public Response getResponse() {
			if (response == null) {
				response = new Response();
			}
			return response;
		}

		public void setResponse(Response response) {
			this.response = response;
		}

		public static class Response {
			@XStreamAsAttribute
			private String code;
			@XStreamAsAttribute
			private String message;
			private BonusQueryResult bonusQueryResult;
			public String getCode() {
				return code;
			}
			public void setCode(String code) {
				this.code = code;
			}
			public String getMessage() {
				return message;
			}
			public void setMessage(String message) {
				this.message = message;
			}
			public BonusQueryResult getBonusQueryResult() {
				if(bonusQueryResult==null){
					bonusQueryResult = new BonusQueryResult();
				}
				return bonusQueryResult;
			}
			public void setBonusQueryResult(BonusQueryResult bonusQueryResult) {
				this.bonusQueryResult = bonusQueryResult;
			}
			
			public static class BonusQueryResult {
				@XStreamAsAttribute
				private String bonusNumber;
				@XStreamAsAttribute
				private String totalItems;
				@XStreamAsAttribute
				private String totalMoney;
				private Issue issue;
				@XStreamImplicit
				private List<BonusItem> bonusItemList;
				public String getBonusNumber() {
					return bonusNumber;
				}
				public void setBonusNumber(String bonusNumber) {
					this.bonusNumber = bonusNumber;
				}
				public String getTotalItems() {
					return totalItems;
				}
				public void setTotalItems(String totalItems) {
					this.totalItems = totalItems;
				}
				public String getTotalMoney() {
					return totalMoney;
				}
				public void setTotalMoney(String totalMoney) {
					this.totalMoney = totalMoney;
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
				public List<BonusItem> getBonusItemList() {
					if(bonusItemList==null){
						bonusItemList = new ArrayList<BonusItem>();
					}
					return bonusItemList;
				}
				public void setBonusItemList(List<BonusItem> bonusItemList) {
					this.bonusItemList = bonusItemList;
				}
				
				public static class Issue {
					@XStreamAsAttribute
					private String number;
					@XStreamAsAttribute
					private String gameName;
					public String getNumber() {
						return number;
					}
					public void setNumber(String number) {
						this.number = number;
					}
					public String getGameName() {
						return gameName;
					}
					public void setGameName(String gameName) {
						this.gameName = gameName;
					}
				}

				@XStreamAlias("bonusItem")
				public static class BonusItem {
					@XStreamAsAttribute
					private String playType;
					@XStreamAsAttribute
					private String money;
					@XStreamAsAttribute
					private String levelBonusMoney;
					@XStreamAsAttribute
					private String isBombBonus;
					@XStreamAsAttribute
					private String bonusLevel;
					@XStreamAsAttribute
					private String ticketID;
					@XStreamAsAttribute
					private String size;
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
					public String getLevelBonusMoney() {
						return levelBonusMoney;
					}
					public void setLevelBonusMoney(String levelBonusMoney) {
						this.levelBonusMoney = levelBonusMoney;
					}
					public String getIsBombBonus() {
						return isBombBonus;
					}
					public void setIsBombBonus(String isBombBonus) {
						this.isBombBonus = isBombBonus;
					}
					public String getBonusLevel() {
						return bonusLevel;
					}
					public void setBonusLevel(String bonusLevel) {
						this.bonusLevel = bonusLevel;
					}
					public String getTicketID() {
						return ticketID;
					}
					public void setTicketID(String ticketID) {
						this.ticketID = ticketID;
					}
					public String getSize() {
						return size;
					}
					public void setSize(String size) {
						this.size = size;
					}
				}
			}
		}
	}
}
