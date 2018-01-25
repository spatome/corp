/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: AbstractBaseService.java 
 * @Prject: api-service
 * @Package: com.hengpeng.api.service 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月20日 下午12:57:36 
 * @version: V1.0   
 */
package com.hengpeng.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hengpeng.api.daofactory.DaoFactory;
import com.hengpeng.api.servicefactory.ServiceFactory;

/** 
 * @ClassName: AbstractBaseService 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月20日 下午12:57:36  
 */
public abstract class AbstractBaseService {
	protected static Logger LOGGER = LoggerFactory.getLogger(AbstractBaseService.class);

	@Autowired
	protected DaoFactory daoFactory;
	
	@Autowired
	protected ServiceFactory serviceFactory;

}
