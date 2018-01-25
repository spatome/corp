/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: CacheService.java 
 * @Prject: api-task
 * @Package: com.hengpeng.api.task.service 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月8日 上午10:00:33 
 * @version: V1.0   
 */
package com.hengpeng.api.task.service;

/** 
 * @ClassName: CacheService 
 * @Description: ehcache
 * @author: zhangwei
 * @date: 2017年8月8日 上午10:00:33  
 */
public interface CacheService {

	public boolean setPrintIssueNo(String key, String value);
	public String getPrintIssueNo(String key);
}
