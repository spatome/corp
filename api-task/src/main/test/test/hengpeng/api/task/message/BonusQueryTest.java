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
import com.hengpeng.api.task.common.message.BonusQueryRequestMessage;
import com.hengpeng.api.task.common.message.BonusQueryResponseMessage;
import com.hengpeng.api.task.common.message.BonusQueryResponseMessage.Body.Response.BonusQueryResult.BonusItem;
import com.hengpeng.api.util.XStreamUtil;
import test.hengpeng.api.task.BaseJUnit;

/** 
 * @ClassName: XmlTest 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月26日 下午3:50:22  
 */
public class BonusQueryTest extends BaseJUnit {

//	@Test
	public void requestToXmlTest(){
		BonusQueryRequestMessage bonusQueryRequestMessage = new BonusQueryRequestMessage();
		bonusQueryRequestMessage.setId("id001");
		bonusQueryRequestMessage.setVersion("2.0");
		bonusQueryRequestMessage.getHeader().setMessengerID("msg001");
		bonusQueryRequestMessage.getHeader().setTimestamp("123456789");
		bonusQueryRequestMessage.getHeader().setTransactionType("SSQ");
		bonusQueryRequestMessage.getHeader().setDigest("dig001");
		bonusQueryRequestMessage.getBody().getBonusQuery().getIssue().setGameName("SSQ");
		bonusQueryRequestMessage.getBody().getBonusQuery().getIssue().setNumber("20170101");
		
		String result = XStreamUtil.toXml(BusConstants.XML_HEAD, bonusQueryRequestMessage);
		System.out.println(result);
	}
	
//	@Test
	public void responseToXmlTest(){
		BonusQueryResponseMessage bonusQueryResponseMessage = new BonusQueryResponseMessage();
		bonusQueryResponseMessage.setId("id001");
		bonusQueryResponseMessage.setVersion("2.0");
		bonusQueryResponseMessage.getHeader().setMessengerID("msg001");
		bonusQueryResponseMessage.getHeader().setTimestamp("123456789");
		bonusQueryResponseMessage.getHeader().setTransactionType("SSQ");
		bonusQueryResponseMessage.getHeader().setDigest("dig001");
		bonusQueryResponseMessage.getBody().getResponse().setCode("0000");
		bonusQueryResponseMessage.getBody().getResponse().getBonusQueryResult().setTotalMoney("100");
		bonusQueryResponseMessage.getBody().getResponse().getBonusQueryResult().getIssue().setGameName("SSQ");
		BonusItem bonusItem = new BonusItem();
		bonusItem.setBonusLevel("6");
		bonusQueryResponseMessage.getBody().getResponse().getBonusQueryResult().getBonusItemList().add(bonusItem);
		
		BonusItem bonusItem1 = new BonusItem();
		bonusItem1.setBonusLevel("5");
		bonusQueryResponseMessage.getBody().getResponse().getBonusQueryResult().getBonusItemList().add(bonusItem1);
		
		String result = XStreamUtil.toXml(BusConstants.XML_HEAD, bonusQueryResponseMessage);
		System.out.println(result);
	}

}
