package com.hiynn.module.entity;

/**
 * description ResponseResult
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月08日 16:00
 */
public class ResponseResult<T> {

	/**
	 * description  响应代码 
	 * @author LouLvLin
	 * @date  2019/5/8  16:00
	 */
	private Integer code;
	/**
	 * description  响应消息
	 * @author LouLvLin
	 * @date  2019/5/8  16:02
	 */
	private String msg;
	/**
	 * description  响应数据
	 * @author LouLvLin
	 * @date  2019/5/8  16:02
	 */
	private T data;

	/**
	 * description  ResponseResult
	 * @author LouLvLin
	 * @date  2019/5/9  9:36
	 * @param code 1
	 * @param msg 2
	 * @param data 3
	 */
	public ResponseResult(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
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
	 * Gets the value of msg
	 *
	 * @return the value of msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * Gets the value of data
	 *
	 * @return the value of data
	 */
	public T getData() {
		return data;
	}
}


