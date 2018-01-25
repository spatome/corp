package com.hengpeng.api.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SsqOrder {
    private Long id;

    private Long version;

    private String companyNo;

    private String ssqOrderNo;

    private String ticketNo;

    private String issueNo;

    private String playType;

    private Integer times;

    private String lotterys;

    private BigDecimal amount;

    private String cardNo;

    private String realName;

    private String mobile;

    private String status;

    private String descs;

    private Date itime;

    private Date utime;

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

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo == null ? null : ticketNo.trim();
    }

    public String getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(String issueNo) {
        this.issueNo = issueNo == null ? null : issueNo.trim();
    }

    public String getPlayType() {
        return playType;
    }

    public void setPlayType(String playType) {
        this.playType = playType == null ? null : playType.trim();
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getLotterys() {
        return lotterys;
    }

    public void setLotterys(String lotterys) {
        this.lotterys = lotterys == null ? null : lotterys.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs == null ? null : descs.trim();
    }

    public Date getItime() {
        return itime;
    }

    public void setItime(Date itime) {
        this.itime = itime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }
}