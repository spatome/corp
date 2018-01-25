/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: App.java 
 * @Prject: api-service
 * @Package: test.hengpeng.api.service 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月21日 下午4:05:36 
 * @version: V1.0   
 */
package test.hengpeng.api.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import com.hengpeng.api.enumtype.CompanyStatus;

/** 
 * @ClassName: App 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月21日 下午4:05:36  
 */
public class App {
	public static void main(String[] args) {
		App app = new App();
		app.setToStr();
	}

	public void setToStr(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("100", "名字太长");
		map.put("101", "名字太短");
		map.put("102", "名字乱码");
		
		String str = StringUtils.join(map.keySet().toArray(), ",");
		System.out.println(str);
		
		String str1 = StringUtils.join(map.values().toArray(), ",");
		System.out.println(str1);
	}
}
