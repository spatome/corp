/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: SsqBuyRVOTest.java 
 * @Prject: api-core
 * @Package: test.hengpeng.api.json 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月2日 下午5:41:58 
 * @version: V1.0   
 */
package test.hengpeng.api.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengpeng.api.vo.OrderQueryRVO;
import com.hengpeng.api.vo.OrderQuerySVO;

/** 
 * @ClassName: OrderQueryVOTest 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月2日 下午5:41:58  
 */
public class OrderQueryVOTest {

	public static void main(String[] args) throws Exception {
		OrderQueryVOTest ssqBuyVOTest = new OrderQueryVOTest();
		
		System.out.println(ssqBuyVOTest.getOrderQueryRVOToStr());
		System.out.println(ssqBuyVOTest.getOrderQuerySVOToStr());
	}
	
	public String getOrderQueryRVOToStr() throws Exception {
		OrderQueryRVO orderQueryRVO = new OrderQueryRVO();
		orderQueryRVO.setEnterpriseNo("000001");
		orderQueryRVO.setOrderNos("11368921201701010000000001");
		orderQueryRVO.setIsMore("NO");

		ObjectMapper om = new ObjectMapper();
		String result = om.writeValueAsString(orderQueryRVO);

		return result;
	}
	
	public String getOrderQuerySVOToStr() throws Exception {
		OrderQuerySVO orderQuerySVO = new OrderQuerySVO();
		
		OrderQuerySVO.TicketInfo ticketInfo = new OrderQuerySVO.TicketInfo();
		ticketInfo.setTicketNo("11201701010000000000000000000001");
		ticketInfo.setOrderNo("11368921201701010000000001");
		ticketInfo.setStatus("UNDEAL");
		ticketInfo.setStatusDescs("未处理");
		ticketInfo.setDealTime("2017-01-01 08:30:00");
		orderQuerySVO.getList().add(ticketInfo);

		ObjectMapper om = new ObjectMapper();
		String result = om.writeValueAsString(orderQuerySVO);

		return result;
	}
}
