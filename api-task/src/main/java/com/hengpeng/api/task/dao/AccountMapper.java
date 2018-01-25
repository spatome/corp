package com.hengpeng.api.task.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hengpeng.api.entity.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);


    List<Account> selectByBean(Account record);
    int addCurrentBalance(@Param("accountNo")String accountNo, @Param("amount")BigDecimal amount);
    int subtractCurrentBalance(@Param("accountNo")String accountNo, @Param("amount")BigDecimal amount);
}