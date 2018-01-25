/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: TestRVO.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.vo 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月6日 下午8:28:36 
 * @version: V1.0   
 */
package com.hengpeng.api.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class TestRVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Length(min=6, max=20)
	private String name;
	@NotNull
	private String password;
	@NotNull
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "TestRVO [name=" + name + ", password=" + password + ", age=" + age + "]";
	}

}
