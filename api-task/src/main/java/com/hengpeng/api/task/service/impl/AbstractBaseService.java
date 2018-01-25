/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: AbstractBaseService.java 
 * @Prject: api-task
 * @Package: com.hengpeng.api.task.service 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月8日 下午2:23:27 
 * @version: V1.0   
 */
package com.hengpeng.api.task.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hengpeng.api.task.daofactory.DaoFactory;
import com.hengpeng.api.task.servicefactory.ServiceFactory;

/** 
 * @ClassName: AbstractBaseService 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月8日 下午2:23:27  
 */
public abstract class AbstractBaseService {

	protected static Logger LOGGER = LoggerFactory.getLogger(AbstractBaseService.class);

	@Resource
	protected ServiceFactory serviceFactory;
	
	@Resource
	protected DaoFactory daoFactory;
}
