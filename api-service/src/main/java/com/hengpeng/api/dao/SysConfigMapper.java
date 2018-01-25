package com.hengpeng.api.dao;

import com.hengpeng.api.entity.SysConfig;

public interface SysConfigMapper {
    int deleteByPrimaryKey(String keyId);

    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    SysConfig selectByPrimaryKey(String keyId);

    int updateByPrimaryKeySelective(SysConfig record);

    int updateByPrimaryKey(SysConfig record);
}