/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: SsqOrderStatus.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.enumtype 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月24日 上午11:11:05 
 * @version: V1.0   
 */
package com.hengpeng.api.enumtype;

/**
 * @ClassName: OrderStatus
 * @Description: 订单状态
 * @author: zhangwei
 * @date: 2017年7月24日 上午11:11:29
 */
public enum OrderStatus {

	UNDEAL("未处理"), DEALING("处理中"), SUCCESS("成功"), FAIL("失败");

	private String text;

	OrderStatus(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
