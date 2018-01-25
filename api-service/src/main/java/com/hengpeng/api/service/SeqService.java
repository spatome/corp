/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: SeqService.java 
 * @Prject: api-service
 * @Package: com.hengpeng.api.service 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月31日 下午5:22:27 
 * @version: V1.0   
 */
package com.hengpeng.api.service;

/** 
 * @ClassName: SeqService 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月31日 下午5:22:27  
 */
public interface SeqService {

	/*消息8位唯一值*/
	public long getMessageId();

	/*订单8位唯一值*/
	public long getOrderId();

}
