/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: UserService.java 
 * @Prject: api-service
 * @Package: com.hengpeng.api.service 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月21日 下午1:30:24 
 * @version: V1.0   
 */
package com.hengpeng.api.service;

import java.util.Map;
import com.hengpeng.api.exception.SException;
import com.hengpeng.api.vo.OrderQueryRVO;
import com.hengpeng.api.vo.OrderQuerySVO;
import com.hengpeng.api.vo.SsqBuyRVO;
import com.hengpeng.api.vo.SsqBuySVO;

/** 
 * @ClassName: SSQService 
 * @Description: 双色球
 * @author: zhangwei
 * @date: 2017年7月24日 上午10:54:54  
 */
public interface SSQService {

	/** 
	 * @Description: 投注
	 * @param SsqBuyRVO
	 * @return
	 * @throws SException
	 * @return: SsqBuySVO
	 */
	public SsqBuySVO buy(SsqBuyRVO ssqBuyRVO) throws SException;

	/** 
	 * @Description: 投注校验
	 * @param buyRVo
	 * @return
	 * @return: Map<票号,失败原因>
	 */
	public Map<String, String> buyVerify(SsqBuyRVO ssqBuyRVO) throws SException;

	/** 
	 * @Description: 订单查询
	 * @param OrderQueryRVO
	 * @return
	 * @throws SException
	 * @return: OrderQuerySVO
	 */
	public OrderQuerySVO orderQuery(OrderQueryRVO orderQueryRVO) throws SException;
}
