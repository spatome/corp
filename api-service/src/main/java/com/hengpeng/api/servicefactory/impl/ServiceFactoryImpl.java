/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: ServiceFactoryImpl.java 
 * @Prject: api-service
 * @Package: com.hengpeng.api.servicefactory.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月21日 上午10:58:58 
 * @version: V1.0   
 */
package com.hengpeng.api.servicefactory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.hengpeng.api.service.BonusService;
import com.hengpeng.api.service.DemoService;
import com.hengpeng.api.service.SSQService;
import com.hengpeng.api.service.SeqService;
import com.hengpeng.api.service.UserService;
import com.hengpeng.api.servicefactory.ServiceFactory;

/** 
 * @ClassName: ServiceFactoryImpl 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月21日 上午10:58:58  
 */
@Lazy
@Service
public class ServiceFactoryImpl implements ServiceFactory {

	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private SeqService seqServiceImpl;
	@Autowired
	private DemoService demoServiceImpl;
	@Autowired
	private UserService userServiceImpl;
	@Autowired
	private SSQService sSQServiceImpl;
	@Autowired
	private BonusService bonusServiceImpl;
	
	@Override
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public DemoService getDemoService() {
		return demoServiceImpl;
	}

	@Override
	public UserService getUserService() {
		return userServiceImpl;
	}

	@Override
	public SSQService getSSQService() {
		return sSQServiceImpl;
	}

	@Override
	public BonusService getBonusService() {
		return bonusServiceImpl;
	}

	/** 
	 * @Description: TODO
	 * @return 
	 * @see com.hengpeng.api.servicefactory.ServiceFactory#getSeqService() 
	 */
	@Override
	public SeqService getSeqService() {
		return seqServiceImpl;
	}
}
