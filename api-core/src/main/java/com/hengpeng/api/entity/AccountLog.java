package com.hengpeng.api.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AccountLog {
    private Long id;

    private Long version;

    private String companyNo;

    private String orderNo;

    private String inOut;

    private String inOutDesc;

    private BigDecimal amount;

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

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo == null ? null : companyNo.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut == null ? null : inOut.trim();
    }

    public String getInOutDesc() {
        return inOutDesc;
    }

    public void setInOutDesc(String inOutDesc) {
        this.inOutDesc = inOutDesc == null ? null : inOutDesc.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getItime() {
        return itime;
    }

    public void setItime(Date itime) {
        this.itime = itime;
    }
}