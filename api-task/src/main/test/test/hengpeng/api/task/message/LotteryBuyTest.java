/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: XmlTest.java 
 * @Prject: api-dhtz
 * @Package: test.hengpeng.api.dhtz.util 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月26日 下午3:50:22 
 * @version: V1.0   
 */
package test.hengpeng.api.task.message;

import com.hengpeng.api.task.common.constants.BusConstants;
import com.hengpeng.api.task.common.message.LotteryBuyRequestMessage;
import com.hengpeng.api.task.common.message.LotteryBuyRequestMessage.Body.LotteryRequest.Ticket;
import com.hengpeng.api.task.common.message.LotteryBuyResponseMessage;
import com.hengpeng.api.util.XStreamUtil;

/** 
 * @ClassName: XmlTest 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月26日 下午3:50:22  
 */
public class LotteryBuyTest extends test.hengpeng.api.task.BaseJUnit {

//	@Test
	public void requestToXmlTest(){
		LotteryBuyRequestMessage lotteryBuyRequestMessage = new LotteryBuyRequestMessage();
		lotteryBuyRequestMessage.setId("id001");
		lotteryBuyRequestMessage.setVersion("2.0");
		lotteryBuyRequestMessage.getHeader().setMessengerID("msg001");
		lotteryBuyRequestMessage.getHeader().setTimestamp("123456789");
		lotteryBuyRequestMessage.getHeader().setTransactionType("SSQ");
		lotteryBuyRequestMessage.getHeader().setDigest("dig001");
		Ticket ticket = new Ticket();
		ticket.setId("id001001");
		ticket.setPlayType("5");
		ticket.setMoney("2");
		ticket.setAmount("1");
		ticket.getIssue().setGameName("SSQ");
		ticket.getIssue().setNumber("20170101");
		ticket.getUserProfile().setUserName("hengpeng");
		ticket.getUserProfile().setCardType("1");
		ticket.getUserProfile().setCardNumber("3211000000000000");
		ticket.getUserProfile().setMail("www@126.com");
		ticket.getUserProfile().setMobile("13600000000");
		ticket.getUserProfile().setRealName("张三");
		ticket.getUserProfile().setBonusPhone("(0755)80000000");
		ticket.getAnteCode().add("01,02,03,04,05");
		ticket.getAnteCode().add("05,06,03,01,09");
		lotteryBuyRequestMessage.getBody().getLotteryRequest().getTicketList().add(ticket);
		
		Ticket ticket1 = new Ticket();
		ticket1.setId("id001002");
		ticket1.setPlayType("5");
		ticket1.setMoney("2");
		ticket1.setAmount("1");
		ticket1.getIssue().setGameName("SSQ");
		ticket1.getIssue().setNumber("20170101");
		ticket1.getUserProfile().setUserName("hengpeng");
		ticket1.getUserProfile().setCardType("1");
		ticket1.getUserProfile().setCardNumber("3211000000000000");
		ticket1.getUserProfile().setMail("www@126.com");
		ticket1.getUserProfile().setMobile("13600000000");
		ticket1.getUserProfile().setRealName("张三");
		ticket1.getUserProfile().setBonusPhone("(0755)80000000");
		ticket1.getAnteCode().add("01,02,03,04,06");
		ticket1.getAnteCode().add("05,06,03,01,08");
		lotteryBuyRequestMessage.getBody().getLotteryRequest().getTicketList().add(ticket1);
		
		String result = XStreamUtil.toXml(BusConstants.XML_HEAD, lotteryBuyRequestMessage);
		System.out.println(result);
	}
	
//	@Test
	public void responseToXmlTest(){
		LotteryBuyResponseMessage lotteryBuyResponseMessage = new LotteryBuyResponseMessage();
		lotteryBuyResponseMessage.setId("id001");
		lotteryBuyResponseMessage.setVersion("2.0");
		lotteryBuyResponseMessage.getHeader().setMessengerID("msg001");
		lotteryBuyResponseMessage.getHeader().setTimestamp("123456789");
		lotteryBuyResponseMessage.getHeader().setTransactionType("SSQ");
		lotteryBuyResponseMessage.getHeader().setDigest("dig001");
		lotteryBuyResponseMessage.getBody().getResponse().setCode("0000");
		
		LotteryBuyResponseMessage.Body.Response.LotteryRequestResult.Ticket ticket = new LotteryBuyResponseMessage.Body.Response.LotteryRequestResult.Ticket();
		ticket.setId("1139222");
		ticket.setDealTime("2017");
		ticket.setMessage("OK");
		ticket.setStatus("0000");
		ticket.setTicketSerialNo("A-B-C");
		lotteryBuyResponseMessage.getBody().getResponse().getLotteryRequestResult().getTicketList().add(ticket);
		
		String result = XStreamUtil.toXml(BusConstants.XML_HEAD, lotteryBuyResponseMessage);
		System.out.println(result);
	}

}
