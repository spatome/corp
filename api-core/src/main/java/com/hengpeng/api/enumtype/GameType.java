/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: GameType.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.enumtype 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月24日 上午10:33:04 
 * @version: V1.0   
 */
package com.hengpeng.api.enumtype;

/**
 * @ClassName: GameType
 * @Description: 玩法
 * @author: zhangwei
 * @date: 2017年7月24日 上午10:33:04
 */
public enum GameType {

	/*格式：定义(编号，描述)*/

	SSQ("11", "双色球");

	private String code;
	private String text;

	GameType(String code, String text) {
		this.code = code;
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
