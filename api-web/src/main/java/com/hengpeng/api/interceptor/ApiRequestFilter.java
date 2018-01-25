/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: MyHttpServletRequestFilter.java 
 * @Prject: api-web
 * @Package: com.hengpeng.api.interceptor 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月4日 下午8:21:35 
 * @version: V1.0   
 */
package com.hengpeng.api.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: ApiRequestFilter
 * @Description: 和BodyHttpServletRequest配合实现http post包体JSON格式并加解密和controller解耦
 * @author: zhangwei
 * @date: 2017年8月4日 下午8:21:35
 */
public class ApiRequestFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		ServletRequest requestWrapper = null;

		if (request instanceof HttpServletRequest) {
			requestWrapper = new BodyHttpServletRequestWrapper((HttpServletRequest) request);
		}

		if (null == requestWrapper) {
			chain.doFilter(request, response);
		} else {
			chain.doFilter(requestWrapper, response);
		}
	}

	@Override
	public void destroy() {
	}
}
