/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: LotteryServiceImpl.java 
 * @Prject: api-service
 * @Package: com.hengpeng.api.service.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月24日 上午10:58:12 
 * @version: V1.0   
 */
package com.hengpeng.api.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hengpeng.api.constants.ApiConstants;
import com.hengpeng.api.constants.BusinessConstants;
import com.hengpeng.api.constants.MessageConstant;
import com.hengpeng.api.entity.Account;
import com.hengpeng.api.entity.SsqOrder;
import com.hengpeng.api.entity.SsqOrderTemp;
import com.hengpeng.api.enumtype.CodeMessage;
import com.hengpeng.api.enumtype.GameType;
import com.hengpeng.api.enumtype.OrderPrintStatus;
import com.hengpeng.api.enumtype.OrderStatus;
import com.hengpeng.api.exception.SException;
import com.hengpeng.api.service.SSQService;
import com.hengpeng.api.util.ConfigParamUtil;
import com.hengpeng.api.util.DateUtil;
import com.hengpeng.api.util.GameVerifyUtil;
import com.hengpeng.api.util.LotteryUtil;
import com.hengpeng.api.util.ValidationUtil;
import com.hengpeng.api.vo.OrderQueryRVO;
import com.hengpeng.api.vo.OrderQuerySVO;
import com.hengpeng.api.vo.SsqBuyRVO;
import com.hengpeng.api.vo.SsqBuyRVO.SsqTicket;
import com.hengpeng.api.vo.SsqBuySVO;

/** 
 * @ClassName: LotteryServiceImpl 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月24日 上午10:58:12  
 */
@Transactional
@Service
public class SSQServiceImpl extends AbstractBaseService implements SSQService {

	/** 
	 * @Description: 投注
	 * @param buyVo
	 * @return
	 * @throws SException 
	 * @see com.hengpeng.api.service.SSQService#buy(com.hengpeng.api.vo.BuyRVo) 
	 */
	@Override
	public SsqBuySVO buy(SsqBuyRVO ssqBuyRVO) throws SException {
		LOGGER.info("投注双色球：" + ssqBuyRVO);
		SsqBuySVO result = new SsqBuySVO();

		try {
			Map<String, String> buyVerifyResult = this.buyVerify(ssqBuyRVO);
			result.setFailCount(String.valueOf(buyVerifyResult.size()));

			StringBuffer sb = new StringBuffer();
			for (Map.Entry<String, String> entry : buyVerifyResult.entrySet()) {
				sb.append("{").append(entry.getKey()).append("#").append(entry.getValue()).append("}");
			}
			result.setFialTicketNos(sb.toString());

			List<SsqOrder> saveSsqOrderList = new ArrayList<SsqOrder>();
			List<SsqOrderTemp> saveSsqOrderTempList = new ArrayList<SsqOrderTemp>();
			Date curDate = new Date();

			for (SsqTicket f : ssqBuyRVO.getList()) {
				if(buyVerifyResult.containsKey(f.getTicketNo())){
					continue;
				}

				String orderNo = LotteryUtil.createOrderNo(GameType.SSQ.toString(), 
						ConfigParamUtil.getProperty(ApiConstants.KXCH_CENTER_USERNAME),
						String.valueOf(serviceFactory.getSeqService().getOrderId())
						);

				SsqBuySVO.TicketOrder ticketOrder = new SsqBuySVO.TicketOrder();
				ticketOrder.setTicketNo(f.getTicketNo());
				ticketOrder.setOrderNo(orderNo);
				result.getList().add(ticketOrder);

				//双色球entity
				SsqOrder ssqOrder = new SsqOrder();
				ssqOrder.setCompanyNo(ssqBuyRVO.getEnterpriseNo());
				ssqOrder.setSsqOrderNo(orderNo);
				ssqOrder.setTicketNo(f.getTicketNo());
				ssqOrder.setIssueNo(f.getIssueNo());
				ssqOrder.setPlayType(f.getPlayType());
				ssqOrder.setTimes(StringUtils.isEmpty(f.getTimes())?1:Integer.valueOf(f.getTimes()));
				ssqOrder.setLotterys(f.getLotterys());
				ssqOrder.setAmount(new BigDecimal(f.getAmount()));
				ssqOrder.setCardNo(f.getCardNo());
				ssqOrder.setRealName(f.getRealName());
				ssqOrder.setMobile(f.getMobile());
				ssqOrder.setStatus(OrderStatus.UNDEAL.toString());
				ssqOrder.setDescs(OrderStatus.UNDEAL.getText());
				ssqOrder.setItime(curDate);
				ssqOrder.setUtime(curDate);
				saveSsqOrderList.add(ssqOrder);
				
				//双色球临时表entity
				SsqOrderTemp ssqOrderTemp = new SsqOrderTemp();
				ssqOrderTemp.setCompanyNo(ssqBuyRVO.getEnterpriseNo());
				ssqOrderTemp.setSsqOrderNo(orderNo);
				ssqOrderTemp.setTicketNo(f.getTicketNo());
				ssqOrderTemp.setIssueNo(f.getIssueNo());
				ssqOrderTemp.setPlayType(f.getPlayType());
				ssqOrderTemp.setTimes(StringUtils.isEmpty(f.getTimes())?1:Integer.valueOf(f.getTimes()));
				ssqOrderTemp.setLotterys(f.getLotterys());
				ssqOrderTemp.setAmount(new BigDecimal(f.getAmount()));
				ssqOrderTemp.setCardNo(f.getCardNo());
				ssqOrderTemp.setRealName(f.getRealName());
				ssqOrderTemp.setMobile(f.getMobile());
				ssqOrderTemp.setStatus(OrderPrintStatus.UNPRINT.toString());
				ssqOrderTemp.setDescs(OrderPrintStatus.UNPRINT.getText());
				ssqOrderTemp.setItime(curDate);
				ssqOrderTemp.setUtime(curDate);
				saveSsqOrderTempList.add(ssqOrderTemp);
			}

			if(saveSsqOrderList.size()>0){
				daoFactory.getSsqOrderMapper().batchInsert(saveSsqOrderList);
				daoFactory.getSsqOrderTempMapper().batchInsert(saveSsqOrderTempList);
			}
		} catch (SException e) {
			LOGGER.error("buySsq", e);
			throw e;
		} catch (Exception e) {
			LOGGER.error("buySsq", e);
			throw new SException(CodeMessage.FAILURE.getCode(), "投注内部异常");
		}

		return result;
	}
	
