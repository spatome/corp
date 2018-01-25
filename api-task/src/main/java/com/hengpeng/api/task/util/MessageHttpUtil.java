package com.hengpeng.api.task.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hengpeng.api.task.common.constants.ConfigConstants;
import com.hengpeng.api.util.ConfigParamUtil;

/**
 * http请求和响应的工具类，主要处理字符编码和其它一些信息
 */
public class MessageHttpUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(MessageHttpUtil.class);
    
    private final static String XML_KEY = "transMessage";

    private final static CloseableHttpClient CLIENT = HttpClients.createDefault();
    private final static String URL = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_URL);

    /** 
     * @Description: http post
     * @param transType
     * @param xmlData
     * @return xml
     * @throws ClientProtocolException
     * @throws IOException
     * @return: String
     */
    public static String post(String transType, String xmlData) {
    	LOGGER.info("=============center============>>");
    	LOGGER.info(xmlData);

    	HttpPost post = new HttpPost(URL);
    	CloseableHttpResponse response = null;
        try {
			List<NameValuePair> params = new ArrayList<NameValuePair>();  
			params.add(new BasicNameValuePair("transType", transType));  
			params.add(new BasicNameValuePair("transMessage", xmlData));
			post.setEntity(new UrlEncodedFormEntity(params, "GBK"));

			post.setHeader("Content-type", "application/x-www-form-urlencoded");
			post.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			response = CLIENT.execute(post);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String content = EntityUtils.toString(entity, "UTF-8");
				LOGGER.info("<<=============center============");
			    LOGGER.info(content);
			    return getParameter(content, XML_KEY);
			}else{
				LOGGER.error("<<=============center============");
				LOGGER.error("Response httpEntity is null");
				throw new RuntimeException("Http post异常：没有回应数据");
			}
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("编码处理异常："+e);
			throw new RuntimeException("编码处理异常:"+e.getMessage());
		} catch (ClientProtocolException e) {
			LOGGER.error("协议处理异常："+e);
			throw new RuntimeException("协议处理异常:"+e.getMessage());
		} catch (ParseException e) {
			LOGGER.error("数据格式处理异常："+e);
			throw new RuntimeException("数据格式处理异常:"+e.getMessage());
		} catch (IOException e) {
			LOGGER.error("IO异常："+e);
			throw new RuntimeException("IO异常:"+e.getMessage());
		}finally {
			if(response!=null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
				}
			}
			if(post !=null)	post.abort();
		}
    };

	/**
	 * @Description: 获取XML
	 * @return:
	 */
    public static String getReturnXml(String source) {
    	return getParameter(source, XML_KEY);
    }
    
	/**
	 * @Description: 根据参数名从响应的消息里面获取参数值,???参数值中不能有&
	 * @return:
	 */
	public static String getParameter(String source, String parameter) {
		String paramValue = null;
		String[] keyvalus = source.split("&");
		for (int i = 0; i < keyvalus.length; i++) {
			String string = keyvalus[i];
			int index = string.indexOf("=");
			if (index > 0) {
				String key = string.substring(0, index);
				if (key.equalsIgnoreCase(parameter)) {
					paramValue = string.substring(index + 1, string.length());
					break;
				}
			}
		}
		return paramValue;
	}
}
