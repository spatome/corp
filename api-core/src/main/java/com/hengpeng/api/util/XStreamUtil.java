/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: XStreamUtil.java 
 * @Prject: api-dhtz
 * @Package: com.hengpeng.api.dhtz.util 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月28日 下午4:52:07 
 * @version: V1.0   
 */
package com.hengpeng.api.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/** 
 * @ClassName: XStreamUtil 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月28日 下午4:52:07  
 */
public class XStreamUtil {

	private final static XStream XM = new XStream(new DomDriver("GBK"));
	static{
		XM.aliasSystemAttribute(null, "class");
		XM.autodetectAnnotations(true);
	}
	
	public static String toXml(String xmlHeader, Object object){
		return xmlHeader + XM.toXML(object);
	};
	
	@SuppressWarnings("unchecked")
	public static <T> T toBean(String xml, Class<T> clazz){
		XStream xStream = new XStream(new DomDriver("GBK"));
		xStream.processAnnotations(clazz);
		return (T)xStream.fromXML(xml);
	}
}
