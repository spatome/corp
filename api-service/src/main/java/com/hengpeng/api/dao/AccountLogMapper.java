package com.hengpeng.api.dao;

import com.hengpeng.api.entity.AccountLog;

public interface AccountLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AccountLog record);

    int insertSelective(AccountLog record);

    AccountLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountLog record);

    int updateByPrimaryKey(AccountLog record);
}