package com.hiynn.module.util;

import com.hiynn.module.entity.ResponseResult;

/**
 * description ResponseResultUtil
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月08日 16:19
 */
@SuppressWarnings("unchecked")
public class ResponseResultUtil {
	/**
	 * description  ResponseResultUtil
	 * @author LouLvLin
	 * @date  2019/5/10  11:12
	 */
	private ResponseResultUtil() {
		//hide the implicit public one
	}

	/**
	 * description  success
	 * @author LouLvLin
	 * @date  2019/5/8  16:29
	 * @param result 1
	 * @return com.hiynn.module.entity.ResponseResult
	 */
	public static ResponseResult success(Object result){
		return new ResponseResult(ResponseCodeEnum.SUCCESS.getCode(),ResponseCodeEnum.SUCCESS.getMessage(),result);
	}
	/**
	 * description  success
	 * @author LouLvLin
	 * @date  2019/5/8  16:29
	 * @return com.hiynn.module.entity.ResponseResult
	 */
	public static ResponseResult success(){
		return success(null);
	}

	/**
	 * description  error 
	 * @author LouLvLin
	 * @date  2019/5/8  16:29
	 * @param responseCodeEnum 1
	 * @return com.hiynn.module.entity.ResponseResult
	 */
	public static ResponseResult error(ResponseCodeEnum responseCodeEnum){
		return new ResponseResult(responseCodeEnum.getCode(),responseCodeEnum.getMessage(),null);
	}
	/**
	 * description  error
	 * @author LouLvLin
	 * @date  2019/5/8  16:29
	 * @param code 1
	 * @param msg 2
	 * @return com.hiynn.module.entity.ResponseResult
	 */
	public static ResponseResult error(Integer code, String msg){
		return new ResponseResult(code,msg,null);
	}









}


