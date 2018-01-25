/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: IssueRVo.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.vo 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月24日 下午7:09:50 
 * @version: V1.0   
 */
package com.hengpeng.api.vo;

import java.io.Serializable;

/**
 * @ClassName: IssueQueryRVo
 * @Description: 奖期查询请求
 * @author: zhangwei
 * @date: 2017年7月24日 下午7:09:50
 */
public class IssueQueryRVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gameType;
	private String issueNo;

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

	@Override
	public String toString() {
		return "IssueRVo [gameType=" + gameType + ", issueNo=" + issueNo + "]";
	}

}
