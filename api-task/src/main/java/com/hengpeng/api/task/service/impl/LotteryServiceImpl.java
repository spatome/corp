/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: IssueServiceImpl.java 
 * @Prject: api-task
 * @Package: com.hengpeng.api.task.service.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月8日 下午2:20:41 
 * @version: V1.0   
 */
package com.hengpeng.api.task.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.hengpeng.api.entity.AccountLog;
import com.hengpeng.api.entity.PrintIssue;
import com.hengpeng.api.entity.SsqOrder;
import com.hengpeng.api.entity.SsqOrderTemp;
import com.hengpeng.api.enumtype.CodeMessage;
import com.hengpeng.api.enumtype.OrderPrintStatus;
import com.hengpeng.api.enumtype.OrderStatus;
import com.hengpeng.api.exception.SException;
import com.hengpeng.api.task.common.message.LotteryBuyRequestMessage;
import com.hengpeng.api.task.common.message.LotteryBuyResponseMessage;
import com.hengpeng.api.task.common.message.TicketQueryResponseMessage;
import com.hengpeng.api.task.service.LotteryService;
import com.hengpeng.api.util.DateUtil;

/** 
 * @ClassName: IssueServiceImpl 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月8日 下午2:20:41  
 */
@Transactional
@Service
public class LotteryServiceImpl extends AbstractBaseService implements LotteryService {

