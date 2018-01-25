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

import com.hengpeng.api.vo.BonusDetailRVO;
import com.hengpeng.api.vo.BonusDetailSVO;
import com.hengpeng.api.vo.BonusQueryRVO;
import com.hengpeng.api.vo.BonusQuerySVO;
import com.hengpeng.api.vo.IssueQueryRVO;
import com.hengpeng.api.vo.IssueQuerySVO;

/** 
 * @ClassName: BonusController 
 * @Description: 开奖
 * @author: zhangwei
 * @date: 2017年7月24日 上午10:07:46  
 */
@Controller
@RequestMapping(value = "v1")
public class BonusController extends BaseController {

	@ResponseBody
	@RequestMapping(value = "/bonus/queryIssue", method = RequestMethod.POST)
	public Object queryIssue(@RequestBody IssueQueryRVO issueQueryRVO) {
		LOGGER.info("bonus/queryIssue 参数："+issueQueryRVO);
		BaseVO<IssueQuerySVO> result = new BaseVO<IssueQuerySVO>();

		result.setBody(serviceFactory.getBonusService().queryIssue(issueQueryRVO));

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/bonus/queryBonus", method = RequestMethod.POST)
	public Object queryBonusInfo(@RequestBody BonusQueryRVO bonusQueryRVO) {
		LOGGER.info("/bonus/queryBonus 参数："+bonusQueryRVO);
		BaseVO<BonusQuerySVO> result = new BaseVO<BonusQuerySVO>();

		result.setBody(serviceFactory.getBonusService().queryBonus(bonusQueryRVO));

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/bonus/queryBonusList", method = RequestMethod.POST)
	public Object queryBonusList(@RequestBody BonusDetailRVO bonusDetailRVO) {
		LOGGER.info("bonus/queryBonusList 参数："+bonusDetailRVO);
		BaseVO<BonusDetailSVO> result = new BaseVO<BonusDetailSVO>();

		result.setBody(serviceFactory.getBonusService().queryBonusList(bonusDetailRVO));

		return result;
	}
}
