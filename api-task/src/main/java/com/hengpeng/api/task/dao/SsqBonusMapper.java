package com.hengpeng.api.task.dao;

import java.util.List;

import com.hengpeng.api.entity.SsqBonus;

public interface SsqBonusMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SsqBonus record);

    int insertSelective(SsqBonus record);

    SsqBonus selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SsqBonus record);

    int updateByPrimaryKey(SsqBonus record);


    SsqBonus getLock(Long id);
    List<SsqBonus> selectByBean(SsqBonus record);
    void batchInsert(List<SsqBonus> records);
    /** 
     * @Description: 中奖统计
     * @return
     * @return: List<SsqBonus>
     */
    List<SsqBonus> selectBonus(SsqBonus record);
}