package com.hengpeng.api.dao;

import java.util.List;
import com.hengpeng.api.entity.SsqOrder;

public interface SsqOrderMapper {
	int deleteByPrimaryKey(Long id);

	int insert(SsqOrder record);

	int insertSelective(SsqOrder record);

	SsqOrder selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SsqOrder record);

	int updateByPrimaryKey(SsqOrder record);

	
	SsqOrder getLock(Long id);
	List<SsqOrder> selectByBean(SsqOrder record);
	void batchInsert(List<SsqOrder> records);
	List<SsqOrder> selectSimpleOrders(String[] orderNos);
}