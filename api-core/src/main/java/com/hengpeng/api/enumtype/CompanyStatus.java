/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: CompanyStatus.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.enumtype 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月21日 下午3:04:34 
 * @version: V1.0   
 */
package com.hengpeng.api.enumtype;

/**
 * @ClassName: CompanyStatus
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月21日 下午3:04:34
 */
public enum CompanyStatus {
	/**
	 * 正常
	 */
	ACTIVE("正常"),
	/**
	 * 关闭
	 */
	CLOSED("关闭"),
	/**
	 * 未激活
	 */
	NOTACTIVE("未激活"),
	/**
	 * 暂停
	 */
	PAUSE("暂停");

	private String text;

	CompanyStatus(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
