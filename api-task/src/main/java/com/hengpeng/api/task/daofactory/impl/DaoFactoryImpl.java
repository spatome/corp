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
package com.hengpeng.api.task.daofactory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.hengpeng.api.task.dao.AccountLogMapper;
import com.hengpeng.api.task.dao.AccountMapper;
import com.hengpeng.api.task.dao.BonusCollectionMapper;
import com.hengpeng.api.task.dao.CompanyMapper;
import com.hengpeng.api.task.dao.IssueMapper;
import com.hengpeng.api.task.dao.PrintIssueMapper;
import com.hengpeng.api.task.dao.SequenceMapper;
import com.hengpeng.api.task.dao.SsqBonusMapper;
import com.hengpeng.api.task.dao.SsqOrderMapper;
import com.hengpeng.api.task.dao.SsqOrderTempMapper;
import com.hengpeng.api.task.dao.SysConfigMapper;
import com.hengpeng.api.task.daofactory.DaoFactory;

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
	private	BonusCollectionMapper bonusCollectionMapper;
	@Autowired
	private	AccountMapper accountMapper;
	@Autowired
	private	AccountLogMapper accountLogMapper;

	@Override
	public CompanyMapper getCompanyMapper() {
		return this.companyMapper;
	}

	@Override
	public IssueMapper getIssueMapper() {
		return this.issueMapper;
	}

	@Override
	public SsqBonusMapper getSsqBonusMapper() {
		return this.ssqBonusMapper;
	}

	@Override
	public SsqOrderMapper getSsqOrderMapper() {
		return this.ssqOrderMapper;
	}

	@Override
	public PrintIssueMapper getPrintIssueMapper() {
		return this.printIssueMapper;
	}

	@Override
	public SequenceMapper getSequenceMapper() {
		return this.sequenceMapper;
	}

	@Override
	public SsqOrderTempMapper getSsqOrderTempMapper() {
		return this.ssqOrderTempMapper;
	}

	@Override
	public SysConfigMapper getSysConfigMapper() {
		return this.sysConfigMapper;
	}

	@Override
	public BonusCollectionMapper getBonusCollectionMapper() {
		return this.bonusCollectionMapper;
	}

	@Override
	public AccountMapper getAccountMapper() {
		return accountMapper;
	}

	@Override
	public AccountLogMapper getAccountLogMapper() {
		return accountLogMapper;
	}

}
