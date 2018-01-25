/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: AccountService.java 
 * @Prject: api-task
 * @Package: com.hengpeng.api.task.service 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月28日 下午6:07:47 
 * @version: V1.0   
 */
package com.hengpeng.api.task.service;

import java.math.BigDecimal;
import com.hengpeng.api.exception.SException;

/** 
 * @ClassName: AccountService 
 * @Description: 账号金额处理类
 * @author: zhangwei
 * @date: 2017年8月28日 下午6:07:47  
 */
public interface AccountService {

	/** 
	 * @Description: 加钱
	 * @param accountNo
	 * @param amount
	 * @return
	 * @return: SException
	 */
	public SException addCurrentBalance(String accountNo, BigDecimal amount);

	/** 
	 * @Description: 减钱
	 * @param accountNo
	 * @param amount
	 * @return
	 * @return: SException
	 */
	public SException subtractCurrentBalance(String accountNo, BigDecimal amount);
}