	/** 
	 * @Description: 向中心投注
	 * @throws SException 
	 * @see com.hengpeng.api.task.service.LotteryService#synTicket() 
	 */
	@Override
	public void synTicket() throws SException {
		try {
			PrintIssue printIssueQ = new PrintIssue();
			printIssueQ.setIssueType("1");
			List<PrintIssue> printIssueList = daoFactory.getPrintIssueMapper().selectByBean(printIssueQ);

			if(printIssueList.size()!=1){
				LOGGER.error("================================================");
				LOGGER.error("严重警告,在售奖期异常,请检查PringIssue的在售奖期...");
				LOGGER.error("================================================");
				return ;
			}
			PrintIssue currentPrintIssue = printIssueList.get(0);
			String salingIssueNo = currentPrintIssue.getIssueNo();

			if(System.currentTimeMillis() > currentPrintIssue.getStopTime().getTime() || System.currentTimeMillis() < currentPrintIssue.getStartTime().getTime()){
				LOGGER.error("================================================");
				LOGGER.error("严重警告,非投注时间,请检查PringIssue的开始和结束时间...");
				LOGGER.error("================================================");
				return ;
			}

			//查询未处理的订单,先存先处理
			SsqOrderTemp ssqOrderTempQ = new SsqOrderTemp();
			ssqOrderTempQ.setIssueNo(salingIssueNo);
			ssqOrderTempQ.setStatus(OrderPrintStatus.UNPRINT.toString());
			PageHelper.startPage(1, 1000);
			PageHelper.orderBy("id desc");
			List<SsqOrderTemp> ssqOrderTempList = daoFactory.getSsqOrderTempMapper().selectByBean(ssqOrderTempQ);

			if(ssqOrderTempList.size()==0){
				return ;
			}

			//投注前先扣款
			List<AccountLog> accountLogListInsert = new ArrayList<>();
			Iterator<SsqOrderTemp> it = ssqOrderTempList.iterator();
			while(it.hasNext()){
				SsqOrderTemp f = it.next();
				SException se = serviceFactory.getAccountService().subtractCurrentBalance(f.getCompanyNo(), f.getAmount().abs());
				if("0000".equals(se.getCode())){
					AccountLog accountLog = new AccountLog();
					accountLog.setCompanyNo(f.getCompanyNo());
					accountLog.setInOut("OUT");
					accountLog.setItime(new Date());
					accountLog.setOrderNo(f.getSsqOrderNo());
					accountLogListInsert.add(accountLog);
					continue;
				}else{
					SsqOrder ssqOrder = new SsqOrder();
					ssqOrder.setSsqOrderNo(f.getSsqOrderNo());
					ssqOrder.setStatus(OrderStatus.FAIL.toString());
					ssqOrder.setDescs(se.getMessage());
					List<SsqOrder> ssqOrderList = new ArrayList<SsqOrder>();
					ssqOrderList.add(ssqOrder);
					this.doBuySsqFail(ssqOrderList);

					it.remove();
				}
			}
			daoFactory.getAccountLogMapper().batchInsert(accountLogListInsert);

			//置临时状态SENDING
			List<Long> updateSendingStatusList = new ArrayList<>();
			for(SsqOrderTemp f : ssqOrderTempList){
				updateSendingStatusList.add(f.getId());
			}
			if(updateSendingStatusList.size()>0){
				daoFactory.getSsqOrderTempMapper().batchUpdateSendingStatus(updateSendingStatusList);
			}

			//组装彩票中心参数
			List<LotteryBuyRequestMessage.Body.LotteryRequest.Ticket> ticketList = new ArrayList<>();
			for (SsqOrderTemp f : ssqOrderTempList) {
				LotteryBuyRequestMessage.Body.LotteryRequest.Ticket ticket = new LotteryBuyRequestMessage.Body.LotteryRequest.Ticket();
				ticket.setId(f.getSsqOrderNo().replaceFirst("11", ""));
				ticket.setPlayType(f.getPlayType());
				ticket.setMoney(f.getAmount().toString());
				ticket.setAmount(String.valueOf(f.getTimes()));
				ticket.getIssue().setGameName("ssq");
				ticket.getIssue().setNumber(f.getIssueNo());
				ticket.getUserProfile().setUserName(f.getCompanyNo());
				ticket.getUserProfile().setCardType("1");
				ticket.getUserProfile().setCardNumber(f.getCardNo());
				ticket.getUserProfile().setMail("spatome@126.com");
				ticket.getUserProfile().setMobile(f.getMobile());
				ticket.getUserProfile().setRealName(f.getRealName());
				ticket.getUserProfile().setBonusPhone("(0755)888602400");
				String[] strs = f.getLotterys().split(";");
				for (String string : strs) {
					ticket.getAnteCode().add(string);
				}
				ticketList.add(ticket);
			}

			//分批向彩票中心投送
			List<List<LotteryBuyRequestMessage.Body.LotteryRequest.Ticket>> ticketListList = this.splitList(ticketList, 500);
			for (List<LotteryBuyRequestMessage.Body.LotteryRequest.Ticket> list : ticketListList) {
				handlerBuyTicket(list);
			}
		} catch (Exception e) {
			LOGGER.error("synTicket", e);
			throw new SException(CodeMessage.FAILURE.getCode(), "synTicket 失败:");
		}
	}

/*	优化用
	public void handlerBuyTicket(List<LotteryBuyRequestMessage.Body.LotteryRequest.Ticket> ticketList) throws Exception{
		serviceFactory.getCenterService().sendTicket(ticketList, String.valueOf(serviceFactory.getSeqService().getMessageId()), "1.1");
	}*/
	
