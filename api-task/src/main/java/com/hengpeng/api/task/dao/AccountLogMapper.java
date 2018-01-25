package com.hengpeng.api.task.dao;

import java.util.List;
import com.hengpeng.api.entity.AccountLog;

public interface AccountLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AccountLog record);

    int insertSelective(AccountLog record);

    AccountLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountLog record);

    int updateByPrimaryKey(AccountLog record);


    void batchInsert(List<AccountLog> records);
}