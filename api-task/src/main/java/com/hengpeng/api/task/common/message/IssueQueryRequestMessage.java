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

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @ClassName: IssueQueryRequestMessage
 * @Description: 奖期查询
 * @author: zhangwei
 * @date: 2017年7月26日 下午2:25:53
 */
@XStreamAlias("message")
public class IssueQueryRequestMessage {
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

		private IssueQuery issueQuery;

		public IssueQuery getIssueQuery() {
			if (issueQuery == null) {
				issueQuery = new IssueQuery();
			}
			return issueQuery;
		}

		public static class IssueQuery {

			private Issue issue;

			public Issue getIssue() {
				if (issue == null) {
					issue = new Issue();
				}
				return issue;
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
		}
	}

}
