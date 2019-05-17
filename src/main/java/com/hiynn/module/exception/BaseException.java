package com.hiynn.module.exception;

import com.hiynn.module.util.ResponseCodeEnum;

/**
 * description BaseException
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月08日 14:48
 */
public class BaseException extends RuntimeException {

	private final Integer code;

	private BaseException(String message, Integer code) {
		super(message);
		this.code = code;
	}

	public BaseException(ResponseCodeEnum responseCodeEnum) {
		this(responseCodeEnum.getMessage(), responseCodeEnum.getCode());
	}

	/**
	 * Gets the value of code
	 *
	 * @return the value of code
	 */
	public Integer getCode() {
		return code;
	}
}


