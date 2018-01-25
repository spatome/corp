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
import com.hengpeng.api.vo.BonusQueryRVO;
import com.hengpeng.api.vo.BonusQuerySVO;
import com.hengpeng.api.vo.IssueQueryRVO;
import com.hengpeng.api.vo.IssueQuerySVO;
import com.hengpeng.api.vo.SsqBuyRVO;
import com.hengpeng.api.vo.SsqBuySVO;

/** 
 * @ClassName: IssueQueryVOTest 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月2日 下午5:41:58  
 */
public class BonusQueryVOTest {

	public static void main(String[] args) throws Exception {
		BonusQueryVOTest ssqBuyVOTest = new BonusQueryVOTest();
		
		System.out.println(ssqBuyVOTest.getBonusQueryRVOToStr());
		System.out.println(ssqBuyVOTest.getBonusQuerySVOToStr());
	}
	
	public String getBonusQueryRVOToStr() throws Exception {
		BonusQueryRVO bonusQueryRVO = new BonusQueryRVO();

		bonusQueryRVO.setEnterpriseNo("000001");
		bonusQueryRVO.setGameType("SSQ");
		bonusQueryRVO.setIssueNo("2017001");

		ObjectMapper om = new ObjectMapper();
		String result = om.writeValueAsString(bonusQueryRVO);

		return result;
	}
	
	public String getBonusQuerySVOToStr() throws Exception {
		BonusQuerySVO bonusQuerySVO = new BonusQuerySVO();

		bonusQuerySVO.setBonusCode("01,02,03,04,05,06#01");
		bonusQuerySVO.setBonusCount("2");
		bonusQuerySVO.setBonusAmount("100");
		
		ObjectMapper om = new ObjectMapper();
		String result = om.writeValueAsString(bonusQuerySVO);

		return result;
	}
}
