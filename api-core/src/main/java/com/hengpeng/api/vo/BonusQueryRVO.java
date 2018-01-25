/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: BonusRVo.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.vo 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月25日 上午8:53:38 
 * @version: V1.0   
 */
package com.hengpeng.api.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @ClassName: BonusQueryRVO
 * @Description: 中奖信息查询请求
 * @author: zhangwei
 * @date: 2017年7月25日 上午8:53:38
 */
public class BonusQueryRVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String gameType;
	@NotBlank
	private String issueNo;
	@NotBlank
	private String enterpriseNo;

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public String getEnterpriseNo() {
		return enterpriseNo;
	}

	public void setEnterpriseNo(String enterpriseNo) {
		this.enterpriseNo = enterpriseNo;
	}

	@Override
	public String toString() {
		return "BonusRVo [gameType=" + gameType + ", issueNo=" + issueNo + ", enterpriseNo=" + enterpriseNo + "]";
	}
}
