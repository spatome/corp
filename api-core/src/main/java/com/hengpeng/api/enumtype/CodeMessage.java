/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: MessageCode.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.enumtype 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月21日 下午5:54:35 
 * @version: V1.0   
 */
package com.hengpeng.api.enumtype;

/**
 * @ClassName: MessageCode
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月21日 下午5:54:35
 */
public enum CodeMessage {

	SUCCESS("0000", "操作成功"),
	FAILURE("9999", "操作失败"),
	NO_LOGIN_OR_LOGIN_TIMEOUT("0002", "未登录或登录超时"),
	MANDATORY_UPGRADE("0003", "强制升级");

	private String code;
	private String msg;

	private CodeMessage(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
