/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: PrintIssueType.java 
 * @Prject: api-task
 * @Package: com.hengpeng.api.task.common.enums 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月10日 下午6:47:59 
 * @version: V1.0   
 */
package com.hengpeng.api.task.common.enums;

/** 
 * @ClassName: PrintIssueType 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月10日 下午6:47:59  
 */
public enum PrintIssueType {
	BOOKING("0", "预开启(奖期未开启)"), 
	SALING("1", "开启新奖期"), 
	PAUSE("2", "暂停销售"), 
	CLOSE("3", "奖期截止"), 
	END_SETTING("4", "完成期结，可以执行销量查询,没完成返奖"), 
	END_BONUS("5", "完成返奖，可执行返奖查询，没完成期结"), 
	BONUS_CODE("6", "发送开奖号码"), 
	END("7", "完成期结和返奖,可执行返奖，销量查询");

	private String value;
	private String text;

	PrintIssueType(String value, String text) {
		this.value = value;
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
