/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: AsyncService.java 
 * @Prject: api-task
 * @Package: com.hengpeng.api.task.service 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月15日 上午9:41:58 
 * @version: V1.0   
 */
package com.hengpeng.api.task.service;

/**
 * @ClassName: AsyncService
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月15日 上午9:41:58
 */
public interface HttpAsyncService {
	/**
	 * 处理异常时，执行该方法
	 * 
	 * @return
	 */
	void failed(Exception ex);

	/**
	 * 处理正常时，执行该方法
	 * 
	 * @return
	 */
	void completed(String responseBody);

	/**
	 * 处理取消时，执行该方法
	 * 
	 * @return
	 */
	void cancelled();
}
