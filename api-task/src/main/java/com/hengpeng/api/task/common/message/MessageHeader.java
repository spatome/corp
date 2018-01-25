/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: MessageHead.java 
 * @Prject: api-dhtz
 * @Package: com.hengpeng.api.dhtz.common.message 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月26日 上午11:39:12 
 * @version: V1.0   
 */
package com.hengpeng.api.task.common.message;

/**
 * @ClassName: MessageHead
 * @Description: 接入系统的消息头
 * @author: zhangwei
 * @date: 2017年7月26日 上午11:39:12
 */
public class MessageHeader {
	/**
	 * 消息发送方的编号
	 */
	private String messengerID;
	/**
	 * 发送消息时的时间戳
	 */
	private String timestamp;
	/**
	 * 交易类型
	 */
	private String transactionType;
	/**
	 * 对消息包的摘要, 摘要算法为MD5，摘要的内容为（消息编号+时间戳+投注代理密码+消息体）
	 */
	private String digest;

	public String getMessengerID() {
		return messengerID;
	}

	public void setMessengerID(String messengerID) {
		this.messengerID = messengerID;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	@Override
	public String toString() {
		return "MessageHead [messengerID=" + messengerID + ", timestamp=" + timestamp + ", transactionType="
				+ transactionType + ", digest=" + digest + "]";
	}

}
