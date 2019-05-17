package com.hiynn.module.dao;

import java.util.List;
import java.util.Map;

/**
 * description 用户操作DAO
 *
 * @author LouLvLin
 * @date 2019年04月10日 8:51
 * @version 1.0
 */
public interface UserMapper {

	/**
	 * description  getUsers
	 * @author LouLvLin
	 * @date  2019/5/6  11:00
	 * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
	 */
	List<Map<String, Object>> getUsers();
	/**
	 * description  getUserById 
	 * @author LouLvLin
	 * @date  2019/5/6  14:56
	 * @param id 1
	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 */
	Map<String, Object> getUserById(Integer id);
	/**
	 * description  insertUser 
	 * @author LouLvLin
	 * @date  2019/5/6  11:06
	 * @param user 1
	 * @return java.lang.Integer
	 */
	Integer insertUser(Map<String, Object> user);
	/**
	 * description  getMaxId
	 * @author LouLvLin
	 * @date  2019/5/6  14:36
	 * @return java.lang.Integer
	 */
	Integer getMaxId();
	/**
	 * description  deleteUserById
	 * @author LouLvLin
	 * @date  2019/5/6  11:06
	 * @param id 1
	 * @return java.lang.Integer
	 */
	Integer deleteUserById(Integer id);
	/**
	 * description  updateUser
	 * @author LouLvLin
	 * @date  2019/5/16  15:46
	 * @param user 2
	 * @return java.lang.Integer
	 */
	Integer updateUser(Map<String, Object> user);

}
