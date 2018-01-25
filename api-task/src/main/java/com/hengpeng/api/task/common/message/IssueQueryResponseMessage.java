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
 * @ClassName: IssueQueryRequestMessage
 * @Description: 消息类
 * @author: zhangwei
 * @date: 2017年7月26日 下午2:25:53
 */
@XStreamAlias("message")
public class IssueQueryResponseMessage {
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
			@XStreamImplicit
			private List<Issue> issueList;

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

			public List<Issue> getIssueList() {
				if (issueList == null) {
					issueList = new ArrayList<Issue>();
				}
				return issueList;
			}

			public void setIssueList(List<Issue> issueList) {
				this.issueList = issueList;
			}

			@XStreamAlias("issue")
			public static class Issue {
				@XStreamAsAttribute
				private String gameName;
				@XStreamAsAttribute
				private String number;
				@XStreamAsAttribute
				private String startTime;
				@XStreamAsAttribute
				private String stopTime;
				@XStreamAsAttribute
				private String officialStartTime;
				@XStreamAsAttribute
				private String officialStopTime;
				@XStreamAsAttribute
				private String status;
				@XStreamAsAttribute
				private String bonusCode;

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

				public String getStartTime() {
					return startTime;
				}

				public void setStartTime(String startTime) {
					this.startTime = startTime;
				}

				public String getStopTime() {
					return stopTime;
				}

				public void setStopTime(String stopTime) {
					this.stopTime = stopTime;
				}

				public String getOfficialStartTime() {
					return officialStartTime;
				}

				public void setOfficialStartTime(String officialStartTime) {
					this.officialStartTime = officialStartTime;
				}

				public String getOfficialStopTime() {
					return officialStopTime;
				}

				public void setOfficialStopTime(String officialStopTime) {
					this.officialStopTime = officialStopTime;
				}

				public String getStatus() {
					return status;
				}

				public void setStatus(String status) {
					this.status = status;
				}

				public String getBonusCode() {
					return bonusCode;
				}

				public void setBonusCode(String bonusCode) {
					this.bonusCode = bonusCode;
				}

				@Override
				public String toString() {
					return "Issue [gameName=" + gameName + ", number=" + number + ", startTime=" + startTime
							+ ", stopTime=" + stopTime + ", officialStartTime=" + officialStartTime
							+ ", officialStopTime=" + officialStopTime + ", status=" + status + ", bonusCode="
							+ bonusCode + "]";
				}

			}
		}
	}
}
