/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: BonusListRVo.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.vo 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月25日 上午9:09:07 
 * @version: V1.0   
 */
package com.hengpeng.api.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @ClassName: BonusDetailRVO
 * @Description: 中奖详情请求
 * @author: zhangwei
 * @date: 2017年7月25日 上午9:09:07
 */
public class BonusDetailRVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String gameType;
	@NotBlank
	private String issueNo;
	@NotBlank
	private String enterpriseNo;
	private String pageNum;
	private String pageSize;

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

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "BonusListRVo [gameType=" + gameType + ", issueNo=" + issueNo + ", enterpriseNo=" + enterpriseNo
				+ ", pageNum=" + pageNum + ", pageSize=" + pageSize + "]";
	}

}
