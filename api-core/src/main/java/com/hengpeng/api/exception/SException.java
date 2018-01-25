/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: SException.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.exception 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月20日 下午4:34:15 
 * @version: V1.0   
 */
package com.hengpeng.api.exception;

/**
 * @ClassName: SException
 * @Description: 自定义异常
 * @author: zhangwei
 * @date: 2017年7月20日 下午4:34:15
 */
public class SException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * @fieldName: code
	 * @fieldType: String
	 * @Description: 异常码
	 */
	private String code;

	public SException(String code, String message) {
		super(message);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	/*不写堆栈*/
	@Override
	public Throwable fillInStackTrace(){
		return this;
	}
}
