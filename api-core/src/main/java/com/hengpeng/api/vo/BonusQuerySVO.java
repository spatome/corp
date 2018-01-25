/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: BonusRVo.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.vo 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月25日 上午8:53:38 
 * @version: V1.0   
 */
package com.hengpeng.api.vo;

import java.io.Serializable;

/**
 * @ClassName: BonusQuerySVO
 * @Description: 中奖信息查询应答
 * @author: zhangwei
 * @date: 2017年7月25日 上午8:53:38
 */
public class BonusQuerySVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String bonusCode;
	private String bonusCount;
	private String bonusAmount;

	public String getBonusCode() {
		return bonusCode;
	}

	public void setBonusCode(String bonusCode) {
		this.bonusCode = bonusCode;
	}

	public String getBonusCount() {
		return bonusCount;
	}

	public void setBonusCount(String bonusCount) {
		this.bonusCount = bonusCount;
	}

	public String getBonusAmount() {
		return bonusAmount;
	}

	public void setBonusAmount(String bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	@Override
	public String toString() {
		return "BonusSVo [bonusCode=" + bonusCode + ", bonusCount=" + bonusCount + ", bonusAmount=" + bonusAmount + "]";
	}

}
