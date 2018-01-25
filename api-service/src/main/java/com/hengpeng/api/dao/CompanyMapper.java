package com.hengpeng.api.dao;

import java.util.List;

import com.hengpeng.api.entity.Company;

public interface CompanyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
    
    
    Company getLock(Long id);
    List<Company> selectByBean(Company record);
}