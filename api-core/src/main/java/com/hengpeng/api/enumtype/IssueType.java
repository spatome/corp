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
 * @ClassName: IssueType
 * @Description: 奖期类型
 * @author: zhangwei
 * @date: 2017年7月24日 上午10:33:04
 */
public enum IssueType {

	BOOKING("预售"), SALING("在售"), PAUSE("暂停销售"), CLOSE("奖期截止"), BONUS("已开奖"), END("已结束");

	private String text;

	IssueType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
