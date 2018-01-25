/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: PasswordDigestMain.java 
 * @Prject: api-service
 * @Package: test.hengpeng.api.company 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月3日 上午10:38:45 
 * @version: V1.0   
 */
package test.hengpeng.api.company;

import org.apache.commons.codec.digest.DigestUtils;

/** 
 * @ClassName: PasswordDigestMain 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月3日 上午10:38:45  
 */
public class PasswordDigestMain {

	public static void main(String[] args) {

		//System.out.println(getMd5("bbbbbb"));
		System.out.println(getPassword("000002", "875f26fdb1cecf20ceb4ca028263dec6", "20170807120101"));
		
	}

	public static String getPassword(String enterpriseNo, String secret, String timeStamp){
		return getMd5(enterpriseNo+secret+timeStamp);
	}

	public static String getMd5(String str){
		return DigestUtils.md5Hex(str);
	};
}
