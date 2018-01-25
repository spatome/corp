/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: SUtil.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.util 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月24日 上午9:22:47 
 * @version: V1.0   
 */
package com.hengpeng.api.util;

import java.util.UUID;

/** 
 * @ClassName: SUtil 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月24日 上午9:22:47  
 */
public class SUtil {

	/** 
	 * @Description: 票号
	 * @return
	 * @return: String
	 */
	public static String createTicketNo(){
		String result = "";

        String uuid = UUID.randomUUID().toString();  
        result = uuid.replace("-", "");  

		return result;
	}

	public static String createOrderNo(){
		String result = "";

        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        result = machineId + String.format("%015d", hashCodeV); 

		return result;
	}

}
