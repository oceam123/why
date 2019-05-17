package com.hiynn.module.service;

import java.util.Map;

/**
 * description user service interface
 *
 * @author LouLvLin
 * @date 2019年04月17日 13:44
 * @version 1.0
 */
public interface IUserService {

	/**
	 * description  getUsers 
	 * @author LouLvLin
	 * @date  2019/5/6  11:08
	 * @param pageNum 1
	 * @param pageSize 2
	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 */
	Map<String, Object> getUsers(int pageNum,int pageSize);
	/**
	 * description  getUserById 
	 * @author LouLvLin
	 * @date  2019/5/6  11:08
	 * @param id 1
	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 */
	Map<String, Object> getUserById(int id);
	/**
	 * description  addUser 
	 * @author LouLvLin
	 * @date  2019/5/6  11:07
	 * @param user 1
	 * @return void
	 */
	void addUser(Map<String, Object> user);

	/**
	 * description  updateUser 
	 * @author LouLvLin
	 * @date  2019/5/6  11:07
	 * @param user 1
	 * @return void
	 */
	void updateUser(int id,Map<String, Object> user);

	/**
	 * description  deleteUserById
	 * @author LouLvLin
	 * @date  2019/5/6  11:07
	 * @param id 1
	 * @return void
	 */
	void deleteUserById(int id);
	/**
	 * description  getMaxId
	 * @author LouLvLin
	 * @date  2019/5/6  15:29
	 * @return java.lang.Integer
	 */
	Integer getMaxId();

}
