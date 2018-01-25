/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: BonusListRVo.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.vo 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月25日 上午9:09:07 
 * @version: V1.0   
 */
package com.hengpeng.api.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BonusDetailSVO
 * @Description: 中奖详情应答
 * @author: zhangwei
 * @date: 2017年7月25日 上午9:09:07
 */
public class BonusDetailSVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String bonusCode;
	private List<BonusInfo> list;

	public String getBonusCode() {
		return bonusCode;
	}

	public void setBonusCode(String bonusCode) {
		this.bonusCode = bonusCode;
	}

	public List<BonusInfo> getList() {
		if(list==null){
			list = new ArrayList<BonusInfo>();
		}
		return list;
	}

	public void setList(List<BonusInfo> list) {
		this.list = list;
	}

	public static class BonusInfo implements Serializable {
		private static final long serialVersionUID = 1L;

		private String orderNo;
		private String playType;
		private String isBombBonus;
		private String bonusLevel;
		private String bonusLevelAmount;
		private String amount;

		public String getOrderNo() {
			return orderNo;
		}
		public void setOrderNo(String orderNo) {
			this.orderNo = orderNo;
		}
		public String getPlayType() {
			return playType;
		}
		public void setPlayType(String playType) {
			this.playType = playType;
		}
		public String getIsBombBonus() {
			return isBombBonus;
		}
		public void setIsBombBonus(String isBombBonus) {
			this.isBombBonus = isBombBonus;
		}
		public String getBonusLevel() {
			return bonusLevel;
		}
		public void setBonusLevel(String bonusLevel) {
			this.bonusLevel = bonusLevel;
		}
		public String getBonusLevelAmount() {
			return bonusLevelAmount;
		}
		public void setBonusLevelAmount(String bonusLevelAmount) {
			this.bonusLevelAmount = bonusLevelAmount;
		}
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
	}
}
