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

import java.util.Arrays;
import java.util.HashSet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hengpeng.api.task.common.message.BonusQueryResponseMessage;
import com.hengpeng.api.task.common.message.IssueQueryResponseMessage;
import com.hengpeng.api.task.common.message.TicketQueryResponseMessage;
import com.hengpeng.api.task.servicefactory.ServiceFactory;

/** 
 * @ClassName: CmdController 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月20日 下午12:32:21  
 */
@Controller
@RequestMapping(value = "center")
public class CenterController extends BaseController {

	@Resource
	private ServiceFactory serviceFactoryImpl;
	
	@ResponseBody
	@RequestMapping(value = "queryPrintIssue", method = RequestMethod.POST)
	public Object queryPrintIssue(HttpServletRequest request, HttpServletResponse response) {
		BaseController.BaseVO<IssueQueryResponseMessage> result = new BaseController.BaseVO<IssueQueryResponseMessage>();

		String issueNo = request.getParameter("issueNo");

		IssueQueryResponseMessage ret = serviceFactoryImpl.getCenterService().getPrintIssue("SSQ", issueNo, String.valueOf(serviceFactoryImpl.getSeqService().getMessageId()), "1.1");
		result.setBody(ret);

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "getBonus", method = RequestMethod.POST)
	public Object getBonus(HttpServletRequest request, HttpServletResponse response) {
		BaseController.BaseVO<BonusQueryResponseMessage> result = new BaseController.BaseVO<BonusQueryResponseMessage>();

		String issueNo = request.getParameter("issueNo");

		BonusQueryResponseMessage ret = serviceFactoryImpl.getCenterService().getBonus("SSQ", issueNo, String.valueOf(serviceFactoryImpl.getSeqService().getMessageId()), "1.1");
		result.setBody(ret);

		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "getTicket", method = RequestMethod.POST)
	public Object getTicket(HttpServletRequest request, HttpServletResponse response) {
		BaseController.BaseVO<TicketQueryResponseMessage> result = new BaseController.BaseVO<TicketQueryResponseMessage>();

		String orderNos = request.getParameter("orderNos");

		TicketQueryResponseMessage ret = serviceFactoryImpl.getCenterService().getTicket(new HashSet<String>(Arrays.asList(orderNos.split(";"))), String.valueOf(serviceFactoryImpl.getSeqService().getMessageId()), "1.1");
		result.setBody(ret);

		return result;
	}
}
