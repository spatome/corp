/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: BusConstants.java 
 * @Prject: api-dhtz
 * @Package: com.hengpeng.api.dhtz.common.constants 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月27日 下午12:36:13 
 * @version: V1.0   
 */
package com.hengpeng.api.task.common.constants;

import java.util.HashMap;
import java.util.Map;

import com.hengpeng.api.enumtype.IssueType;

/** 
 * @ClassName: BusConstants 
 * @Description: 定时任务业务常量
 * @author: zhangwei
 * @date: 2017年7月27日 下午12:36:13  
 */
public class BusConstants {

	//	------------------------------和中心相关-----------------------------
	/**
	 * @Description: XML报文头，包括回车换行
	 */
	public final static String XML_HEAD = "<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n";

	/**
	 * @Description: 彩票中心报文版本号
	 */
	public final static String CENTER_VERSION = "1.1";
	
	/**
	 * @Description: Map<中心奖期状态, API奖期状态>
	 */
	public static Map<String, String> ISSUE_TYPE = new HashMap<String, String>();
	static{
		//预开启(奖期未开启)
		ISSUE_TYPE.put("0", IssueType.BOOKING.toString());
		//开启新奖期
		ISSUE_TYPE.put("1", IssueType.SALING.toString());
		//暂停销售
		ISSUE_TYPE.put("2", IssueType.PAUSE.toString());
		//奖期截止
		ISSUE_TYPE.put("3", IssueType.CLOSE.toString());
		//完成期结，可以执行销量查询,没完成返奖,此时可以返奖
		ISSUE_TYPE.put("4", IssueType.CLOSE.toString());
		//完成返奖，可执行返奖查询，没完成期结
		ISSUE_TYPE.put("5", IssueType.BONUS.toString());
		//发送开奖号码
		ISSUE_TYPE.put("6", IssueType.BONUS.toString());
		//完成期结和返奖,可执行返奖，销量查询
		ISSUE_TYPE.put("7", IssueType.END.toString());
	}
	
	//	---------------------------END	和中心相关----------------------------
}
