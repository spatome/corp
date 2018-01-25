/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: ServiceFactory.java 
 * @Prject: api-task
 * @Package: com.hengpeng.api.task.servicefactory 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月8日 下午1:48:10 
 * @version: V1.0   
 */
package com.hengpeng.api.task.servicefactory;

import org.springframework.context.ApplicationContext;

import com.hengpeng.api.task.service.AccountService;
import com.hengpeng.api.task.service.BonusService;
import com.hengpeng.api.task.service.CacheService;
import com.hengpeng.api.task.service.CenterService;
import com.hengpeng.api.task.service.IssueService;
import com.hengpeng.api.task.service.LotteryService;
import com.hengpeng.api.task.service.SeqService;

/** 
 * @ClassName: ServiceFactory 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月8日 下午1:48:10  
 */
public interface ServiceFactory {

	public ApplicationContext getApplicationContext();

	public SeqService getSeqService();

	public CenterService getCenterService();

	public CacheService getCacheService();


	public BonusService getBonusService();
	
	public IssueService getIssueService();
	
	public LotteryService getLotteryService();
	
	public AccountService getAccountService();
}
