/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: SsqCode.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.domain.lottery 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月16日 下午2:50:57 
 * @version: V1.0   
 */
package com.hengpeng.api.domain.lottery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: SsqCode
 * @Description: 双色球
 * @author: zhangwei
 * @date: 2017年8月16日 下午2:50:57
 */
public class SsqCode {

	/**
	 * @Description: 双色球单式投注regex
	 */
	public final static String SSQ_CODE_BASE_REGEX_101 = "^([0-9][0-9][,]){5}[0-9][0-9]#[0-9][0-9]$";
	/**
	 * @Description: 双色球复式投注regex
	 */
	public final static String SSQ_CODE_BASE_REGEX_102 = "^([0-9][0-9][,]){5,19}[0-9][0-9]#([0-9][0-9][,]){0,15}[0-9][0-9]$";
	/**
	 * @Description: 双色球胆拖投注regex
	 */
	public final static String SSQ_CODE_BASE_REGEX_103 = "^([0-9][0-9][,]){0,4}[0-9][0-9][$]([0-9][0-9][,]){0,9}[0-9][0-9][#]([0-9][0-9][,]){0,15}[0-9][0-9]$";

	// 号码
	private String code;
	// 类型:单式(101) 复式(102) 胆拖(103)
	private String playType;

	// 红球
	private List<String> redCodeList;
	// 红球胆拖
	private List<String> redCodeAppendList;
	// 篮球
	private List<String> blueCodeList;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPlayType() {
		return playType;
	}

	public void setPlayType(String playType) {
		this.playType = playType;
	}

	public List<String> getRedCodeList() {
		if(redCodeList==null){
			redCodeList = new ArrayList<String>();
		}
		return redCodeList;
	}

	public void setRedCodeList(List<String> redCodeList) {
		this.redCodeList = redCodeList;
	}

	public List<String> getRedCodeAppendList() {
		if(redCodeAppendList==null){
			redCodeAppendList = new ArrayList<String>();
		}
		return redCodeAppendList;
	}

	public void setRedCodeAppendList(List<String> redCodeAppendList) {
		this.redCodeAppendList = redCodeAppendList;
	}

	public List<String> getBlueCodeList() {
		if(blueCodeList==null){
			blueCodeList = new ArrayList<String>();
		}
		return blueCodeList;
	}

	public void setBlueCodeList(List<String> blueCodeList) {
		this.blueCodeList = blueCodeList;
	}

	/** 
	 * @Description: 根据号码判断playType
	 * @param code
	 * @return
	 * @return: String
	 */
	private String calcPlayType (String code){
		try {
			if(code.matches(SSQ_CODE_BASE_REGEX_101)){
				return "101";
			}else if(code.matches(SSQ_CODE_BASE_REGEX_102)){
				return "102";
			}else if(code.matches(SSQ_CODE_BASE_REGEX_103)){
				return "103";
			}else {
				return null;
			}
		} catch (Exception e) {
			throw new RuntimeException("计算双色球playType异常,号码:"+code);
		}
	}
	
	public SsqCode(String playType, String code){
		this.playType = playType;
		this.code = code;

		try {
			if(StringUtils.isBlank(code)){
				throw new RuntimeException("双色球号码空");
			}

			if(!this.playType.equals(this.calcPlayType(code))){
				throw new RuntimeException("投注类型和投注号码的类型不符");
			};

			//拆分红蓝球
			String[] codes = code.split("#");
			this.blueCodeList = Arrays.asList(codes[1].split(","));
			//拆分红球
			String[] redCodes = codes[0].split("$");
			this.redCodeList = Arrays.asList(redCodes[0].split(","));
			if(redCodes.length>1){
				this.redCodeAppendList = Arrays.asList(redCodes[1].split(","));
			}

			this.verifyEcho();
			this.verifyNumber();
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("双色球校验初始化错误:"+e.getMessage());
		}
	}

	/** 
	 * @Description: 计算注数量
	 * @return
	 * @return: int
	 */
	public int calcNotesCount(){
		int i=0;

		if("101".equals(this.playType)){
			i =1;
		}else if("102".equals(this.playType)){
			int n = Integer.valueOf(this.getRedCodeList().size());
			i = n*(n-1)*(n-2)*(n-3)*(n-4)*(n-5)/(6*5*4*3*2*1);
			i = i*Integer.valueOf(this.getBlueCodeList().size());
		}else{
			throw new RuntimeException("目前仅支持单复式");
		}

		return i;
	}
	
	/** 
	 * @Description: 校验重复号码
	 * @return: void
	 */
	private void verifyEcho(){
		Set<String> echoSet = new TreeSet<String>();
		for (String f : this.blueCodeList) {
			echoSet.add(f);
		}
		if(echoSet.size() < this.blueCodeList.size()){
			throw new RuntimeException("双色球蓝球有重复");
		}

		echoSet.clear();
		for (String f : this.redCodeList) {
			echoSet.add(f);
		}
		if(echoSet.size() < this.redCodeList.size()){
			throw new RuntimeException("双色球红球有重复");
		}
		if(this.redCodeAppendList!=null){
			for (String f : this.redCodeAppendList) {
				echoSet.add(f);
			}
			if(echoSet.size() < this.redCodeList.size() + this.redCodeAppendList.size()){
				throw new RuntimeException("双色球胆拖有重复");
			}
		}
	}

	/** 
	 * @Description: 校验球是否在[01,16]和[01,33]
	 * @return: void
	 */
	private void verifyNumber(){
		for (String f : blueCodeList) {
			if(Integer.valueOf(f)<1 || Integer.valueOf(f)>16){
				throw new RuntimeException("双色球蓝球范围[01,16]");
			}
		}

		for (String f : redCodeList) {
			if(Integer.valueOf(f)<1 || Integer.valueOf(f)>33){
				throw new RuntimeException("双色球红球范围[01,33]");
			}
		}

		if(this.redCodeAppendList!=null){
			for (String f : redCodeAppendList) {
				if(Integer.valueOf(f)<1 || Integer.valueOf(f)>33){
					throw new RuntimeException("双色球胆拖范围[01,33]");
				}
			}			
		}
	}
	
	@Override
	public String toString() {
		return "SsqCode [code=" + code + ", playType=" + playType + ", redCodeList=" + redCodeList
				+ ", redCodeAppendList=" + redCodeAppendList + ", blueCodeList=" + blueCodeList + "]";
	}

	public static void main(String[] args) throws Exception {
		String code = "01,02,03,04,05,06,07#01,02";

		SsqCode ssqCode = new SsqCode("102", code);
		
		System.out.println( ssqCode.calcNotesCount() );
	}
}
