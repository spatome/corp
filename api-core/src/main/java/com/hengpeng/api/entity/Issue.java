package com.hengpeng.api.entity;

import java.util.Date;

public class Issue {
    private Long id;

    private Long version;

    private String issueNo;

    private String gameType;

    private String bonusCode;

    private Date startTime;

    private Date stopTime;

    private Date officialStartTime;

    private Date officialStopTime;

    private String issueType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(String issueNo) {
        this.issueNo = issueNo == null ? null : issueNo.trim();
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType == null ? null : gameType.trim();
    }

    public String getBonusCode() {
        return bonusCode;
    }

    public void setBonusCode(String bonusCode) {
        this.bonusCode = bonusCode == null ? null : bonusCode.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public Date getOfficialStartTime() {
        return officialStartTime;
    }

    public void setOfficialStartTime(Date officialStartTime) {
        this.officialStartTime = officialStartTime;
    }

    public Date getOfficialStopTime() {
        return officialStopTime;
    }

    public void setOfficialStopTime(Date officialStopTime) {
        this.officialStopTime = officialStopTime;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType == null ? null : issueType.trim();
    }
}