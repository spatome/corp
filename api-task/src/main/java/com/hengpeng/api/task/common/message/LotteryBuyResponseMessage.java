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
 * @ClassName: LotteryBuyResponseMessage
 * @Description: 消息类
 * @author: zhangwei
 * @date: 2017年7月26日 下午2:25:53
 */
@XStreamAlias("message")
public class LotteryBuyResponseMessage {
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
			private LotteryRequestResult lotteryRequestResult;

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
			public LotteryRequestResult getLotteryRequestResult() {
				if(lotteryRequestResult==null){
					lotteryRequestResult = new LotteryRequestResult();
				}
				return lotteryRequestResult;
			}
			public void setLotteryRequestResult(LotteryRequestResult lotteryRequestResult) {
				this.lotteryRequestResult = lotteryRequestResult;
			}

			public static class LotteryRequestResult {
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
					private String dealTime;
					@XStreamAsAttribute
					private String status;
					@XStreamAsAttribute
					private String message;
					@XStreamAsAttribute
					private String ticketSerialNo;
					public String getId() {
						return id;
					}
					public void setId(String id) {
						this.id = id;
					}
					public String getDealTime() {
						return dealTime;
					}
					public void setDealTime(String dealTime) {
						this.dealTime = dealTime;
					}
					public String getStatus() {
						return status;
					}
					public void setStatus(String status) {
						this.status = status;
					}
					public String getMessage() {
						return message;
					}
					public void setMessage(String message) {
						this.message = message;
					}
					public String getTicketSerialNo() {
						return ticketSerialNo;
					}
					public void setTicketSerialNo(String ticketSerialNo) {
						this.ticketSerialNo = ticketSerialNo;
					}
				}
			}
		}
	}
}