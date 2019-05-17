package com.hiynn.module.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * description OkHttpUtil
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月15日 11:20
 */
public class OkHttpUtil {

	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(OkHttpUtil.class);

	/**
	 * description  OkHttpUtil
	 * @author LouLvLin
	 * @date  2019/5/15  11:21
	 */
	private OkHttpUtil() {
	}
	/**
	 * description  OkHttpClientHolder 
	 * @author LouLvLin
	 * @date  2019/5/15  14:43
	 * @return
	 */
	private static class OkHttpClientHolder {
		private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
				.connectTimeout(10, TimeUnit.SECONDS)
				.readTimeout(20, TimeUnit.SECONDS)
				.writeTimeout(20, TimeUnit.SECONDS)
				.retryOnConnectionFailure(false)
				.build();
	}

	/**
	 * description  getOkHttpClient
	 * @author LouLvLin
	 * @date  2019/5/15  14:43
	 * @return okhttp3.OkHttpClient
	 */
	private static OkHttpClient getOkHttpClient(){
		return  OkHttpUtil.OkHttpClientHolder.okHttpClient;
	}

	/**
	 * description  getSync 
	 * @author LouLvLin
	 * @date  2019/5/15  14:44
	 * @param url 1
	 * @return java.lang.String
	 */
	public static String getSync(String url) {
		String result = "";
		try {
			Response response = getOkHttpClient()
					.newCall(OkHttpRequestUtil.buildRequest(url,HttpMethodType.GET,"")).execute();

			if (!response.isSuccessful()) {
				throw new IOException("getSync服务器端错误:" + response);
			}
			result = response.body().string();
		} catch (IOException e) {
			LOGGER.error("getSync error: ",e);
		}
		return result;
	}

	/**
	 * description  postSync 
	 * @author LouLvLin
	 * @date  2019/5/15  15:07
	 * @param url 1
 * @param parameterJsonType 2
	 * @return java.lang.String
	 */
	public static String postSync(String url,String parameterJsonType) {
		String result = "";
		try {
			Response response = getOkHttpClient()
					.newCall(OkHttpRequestUtil.buildRequest(url,HttpMethodType.POST,parameterJsonType)).execute();
			if (!response.isSuccessful()) {
				throw new IOException("postSync服务器端错误:" + response);
			}
			result = response.body().string();
		} catch (IOException e) {
			LOGGER.error("postSync error: ",e);
		}
		return result;
	}
}


