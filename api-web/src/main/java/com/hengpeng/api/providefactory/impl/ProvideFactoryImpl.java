/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: ProvideFactoryImpl.java 
 * @Prject: api-web
 * @Package: com.hengpeng.api.providefactory.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月21日 下午3:48:53 
 * @version: V1.0   
 */
package com.hengpeng.api.providefactory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.hengpeng.api.providefactory.ProvideFactory;
import com.hengpeng.api.service.BonusService;
import com.hengpeng.api.service.DemoService;
import com.hengpeng.api.service.SSQService;
import com.hengpeng.api.service.UserService;

/** 
 * @ClassName: ProvideFactoryImpl 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月21日 下午3:48:53  
 */
@Lazy
@Service
public class ProvideFactoryImpl implements ProvideFactory {

	@Autowired
	private DemoService demoService;
	@Autowired
	private UserService userService;
	@Autowired
	private SSQService sSQService;
	@Autowired
	private BonusService bonusService;

	@Override
	public DemoService getDemoService() {
		return demoService;
	}

	@Override
	public UserService getUserService() {
		return userService;
	}

	@Override
	public SSQService getSSQService() {
		return sSQService;
	}

	@Override
	public BonusService getBonusService() {
		return bonusService;
	}
}