	/** 
	 * @Description: 双色球投注校验
	 * @return: Map<票号， 失败原因>
	 */
	public Map<String, String> buyVerify(SsqBuyRVO ssqBuyRVO) throws SException {
		Map<String, String> result = new HashMap<String, String>();

		//校验
		ValidationUtil.ValidationResult vr = ValidationUtil.validateEntity(ssqBuyRVO);
		if(vr.isHasErrors()){
			throw new SException(CodeMessage.FAILURE.getCode(), vr.getErrorMsg().toString());
		}

		if(ssqBuyRVO.getList().size()<=0 || ssqBuyRVO.getList().size()>BusinessConstants.SSQ_BUY_TICKET_MAX_NUM){
			throw new SException(CodeMessage.FAILURE.getCode(), "List票数必须大于0和不超过"+BusinessConstants.SSQ_BUY_TICKET_MAX_NUM);
		}

		BigDecimal totalAmount = new BigDecimal("0.00");
		for (SsqBuyRVO.SsqTicket f : ssqBuyRVO.getList()) {
			totalAmount = totalAmount.add(new BigDecimal(f.getAmount()));

			ValidationUtil.ValidationResult vrTicket = ValidationUtil.validateEntity(f);

			if(vrTicket.isHasErrors()){
				String errMsg = vrTicket.getErrorMsg().toString();
				result.put(f.getTicketNo(), errMsg.replace("{", "").replace("}", ""));
			}

			//校验lotterys
			SException se = GameVerifyUtil.ssqCodeVerify(f.getLotterys(), f.getPlayType(), StringUtils.isBlank(f.getTimes())?"1":f.getTimes(), f.getAmount());
			if(MessageConstant.TRANSACTION_RESPONSE_CODE_SUCCESS.equals(se.getCode())){
			}else {
				result.put(f.getTicketNo(), se.getMessage());
			};
		}

		//简单校验可用金额
		Account accountQ = new Account();
		accountQ.setStatus("ACTIVE");
		accountQ.setAccountNo(ssqBuyRVO.getEnterpriseNo());
		Account account = daoFactory.getAccountMapper().selectByBean(accountQ).get(0);
		if(totalAmount.compareTo(account.getCurrentBalance())==1){
			throw new SException(CodeMessage.FAILURE.getCode(), "保证金可能不够");
		}

		return result;
	}