	/** 
	 * @Description: 向中心投注彩票
	 * @param ticketList
	 * @throws Exception
	 * @return: void
	 */
	public void handlerBuyTicket(List<LotteryBuyRequestMessage.Body.LotteryRequest.Ticket> ticketList) throws Exception{
		LotteryBuyResponseMessage lotteryBuyResponseMessage = serviceFactory.getCenterService().buyTicket(ticketList, String.valueOf(serviceFactory.getSeqService().getMessageId()), "1.1");
		String retCode = lotteryBuyResponseMessage.getBody().getResponse().getCode();

		if(retCode.equals("0000")) {
			List<SsqOrderTemp> ssqOrderTempListUpdate = new ArrayList<SsqOrderTemp>();

			for (LotteryBuyRequestMessage.Body.LotteryRequest.Ticket ticket : ticketList) {
				SsqOrderTemp ssqOrderTempUpdate = new SsqOrderTemp();
				ssqOrderTempUpdate.setSsqOrderNo("11"+ticket.getId());
				ssqOrderTempUpdate.setStatus(OrderPrintStatus.SENDED.toString());
				ssqOrderTempUpdate.setDescs(OrderPrintStatus.SENDED.getText());
				ssqOrderTempUpdate.setUtime(new Date());
				ssqOrderTempListUpdate.add(ssqOrderTempUpdate);
			}
			if(ssqOrderTempListUpdate.size()>0){
				daoFactory.getSsqOrderTempMapper().batchUpdateStatusByOrderNo(ssqOrderTempListUpdate);
			}
		}else{
			//失败 拆分单个重发
			for (LotteryBuyRequestMessage.Body.LotteryRequest.Ticket f : ticketList) {
				List<LotteryBuyRequestMessage.Body.LotteryRequest.Ticket> reTicketList = new ArrayList<>();
				reTicketList.add(f);

				LotteryBuyResponseMessage reLotteryBuyResponseMessage = serviceFactory.getCenterService().buyTicket(reTicketList, String.valueOf(serviceFactory.getSeqService().getMessageId()), "1.1");
				String retCode1 = reLotteryBuyResponseMessage.getBody().getResponse().getCode();

				if(retCode1.equals("0000")){
					SsqOrderTemp ssqOrderTempUpdate = new SsqOrderTemp();
					ssqOrderTempUpdate.setSsqOrderNo("11"+f.getId());
					ssqOrderTempUpdate.setStatus(OrderPrintStatus.SENDED.toString());
					ssqOrderTempUpdate.setDescs(OrderPrintStatus.SENDED.getText());
					ssqOrderTempUpdate.setUtime(new Date());
					daoFactory.getSsqOrderTempMapper().updateByOrderNoSelective(ssqOrderTempUpdate);
				}else{
					SsqOrder ssqOrderUpdate = new SsqOrder();
					ssqOrderUpdate.setSsqOrderNo("11"+f.getId());
					ssqOrderUpdate.setStatus(OrderStatus.FAIL.toString());
					ssqOrderUpdate.setDescs(reLotteryBuyResponseMessage.getBody().getResponse().getMessage());
					ssqOrderUpdate.setUtime(new Date());
					daoFactory.getSsqOrderMapper().updateByOrderNoSelective(ssqOrderUpdate);

					daoFactory.getSsqOrderTempMapper().deleteByOrderNo("11"+f.getId());

					//冲正
					SException se = serviceFactory.getAccountService().addCurrentBalance(f.getUserProfile().getUserName(), new BigDecimal(f.getMoney()).abs());
					AccountLog accountLog = new AccountLog();
					accountLog.setCompanyNo(f.getUserProfile().getUserName());
					accountLog.setInOut("IN");
					accountLog.setItime(new Date());
					accountLog.setOrderNo(f.getId());
					accountLog.setAmount(new BigDecimal(f.getMoney()));
					accountLog.setInOutDesc("(SENDED失败冲正)"+se.getMessage());
					daoFactory.getAccountLogMapper().insertSelective(accountLog);
				}
			}
		}
	}

	/** 
	 * @Description: 同步票状态
	 * @throws SException 
	 * @see com.hengpeng.api.task.service.LotteryService#synTicketStatus() 
	 */
	@Override
	public void synTicketStatus() throws SException {
		try {
			//查询订单状态
			SsqOrderTemp ssqOrderTempQ = new SsqOrderTemp();
			ssqOrderTempQ.setStatus(OrderPrintStatus.SENDED.toString());
			PageHelper.startPage(1, 200);
			PageHelper.orderBy("id desc");
			List<SsqOrderTemp> ssqOrderTempList = daoFactory.getSsqOrderTempMapper().selectByBean(ssqOrderTempQ);

			if(ssqOrderTempList.size()==0){
				return ;
			}

			List<String> orderNoList = new ArrayList<String>();
			for (SsqOrderTemp f : ssqOrderTempList) {
				orderNoList.add(f.getSsqOrderNo().replaceFirst("11", ""));
			}
			List<List<String>> orderNoListList = this.splitList(orderNoList, 5);
			
			for (List<String> list : orderNoListList) {
				this.handlerTicketStatus(new HashSet<String>(list));
			}

		} catch (Exception e) {
			LOGGER.error("synTicketStatus", e);
			throw new SException(CodeMessage.FAILURE.getCode(), "synTicketStatus 失败:");
		}
	}
	
