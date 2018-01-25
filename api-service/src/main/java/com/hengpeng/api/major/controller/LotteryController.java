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
package com.hengpeng.api.major.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hengpeng.api.vo.OrderQueryRVO;
import com.hengpeng.api.vo.OrderQuerySVO;
import com.hengpeng.api.vo.SsqBuyRVO;
import com.hengpeng.api.vo.SsqBuySVO;

/** 
 * @ClassName: LotteryController 
 * @Description: 彩票
 * @author: zhangwei
 * @date: 2017年7月24日 上午10:07:46  
 */
@Controller
@RequestMapping(value = "v1")
public class LotteryController extends BaseController {

	@ResponseBody
	@RequestMapping(value = "/lottery/ssq/buy", method = RequestMethod.POST)
	public Object buySsq(@RequestBody SsqBuyRVO ssqBuyRVO) throws Exception {
		LOGGER.info("lottery/ssq/buy 参数："+ssqBuyRVO);
		BaseVO<SsqBuySVO> result = new BaseVO<SsqBuySVO>();

		result.setBody(serviceFactory.getSSQService().buy(ssqBuyRVO));

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/lottery/queryOrder", method = RequestMethod.POST)
	public Object queryOrder(@RequestBody OrderQueryRVO orderQueryRVO) throws Exception {
		LOGGER.info("lottery/queryOrder 参数："+orderQueryRVO);
		BaseVO<OrderQuerySVO> result = new BaseVO<OrderQuerySVO>();

		result.setBody(serviceFactory.getSSQService().orderQuery(orderQueryRVO));

		return result;
	}
}
