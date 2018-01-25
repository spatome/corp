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
import com.hengpeng.api.vo.SsqBuyRVO;
import com.hengpeng.api.vo.SsqBuySVO;

/** 
 * @ClassName: SsqBuyRVOTest 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月2日 下午5:41:58  
 */
public class SsqBuyVOTest {

	public static void main(String[] args) throws Exception {
		SsqBuyVOTest ssqBuyVOTest = new SsqBuyVOTest();
		
		System.out.println(ssqBuyVOTest.getSsqBuyRVOToStr());
		System.out.println(ssqBuyVOTest.getSsqBuySVOToStr());
	}
	
	public String getSsqBuyRVOToStr() throws Exception {
		SsqBuyRVO ssqBuyRVO = new SsqBuyRVO();
		ssqBuyRVO.setEnterpriseNo("000001");
		
		SsqBuyRVO.SsqTicket ssqTicket = new SsqBuyRVO.SsqTicket();
		ssqTicket.setTicketNo("11201701010000000000000000000001");
		ssqTicket.setCardNo("210002199001010700");
		ssqTicket.setRealName("本拉登");
		ssqTicket.setMobile("13000000000");
		ssqTicket.setMail("heng@126.com");
		ssqTicket.setIssueNo("2017001");
		ssqTicket.setGameType("SSQ");
		ssqTicket.setPlayType("101");
		ssqTicket.setTimes("1");
		ssqTicket.setLotterys("01,02,03,04,05,06#01");
		ssqTicket.setAmount("2.00");
		ssqBuyRVO.getList().add(ssqTicket);

		SsqBuyRVO.SsqTicket ssqTicket1 = new SsqBuyRVO.SsqTicket();
		ssqTicket1.setTicketNo("11201701010000000000000000000002");
		ssqTicket1.setCardNo("210002199001010700");
		ssqTicket1.setRealName("本拉登");
		ssqTicket1.setMobile("13000000000");
		ssqTicket1.setMail("heng@126.com");
		ssqTicket1.setIssueNo("2017001");
		ssqTicket1.setGameType("SSQ");
		ssqTicket1.setPlayType("101");
		ssqTicket1.setTimes("1");
		ssqTicket1.setLotterys("01,02,03,04,05,06#01,02");
		ssqTicket1.setAmount("4.00");
		ssqBuyRVO.getList().add(ssqTicket1);

		SsqBuyRVO.SsqTicket ssqTicket2 = new SsqBuyRVO.SsqTicket();
		ssqTicket2.setTicketNo("11201701010000000000000000000003");
		ssqTicket2.setCardNo("210002199001010700");
		ssqTicket2.setRealName("本拉登");
		ssqTicket2.setMobile("13000000000");
		ssqTicket2.setMail("heng@126.com");
		ssqTicket2.setIssueNo("2017001");
		ssqTicket2.setGameType("SSQ");
		ssqTicket2.setPlayType("101");
		ssqTicket2.setTimes("2");
		ssqTicket2.setLotterys("01,02,03,04,05,06#01");
		ssqTicket2.setAmount("4.00");
		ssqBuyRVO.getList().add(ssqTicket2);

		ObjectMapper om = new ObjectMapper();
		String result = om.writeValueAsString(ssqBuyRVO);

		return result;
	}
	
	public String getSsqBuySVOToStr() throws Exception {
		SsqBuySVO ssqBuySVO = new SsqBuySVO();
		ssqBuySVO.setFailCount("2");
		ssqBuySVO.setFialTicketNos("{11201701010000000000000000000001#金额不符}{11201701010000000000000000000003#金额金额不符}");

		SsqBuySVO.TicketOrder ticketOrder = new SsqBuySVO.TicketOrder();
		ticketOrder.setTicketNo("11201701010000000000000000000001");
		ticketOrder.setOrderNo("");
		ssqBuySVO.getList().add(ticketOrder);

		SsqBuySVO.TicketOrder ticketOrder1 = new SsqBuySVO.TicketOrder();
		ticketOrder1.setTicketNo("11201701010000000000000000000003");
		ticketOrder1.setOrderNo("");
		ssqBuySVO.getList().add(ticketOrder1);
		
		ObjectMapper om = new ObjectMapper();
		String result = om.writeValueAsString(ssqBuySVO);

		return result;
	}
}
