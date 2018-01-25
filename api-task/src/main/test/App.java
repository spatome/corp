import java.util.ArrayList;
import java.util.List;

/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: App.java 
 * @Prject: api-task
 * @Package:  
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月14日 下午3:38:01 
 * @version: V1.0   
 */

/**
 * @ClassName: App
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月14日 下午3:38:01
 */
public class App {

	/**
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");

		List<List<String>> result = App.splitList(list, 10);
		for (List<String> list2 : result) {
			System.out.println(list2);
		}
	}

	public static <T> List<List<T>> splitList(List<T> list, int len) {
		if (list == null || list.size() == 0 || len < 1) {
			return null;
		}

		List<List<T>> result = new ArrayList<List<T>>();

		int size = list.size();
		int count = (size + len - 1) / len;

		for (int i = 0; i < count; i++) {
			List<T> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
			result.add(subList);
		}
		return result;
	}
}
