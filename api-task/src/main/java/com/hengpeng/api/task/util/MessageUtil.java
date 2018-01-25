/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: DigestUtil.java 
 * @Prject: api-dhtz
 * @Package: com.hengpeng.api.dhtz.util.secure 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月26日 下午7:38:21 
 * @version: V1.0   
 */
package com.hengpeng.api.task.util;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: DigestMessageUtil
 * @Description: 电话投注签名
 * @author: zhangwei
 * @date: 2017年7月26日 下午7:38:21
 */
public class MessageUtil {

	private final static String DEFAULT_LANG = "GBK";

	/** 
	 * @param src
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	public static String toMd5(String src) throws Exception{
		if(StringUtils.isEmpty(src)){
			 throw new RuntimeException("要Md5的数据是null");
		 }
		 byte[] in = src.getBytes(DEFAULT_LANG);
		 byte[] out = MessageDigest.getInstance("MD5").digest(in);
		 return Hex.encodeHexString(out);
	}
	
	/** 
	 * @Description: 签名
	 * @param enterpriseNo
	 * @param timestamp
	 * @param msgerPwd
	 * @param body
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	public static String sign(String id, String timestamp, String msgerPwd, String body) throws Exception {
		StringBuffer src = new StringBuffer();
		src.append(id);
		src.append(timestamp);
		src.append(msgerPwd);
		src.append(body);
		return toMd5(src.toString());
	}
}
