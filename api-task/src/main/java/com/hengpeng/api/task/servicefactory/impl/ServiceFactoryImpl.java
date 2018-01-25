/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: ServiceFactoryImpl.java 
 * @Prject: api-task
 * @Package: com.hengpeng.api.task.servicefactory.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月8日 下午1:48:43 
 * @version: V1.0   
 */
package com.hengpeng.api.task.servicefactory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.hengpeng.api.task.service.AccountService;
import com.hengpeng.api.task.service.BonusService;
import com.hengpeng.api.task.service.CacheService;
import com.hengpeng.api.task.service.CenterService;
import com.hengpeng.api.task.service.IssueService;
import com.hengpeng.api.task.service.LotteryService;
import com.hengpeng.api.task.service.SeqService;
import com.hengpeng.api.task.servicefactory.ServiceFactory;

/** 
 * @ClassName: ServiceFactoryImpl 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月8日 下午1:48:43  
 */
@Lazy
@Service
public class ServiceFactoryImpl implements ServiceFactory {

	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private SeqService seqServiceImpl;
	@Autowired
	private CenterService centerServiceImpl;
	@Autowired
	private CacheService cacheServiceImpl;
	
	@Autowired
	private BonusService bonusServiceImpl;
	@Autowired
	private IssueService issueServiceImpl;
	@Autowired
	private LotteryService lotteryServiceImpl;
	@Autowired
	private AccountService accountServiceImpl;
	
	@Override
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public SeqService getSeqService() {
		return seqServiceImpl;
	}

	@Override
	public CenterService getCenterService() {
		return centerServiceImpl;
	}

	@Override
	public CacheService getCacheService() {
		return cacheServiceImpl;
	}

	/** 
	 * @Description: TODO
	 * @return 
	 * @see com.hengpeng.api.task.servicefactory.ServiceFactory#getBonusService() 
	 */
	@Override
	public BonusService getBonusService() {
		return this.bonusServiceImpl;
	}

	/** 
	 * @Description: TODO
	 * @return 
	 * @see com.hengpeng.api.task.servicefactory.ServiceFactory#getIssueService() 
	 */
	@Override
	public IssueService getIssueService() {
		return this.issueServiceImpl;
	}

	/** 
	 * @Description: TODO
	 * @return 
	 * @see com.hengpeng.api.task.servicefactory.ServiceFactory#getLotteryService() 
	 */
	@Override
	public LotteryService getLotteryService() {
		return this.lotteryServiceImpl;
	}

	/** 
	 * @Description: TODO
	 * @return 
	 * @see com.hengpeng.api.task.servicefactory.ServiceFactory#getAccountService() 
	 */
	@Override
	public AccountService getAccountService() {
		return accountServiceImpl;
	}

}
