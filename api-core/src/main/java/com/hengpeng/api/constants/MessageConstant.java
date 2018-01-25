/**
 * <pre>
 * Title: 		MessageConstant.java
 * Project: 	api-core
 * Type:		com.hengpeng.api.constants.MessageConstant
 * Author:		shenshaopeng
 * Create:	 	2017-7-29 上午11:38:54
 * Copyright: 	Copyright (c) 2017
 * Company:
 * <pre>
 */
package com.hengpeng.api.constants;

import java.io.Serializable;

/**
 * <pre>
 * 接入交易消息常量定义
 * </pre>
 * @author shenshaopeng
 * @version 1.0, 2017-7-29
 */
public class MessageConstant implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8374189547361489347L;

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:消息格式错误。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_0010 = "0010";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:不支持的协议版本，比如设定了message的version属性为0.1。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_0011 = "0011";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:messageID格式错误。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_0012 = "0012";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:timestamp时间戳格式错误。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_0014 = "0014";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:消息摘要不匹配
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_0015 = "0015";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:不支持该交易类型
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_0016 = "0016";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:MessageId重复
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_0017 = "0017";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:调用委托投注接口的IP地址不是绑定的投注IP地址
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_0097 = "0097";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:单个请求超出最大并发数
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_0098 = "0098";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:单个请求与上次时间间隔不能小于最小时间间隔
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_0099 = "0099";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:投注玩法未开启。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_1027 = "1027";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:玩法不存在
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_1008 = "1008";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:该玩法未开通权限
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_1026 = "1026";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:奖期不存在
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_1009 = "1009";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:处理投注过程中出现票投注失败
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_1010 = "1010";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:奖期非投注状态
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_1011 = "1011";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:请求消息中指定的玩法不存在
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_1012 = "1012";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:奖期未截止
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_1013 = "1013";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:奖期未完成期结
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_1014 = "1014";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:奖期未完成兑奖
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_1015 = "1015";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:代理不支持某个特定玩法（恒朋无纸化彩票系统可以管理投注代理商支持的玩法）
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_1016 = "1016";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:请求消息中指定的某玩法的奖期不存在
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_1017 = "1017";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:代理商无此奖期销售统计数据。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_1018 = "1018";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:奖期已经截止。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_1019 = "1019";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:用户证件号码格式错误
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2001 = "2001";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:用户手机号码错误
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2002 = "2002";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:必须填写用户证件号码
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2003 = "2003";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:必须填写用户手机号码
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2004 = "2004";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:投注号码个数超出允许范围
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2010 = "2010";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:单个号码值超出允许范围（比如双色球投注号码中包含了78）
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2011 = "2011";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:禁止倍投
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2012 = "2012";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:禁止多期投注
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2013 = "2013";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:禁止胆拖投注
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2014 = "2014";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:禁止复式投注
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2015 = "2015";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:禁止组选投注
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2016 = "2016";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:禁止和值投注
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2017 = "2017";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:单票投注金额超出上限
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2018 = "2018";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:倍投的倍数超出范围
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2030 = "2030";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:多期投注的期数超出允许范围
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2031 = "2031";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:单个号码购买注数超出允许范围
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2032 = "2032";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:票金额不相符（比如ticket的money属性值与根据item计算出来的资金不符合）
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2040 = "2040";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:超出返奖截止时间,禁止返奖
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2041 = "2041";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:票流水号格式错误
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2042 = "2042";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:不支持的投注方式
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2043 = "2043";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:投注号码格式错误
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2044 = "2044";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:投注代理商的交易请求过于密集（恒朋无纸化彩票系统可能对投注代理商的交易请求发送频率进行限制）
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2045 = "2045";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:单个投注请求中包含的投注票数超出上限
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2046 = "2046";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:单个票查询请求中包含的投注票数超出上限
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2047 = "2047";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:重复发送的投注票（该投注票已经发送到恒朋无纸化彩票系统了）
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2048 = "2048";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:不存在该票号
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2049 = "2049";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:倍投数必须至少大于等于1
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2050 = "2050";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:投注失败
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2051 = "2051";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:投注中
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2052 = "2052";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:不存在的POS机编号
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_2099 = "2099";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:非归集帐户
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3000 = "3000";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:投注代理商已经被冻结
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3001 = "3001";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:投注代理商已经被关闭
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3002 = "3002";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:投注代理商不存在，比如指定的messengerID非法
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3003 = "3003";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:投注代理商已经被暂停
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3004 = "3004";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:投注代理商未开启
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3005 = "3005";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:投注代理商销售金额已经超出上限
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3010 = "3010";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:投注代理商配置信息错误（管理资金账户代理商调用非管理资金账户投注接口）。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3011 = "3011";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:彩民帐户不存在。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3012 = "3012";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:彩民帐户余额不足。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3013 = "3013";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:当前彩民帐户不存在的时候返回代码。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3014 = "3014";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:代理商帐户余额不足。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3015 = "3015";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:赠送彩金编号重复。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3016 = "3016";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:单次委托帐户资金查询请求超出上限。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3017 = "3017";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:赠送彩金编号不存在。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3018 = "3018";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:保证金查询中消息头中的代理同编号与要查询的代理商编号不一致
	 * </p>
	 */

	public final static String TRANSACTION_RESPONSE_CODE_3019 = "3019";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:发起人已存在。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3100 = "3100";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:发起人资格无法发起资格或发起人不存在。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3101 = "3101";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:代理商联合购买方案编号重复。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3201 = "3201";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:方案发起人无权限。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3202 = "3202";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:佣金比例超限。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3203 = "3203";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:佣金比例设置错误。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3204 = "3204";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:投注明细统计结果与总金额或总票数不符。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3205 = "3205";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:联合购买总票数超限。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3206 = "3206";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:代理商无联合购买权限。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3207 = "3207";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:代理联合购买方案不存在。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3208 = "3208";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:不支持的证件类型。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3220 = "3220";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:缺少用户登录名。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3221 = "3221";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:缺少用户登录密码。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3222 = "3222";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:帐户已经存在。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3223 = "3223";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:缺少证件类型。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3224 = "3224";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:邮件地址格式错误。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_3225 = "3225";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:未找到支付提供商。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_9001 = "9001";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:未找到交易类型。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_9002 = "9002";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:提交参数不能为空。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_9003 = "9003";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:不支持的字符编码。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_9004 = "9004";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:支付网关返回错误。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_9005 = "9005";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:数字签名错误。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_9006 = "9006";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:交易金额不符。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_9007 = "9007";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:交易重复处理。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_9008 = "9008";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:交易不存在。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_9009 = "9009";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:电话投注卡不存在或密码错误。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_9010 = "9010";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:电话投注卡卡面余额不相符。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_9011 = "9011";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:电话投注卡状态处于非销售状态。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_9012 = "9012";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:电话投注卡已过期。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_9013 = "9013";

	/**
	 * 代理商接入系统接口协议状态码：系统未知异常 {@value}
	 * <p>
	 * 说明:9999
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_9999 = "9999";

	/**
	 * 代理商接入系统接口协议状态码：对不起，因网络繁忙，本次操作未成功！{@value}
	 * <p>
	 * 说明:9997
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_9997 = "9997";

	/**
	 * 代理商接入系统接口协议状态码 {@value}
	 * <p>
	 * 说明:成功，系统处理正常。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_CODE_SUCCESS = "0000";

	/**
	 * 代理商接入系统接口协议状态码说明 {@value}
	 * <p>
	 * 交易类型不存在。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_MESSAGE_599 = "交易类型不存在。";

	/**
	 * 代理商接入系统接口协议状态码说明：系统未知异常 {@value}
	 * <p>
	 * 说明:系统未知异常
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_MESSAGE_9999 = "系统未知异常";

	/**
	 * 代理商接入系统接口协议版本响应码说明 {@value}
	 * <p>
	 * 说明:成功，系统处理正常。
	 * </p>
	 */
	public final static String TRANSACTION_RESPONSE_MESSAGE_SUCCESS = "成功，系统处理正常。";

	/**
	 * 交易类型：彩民帐户资金查询请求 {@value}
	 * <p>
	 * 116
	 * </p>
	 */
	public final static int TRANSTYPE_ACCOUNTQUERY_REQUEST = 116;

	/**
	 * 交易类型：彩民帐户资金查询响应 {@value}
	 * <p>
	 * 516
	 * </p>
	 */
	public final static int TRANSTYPE_ACCOUNTQUERY_RESPONSE = 516;

	/**
	 * 交易类型：销量查询请求 {@value}
	 * <p>
	 * 107
	 * </p>
	 */
	public final static int TRANSTYPE_BALANCEQUERY_REQUEST = 107;

	/**
	 * 交易类型：销量查询响应 {@value}
	 * <p>
	 * 507
	 * </p>
	 */
	public final static int TRANSTYPE_BALANCEQUERY_RESPONSE = 507;

	/**
	 * 交易类型：奖期通知请求 {@value}
	 * <p>
	 * 107
	 * </p>
	 */
	public final static int TRANSTYPE_BONUSNOTIFY_REQUEST = 108;

	/**
	 * 交易类型：奖期通知响应 {@value}
	 * <p>
	 * 507
	 * </p>
	 */
	public final static int TRANSTYPE_BONUSNOTIFY_RESPONSE = 508;

	/**
	 * 交易类型：返奖查询请求 {@value}
	 * <p>
	 * 106
	 * </p>
	 */
	public final static int TRANSTYPE_BONUSQUERY_REQUEST = 106;

	/**
	 * 交易类型：返奖查询响应 {@value}
	 * <p>
	 * 506
	 * </p>
	 */
	public final static int TRANSTYPE_BONUSQUERY_RESPONSE = 506;

	/**
	 * 交易类型：电话投注卡充值请求 {@value}
	 * <p>
	 * 117
	 * </p>
	 */
	public final static int TRANSTYPE_CARDFILLREQUEST_REQUEST = 117;

	/**
	 * 交易类型：电话投注卡充值响应 {@value}
	 * <p>
	 * 517
	 * </p>
	 */
	public final static int TRANSTYPE_CARDFILLREQUEST_RESPONSE = 517;

	public static final String TRANSTYPE_COMMON_HEADER = "000";

	/**
	 * 交易类型：代理商保证金查询请求 {@value}
	 * <p>
	 * 131
	 * </p>
	 */
	public final static int TRANSTYPE_DEPOSITQUERY_REQUEST = 132;

	/**
	 * 交易类型：代理商保证金查询响应 {@value}
	 * <p>
	 * 531
	 * </p>
	 */
	public final static int TRANSTYPE_DEPOSITQUERY_RESPONSE = 532;

	/**
	 * 交易类型：提款通知请求 {@value}
	 * <p>
	 * 107
	 * </p>
	 */
	public final static int TRANSTYPE_DRAWINGNOTIFY_REQUEST = 112;

	/**
	 * 交易类型：提款通知响应 {@value}
	 * <p>
	 * 507
	 * </p>
	 */
	public final static int TRANSTYPE_DRAWINGNOTIFY_RESPONSE = 512;

	/**
	 * 交易类型：提款查询请求 {@value}
	 * <p>
	 * 107
	 * </p>
	 */
	public final static int TRANSTYPE_DRAWINGQUERY_REQUEST = 113;

	/**
	 * 交易类型：提款查询响应 {@value}
	 * <p>
	 * 507
	 * </p>
	 */
	public final static int TRANSTYPE_DRAWINGQUERY_RESPONSE = 513;

	/**
	 * 交易类型：提款请求 {@value}
	 * <p>
	 * 107
	 * </p>
	 */
	public final static int TRANSTYPE_DRAWINGREQUEST_REQUEST = 111;

	/**
	 * 交易类型：提款响应 {@value}
	 * <p>
	 * 507
	 * </p>
	 */
	public final static int TRANSTYPE_DRAWINGREQUEST_RESPONSE = 511;

	/**
	 * 交易类型：充值通知请求 {@value}
	 * <p>
	 * 107
	 * </p>
	 */
	public final static int TRANSTYPE_FILLNOTIFY_REQUEST = 109;

	/**
	 * 交易类型：充值通知响应 {@value}
	 * <p>
	 * 507
	 * </p>
	 */
	public final static int TRANSTYPE_FILLNOTIFY_RESPONSE = 509;

	/**
	 * 交易类型：充值查询请求 {@value}
	 * <p>
	 * 107
	 * </p>
	 */
	public final static int TRANSTYPE_FILLQUERY_REQUEST = 110;

	/**
	 * 交易类型：充值查询响应 {@value}
	 * <p>
	 * 507
	 * </p>
	 */
	public final static int TRANSTYPE_FILLQUERY_RESPONSE = 510;

	/**
	 * 交易类型：奖期通知请求 {@value}
	 * <p>
	 * 101
	 * </p>
	 */
	public final static int TRANSTYPE_ISSUENOTIFY_REQUEST = 101;

	/**
	 * 交易类型：奖期通知响应 {@value}
	 * <p>
	 * 501
	 * </p>
	 */
	public final static int TRANSTYPE_ISSUENOTIFY_RESPONSE = 501;

	/**
	 * 交易类型：奖期通知请求 {@value}
	 * <p>
	 * 102
	 * </p>
	 */
	public final static int TRANSTYPE_ISSUEQUERY_REQUEST = 102;

	/**
	 * 交易类型：奖期通知响应 {@value}
	 * <p>
	 * 502
	 * </p>
	 */
	public final static int TRANSTYPE_ISSUEQUERY_RESPONSE = 502;

	/**
	 * 交易类型：投注请求 {@value}
	 * <p>
	 * 103
	 * </p>
	 */
	public final static int TRANSTYPE_LOTTERYREQUEST_REQUEST = 103;

	/**
	 * 交易类型：投注响应 {@value}
	 * <p>
	 * 503
	 * </p>
	 */
	public final static int TRANSTYPE_LOTTERYREQUEST_RESPONSE = 503;

	/**
	 * 交易类型：交易类型不存在。 {@value}
	 * <p>
	 * 599
	 * </p>
	 */
	public final static int TRANSTYPE_NOTSUPPORT_RESPONSE = 599;

	/**
	 * 交易类型：赠金请求 {@value}
	 * <p>
	 * 114
	 * </p>
	 */
	public final static int TRANSTYPE_PRESENTMONEY_REQUEST = 114;

	/**
	 * 交易类型：赠金响应 {@value}
	 * <p>
	 * 514
	 * </p>
	 */
	public final static int TRANSTYPE_PRESENTMONEY_RESPONSE = 514;

	/**
	 * 交易类型：赠金查询请求 {@value}
	 * <p>
	 * 115
	 * </p>
	 */
	public final static int TRANSTYPE_PRESENTQUERY_REQUEST = 115;

	/**
	 * 交易类型：赠金查询响应 {@value}
	 * <p>
	 * 515
	 * </p>
	 */
	public final static int TRANSTYPE_PRESENTQUERY_RESPONSE = 515;

	/**
	 * 交易类型：实时投注请求 {@value}
	 * <p>
	 * 131
	 * </p>
	 */
	public final static int TRANSTYPE_REALTIMELOTTERYREQUEST_REQUEST = 133;

	/**
	 * 交易类型：实时投注响应 {@value}
	 * <p>
	 * 531
	 * </p>
	 */
	public final static int TRANSTYPE_REALTIMELOTTERYREQUEST_RESPONSE = 533;

	/**
	 * 交易类型：帐户注册请求 {@value}
	 * <p>
	 * 130
	 * </p>
	 */
	public final static int TRANSTYPE_REGISTER_REQUEST = 130;

	/**
	 * 交易类型：帐户注册响应 {@value}
	 * <p>
	 * 530
	 * </p>
	 */
	public final static int TRANSTYPE_REGISTER_RESPONSE = 530;

	/**
	 * 交易类型：风险控制查询接口请求 {@value}
	 * <p>
	 * 131
	 * </p>
	 */
	public final static int TRANSTYPE_RISKCONTROL_REQUEST = 134;

	/**
	 * 交易类型：风险控制查询接口响应 {@value}
	 * <p>
	 * 531
	 * </p>
	 */
	public final static int TRANSTYPE_RISKCONTROL_RESPONSE = 534;

	/**
	 * 交易类型：风险控制方式查询接口请求 {@value}
	 * <p>
	 * 131
	 * </p>
	 */
	public final static int TRANSTYPE_RISKCONTROLPLAYTYPE_REQUEST = 135;

	/**
	 * 交易类型：风险控制方式查询接口响应 {@value}
	 * <p>
	 * 531
	 * </p>
	 */
	public final static int TRANSTYPE_RISKCONTROLPLAYTYPE_RESPONSE = 535;

	/**
	 * 交易类型：发起人资格申请请求 {@value}
	 * <p>
	 * 118
	 * </p>
	 */
	public final static int TRANSTYPE_SPONSORAPPLY_REQUEST = 118;

	/**
	 * 交易类型：发起人资格申请响应 {@value}
	 * <p>
	 * 518
	 * </p>
	 */
	public final static int TRANSTYPE_SPONSORAPPLY_RESPONSE = 518;

	/**
	 * 交易类型：发起人资格取消请求 {@value}
	 * <p>
	 * 119
	 * </p>
	 */
	public final static int TRANSTYPE_SPONSORCANCEL_REQUEST = 119;

	/**
	 * 交易类型：发起人资格取消响应 {@value}
	 * <p>
	 * 519
	 * </p>
	 */
	public final static int TRANSTYPE_SPONSORCANCEL_RESPONSE = 519;

	/**
	 * 交易类型：发起人状态通知请求 {@value}
	 * <p>
	 * 120
	 * </p>
	 */
	public final static int TRANSTYPE_SPONSORNOTIFY_REQUEST = 120;

	/**
	 * 交易类型：发起人状态通知响应 {@value}
	 * <p>
	 * 520
	 * </p>
	 */
	public final static int TRANSTYPE_SPONSORNOTIFY_RESPONSE = 520;

	/**
	 * 交易类型：投注结果通知请求 {@value}
	 * <p>
	 * 104
	 * </p>
	 */
	public final static int TRANSTYPE_TICKETNOTIFY_REQUEST = 104;

	/**
	 * 交易类型：投注结果通知响应 {@value}
	 * <p>
	 * 504
	 * </p>
	 */
	public final static int TRANSTYPE_TICKETNOTIFY_RESPONSE = 504;

	/**
	 * 交易类型：票查询请求 {@value}
	 * <p>
	 * 105
	 * </p>
	 */
	public final static int TRANSTYPE_TICKETQUERY_REQUEST = 105;

	/**
	 * 交易类型：票查询响应 {@value}
	 * <p>
	 * 505
	 * </p>
	 */
	public final static int TRANSTYPE_TICKETQUERY_RESPONSE = 505;

	/**
	 * 交易类型：帐户更新请求 {@value}
	 * <p>
	 * 131
	 * </p>
	 */
	public final static int TRANSTYPE_USERUPDATE_REQUEST = 131;

	/**
	 * 交易类型：帐户更新响应 {@value}
	 * <p>
	 * 531
	 * </p>
	 */
	public final static int TRANSTYPE_USERUPDATE_RESPONSE = 531;

	/**
	 * 交易类型：订单投注请求 {@value}
	 * <p>
	 * 140
	 * </p>
	 */
	public final static int TRANSTYPE_ORDERREQUEST_REQUEST = 140;

	/**
	 * 交易类型：订单投注响应 {@value}
	 * <p>
	 * 540
	 * </p>
	 */
	public final static int TRANSTYPE_ORDERREQUEST_RESPONSE = 540;

	/**
	 * 交易类型：订单投注结果通知请求 {@value}
	 * <p>
	 * 141
	 * </p>
	 */
	public final static int TRANSTYPE_ORDERNOTIFY_REQUEST = 141;

	/**
	 * 交易类型：订单投注结果通知响应 {@value}
	 * <p>
	 * 541
	 * </p>
	 */
	public final static int TRANSTYPE_ORDERNOTIFY_RESPONSE = 541;

	/**
	 * 交易类型：订单投注查询请求 {@value}
	 * <p>
	 * 142
	 * </p>
	 */
	public final static int TRANSTYPE_ORDERQUERY_REQUEST = 142;

	/**
	 * 交易类型：订单投注查询响应 {@value}
	 * <p>
	 * 542
	 * </p>
	 */
	public final static int TRANSTYPE_ORDERQUERY_RESPONSE = 542;

	/**
	 * 投注订单号重复
	 */
	public final static String TRANSACTION_RESPONSE_CODE_1021 = "1021";

	/**
	 * 不存在该订单号
	 */
	public final static String TRANSACTION_RESPONSE_CODE_1022 = "1022";

}