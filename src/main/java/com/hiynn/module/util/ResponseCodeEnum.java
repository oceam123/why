package com.hiynn.module.util;

/**
 * description: ResponseCodeEnum
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月08日 16:07
 */
public enum ResponseCodeEnum {

	// 系统通用配置
	SUCCESS(1, "success"),
	FAIL(0, "failure"),

	// 用户模块配置
	DEL_USER_INFO_FAILED(1000, "删除用户信息失败");

    // 其它模块配置 如下：
    // SAVE_USER_INFO_FAILED(2001, "保存用户信息失败"),

	// GET_USER_INFO_FAILED(2002, "获取用户信息失败"),


	/**
	 * description  code
	 * @author LouLvLin
	 * @date  2019/5/8  16:10
	 */
	private Integer code;
	/**
	 * description  message
	 * @author LouLvLin
	 * @date  2019/5/8  16:10
	 */
	private String message;

	/**
	 * description  ResponseCodeEnum
	 * @author LouLvLin
	 * @date  2019/5/8  16:11
	 * @param code 1
	 * @param message 2
	 */
	ResponseCodeEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * Gets the value of code
	 *
	 * @return the value of code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * Gets the value of message
	 *
	 * @return the value of message
	 */
	public String getMessage() {
		return message;
	}
}
