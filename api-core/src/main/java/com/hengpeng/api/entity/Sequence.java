package com.hengpeng.api.entity;

public class Sequence {
    private String name;

    private Long version;

    private Integer cachecount;

    private Long indexnum;

    private Long modmaxnum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Integer getCachecount() {
        return cachecount;
    }

    public void setCachecount(Integer cachecount) {
        this.cachecount = cachecount;
    }

    public Long getIndexnum() {
        return indexnum;
    }

    public void setIndexnum(Long indexnum) {
        this.indexnum = indexnum;
    }

    public Long getModmaxnum() {
        return modmaxnum;
    }

    public void setModmaxnum(Long modmaxnum) {
        this.modmaxnum = modmaxnum;
    }
}