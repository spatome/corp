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
package com.hengpeng.api.task.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hengpeng.api.task.servicefactory.ServiceFactory;

/** 
 * @ClassName: CmdController 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月20日 下午12:32:21  
 */
@Controller
@RequestMapping(value = "task")
public class TaskController extends BaseController {

	@Resource
	private ServiceFactory serviceFactory;
	
	@ResponseBody
	@RequestMapping(value = "synNewPringIssue", method = RequestMethod.GET)
	public Object synNewPringIssue(HttpServletRequest request, HttpServletResponse response) {
		BaseController.BaseVO<String> result = new BaseController.BaseVO<String>();

		serviceFactory.getIssueService().synNewPringIssue();

		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "synBonusPrintIssue", method = RequestMethod.GET)
	public Object synSalingPringIssue(HttpServletRequest request, HttpServletResponse response) {
		BaseController.BaseVO<String> result = new BaseController.BaseVO<String>();

		serviceFactory.getIssueService().synBonusPrintIssue();

		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "synBonus", method = RequestMethod.GET)
	public Object synBonus(HttpServletRequest request, HttpServletResponse response) {
		BaseController.BaseVO<String> result = new BaseController.BaseVO<String>();

		serviceFactory.getBonusService().synBonus();

		return result;
	}
}
