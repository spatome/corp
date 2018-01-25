/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: HandlerBuyServiceImpl.java 
 * @Prject: api-task
 * @Package: com.hengpeng.api.task.service.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月15日 上午9:44:24 
 * @version: V1.0   
 */
package com.hengpeng.api.task.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hengpeng.api.entity.SsqOrder;
import com.hengpeng.api.entity.SsqOrderTemp;
import com.hengpeng.api.enumtype.OrderPrintStatus;
import com.hengpeng.api.enumtype.OrderStatus;
import com.hengpeng.api.task.common.message.LotteryBuyResponseMessage;
import com.hengpeng.api.task.service.HttpAsyncService;
import com.hengpeng.api.util.XStreamUtil;

/** 
 * @ClassName: HandlerBuyServiceImpl 
 * @Description: 投注，报文接收
 * @author: zhangwei
 * @date: 2017年8月15日 上午9:44:24  
 */
@Transactional
@Service
public class HandlerBuyServiceImpl extends AbstractBaseService implements HttpAsyncService {

	@Override
	public void failed(Exception ex) {
	}

	@Override
	public void completed(String responseBody) {
		LotteryBuyResponseMessage lotteryBuyResponseMessage = XStreamUtil.toBean(responseBody, LotteryBuyResponseMessage.class);
		String retCode = lotteryBuyResponseMessage.getBody().getResponse().getCode();
		Date date = new Date();

		if(retCode.equals("0000")) {
			List<SsqOrderTemp> ssqOrderTempListUpdate = new ArrayList<SsqOrderTemp>();
			for (LotteryBuyResponseMessage.Body.Response.LotteryRequestResult.Ticket ticket : lotteryBuyResponseMessage.getBody().getResponse().getLotteryRequestResult().getTicketList()) {
				SsqOrderTemp ssqOrderTempUpdate = new SsqOrderTemp();
				ssqOrderTempUpdate.setSsqOrderNo("11"+ticket.getId());
				ssqOrderTempUpdate.setStatus(OrderPrintStatus.SENDED.toString());
				ssqOrderTempUpdate.setDescs(OrderPrintStatus.SENDED.getText());
				ssqOrderTempUpdate.setUtime(date);
				ssqOrderTempListUpdate.add(ssqOrderTempUpdate);						
			}

			if(ssqOrderTempListUpdate.size()>0){
				daoFactory.getSsqOrderTempMapper().batchUpdateStatusByOrderNo(ssqOrderTempListUpdate);	
			}
		}else{
			List<SsqOrder> ssqOrderListUpdate = new ArrayList<SsqOrder>();
			for (LotteryBuyResponseMessage.Body.Response.LotteryRequestResult.Ticket ticket : lotteryBuyResponseMessage.getBody().getResponse().getLotteryRequestResult().getTicketList()) {			
				SsqOrder ssqOrderUpdate = new SsqOrder();
				ssqOrderUpdate.setSsqOrderNo("11"+ticket.getId());
				ssqOrderUpdate.setStatus(OrderStatus.FAIL.toString());
				ssqOrderUpdate.setDescs(lotteryBuyResponseMessage.getBody().getResponse().getMessage());
				ssqOrderUpdate.setUtime(date);
				ssqOrderListUpdate.add(ssqOrderUpdate);

				daoFactory.getSsqOrderTempMapper().deleteByOrderNo("11"+ticket.getId());
			}

			if(ssqOrderListUpdate.size()>0){
				daoFactory.getSsqOrderMapper().batchUpdateStatusByOrderNo(ssqOrderListUpdate);
			}
		}
	}

	@Override
	public void cancelled() {
	}
}
