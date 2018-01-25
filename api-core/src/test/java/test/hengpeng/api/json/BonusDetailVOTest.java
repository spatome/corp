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
import com.hengpeng.api.vo.BonusDetailRVO;
import com.hengpeng.api.vo.BonusDetailSVO;
import com.hengpeng.api.vo.BonusQueryRVO;
import com.hengpeng.api.vo.BonusQuerySVO;
import com.hengpeng.api.vo.IssueQueryRVO;
import com.hengpeng.api.vo.IssueQuerySVO;
import com.hengpeng.api.vo.SsqBuyRVO;
import com.hengpeng.api.vo.SsqBuySVO;

/** 
 * @ClassName: BonusDetailVOTest 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月2日 下午5:41:58  
 */
public class BonusDetailVOTest {

	public static void main(String[] args) throws Exception {
		BonusDetailVOTest ssqBuyVOTest = new BonusDetailVOTest();
		
		System.out.println(ssqBuyVOTest.getBonusDetailRVOToStr());
		System.out.println(ssqBuyVOTest.getBonusDetailSVOToStr());
	}
	
	public String getBonusDetailRVOToStr() throws Exception {
		BonusDetailRVO bonusDetailRVO = new BonusDetailRVO();

		bonusDetailRVO.setEnterpriseNo("000001");
		bonusDetailRVO.setGameType("SSQ");
		bonusDetailRVO.setIssueNo("20170101");
		bonusDetailRVO.setPageNum("1");
		bonusDetailRVO.setPageSize("1000");

		ObjectMapper om = new ObjectMapper();
		String result = om.writeValueAsString(bonusDetailRVO);

		return result;
	}
	
	public String getBonusDetailSVOToStr() throws Exception {
		BonusDetailSVO bonusDetailSVO = new BonusDetailSVO();

		bonusDetailSVO.setBonusCode("01,02,03,04,05,06#01");
		
		BonusDetailSVO.BonusInfo bonusInfo = new BonusDetailSVO.BonusInfo();
		bonusInfo.setOrderNo("");
		bonusInfo.setPlayType("101");
		bonusInfo.setIsBombBonus("NO");
		bonusInfo.setBonusLevel("6");
		bonusInfo.setBonusLevelAmount("5.00");
		bonusInfo.setAmount("10.00");
		bonusDetailSVO.getList().add(bonusInfo);
		
		ObjectMapper om = new ObjectMapper();
		String result = om.writeValueAsString(bonusDetailSVO);

		return result;
	}
}
