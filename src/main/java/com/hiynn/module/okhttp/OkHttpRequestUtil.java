package com.hiynn.module.okhttp;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * description OkHttpRequestUtil
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月15日 10:07
 */
public class OkHttpRequestUtil {


	private static final MediaType TYPE_JSON = MediaType
			.parse("application/json;charset=utf-8");

	/**
	 * description  OkHttpRequestUtil
	 * @author LouLvLin
	 * @date  2019/5/15  10:07
	 */
	private OkHttpRequestUtil() {
	}

	/**
	 * description  buildRequest 
	 * @author LouLvLin
	 * @date  2019/5/15  11:36
	 * @param url 1
	 * @param httpMethodType 2
	 * @param params 3
	 * @return okhttp3.Request
	 */
	public static Request buildRequest(String url,HttpMethodType httpMethodType,String params) {
		Request.Builder builder = new Request.Builder().url(url);
		if (HttpMethodType.GET == httpMethodType) {
			builder.get();
		}else if (HttpMethodType.POST == httpMethodType){
			RequestBody requestBody = RequestBody.create(TYPE_JSON, params);
			builder.post(requestBody);
		}
		return builder.build();
	}
}


