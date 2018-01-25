/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: DaoFactory.java 
 * @Prject: api-service
 * @Package: com.hengpeng.api.daofactory 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月21日 上午10:09:28 
 * @version: V1.0   
 */
package com.hengpeng.api.daofactory;

import com.hengpeng.api.dao.AccountMapper;
import com.hengpeng.api.dao.CompanyMapper;
import com.hengpeng.api.dao.IssueMapper;
import com.hengpeng.api.dao.PrintIssueMapper;
import com.hengpeng.api.dao.SequenceMapper;
import com.hengpeng.api.dao.SsqBonusMapper;
import com.hengpeng.api.dao.SsqOrderMapper;
import com.hengpeng.api.dao.SsqOrderTempMapper;
import com.hengpeng.api.dao.SysConfigMapper;

/**
 * @ClassName: DaoFactory
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月21日 上午10:09:28
 */
public interface DaoFactory {

	public CompanyMapper getCompanyMapper();

	public IssueMapper getIssueMapper();

	public PrintIssueMapper getPrintIssueMapper();

	public SequenceMapper getSequenceMapper();

	public SsqBonusMapper getSsqBonusMapper();

	public SsqOrderMapper getSsqOrderMapper();

	public SsqOrderTempMapper getSsqOrderTempMapper();

	public SysConfigMapper getSysConfigMapper();

	public AccountMapper getAccountMapper();
}
