/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: DemoServiceImpl.java 
 * @Prject: api-service
 * @Package: com.hengpeng.api.service.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月20日 下午1:00:01 
 * @version: V1.0   
 */
package com.hengpeng.api.service.impl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hengpeng.api.entity.Company;
import com.hengpeng.api.enumtype.CodeMessage;
import com.hengpeng.api.enumtype.CompanyStatus;
import com.hengpeng.api.exception.SException;
import com.hengpeng.api.service.UserService;
import com.hengpeng.api.util.ValidationUtil;
import com.hengpeng.api.vo.LoginRVO;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月21日 下午1:35:59
 */
@Transactional
@Service
public class UserServiceImpl extends AbstractBaseService implements UserService {

	public void verify(LoginRVO loginRVO) throws SException {
		ValidationUtil.ValidationResult vr = ValidationUtil.validateEntity(loginRVO);

		if(vr.isHasErrors()){
			throw new SException(CodeMessage.FAILURE.getCode(), vr.getErrorMsg().toString());
		}
	};
	
	/**
	 * @Description: 核对登录(商户号+secret(开心营销提供)+timeStamp)
	 * @param loginInfoVo
	 * @return 商户号
	 * @throws SException
	 * @see com.hengpeng.api.service.UserService#getToken(com.hengpeng.api.vo.LoginRVO)
	 */
	@Override
	public String verityLogin(LoginRVO loginRVO) throws SException {
		this.verify(loginRVO);
		String result = null;

		try {
			Company companyQ = new Company();
			companyQ.setOpenKey(StringUtils.trimToEmpty(loginRVO.getOpenKey()));
			List<Company> companyList = super.daoFactory.getCompanyMapper().selectByBean(companyQ);

			if (companyList.size() == 0) {
				throw new SException(CodeMessage.FAILURE.getCode(), "账号不存在");
			}

			boolean usernNameFlag = true;
			for (Company f : companyList) {
				if(f.getOpenKey().equals(loginRVO.getOpenKey())){
					usernNameFlag = false;

					if (!CompanyStatus.ACTIVE.equals(CompanyStatus.valueOf(companyList.get(0).getStatus()))) {
						throw new SException(CodeMessage.FAILURE.getCode(), "账号："+loginRVO.getOpenKey()+"未激活");
					}

					String password = f.getCompanyNo()+f.getOpenSecret()+loginRVO.getTimeStamp();
					String passwordDigest = DigestUtils.md5Hex(password);
					if(passwordDigest.equals(loginRVO.getOpenSecret())){
						result = f.getCompanyNo();
					}else{
						throw new SException(CodeMessage.FAILURE.getCode(), "账号："+loginRVO.getOpenKey()+"密码校验未通过");
					}
				}
			}
			if(usernNameFlag) {
				throw new SException(CodeMessage.FAILURE.getCode(), "用户名区分大小写");
			}
		} catch (SException e) {
			LOGGER.error("verityLogin", e);
			throw e;
		} catch (Exception e) {
			LOGGER.error("verityLogin", e);
			throw new SException(CodeMessage.FAILURE.getCode(), "内部异常");
		}

		return result;
	}
}
