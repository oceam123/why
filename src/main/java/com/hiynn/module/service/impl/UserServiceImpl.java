package com.hiynn.module.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hiynn.module.dao.UserMapper;
import com.hiynn.module.exception.UserException;
import com.hiynn.module.service.IUserService;
import com.hiynn.module.util.ResponseCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.cache.annotation.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * description userServiceImpl
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年04月17日 14:11
 */
@Service
public class UserServiceImpl implements IUserService {

	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;

	/**
	 * description  getUsers 
	 * @author LouLvLin
	 * @date  2019/5/6  15:12
	 * @param pageNum 1
	 * @param pageSize 2
	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 */
	@Override
	public Map<String, Object> getUsers(int pageNum, int pageSize) {
		Map<String,Object> users = new LinkedHashMap<>();
		Page page = PageHelper.startPage(pageNum, pageSize);
		List<Map<String,Object>> result = userMapper.getUsers();

		users.put("result", result);
		Map<String,Object> pageInfo = new LinkedHashMap<>();
		pageInfo.put("totalPage", page.getPages());
		pageInfo.put("totalCount", page.getTotal());
		pageInfo.put("currentPage", page.getPageNum());
		users.put("pageInfo", pageInfo);
		return users;
	}

	/**
	 * description  getUserById
	 *
	 * @param id 1
	 * @return java.util.Map<java.lang.String , java.lang.Object>
	 * @author LouLvLin
	 * @date 2019/5/6  11:08
	 */
	@CacheResult(cacheName="default")
	@Override
	public Map<String, Object> getUserById(@CacheKey int id) {
		return userMapper.getUserById(id);
	}

	/**
	 * description  addUser
	 *
	 * @param user 1
	 * @return void
	 * @author LouLvLin
	 * @date 2019/5/6  11:07
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addUser(Map<String, Object> user) {
		userMapper.insertUser(user);
	}

	/**
	 * description  updateUser
	 *
	 * @param user 1
	 * @return void
	 * @author LouLvLin
	 * @date 2019/5/6  11:07
	 */
	@CachePut(cacheName="default")
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateUser(@CacheKey int id,@CacheValue Map<String, Object> user) {
		user.put("id", id);
		userMapper.updateUser(user);
	}

	/**
	 * description  deleteUserById
	 *
	 * @param id 1
	 * @return void
	 * @author LouLvLin
	 * @date 2019/5/6  11:07
	 */
	@CacheRemove(cacheName="default")
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteUserById(@CacheKey int id) {
		int result = 0;
		try {
			result = userMapper.deleteUserById(id);
		} catch(Exception e){
			LOGGER.error("删除用户信息失败", e);
			throw new UserException(ResponseCodeEnum.DEL_USER_INFO_FAILED);
		}
		if (1 != result) {
			throw new UserException(ResponseCodeEnum.DEL_USER_INFO_FAILED);
		}
	}

	/**
	 * description  getMaxId
	 *
	 * @return java.lang.Integer
	 * @author LouLvLin
	 * @date 2019/5/6  15:29
	 */
	@Override
	public Integer getMaxId() {
		return userMapper.getMaxId();
	}
}


