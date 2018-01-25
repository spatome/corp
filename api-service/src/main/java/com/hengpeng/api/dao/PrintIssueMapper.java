package com.hengpeng.api.dao;

import com.hengpeng.api.entity.PrintIssue;

public interface PrintIssueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PrintIssue record);

    int insertSelective(PrintIssue record);

    PrintIssue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PrintIssue record);

    int updateByPrimaryKey(PrintIssue record);
}