	public void verify(OrderQueryRVO orderQueryRVO) throws SException {
		ValidationUtil.ValidationResult vr = ValidationUtil.validateEntity(orderQueryRVO);

		if(vr.isHasErrors()){
			throw new SException(CodeMessage.FAILURE.getCode(), vr.getErrorMsg().toString());
		}

		String[] orderNos = orderQueryRVO.getOrderNos().split(",");
		if(orderNos.length>BusinessConstants.QUERY_ORDER_MAX_NUM){
			throw new SException(CodeMessage.FAILURE.getCode(), "票数必须不超过"+BusinessConstants.QUERY_ORDER_MAX_NUM);
		}
	};

	/** 
	 * @Description: 订单查询
	 * @param orderRVo
	 * @return
	 * @throws SException 
	 * @see com.hengpeng.api.service.SSQService#orderQuery(com.hengpeng.api.vo.OrderRVo) 
	 */
	@Override
	public OrderQuerySVO orderQuery(OrderQueryRVO orderQueryRVO) throws SException {
		this.verify(orderQueryRVO);

		try {
			if("YES".equalsIgnoreCase(orderQueryRVO.getIsMore())){
				return this.detailOrderQuery(orderQueryRVO.getEnterpriseNo(), orderQueryRVO.getOrderNos().split(","));
			}else{
				//
				return this.simpleOrderQuery(orderQueryRVO.getEnterpriseNo(), orderQueryRVO.getOrderNos().split(","));
			}
		} catch (SException e) {
			LOGGER.error("orderQuery", e);
			throw e;
		} catch (Exception e) {
			LOGGER.error("orderQuery", e);
			throw new SException(CodeMessage.FAILURE.getCode(), "订单查询内部异常");
		}
	}

	/** 
	 * @Description: 订单查询简单信息
	 * @param enterpriseNo
	 * @param orderNos
	 * @return
	 * @return: List<OrderSimpleVo>
	 */
	private OrderQuerySVO simpleOrderQuery(String enterpriseNo, String[] orderNos) {
		OrderQuerySVO result = new OrderQuerySVO();
		
		if(orderNos.length>0){
			List<SsqOrder> ssqOrderList = daoFactory.getSsqOrderMapper().selectSimpleOrders(orderNos);

			for (SsqOrder f : ssqOrderList) {
				OrderQuerySVO.TicketInfo ticketInfo = new OrderQuerySVO.TicketInfo();
				ticketInfo.setTicketNo(f.getTicketNo());
				ticketInfo.setOrderNo(f.getSsqOrderNo());
				ticketInfo.setStatus(f.getStatus());
				ticketInfo.setDealTime(DateUtil.formatDate(f.getUtime()));

				if(f.getCompanyNo().equals(enterpriseNo)){
					//是该公司的
					ticketInfo.setStatusDescs(f.getDescs());	
				}else{
					ticketInfo.setStatusDescs("该订单不属于本公司");
				}

				result.getList().add(ticketInfo);
			}
		}

		return result;
	}
	
	/** 
	 * @Description: 订单查询详细信息
	 * @param enterpriseNo
	 * @param orderNos
	 * @return
	 * @return: List<OrderDetailVo>
	 */
	private OrderQuerySVO detailOrderQuery(String enterpriseNo, String[] orderNos) {
		OrderQuerySVO result = new OrderQuerySVO();
		
		if(orderNos.length>0){
			List<SsqOrder> ssqOrderList = daoFactory.getSsqOrderMapper().selectSimpleOrders(orderNos);

			for (SsqOrder f : ssqOrderList) {
				OrderQuerySVO.TicketInfo ticketInfo = new OrderQuerySVO.TicketInfo();
				ticketInfo.setTicketNo(f.getTicketNo());
				ticketInfo.setOrderNo(f.getSsqOrderNo());
				ticketInfo.setStatus(f.getStatus());
				ticketInfo.setDealTime(DateUtil.formatDate(f.getUtime()));
				ticketInfo.setAmount(f.getAmount().toString());
				ticketInfo.setCardNo(f.getCardNo());
				ticketInfo.setGameType("SSQ");
				ticketInfo.setIssueNo(f.getIssueNo());
				ticketInfo.setLotterys(f.getLotterys());
				ticketInfo.setMobile(f.getMobile());
				ticketInfo.setPlayType(f.getPlayType());
				ticketInfo.setRealName(f.getRealName());

				if(f.getCompanyNo().equals(enterpriseNo)){
					//是该公司的
					ticketInfo.setStatusDescs(f.getDescs());	
				}else{
					ticketInfo.setStatusDescs("该订单不属于本公司");
				}

				result.getList().add(ticketInfo);
			}
		}

		return result;
	}
}