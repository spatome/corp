/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: SeqServiceImpl.java 
 * @Prject: api-service
 * @Package: com.hengpeng.api.service.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月31日 下午5:24:28 
 * @version: V1.0   
 */
package com.hengpeng.api.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.hengpeng.api.dao.SequenceMapper;
import com.hengpeng.api.entity.Sequence;
import com.hengpeng.api.service.SeqService;

/** 
 * @ClassName: SeqServiceImpl
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月31日 下午5:24:28  
 */
@Transactional(propagation=Propagation.NOT_SUPPORTED)
@Service
public class SeqServiceImpl implements SeqService {

	@Resource
	private SequenceMapper sequenceMapper;

	/**
	 * @fieldName: MSGID_KEY
	 * @fieldType: String
	 * @Description: messageID字段值
	 */
	private final static String MSGID_KEY = "msgId";
	
	/**
	 * @fieldName: ORDERID_KEY
	 * @fieldType: String
	 * @Description: orderId字段值
	 */
	private final static String ORDERID_KEY = "orderId";
	
	/**
	 * @fieldName: CACHE_NUM
	 * @fieldType: int
	 * @Description: 一次取100个
	 */
	private final static int CACHE_NUM = 99;
	
	private Lock lock = new ReentrantLock();
	private volatile Map<String, Seq> seqPool = new HashMap<>();
	
	@Override
	public long getMessageId() {
		lock.lock();
		
		try {
			Seq seq = seqPool.get(MSGID_KEY);
			
			if(seq !=null && seq.currentValue != seq.nexeValue){
				seq.currentValue++;
			}else{
				//接收新的
				seq = this.getNextValue(MSGID_KEY);
			}
			
			return seq.currentValue;
		} finally {
			lock.unlock();
		}
	}

	@Override
	public long getOrderId() {
		lock.lock();
		
		try {
			Seq seq = seqPool.get(ORDERID_KEY);
			
			if(seq !=null && seq.currentValue != seq.nexeValue){
				seq.currentValue++;
			}else{
				//接收新的
				seq = this.getNextValue(ORDERID_KEY);
			}
			
			return seq.currentValue;
		} finally {
			lock.unlock();
		}
	}

    /** 
     * @Description: 从数据库取序列
     * @param name
     * @return
     * @return: Seq
     */
    private Seq getNextValue(String name) {
        Seq seq;
        long currentValue, nextValue;

        Sequence sequence = sequenceMapper.selectByPrimaryKey(name);
        currentValue = sequence.getIndexnum();
        nextValue = currentValue + CACHE_NUM;

        sequence.setIndexnum(nextValue+1);
        sequenceMapper.updateByPrimaryKeySelective(sequence);

        seq = new Seq(currentValue, nextValue);
        seqPool.put(name, seq);

        return seq;
    }
	
	public class Seq{
		public Seq(long currentValue, long nexeValue) {
			this.currentValue = currentValue;
			this.nexeValue = nexeValue;
		}
		long currentValue;
		long nexeValue;
	}
}
