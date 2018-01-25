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
public class IssueQueryVOTest {

	public static void main(String[] args) throws Exception {
		IssueQueryVOTest ssqBuyVOTest = new IssueQueryVOTest();
		
		System.out.println(ssqBuyVOTest.getIssueQueryRVoToStr());
		System.out.println(ssqBuyVOTest.getIssueQuerySVOToStr());
	}
	
	public String getIssueQueryRVoToStr() throws Exception {
		IssueQueryRVO issueQueryRVo = new IssueQueryRVO();
		issueQueryRVo.setGameType("SSQ");
		issueQueryRVo.setIssueNo("2017001");

		ObjectMapper om = new ObjectMapper();
		String result = om.writeValueAsString(issueQueryRVo);

		return result;
	}
	
	public String getIssueQuerySVOToStr() throws Exception {
		IssueQuerySVO issueQuerySVO = new IssueQuerySVO();
		issueQuerySVO.setIssueNo("2017001");
		issueQuerySVO.setGameType("SSQ");
		issueQuerySVO.setIssueType("BONUS");
		issueQuerySVO.setBonusCode("01,02,03,04,05,06#01");
		issueQuerySVO.setOfficialStartTime("2017-01-01 08:30:00");
		issueQuerySVO.setOfficialStopTime("2017-01-02 08:30:00");
		issueQuerySVO.setStartTime("2017-01-01 08:00:00");
		issueQuerySVO.setStopTime("2017-01-02 08:00:00");
		
		ObjectMapper om = new ObjectMapper();
		String result = om.writeValueAsString(issueQuerySVO);

		return result;
	}
}
