/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: DemoService.java 
 * @Prject: api-service
 * @Package: com.hengpeng.api.service 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月20日 下午12:56:31 
 * @version: V1.0   
 */
package com.hengpeng.api.service;

import com.hengpeng.api.exception.SException;

/** 
 * @ClassName: DemoService 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月20日 下午12:56:31  
 */
public interface DemoService {

	public void batchCreateOrder(String issueNo, int count) throws SException;
	
	public String hello(String name) throws SException;

}
