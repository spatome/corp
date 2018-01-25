package com.hengpeng.api.enumtype;

/**
 * <pre>
 * 出票类型
 * </pre>
 * 
 * @author sl
 * @version 1.0, 2017-7-14
 */
public enum OrderPrintStatus {
	FAILED("出票失败"), PRINTED("已出票"), PRINTING("出票中"), SENDED("已发送"), SENDING("发送中"), UNPRINT("未出票");

	private String text;

	OrderPrintStatus(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
