/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: DemoController.java 
 * @Prject: api-service
 * @Package: com.hengpeng.api.major 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月2日 下午2:45:04 
 * @version: V1.0   
 */
package com.hengpeng.api.major.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hengpeng.api.service.DemoService;

/** 
 * @ClassName: DemoController 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月2日 下午2:45:04  
 */
@Controller
@RequestMapping("demo")
public class DemoController extends BaseController {

	@Resource
	private DemoService demoService;
	
	@ResponseBody
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public Object test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseVO<String> result = new BaseVO<String>();

		result.setBody( demoService.hello(request.getParameter("id")) );

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "buy", method = RequestMethod.POST)
	public Object db(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseController.BaseVO<String> result = new BaseController.BaseVO<String>();
		
		String issueNo = request.getParameter("issueNo");
		String count = request.getParameter("count");
		if(StringUtils.isAnyBlank(issueNo, count)){
			return result;
		}

		demoService.batchCreateOrder(issueNo, Integer.valueOf(count));

		return result;
	}
}
