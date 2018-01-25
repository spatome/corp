/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: Start.java 
 * @Prject: api-service
 * @Package: com.hengpeng.api 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月20日 下午1:01:50 
 * @version: V1.0   
 */
package com.hengpeng.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: Start
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月20日 下午1:01:50
 */
public class Start {
	protected static Logger LOGGER = LoggerFactory.getLogger(Start.class);
	
	
	public static void main(String[] args) {
		Start.getLocalip();
		LOGGER.info("开始启动api-service...");

		com.alibaba.dubbo.container.Main.main(args);
	}
	
    private static void getLocalip() {  
        try {  
        	LOGGER.info("服务暴露的ip: " + java.net.InetAddress.getLocalHost().getHostAddress());  
        } catch (Exception e) {  
        	LOGGER.error(e.getMessage(), e);  
        }  
    }
}
