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

import org.junit.Test;
import com.hengpeng.api.task.common.constants.BusConstants;
import com.hengpeng.api.task.common.message.TicketQueryResponseMessage;
import com.hengpeng.api.task.common.message.TicketQueryResponseMessage.Body.Response.TicketQueryResult.Ticket;
import com.hengpeng.api.util.XStreamUtil;
import test.hengpeng.api.task.BaseJUnit;

/** 
 * @ClassName: XmlTest 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月26日 下午3:50:22  
 */
public class TicketQueryTest extends BaseJUnit {

	@Test
	public void responseToXmlTest(){
		TicketQueryResponseMessage ticketQueryResponseMessage = new TicketQueryResponseMessage();
		ticketQueryResponseMessage.setId("id001");
		ticketQueryResponseMessage.getHeader().setMessengerID("mid001");
		ticketQueryResponseMessage.getBody().getResponse().setCode("0000");
		
		Ticket ticket = new Ticket();
		ticketQueryResponseMessage.getBody().getResponse().getTicketQueryResult().getTicketList().add(ticket);
		ticket.setId("id001");
		ticket.getIssue().setGameName("SSQ");
		ticket.getUserProfile().setUserName("zw");
		ticket.getAnteCode().add("01,09|06,07");

		Ticket ticket1 = new Ticket();
		ticketQueryResponseMessage.getBody().getResponse().getTicketQueryResult().getTicketList().add(ticket1);
		ticket1.setId("id002");
		ticket1.getIssue().setGameName("SSQ");
		ticket1.getUserProfile().setUserName("zw2");
		ticket1.getAnteCode().add("01");
		ticket1.getAnteCode().add("02");
		
		String result = XStreamUtil.toXml(BusConstants.XML_HEAD, ticketQueryResponseMessage);
		System.out.println(result);
	}

}
