/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: ApiInterceptor.java 
 * @Prject: api-web
 * @Package: com.hengpeng.api.interceptor 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月21日 下午4:23:08 
 * @version: V1.0   
 */
package com.hengpeng.api.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengpeng.api.controller.BaseController;
import com.hengpeng.api.enumtype.CodeMessage;
import com.hengpeng.api.util.ConfigParamUtil;
import com.hengpeng.api.util.secure.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;

/** 
 * @ClassName: ApiInterceptor 
 * @Description: API拦截器	验证Token,不拦截登录
 * @author: zhangwei
 * @date: 2017年7月21日 下午4:23:08  
 */
public class ApiInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	/** 
	 * @Description: TOKEN检查，SIGN校验
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception 
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object) 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String token = request.getParameter("token");
		String sign = request.getParameter("sign");
		String timeStamp = request.getParameter("timeStamp");

		if(StringUtils.isAnyEmpty(token, sign, timeStamp)){
			BaseController.BaseVO<String> baseVo = new BaseController.BaseVO<String>();
			baseVo.setCode(String.valueOf(CodeMessage.FAILURE.getCode()));
			baseVo.setMessage(CodeMessage.FAILURE.getMsg() + "-token OR sign OR timeStamp IS NULL");
			this.returnJson(response, new ObjectMapper().writeValueAsString(baseVo));
			return false;
		}

		try {
			String enterpriseNo = JwtUtil.unSign(token);

			BodyHttpServletRequestWrapper bodyRequest = new BodyHttpServletRequestWrapper(request);
			String body = new String(bodyRequest.getBody(), "UTF-8").replaceAll("\r|\n", "");

			if(this.verifySign(sign, enterpriseNo, timeStamp, body)){
			}else{
				BaseController.BaseVO<String> baseVo = new BaseController.BaseVO<String>(CodeMessage.FAILURE.getCode(), CodeMessage.FAILURE.getMsg() + "-签名错误");
				this.returnJson(response, new ObjectMapper().writeValueAsString(baseVo));
				return false;
			}

			/*ip白名单,没配置表示全部是白名单*/
			String ips = ConfigParamUtil.getProperty("config.ips."+enterpriseNo);
			String currentIp = this.getIpAddr(request);
			if(StringUtils.isNotBlank(ips) && !ips.contains(currentIp)){
				BaseController.BaseVO<String> baseVo = new BaseController.BaseVO<String>(CodeMessage.FAILURE.getCode(), CodeMessage.FAILURE.getMsg() + "-IP黑名单:"+currentIp);
				this.returnJson(response, new ObjectMapper().writeValueAsString(baseVo));
				return false;
			}
		} catch (ExpiredJwtException e) {
			BaseController.BaseVO<String> baseVo = new BaseController.BaseVO<String>(CodeMessage.NO_LOGIN_OR_LOGIN_TIMEOUT.getCode(), CodeMessage.NO_LOGIN_OR_LOGIN_TIMEOUT.getMsg() + "-Token过期");
			this.returnJson(response, new ObjectMapper().writeValueAsString(baseVo));
			return false;
		} catch (Exception e) {
			BaseController.BaseVO<String> baseVo = new BaseController.BaseVO<String>(String.valueOf(CodeMessage.FAILURE.getCode()), CodeMessage.FAILURE.getMsg() + "-Token校验失败");
			this.returnJson(response, new ObjectMapper().writeValueAsString(baseVo));
			return false;
		}

		return true;
	}

	/** 
	 * @Description: TODO
	 * @param request
	 * @param enterpriseNo
	 * @return
	 * @return: boolean
	 */
	private boolean verifyIp(HttpServletRequest request, String enterpriseNo) {
		String ips = ConfigParamUtil.getProperty("config.ips."+enterpriseNo);

		return true;
	}

	private void returnJson(HttpServletResponse response, String jsonStr){
		PrintWriter out = null;
        try {
			response.setContentType("application/json;charset=UTF-8");  
			out = response.getWriter();
			out.write(jsonStr);
			out.flush();
		} catch (IOException e) {
		} finally {
			if(out !=null){
				out.close();
			}
		}
	}

	/** 
	 * @Description: MD5摘要方式：enterpriseNo+timeStamp+JSON
	 * @return
	 * @return: boolean
	 */
	private boolean verifySign(String sign, String enterpriseNo, String timeStamp, String body){
		//测试用：跳过签名
		if("000001".equals(enterpriseNo)){
			return true;
		}

		StringBuffer sb = new StringBuffer();
		sb.append(enterpriseNo).append(timeStamp).append(body);
		
		String localSign = DigestUtils.md5Hex(sb.toString());
		System.out.println("===================sign==================");
		System.out.println(sb.toString());
		System.out.println("本地签名:"+localSign);
		System.out.println("=====================================");

		if(sign.equals(localSign)){
			return true;
		}else{
			return false;
		}
	}

	private String getIpAddr(HttpServletRequest request) {
	    String ip = request.getHeader("X-Forwarded-For");
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("HTTP_CLIENT_IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getRemoteAddr();
	    }
	      return ip;
	}
}
