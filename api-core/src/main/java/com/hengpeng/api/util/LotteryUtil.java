/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: LotteryUtil.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.util 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月24日 上午10:23:00 
 * @version: V1.0   
 */
package com.hengpeng.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hengpeng.api.enumtype.GameType;

/** 
 * @ClassName: LotteryUtil 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月24日 上午10:23:00  
 */
public class LotteryUtil {

	private static SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMdd");

	/** 
	 * @Description: 订单号长度（24位）：gameType(2位)+商户号(6位)+4位商户编号+时间(8位)+SEQ（10位）
	 * @return	订单号
	 * @return: String
	 */
	public static String createOrderNo(String gameType, String enterpriseNo, String seq){
		StringBuffer sb = new StringBuffer();

		String seqStr = "0000000000" +seq; 

		sb.append(GameType.valueOf(gameType).getCode()).append(enterpriseNo).append("0004").append(SDF.format(new Date()))
		.append(seqStr.substring(seqStr.length()-10, seqStr.length()));

		return sb.toString();
	}
	public static String createOrderNo(String enterpriseNo, String seq){
		StringBuffer sb = new StringBuffer();

		String seqStr = "0000000000" +seq; 

		sb.append(enterpriseNo).append("0004").append(SDF.format(new Date()))
		.append(seqStr.substring(seqStr.length()-10, seqStr.length()));

		return sb.toString();
	}
	
	public static String createMessageNo(String enterpriseNo, String seq){
		StringBuffer sb = new StringBuffer();

		String seqStr = "00000000" +seq; 
		
		sb.append(enterpriseNo).append(SDF.format(new Date()))
		.append(seqStr.substring(seqStr.length()-8, seqStr.length()));

		return sb.toString();
	}

	public static void main(String[] args) {
	}
}
