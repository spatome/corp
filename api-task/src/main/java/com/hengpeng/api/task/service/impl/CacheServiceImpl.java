/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: CacheServiceImpl.java 
 * @Prject: api-task
 * @Package: com.hengpeng.api.task.service.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月8日 上午10:01:00 
 * @version: V1.0   
 */
package com.hengpeng.api.task.service.impl;

import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;
import com.hengpeng.api.task.service.CacheService;

/** 
 * @ClassName: CacheServiceImpl 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月8日 上午10:01:00  
 */
@Service
public class CacheServiceImpl implements CacheService {
	
	protected static Logger LOGGER = LoggerFactory.getLogger(CacheServiceImpl.class);

	private final static String KEY_PRINTISSUE_ISSUE_NO = "CACHE.PRINTISSUE.ISSUE_NO";

	@Resource
	private EhCacheCacheManager cacheManager;
	
	public boolean setPrintIssueNo(String key, String value) {
		try {
			if(StringUtils.isEmpty(key)){
				return false;
			}

			Cache cache = cacheManager.getCache(KEY_PRINTISSUE_ISSUE_NO);
			cache.put(key, value);
			
			return true;
		} catch (Exception e) {
			LOGGER.error("setPrintIssueNo:", e);
			return false;
		}
	}

	public String getPrintIssueNo(String key) {
		try {
			if(key==null){
				return null;
			}

			Cache cache = cacheManager.getCache(KEY_PRINTISSUE_ISSUE_NO);
			ValueWrapper vw = cache.get(key);
			if(vw==null){
				return null;
			}else{
				return String.valueOf(vw.get());
			}
		} catch (Exception e) {
			LOGGER.error("getPrintIssueNo:", e);
		}
		
		return null;
	}
}
