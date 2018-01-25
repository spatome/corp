package com.hengpeng.api.util;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.hengpeng.api.domain.lottery.SsqCode;
import com.hengpeng.api.exception.SException;

/**
 * <pre>
 * 玩法信息校验
 * </pre>
 * 
 * @author shenshaopeng
 * @version 1.0, 2017-7-29
 */
public class GameVerifyUtil {

	public static SException ssqCodeVerify(final String codeString, String playType, final String times, final String amount) {
		try {
			String[] codes = codeString.split(";");
			if("101".equals(playType)){
				if(codes.length>5) return new SException("9999", "单式不能超过5注");
			}else if("102".equals(playType)){
				if(codes.length>1) return new SException("9999", "复式不能超过1注");
			}else{
				return new SException("9999", "不支持的投注方式");
			}

			if(StringUtils.isNotBlank(times) && Integer.valueOf(times)>99){
				return new SException("9999", "倍数最大99");
			}
			
			if(new BigDecimal(amount).compareTo(new BigDecimal("20000.00"))==1){
				return new SException("9999", "不能超过2万元");
			}

			int notesCount = 0;		//总投注数量
			for (String code : codes) {
				SsqCode ssqCode = new SsqCode(playType, code);
				notesCount += ssqCode.calcNotesCount();
			}

			BigDecimal currentAmount = new BigDecimal(notesCount).multiply(new BigDecimal("2.00")).multiply(new BigDecimal(StringUtils.isBlank(times)?"1":times));
			if(currentAmount.compareTo(new BigDecimal(amount))!=0){
				return new SException("9999", "金额不符合，实际金额："+currentAmount.toString());
			}

			return new SException("0000", "校验通过"); 
		} catch (Exception e) {
			return new SException("9999", e.getMessage());
		}
	}
	
/*	
//	public final static String SSQ_CODE_BASE_REGEX = "^([0-9][0-9][,${0,1}]{0,1})+([0-9][0-9]){1}(#)([0-9][0-9][,]{0,1})*([0-9][0-9]){1}$";
	
	*//**
	 * @Description: 双色球单式投注regex
	 *//*
	public final static String SSQ_CODE_BASE_REGEX_101 = "^([0-9][0-9][,]){5}[0-9][0-9]#[0-9][0-9]$";
	*//**
	 * @Description: 双色球复式投注regex
	 *//*
	public final static String SSQ_CODE_BASE_REGEX_102 = "^([0-9][0-9][,]){5,19}[0-9][0-9]#([0-9][0-9][,]){0,15}[0-9][0-9]$";
	
	*//**
	 * @Description: 双色球胆拖投注regex
	 *//*
	public final static String SSQ_CODE_BASE_REGEX_103 = "^([0-9][0-9][,]){0,4}[0-9][0-9][$]([0-9][0-9][,]){0,9}[0-9][0-9][#]([0-9][0-9][,]){0,15}[0-9][0-9]$";


	*//**
	 * 号码段内号码位分割符 {@value}
	 * 
	 * @value ,
	 *//*
	public final static String CODE_COMPART_STRING = ",";

	*//**
	 * 号码段分割符 {@value}
	 * 
	 * @value #
	 *//*
	public final static String PART_COMPART_STRING = "#";

	*//**
	 * 号码段每注的分割符 {@value}
	 * 
	 * @value ;
	 *//*
	public final static String SHARE_COMPART_STRING = ";";

	
	public static SException ssqCodeVerify(final String codeString, final String times, final String amount) {
		try {
			String[] codes = codeString.split(";");
			if(codes.length>5){
				return new SException("9999", "(不能超过5注)");
			}
			
			if(!GameVerifyUtil.isNot101NumOk(codes)){
				return new SException("9999", "(非单式不能超过1注)");
			}

			for (String f : codes) {
				//判断每注号码类型
				String playType = GameVerifyUtil.getPlayType(f);
				if(StringUtils.isBlank(playType)){
					return new SException("9999","(双色球号码格式不正确)");
				}

				GameVerifyUtil.SsqCode ssqCode = new GameVerifyUtil.SsqCode(playType, f);

			}

			return new SException("0000", "校验通过"); 
		} catch (Exception e) {
			return new SException("9999", e.getMessage());
		}
	}
	
	*//** 
	 * @Description: 一票中最多有1注复式或者胆拖
	 * @param codes
	 * @return
	 * @return: boolean
	 *//*
	public static boolean isNot101NumOk(String[] codes) throws Exception {
		try {
			int notSingle = 0;
			for (String s : codes) {
				if(!s.matches(SSQ_CODE_BASE_REGEX_101)){
					notSingle++;
				}
			}

			return notSingle<=1;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static String getPlayType(String code){
		if(code.matches(SSQ_CODE_BASE_REGEX_101)){
			return "101";
		}else if(code.matches(SSQ_CODE_BASE_REGEX_102)){
			return "102";
		}else if(code.matches(SSQ_CODE_BASE_REGEX_103)){
			return "103";
		}else {
			return "";
		}
	}

	public static SException ssqCodeVerify(final String codeString) {
		SException result = new SException("9999", "未知异常");

		try {

			
			 * 1、将号码通过分割符拆开，得到注数，校验注数上下限
			 
			int partNum = 0;
			ArrayList<String> partArray = compartString(codeString, SHARE_COMPART_STRING);
			partNum = partArray.size();
			if (partNum < 1) {
				return new SException(MessageConstant.TRANSACTION_RESPONSE_CODE_2044, "投注号码不能为空");
			}
			if (partNum > 5) {
				return new SException(MessageConstant.TRANSACTION_RESPONSE_CODE_2044, "投注号码注数超限制");
			}

			// 基本号码部分
			ArrayList<String> baseCodeSet = new ArrayList<String>();

			
			 * 2、校验每注号码规则
			 
			for (int i = 0; i < partNum; i++) {
				String partString = (partArray.get(i)).toString();
				if (partString.indexOf(PART_COMPART_STRING) == -1) {
					return new SException(MessageConstant.TRANSACTION_RESPONSE_CODE_2044, "投注号码格式，缺少#字符");
				}
				baseCodeSet = compartString(partString, PART_COMPART_STRING);
				int baseCodeCount = baseCodeVerify(baseCodeSet.get(0), CODE_COMPART_STRING);

				if (baseCodeCount < 6) {
					return new SException(MessageConstant.TRANSACTION_RESPONSE_CODE_2044, "红球号码个数不能低于6个");
				}

				if (baseCodeCount > 20) {
					return new SException(MessageConstant.TRANSACTION_RESPONSE_CODE_2044, "红球号码个数不能超过20个");
				}

				if (getSameElement(compartString(baseCodeSet.get(0), CODE_COMPART_STRING)) != 0) {
					return new SException(MessageConstant.TRANSACTION_RESPONSE_CODE_2044, "红球号码出现重复");
				}

				int partCodeCount = baseCodeVerify(baseCodeSet.get(1), CODE_COMPART_STRING);

				if (partCodeCount < 1) {
					return new SException(MessageConstant.TRANSACTION_RESPONSE_CODE_2044, "蓝球号码个数不能低于1个");
				}

				if (partCodeCount > 16) {
					return new SException(MessageConstant.TRANSACTION_RESPONSE_CODE_2044, "蓝球号码个数不能超过16个");
				}

				if (getSameElement(compartString(baseCodeSet.get(1), CODE_COMPART_STRING)) != 0) {
					return new SException(MessageConstant.TRANSACTION_RESPONSE_CODE_2044, "蓝球号码出现重复");
				}

			}
			return new SException(MessageConstant.TRANSACTION_RESPONSE_CODE_SUCCESS, "号码格式校验通过");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	*//**
	 * <pre>
	 * 分割字符串
	 * </pre>
	 * 
	 * @param str
	 * @param compart
	 * @return
	 *//*
	public static ArrayList<String> compartString(String str, String compart) {
		String[] strs = str.split(compart, -1);
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() > 1) {
				list.add(strs[i]);
			}
		}
		return list;
	}

	*//**
	 * <pre>
	 * 基本号码个数
	 * </pre>
	 * 
	 * @param str
	 * @param compart
	 * @return
	 *//*
	public static int baseCodeVerify(String str, String compart) {
		String[] strs = str.split(compart, -1);
		return strs.length;
	}

	*//**
	 * <pre>
	 * 用来判断某一个ArrayList中是否包含相同的元素 并找出是哪个相同
	 * </pre>
	 * 
	 * @param elementSet
	 * @return
	 *//*
	public static int getSameElement(List<String> elementSet) {
		TreeSet<String> set = new TreeSet<String>();
		int elementNum = elementSet.size();
		for (int i = 0; i < elementNum; i++) {
			if (!set.add(elementSet.get(i))) {
				return i + 1;
			}
		}
		return 0;
	}

	public static class SsqCode {
		private String playType;
		private String code;
		private List<String> redCodeList;
		private List<String> redCodeAppendList;
		private List<String> blueCodeList;

		public List<String> getRedCodeList() {
			if (redCodeList == null) {
				redCodeList = new ArrayList<String>();
			}
			return redCodeList;
		}

		public void setRedCodeList(List<String> redCodeList) {
			this.redCodeList = redCodeList;
		}

		public List<String> getRedCodeAppendList() {
			if (redCodeAppendList == null) {
				redCodeAppendList = new ArrayList<String>();
			}
			return redCodeAppendList;
		}

		public void setRedCodeAppendList(List<String> redCodeAppendList) {
			this.redCodeAppendList = redCodeAppendList;
		}

		public List<String> getBlueCodeList() {
			if (blueCodeList == null) {
				blueCodeList = new ArrayList<String>();
			}
			return blueCodeList;
		}

		public void setBlueCodeList(List<String> blueCodeList) {
			this.blueCodeList = blueCodeList;
		}

		public SsqCode(String playType, String codeString){
			this.playType = playType;
			this.code = codeString;

			try {
				String[] codeStrings = codeString.split("#");
				this.setBlueCodeList(Arrays.asList(codeStrings[1].split(",")));

				Set<String> echoSet = new TreeSet<String>();
				for (String f : this.getBlueCodeList()) {
					if(!(Integer.valueOf(f)>=1 && Integer.valueOf(f)<=16)){
						throw new RuntimeException("蓝球范围[1,16]");
					}
					echoSet.add(f);
				}
				if(echoSet.size() < this.getBlueCodeList().size()){
					throw new RuntimeException("蓝球有重复");
				}

				String[] redCodes = codeStrings[0].split("$");
				this.setRedCodeList(Arrays.asList(redCodes[0].split(",")));
				if(redCodes.length>1){
					this.setRedCodeAppendList(Arrays.asList(redCodes[1].split(",")));
				}

				echoSet.clear();
				for (String f : this.getRedCodeList()) {
					if(!(Integer.valueOf(f)>=1 && Integer.valueOf(f)<=33)){
						throw new RuntimeException("红球范围[1,33]");
					}
					echoSet.add(f);
				}
				if(echoSet.size() < this.getRedCodeList().size()){
					throw new RuntimeException("红球有重复");
				}

				for (String f : this.getRedCodeAppendList()) {
					if(!(Integer.valueOf(f)>=1 && Integer.valueOf(f)<=33)){
						throw new RuntimeException("胆拖红球范围[1,33]");
					}
					echoSet.add(f);
				}
				if(echoSet.size() < this.getRedCodeList().size()+this.getRedCodeAppendList().size()){
					throw new RuntimeException("胆拖红球有重复");
				}
			} catch (RuntimeException e) {
				throw e;
			} catch (Exception e) {
				throw new RuntimeException("双色球号码格式不正确");
			}
		}
		
		public BigDecimal getAmount(){
			if("101".equals(playType)){
				return new BigDecimal("2.0");
			}else if("102".equals(playType)){
				return new BigDecimal("-1.00");
			}else if("103".equals(playType)){
				return new BigDecimal("-1.00");
			}else{
				return new BigDecimal("-1.00");
			}
		}

		public String getPlayType() {
			return playType;
		}

		public void setPlayType(String playType) {
			this.playType = playType;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		@Override
		public String toString() {
			return "SsqCode [playType=" + playType + ", code=" + code + ", redCodeList=" + redCodeList
					+ ", redCodeAppendList=" + redCodeAppendList + ", blueCodeList=" + blueCodeList + "]";
		}
	}

	public static void main(String[] args) {
		// System.out.println(ssqCodeVerify("02,14,16,23,27#16;01,03,07,23,28,31#13;02,08,11,15,16,23#10;01,09,10,13,21,32#09;06,12,17,26,31,33#06"));
		// "01,02,14,16,23,27#16;01,03,07,23,28,31#13;02,08,11,15,16,23#10;01,09,10,13,21,32#09;06,12,17,26,31,33#06");
		// System.out
		// .println(ssqCodeVerify("02,14,16,23,27,01,02,14,16,23,27#01,02,14,16,23,27,01,02,14,16,23,27,01,02,14,16,23,27,01;"));
		String codeString="02,14,16,23,27#16;01,03,07,23,28,31#13;02,08,11,15,16,23#10;01,09,10,13,21,32#09;06,12,17,26,31,33#06";

		SException se = GameVerifyUtil.ssqCodeVerify(codeString, "1", "2.00");

		System.out.println(se.getCode()+"  "+se.getMessage());
	}


	public static int getLotNum(String codes, Integer playtype) throws Exception {
		int lotNum = 0;
		int price = 0;
		// 混投计算投注号码
		if (playtype.equals(MSConstants.mix_playtype))
		{
			Map<Integer, List<AnteCodeData>> map = Func.getPlaytypeAnteCodes(codes);
			for (Map.Entry<Integer, List<AnteCodeData>> entry : map.entrySet())
			{
				for (AnteCodeData ac : entry.getValue())
				{
					List<AnteCodeData> list = new ArrayList<AnteCodeData>();
					list.add(ac);
					lotGame.checkAnteCode(list, entry.getKey());
					int num = lotGame.getDrawings(list, entry.getKey());
					lotNum += num;
					int money = num * Func.calcPrice(game, entry.getKey());
					if (money > 2000000)
					{
						throw new GameException("单注金额不能超过2万元");
					}
					price += money;
				}
			}
		}
		// 单投注方式校验和计算投注号码
		else
		{
			List<AnteCodeData> lotData = Func.getAnteCodeDatas(codes);
			for (AnteCodeData ad : lotData)
			{
				List<AnteCodeData> data = new ArrayList<AnteCodeData>();
				data.add(ad);
				lotGame.checkAnteCode(data, playtype);
				lotNum += lotGame.getDrawings(data, playtype);
				int money = lotGame.getDrawings(data, playtype) * Func.calcPrice(game, playtype);
				if (money > 2000000)
				{
					throw new GameException("单注金额不能超过2万元");
				}
				price += money;
			}
		}
		lottery.setLotNum(lotNum);
		lottery.setMoney(price);
		return lottery;
	}*/
}