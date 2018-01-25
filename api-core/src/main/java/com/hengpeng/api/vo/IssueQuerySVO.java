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
 * @ClassName: IssueQuerySVO
 * @Description: 奖期查询应答
 * @author: zhangwei
 * @date: 2017年7月24日 下午7:09:50
 */
public class IssueQuerySVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String issueNo;
	private String gameType;
	private String startTime;
	private String stopTime;
	private String officialStartTime;
	private String officialStopTime;
	private String bonusCode;
	private String issueType;

	public String getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public String getOfficialStartTime() {
		return officialStartTime;
	}

	public void setOfficialStartTime(String officialStartTime) {
		this.officialStartTime = officialStartTime;
	}

	public String getOfficialStopTime() {
		return officialStopTime;
	}

	public void setOfficialStopTime(String officialStopTime) {
		this.officialStopTime = officialStopTime;
	}

	public String getBonusCode() {
		return bonusCode;
	}

	public void setBonusCode(String bonusCode) {
		this.bonusCode = bonusCode;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	@Override
	public String toString() {
		return "IssueSVo [issueNo=" + issueNo + ", gameType=" + gameType + ", startTime=" + startTime + ", stopTime="
				+ stopTime + ", officialStartTime=" + officialStartTime + ", officialStopTime=" + officialStopTime
				+ ", bonusCode=" + bonusCode + ", issueType=" + issueType + "]";
	}

}
