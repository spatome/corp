/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: ServiceFactory.java 
 * @Prject: api-service
 * @Package: com.hengpeng.api.servicefactory.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月21日 上午10:54:22 
 * @version: V1.0   
 */
package com.hengpeng.api.servicefactory;

import org.springframework.context.ApplicationContext;

import com.hengpeng.api.service.BonusService;
import com.hengpeng.api.service.DemoService;
import com.hengpeng.api.service.SSQService;
import com.hengpeng.api.service.SeqService;
import com.hengpeng.api.service.UserService;

/**
 * @ClassName: ServiceFactory
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月21日 上午10:54:22
 */
public interface ServiceFactory {

	public ApplicationContext getApplicationContext();
	
	public SeqService getSeqService();

	public DemoService getDemoService();

	public UserService getUserService();

	public SSQService getSSQService();
	
	public BonusService getBonusService();

}
