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
import com.hengpeng.api.vo.LoginRVO;

/**
 * @ClassName: UserController
 * @Description: 用户
 * @author: zhangwei
 * @date: 2017年7月21日 下午12:37:08
 */
@Controller
@RequestMapping("v1")
public class UserController extends BaseController {

	@ResponseBody
	@RequestMapping(value = "getToken", method = RequestMethod.POST)
	public Object getToken(@RequestBody LoginRVO loginRVo) throws Exception {
		BaseVO<String> result = new BaseVO<String>();

		String enterpirseNo = serviceFactory.getUserService().verityLogin(loginRVo);
		result.setBody(enterpirseNo);

		return result;
	}

}
