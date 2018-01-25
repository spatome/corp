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
 * @ClassName: IssueService 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月8日 下午2:20:21  
 */
public interface IssueService {
	
	/** 
	 * @Description: 同步在售奖期
	 * @throws SException
	 * @return: void
	 */
	public void synNewPringIssue() throws SException;

	/** 
	 * @Description: 同步未结束的奖期
	 * @throws SException
	 * @return: void
	 */
	public void synBonusPrintIssue() throws SException;

	/** 
	 * @Description: 补充奖期
	 * @throws SException
	 * @return: void
	 */
	public void synSalingPringIssue() throws SException;

}
