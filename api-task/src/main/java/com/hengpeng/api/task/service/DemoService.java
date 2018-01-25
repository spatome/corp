/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: DemoService.java 
 * @Prject: api-task
 * @Package: com.hengpeng.api.task.service 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月10日 下午2:59:16 
 * @version: V1.0   
 */
package com.hengpeng.api.task.service;

import java.math.BigDecimal;

import com.hengpeng.api.exception.SException;

/** 
 * @ClassName: DemoService 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月10日 下午2:59:16  
 */
public interface DemoService {

	public void batchCreateOrder(String issueNo, int count) throws SException;
	
	public void test1(String accountNo, BigDecimal amount);
}
