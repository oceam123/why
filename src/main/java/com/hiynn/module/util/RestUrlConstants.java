package com.hiynn.module.util;

/**
 * description 项目url接口定义
 * @author LouLvLin
 * @version 1.0
 * @date 2019年04月16日 14:42
 */
public class RestUrlConstants {

	/**
	* description  RestUrlConstants
	* @author LouLvLin
	* @date  2019/4/16  14:49
	* @return
	**/
	private RestUrlConstants() {
	}

	/**
	 * 分页获取用户信息
	 */
	public static final String GET_USERS_WITH_PAGE = "/users/{pageNum}/{pageSize}";
	/**
	 * 根据id获取用户信息
	 */
	public static final String GET_USER_WITH_ID = "/users/{id}";
	/**
	 * 新增用户
	 */
	public static final String ADD_USER = "/users";
	/**
	 * 根据id修改用户
	 */
	public static final String UPDATE_USER = "/users/{id}";
	/**
	 * 根据id删除用户
	 */
	public static final String DEL_USER = "/users/{id}";


}


