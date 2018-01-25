/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: UserService.java 
 * @Prject: api-service
 * @Package: com.hengpeng.api.service 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月21日 下午1:30:24 
 * @version: V1.0   
 */
package com.hengpeng.api.service;

import com.hengpeng.api.exception.SException;
import com.hengpeng.api.vo.BonusDetailRVO;
import com.hengpeng.api.vo.BonusDetailSVO;
import com.hengpeng.api.vo.BonusQueryRVO;
import com.hengpeng.api.vo.BonusQuerySVO;
import com.hengpeng.api.vo.IssueQueryRVO;
import com.hengpeng.api.vo.IssueQuerySVO;

/** 
 * @ClassName: IssueService 
 * @Description: 开奖
 * @author: zhangwei
 * @date: 2017年7月24日 下午7:15:40  
 */
public interface BonusService {

	/** 
	 * @Description: 查询奖期
	 * @param issueRVo
	 * @return
	 * @throws SException
	 * @return: IssueSVo
	 */
	public IssueQuerySVO queryIssue(IssueQueryRVO issueQueryRVO) throws SException;
	
	/** 
	 * @Description: 查询中奖信息
	 * @param bonusRVo
	 * @return
	 * @throws SException
	 * @return: BonusSVo
	 */
	public BonusQuerySVO queryBonus(BonusQueryRVO bonusQueryRVO) throws SException;
	
	/** 
	 * @Description: 中奖详情
	 * @param bonusListRVo
	 * @return
	 * @throws SException
	 * @return: BonusListSVo
	 */
	public BonusDetailSVO queryBonusList(BonusDetailRVO bonusDetailRVO) throws SException;
}
