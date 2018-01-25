/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: DemoController.java 
 * @Prject: api-web
 * @Package: com.hengpeng.api.controller 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月20日 下午12:32:21 
 * @version: V1.0   
 */
package com.hengpeng.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/** 
 * @ClassName: DemoController 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月20日 下午12:32:21  
 */
@Controller
@RequestMapping("demo")
public class DemoController extends BaseController {

	@ResponseBody
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public Object test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseVO<String> result = new BaseVO<String>();


		return result;
	}
	
}
