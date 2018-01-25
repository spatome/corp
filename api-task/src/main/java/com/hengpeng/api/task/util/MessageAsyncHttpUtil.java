package com.hengpeng.api.task.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hengpeng.api.task.common.constants.ConfigConstants;
import com.hengpeng.api.task.service.HttpAsyncService;
import com.hengpeng.api.util.ConfigParamUtil;

/**
 * 只处理投注
 */
public class MessageAsyncHttpUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(MessageAsyncHttpUtil.class);

    private final static String XML_KEY = "transMessage";

    private final static String URL = ConfigParamUtil.getProperty(ConfigConstants.KXCH_CENTER_URL);

    private static HttpClientContext context = HttpClientContext.create();

    /** 
     * @Description: http post
     * @param transType
     * @param xmlData
     * @return xml
     * @throws ClientProtocolException
     * @throws IOException
     * @return: String
     */
    public static void post(final String transType, String xmlData, final HttpAsyncService handler) {
    	LOGGER.info("=============center============>>");
//    	LOGGER.info(xmlData);

    	HttpPost post = new HttpPost(URL);
    	
		final CloseableHttpAsyncClient httpClient = HttpAsyncClients.createDefault();
        try {
			List<NameValuePair> params = new ArrayList<NameValuePair>();  
			params.add(new BasicNameValuePair("transType", transType));  
			params.add(new BasicNameValuePair("transMessage", xmlData));
			post.setEntity(new UrlEncodedFormEntity(params, "GBK"));

			post.setHeader("Content-type", "application/x-www-form-urlencoded");
			post.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

			httpClient.start();
			httpClient.execute(post, context, new FutureCallback<HttpResponse>(){

				@Override
				public void cancelled() {
					close(httpClient);
					handler.cancelled();
				}

				@Override
				public void completed(HttpResponse response) {
					String content = "";

					try {
						//String content = EntityUtils.toString(response.getEntity(), "UTF-8");
						content = IOUtils.toString(response.getEntity().getContent(), "GBK");
						LOGGER.info("<<=============center============");
						LOGGER.info(content);
					} catch (ParseException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					String resultXml = getParameter(content, XML_KEY);
					handler.completed(resultXml);
					close(httpClient);
				}

				@Override
				public void failed(Exception ex) {
					close(httpClient);
					handler.failed(ex);
				}
			});
		} catch (Exception e) {
			LOGGER.error("post异常："+e);
			throw new RuntimeException("post异常:"+e.getMessage());
		}
    };

	/**
	 * @Description: 获取XML
	 * @return:
	 */
    public static String getReturnXml(String source) {
    	return getParameter(source, XML_KEY);
    }
    
    private static void close(CloseableHttpAsyncClient client){
    	if(client!=null){
    		try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
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
