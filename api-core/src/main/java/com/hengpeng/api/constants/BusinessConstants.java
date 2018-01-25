/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: MessageConstants.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.constants 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月21日 下午1:46:36 
 * @version: V1.0   
 */
package com.hengpeng.api.constants;

/** 
 * @ClassName: BusinessConstants 
 * @Description: 业务常量
 * @author: zhangwei
 * @date: 2017年7月21日 下午1:46:36  
 */
public class BusinessConstants {


	/**
	 * 双色球投注最大票数
	 */
	public final static int SSQ_BUY_TICKET_MAX_NUM = 100;

	/**
	 * 查询订单最大票数
	 */
	public final static int QUERY_ORDER_MAX_NUM = 100;
	
	/**
	 * 查询中奖详情页最大
	 */
	public final static int QUERY_BONUS_LIST_MAX_PAGE_SIZE = 10000;
	/**
	 * 查询中奖详情页默认大小
	 */
	public final static int QUERY_BONUS_LIST_DEFAULT_PAGE_SIZE = 1000;


	/**
	 * 奖期开始时间-实际开始时间（如果延迟则为正，提前则为负，单位秒）
	 */
	public final static long ISSUE_START_TIME_OFFSET = 0l;
	public final static long ISSUE_STOP_TIME_OFFSET = -300l;
	
	/**
	 * 奖期同步结束状态(由中心设定的值)
	 */
	public final static int TASK_ISSUE_STOP_STATUS = 3;
	/*public final static int TASK_ISSUE_STOP_STATUS = 5;*/
}
