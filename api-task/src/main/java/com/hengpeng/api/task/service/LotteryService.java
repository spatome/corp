/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: IssueService.java 
 * @Prject: api-task
 * @Package: com.hengpeng.api.task.service 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月8日 下午2:20:21 
 * @version: V1.0   
 */
package com.hengpeng.api.task.service;

import com.hengpeng.api.exception.SException;

/** 
 * @ClassName: LotteryService 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月8日 下午2:20:21  
 */
public interface LotteryService {

	/** 
	 * 上行
	 */
	public void synTicket() throws SException;
	
	/** 
	 * 下行
	 */
	public void synTicketStatus() throws SException;
}
