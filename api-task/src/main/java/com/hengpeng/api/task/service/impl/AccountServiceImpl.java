/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: AccountServiceImpl.java 
 * @Prject: api-task
 * @Package: com.hengpeng.api.task.service.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月28日 下午6:25:48 
 * @version: V1.0   
 */
package com.hengpeng.api.task.service.impl;

import java.math.BigDecimal;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.hengpeng.api.enumtype.CodeMessage;
import com.hengpeng.api.exception.SException;
import com.hengpeng.api.task.service.AccountService;

/** 
 * @ClassName: AccountServiceImpl 
 * @Description: 账号金额处理
 * @author: zhangwei
 * @date: 2017年8月28日 下午6:25:48  
 */
@Transactional
@Service
public class AccountServiceImpl extends AbstractBaseService implements AccountService {

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public SException addCurrentBalance(String accountNo, BigDecimal amount) {
		try {
			if(StringUtils.isBlank(accountNo)){
				return new SException(CodeMessage.FAILURE.getCode(), "accountNo null");
			}
			if(amount.signum()==-1){
				return new SException(CodeMessage.FAILURE.getCode(), "金额不能是负");
			}else if(amount.signum()==0){
				return new SException(CodeMessage.SUCCESS.getCode(), "操作成功");
			}

			int ret = daoFactory.getAccountMapper().addCurrentBalance(accountNo, amount);
			if(ret>0){
				return new SException(CodeMessage.SUCCESS.getCode(), "操作成功");	
			}else {
				return new SException(CodeMessage.FAILURE.getCode(), "加钱失败");
			}
		} catch (Exception e) {
			LOGGER.error("AccountServiceImpl.addCurrentBalance()", e);
			return new SException(CodeMessage.FAILURE.getCode(), String.format("账号加钱异常,账号{%s}金额{%s}", accountNo, amount.toString()));
		}
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public SException subtractCurrentBalance(String accountNo, BigDecimal amount) {
		try {
			if(StringUtils.isBlank(accountNo)){
				return new SException(CodeMessage.FAILURE.getCode(), "accountNo null");
			}
			if(amount.signum()==-1){
				return new SException(CodeMessage.FAILURE.getCode(), "金额不能是负");
			}else if(amount.signum()==0){
				return new SException(CodeMessage.SUCCESS.getCode(), "操作成功");
			}

			int ret = daoFactory.getAccountMapper().subtractCurrentBalance(accountNo, amount);
			if(ret>0){
				return new SException(CodeMessage.SUCCESS.getCode(), "操作成功");	
			}else {
				return new SException(CodeMessage.FAILURE.getCode(), "扣钱失败,可能余额不足");
			}
		} catch (Exception e) {
			LOGGER.error("AccountServiceImpl.subtractCurrentBalance()", e);
			return new SException(CodeMessage.FAILURE.getCode(), String.format("账号扣钱异常,账号{%s}金额{%s}", accountNo, amount.toString()));
		}
	}
}
