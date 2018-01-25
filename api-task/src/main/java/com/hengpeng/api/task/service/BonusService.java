/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: BonusService.java 
 * @Prject: api-task
 * @Package: com.hengpeng.api.task.service 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月9日 下午5:00:54 
 * @version: V1.0   
 */
package com.hengpeng.api.task.service;

import com.hengpeng.api.exception.SException;

/** 
 * @ClassName: BonusService 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月9日 下午5:00:54  
 */
public interface BonusService {

	
	/** 
	 * @Description: 兑奖
	 * @throws SException
	 * @return: void
	 */
	public void synBonus() throws SException;
}
