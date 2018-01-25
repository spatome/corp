/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: DaoFactoryImpl.java 
 * @Prject: api-service
 * @Package: com.hengpeng.api.daofactory.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月21日 上午10:13:46 
 * @version: V1.0   
 */
package com.hengpeng.api.daofactory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.hengpeng.api.dao.AccountMapper;
import com.hengpeng.api.dao.CompanyMapper;
import com.hengpeng.api.dao.IssueMapper;
import com.hengpeng.api.dao.PrintIssueMapper;
import com.hengpeng.api.dao.SequenceMapper;
import com.hengpeng.api.dao.SsqBonusMapper;
import com.hengpeng.api.dao.SsqOrderMapper;
import com.hengpeng.api.dao.SsqOrderTempMapper;
import com.hengpeng.api.dao.SysConfigMapper;
import com.hengpeng.api.daofactory.DaoFactory;

/**
 * @ClassName: DaoFactoryImpl
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月21日 上午10:13:46
 */
@Lazy
@Repository
public class DaoFactoryImpl implements DaoFactory {

	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private IssueMapper issueMapper;
	@Autowired
	private PrintIssueMapper printIssueMapper;
	@Autowired
	private SsqBonusMapper ssqBonusMapper;
	@Autowired
	private SsqOrderMapper ssqOrderMapper;	
	@Autowired
	private SsqOrderTempMapper ssqOrderTempMapper;	
	@Autowired
	private SysConfigMapper sysConfigMapper;
	@Autowired
	private SequenceMapper sequenceMapper;
	@Autowired
	private AccountMapper accountMapper;

	/**
	 * @Description: TODO
	 * @return
	 * @see com.hengpeng.api.daofactory.DaoFactory#getCompanyMapper()
	 */
	@Override
	public CompanyMapper getCompanyMapper() {
		return this.companyMapper;
	}

	/**
	 * @Description: TODO
	 * @return
	 * @see com.hengpeng.api.daofactory.DaoFactory#getIssueMapper()
	 */
	@Override
	public IssueMapper getIssueMapper() {
		return this.issueMapper;
	}

	/**
	 * @Description: TODO
	 * @return
	 * @see com.hengpeng.api.daofactory.DaoFactory#getSsqBonusMapper()
	 */
	@Override
	public SsqBonusMapper getSsqBonusMapper() {
		return this.ssqBonusMapper;
	}

	/**
	 * @Description: TODO
	 * @return
	 * @see com.hengpeng.api.daofactory.DaoFactory#getSsqOrderMapper()
	 */
	@Override
	public SsqOrderMapper getSsqOrderMapper() {
		return this.ssqOrderMapper;
	}

	/** 
	 * @Description: TODO
	 * @return 
	 * @see com.hengpeng.api.daofactory.DaoFactory#getPrintIssueMapper() 
	 */
	@Override
	public PrintIssueMapper getPrintIssueMapper() {
		return this.printIssueMapper;
	}

	/** 
	 * @Description: TODO
	 * @return 
	 * @see com.hengpeng.api.daofactory.DaoFactory#getSequenceMapper() 
	 */
	@Override
	public SequenceMapper getSequenceMapper() {
		return this.sequenceMapper;
	}

	/** 
	 * @Description: TODO
	 * @return 
	 * @see com.hengpeng.api.daofactory.DaoFactory#getSsqOrderTempMapper() 
	 */
	@Override
	public SsqOrderTempMapper getSsqOrderTempMapper() {
		return this.ssqOrderTempMapper;
	}

	/** 
	 * @Description: TODO
	 * @return 
	 * @see com.hengpeng.api.daofactory.DaoFactory#getSysConfigMapper() 
	 */
	@Override
	public SysConfigMapper getSysConfigMapper() {
		return this.sysConfigMapper;
	}

	/** 
	 * @Description: TODO
	 * @return 
	 * @see com.hengpeng.api.daofactory.DaoFactory#getAccountMapper() 
	 */
	@Override
	public AccountMapper getAccountMapper() {
		return accountMapper;
	}

}
