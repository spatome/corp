/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: BaseJUnit.java 
 * @Prject: api-task
 * @Package: test.hengpeng.api.task 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月9日 下午12:06:35 
 * @version: V1.0   
 */
package test.hengpeng.api.task;

import java.util.List;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * @ClassName: BaseJUnit 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月9日 下午12:06:35  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:META-INF/spring/applicationContext.xml" })
public class BaseJUnit {

	public void printListInfos(List<?> resultList) {
		System.out.println("******************开始打印数据*****************");
		if (resultList != null) {
			int size = resultList.size();
			System.out.println("当前记录条数为：" + size);
			if (size != 0) {
				System.out.println("打印元素:********************");
				for (Object result : resultList) {
					System.out.println(result);
				}
			}
		}
		System.out.println("打印结束********************************");
	}
}
