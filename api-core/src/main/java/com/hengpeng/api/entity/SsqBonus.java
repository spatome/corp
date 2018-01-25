package com.hengpeng.api.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SsqBonus {
    private Long id;

    private Long version;

    private String issueNo;

    private String companyNo;

    private String ssqOrderNo;

    private String playType;

    private Integer bonusCount;

    private BigDecimal bonusAmount;

    private String bonusCode;

    private String bonusLevel;

    private BigDecimal bonusLevelAmount;

    private String isBomBonus;

    private Date itime;

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

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo == null ? null : companyNo.trim();
    }

    public String getSsqOrderNo() {
        return ssqOrderNo;
    }

    public void setSsqOrderNo(String ssqOrderNo) {
        this.ssqOrderNo = ssqOrderNo == null ? null : ssqOrderNo.trim();
    }

    public String getPlayType() {
        return playType;
    }

    public void setPlayType(String playType) {
        this.playType = playType == null ? null : playType.trim();
    }

    public Integer getBonusCount() {
        return bonusCount;
    }

    public void setBonusCount(Integer bonusCount) {
        this.bonusCount = bonusCount;
    }

    public BigDecimal getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(BigDecimal bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public String getBonusCode() {
        return bonusCode;
    }

    public void setBonusCode(String bonusCode) {
        this.bonusCode = bonusCode == null ? null : bonusCode.trim();
    }

    public String getBonusLevel() {
        return bonusLevel;
    }

    public void setBonusLevel(String bonusLevel) {
        this.bonusLevel = bonusLevel == null ? null : bonusLevel.trim();
    }

    public BigDecimal getBonusLevelAmount() {
        return bonusLevelAmount;
    }

    public void setBonusLevelAmount(BigDecimal bonusLevelAmount) {
        this.bonusLevelAmount = bonusLevelAmount;
    }

    public String getIsBomBonus() {
        return isBomBonus;
    }

    public void setIsBomBonus(String isBomBonus) {
        this.isBomBonus = isBomBonus == null ? null : isBomBonus.trim();
    }

    public Date getItime() {
        return itime;
    }

    public void setItime(Date itime) {
        this.itime = itime;
    }
}