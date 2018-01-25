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
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @ClassName: LoginRVO
 * @Description: 登录请求
 * @author: zhangwei
 * @date: 2017年7月21日 下午1:20:25
 */
public class LoginRVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String openKey;
	@NotBlank
	private String openSecret;
	@Length(min=14, max=14)
	private String timeStamp;

	public String getOpenKey() {
		return openKey;
	}

	public void setOpenKey(String openKey) {
		this.openKey = openKey;
	}

	public String getOpenSecret() {
		return openSecret;
	}

	public void setOpenSecret(String openSecret) {
		this.openSecret = openSecret;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "LoginRVO [openKey=" + openKey + ", openSecret=" + openSecret + ", timeStamp=" + timeStamp + "]";
	}
}
