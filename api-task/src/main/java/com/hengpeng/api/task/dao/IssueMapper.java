package com.hengpeng.api.task.dao;

import java.util.List;

import com.hengpeng.api.entity.Issue;

public interface IssueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Issue record);

    int insertSelective(Issue record);

    Issue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Issue record);

    int updateByPrimaryKey(Issue record);
    
    
    Issue getLock(Long id);
    List<Issue> selectByBean(Issue record);
    int updateByIssueNoSelective(Issue record);
}