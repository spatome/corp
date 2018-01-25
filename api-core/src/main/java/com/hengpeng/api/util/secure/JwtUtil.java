/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: JwtUtil.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.util.secure 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月21日 下午2:31:01 
 * @version: V1.0   
 */
package com.hengpeng.api.util.secure;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/** 
 * @ClassName: JwtUtil 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月21日 下午2:31:01  
 */
public class JwtUtil {
	private final static String BASE_SECRET = "api.mpts.hengpeng.com";

	/**
	 * 生成TOKEN
	 * @param userSn
	 * @param ttlMillis 过期时间：毫秒 ， 不过期：0
	 * @return
	 * @throws Exception
	 */
	public static String sign(String userSn, long ttlMillis) throws Exception {
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		JwtBuilder builder = Jwts.builder()
				.setIssuedAt(now)
				.setSubject(userSn)
				.signWith(SignatureAlgorithm.HS512, BASE_SECRET);
		if (ttlMillis > 0) {
			long expMillis = nowMillis + ttlMillis; 
			Date exp = new Date(expMillis); 
			builder.setExpiration(exp); 
		}

		return builder.compact();
	}
	
	/**
	 * 解密
	 * ExpiredJwtException 过期异常,自行扑捉
	 * @param token
	 * @return userSN
	 * @throws Exception
	 */
	public static String unSign(String token) throws Exception {
		Claims claims = Jwts.parser().setSigningKey(BASE_SECRET).parseClaimsJws(token).getBody();

		return claims.getSubject();
	}
}
