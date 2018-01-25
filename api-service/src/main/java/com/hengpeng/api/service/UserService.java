/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: UserService.java 
 * @Prject: api-service
 * @Package: com.hengpeng.api.service 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月21日 下午1:30:24 
 * @version: V1.0   
 */
package com.hengpeng.api.service;

import com.hengpeng.api.exception.SException;
import com.hengpeng.api.vo.LoginRVO;

/** 
 * @ClassName: UserService 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月21日 下午1:30:24  
 */
public interface UserService {

	/** 
	 * @Description: 核对登录账号
	 * @param LoginRVO
	 * @throws SException
	 * @return: String	商户编号
	 */
	public String verityLogin(LoginRVO loginRVO) throws SException;
}
