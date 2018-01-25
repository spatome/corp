package com.hengpeng.api.dao;

import java.util.List;
import com.hengpeng.api.entity.SsqOrderTemp;

public interface SsqOrderTempMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SsqOrderTemp record);

    int insertSelective(SsqOrderTemp record);

    SsqOrderTemp selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SsqOrderTemp record);

    int updateByPrimaryKey(SsqOrderTemp record);


    List<SsqOrderTemp> selectByBean(SsqOrderTemp record);
    void batchInsert(List<SsqOrderTemp> records);
}