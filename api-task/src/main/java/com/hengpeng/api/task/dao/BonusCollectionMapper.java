package com.hengpeng.api.task.dao;

import com.hengpeng.api.entity.BonusCollection;

public interface BonusCollectionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BonusCollection record);

    int insertSelective(BonusCollection record);

    BonusCollection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BonusCollection record);

    int updateByPrimaryKey(BonusCollection record);
}