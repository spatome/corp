/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: BuyQueryVo.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.vo 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月24日 下午12:01:29 
 * @version: V1.0   
 */
package com.hengpeng.api.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @ClassName: OrderQueryRVO
 * @Description: 订单查询请求（最多100个）
 * @author: zhangwei
 * @date: 2017年7月24日 下午12:01:29
 */
public class OrderQueryRVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String enterpriseNo;
	@NotBlank
	private String orderNos;
	private String isMore;

	public String getEnterpriseNo() {
		return enterpriseNo;
	}

	public void setEnterpriseNo(String enterpriseNo) {
		this.enterpriseNo = enterpriseNo;
	}

	public String getOrderNos() {
		return orderNos;
	}

	public void setOrderNos(String orderNos) {
		this.orderNos = orderNos;
	}

	public String getIsMore() {
		return isMore;
	}

	public void setIsMore(String isMore) {
		this.isMore = isMore;
	}

	@Override
	public String toString() {
		return "OrderRVo [enterpriseNo=" + enterpriseNo + ", orderNos=" + orderNos + ", isMore=" + isMore + "]";
	}
}
