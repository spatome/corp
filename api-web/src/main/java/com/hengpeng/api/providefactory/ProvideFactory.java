/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: ProvideFactory.java 
 * @Prject: api-web
 * @Package: com.hengpeng.api.providefactory 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月21日 下午3:48:12 
 * @version: V1.0   
 */
package com.hengpeng.api.providefactory;

import com.hengpeng.api.service.BonusService;
import com.hengpeng.api.service.DemoService;
import com.hengpeng.api.service.SSQService;
import com.hengpeng.api.service.UserService;

/** 
 * @ClassName: ProvideFactory 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月21日 下午3:48:12  
 */
public interface ProvideFactory {
	public DemoService getDemoService();

	public UserService getUserService();

	public SSQService getSSQService();
	
	public BonusService getBonusService();
}