	/** 
	 * @Description: 处理票状态
	 * @param orderNoSet
	 * @throws Exception
	 * @return: void
	 */
	public void handlerTicketStatus(Set<String> orderNoSet) throws Exception {
		TicketQueryResponseMessage ticketQueryResponseMessage = serviceFactory.getCenterService().getTicket(orderNoSet, String.valueOf(serviceFactory.getSeqService().getMessageId()), "1.1");
		String retCode = ticketQueryResponseMessage.getBody().getResponse().getCode();

		if("0000".equals(retCode)){
			List<TicketQueryResponseMessage.Body.Response.TicketQueryResult.Ticket> retTicketList = ticketQueryResponseMessage.getBody().getResponse().getTicketQueryResult().getTicketList();

			List<SsqOrder> ssqOrderListUpdate = new ArrayList<SsqOrder>();
			for (TicketQueryResponseMessage.Body.Response.TicketQueryResult.Ticket ticket : retTicketList) {
				SsqOrder ssqOrderUpdate = new SsqOrder();
				ssqOrderUpdate.setSsqOrderNo("11"+ticket.getId());
				ssqOrderUpdate.setStatus("0000".equals(ticket.getStatus())?OrderStatus.SUCCESS.toString():OrderStatus.FAIL.toString());
				ssqOrderUpdate.setDescs(ticket.getMessage());
				ssqOrderUpdate.setUtime(DateUtil.parseLongDateNoSplit(ticket.getDealTime()));
				ssqOrderListUpdate.add(ssqOrderUpdate);

				daoFactory.getSsqOrderTempMapper().deleteByOrderNo("11"+ticket.getId());
				
				if(!"0000".equals(ticket.getStatus())){
					//冲正
					SException se = serviceFactory.getAccountService().addCurrentBalance(ticket.getUserProfile().getUserName(), new BigDecimal(ticket.getMoney()).abs());
					AccountLog accountLog = new AccountLog();
					accountLog.setCompanyNo(ticket.getUserProfile().getUserName());
					accountLog.setInOut("IN");
					accountLog.setItime(new Date());
					accountLog.setOrderNo(ticket.getId());
					accountLog.setAmount(new BigDecimal(ticket.getMoney()));
					accountLog.setInOutDesc("(出票失败冲正)"+se.getMessage());
					daoFactory.getAccountLogMapper().insertSelective(accountLog);
				}
			}
			if(ssqOrderListUpdate.size()>0){
				daoFactory.getSsqOrderMapper().batchUpdateStatusByOrderNo(ssqOrderListUpdate);	
			}
		}
	}

	public <T> List<List<T>> splitList(List<T> list, int len) {
		if (list == null || list.size() == 0 || len < 1) {
			return null;
		}

		List<List<T>> result = new ArrayList<List<T>>();

		int size = list.size();
		int count = (size + len - 1) / len;

		for (int i = 0; i < count; i++) {
			List<T> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
			result.add(subList);
		}
		return result;
	}
	
	/** 
	 * @Description: 双色球订单处理失败
	 * @param ssqOrderList(需要orderNo, status,descs)
	 * @return: void
	 */
	public void doBuySsqFail(List<SsqOrder> ssqOrderList){
		//先修改结果
		daoFactory.getSsqOrderMapper().batchUpdateStatusByOrderNo(ssqOrderList);

		//后删除临时处理记录
		for (SsqOrder ssqOrder : ssqOrderList) {
			daoFactory.getSsqOrderTempMapper().deleteByOrderNo(ssqOrder.getSsqOrderNo());	
		}
	}
}
