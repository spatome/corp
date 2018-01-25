/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: LoginVo.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.vo 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月21日 下午1:20:25 
 * @version: V1.0   
 */
package com.hengpeng.api.vo;

import java.io.Serializable;

/**
 * @ClassName: LoginSVO
 * @Description: 登录应答
 * @author: zhangwei
 * @date: 2017年7月21日 下午1:20:25
 */
public class LoginSVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
