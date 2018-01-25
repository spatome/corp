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

/**
 * @ClassName: SsqBuySVO
 * @Description: 双色球投注应答
 * @author: zhangwei
 * @date: 2017年8月2日 下午5:07:34
 */
public class SsqBuySVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String failCount;
	private String fialTicketNos;
	private List<TicketOrder> list;

	public String getFailCount() {
		return failCount;
	}

	public void setFailCount(String failCount) {
		this.failCount = failCount;
	}

	public String getFialTicketNos() {
		return fialTicketNos;
	}

	public void setFialTicketNos(String fialTicketNos) {
		this.fialTicketNos = fialTicketNos;
	}

	public List<TicketOrder> getList() {
		if (list == null) {
			list = new ArrayList<TicketOrder>();
		}
		return list;
	}

	public void setList(List<TicketOrder> list) {
		this.list = list;
	}
	
	public static class TicketOrder implements Serializable {
		private static final long serialVersionUID = 1L;

		private String ticketNo;
		private String orderNo;

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
	}
}
