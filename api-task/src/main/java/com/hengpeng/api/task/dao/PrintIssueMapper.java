package com.hengpeng.api.task.dao;

import java.util.List;

import com.hengpeng.api.entity.PrintIssue;

public interface PrintIssueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PrintIssue record);

    int insertSelective(PrintIssue record);

    PrintIssue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PrintIssue record);

    int updateByPrimaryKey(PrintIssue record);
    
    
    int selectCountByIssueNo(String issueNo);
    List<PrintIssue> selectByBean(PrintIssue printIssue);
    int updateByIssueNoSelective(PrintIssue record);

    List<PrintIssue> selectNeedRemoteIssue();
    List<PrintIssue> selectNeedBonusIssue();
    
}