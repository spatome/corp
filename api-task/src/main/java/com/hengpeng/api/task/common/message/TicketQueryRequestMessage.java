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
 * @ClassName: TicketQueryRequestMessage
 * @Description: 票查询
 * @author: zhangwei
 * @date: 2017年7月26日 下午2:25:53
 */
@XStreamAlias("message")
public class TicketQueryRequestMessage {
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
		private TicketQuery ticketQuery;

		public TicketQuery getTicketQuery() {
			if (ticketQuery == null) {
				ticketQuery = new TicketQuery();
			}
			return ticketQuery;
		}

		public void setTicketQuery(TicketQuery ticketQuery) {
			this.ticketQuery = ticketQuery;
		}

		public static class TicketQuery {
			@XStreamImplicit
			private List<Ticket> ticketList;

			public List<Ticket> getTicketList() {
				if(ticketList==null) {
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

				public String getId() {
					return id;
				}

				public void setId(String id) {
					this.id = id;
				}
			}
		}
	}
}
