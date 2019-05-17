package com.hiynn.module.exception;

import com.hiynn.module.util.ResponseCodeEnum;

/**
 * description UserException
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月08日 18:01
 */
public class UserException extends BaseException {
	/**
	 * description  UserException
	 * @author LouLvLin
	 * @date  2019/5/9  8:47
	 * @param responseCodeEnum 1
	 */
	public UserException(ResponseCodeEnum responseCodeEnum) {
		super(responseCodeEnum);
	}
}


