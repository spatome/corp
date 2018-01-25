/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: ApiFilter.java 
 * @Prject: api-web
 * @Package: com.hengpeng.api.interceptor 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月4日 下午7:30:42 
 * @version: V1.0   
 */
package com.hengpeng.api.interceptor;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.IOUtils;

/** 
 * @ClassName: ApiFilter 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月4日 下午7:30:42  
 */
public class BodyHttpServletRequestWrapper extends HttpServletRequestWrapper {

	private final byte[] body;

	public BodyHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		body = IOUtils.toByteArray(request.getReader(), "UTF-8");
	}

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }
    
    @Override
    public ServletInputStream getInputStream() throws IOException {

        final ByteArrayInputStream bais = new ByteArrayInputStream(this.body);

        return new ServletInputStream() {

            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };
    }

	public byte[] getBody() {
		return body;
	}
}
