package com.hengpeng.api.dao;

import java.util.List;
import com.hengpeng.api.entity.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);


    List<Account> selectByBean(Account record);
}