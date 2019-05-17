package com.hiynn.module.controller;

import com.hiynn.module.entity.ResponseResult;
import com.hiynn.module.service.IUserService;
import com.hiynn.module.util.ResponseResultUtil;
import com.hiynn.module.util.RestUrlConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * description UserController
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月05日 15:00
 */
@RestController
@Api(tags="用户管理")
public class UserController {
	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;


	/**
	 * description  getUsers 
	 * @author LouLvLin
	 * @date  2019/5/6  15:54
	 * @param pageNum 1
	 * @param pageSize 2
	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 */
	@ApiOperation(value="分页获取用户列表", httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = RestUrlConstants.GET_USERS_WITH_PAGE, method = RequestMethod.GET)
	public ResponseResult getUsers(@PathVariable("pageNum") Integer pageNum,
	                               @PathVariable("pageSize") Integer pageSize) {
		LOGGER.info("coming into UserController.getUsers,and params is : pageNum : {} ,pageSize : {}",pageNum,pageSize);
		return ResponseResultUtil.success(userService.getUsers(pageNum, pageSize));
	}

	/**
	 * description  getUserById 
	 * @author LouLvLin
	 * @date  2019/5/16  15:42
	 * @param id 1
	 * @return com.hiynn.module.entity.ResponseResult
	 */
	@ApiOperation(value="根据用户id获取用户信息", httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = RestUrlConstants.GET_USER_WITH_ID, method = RequestMethod.GET)
	public ResponseResult getUserById(@PathVariable("id") Integer id) {
		LOGGER.info("coming into UserController.getUserById,and params is : id : {}",id);
		return ResponseResultUtil.success(userService.getUserById(id));
	}

	/**
	 * description  addUser 
	 * @author LouLvLin
	 * @date  2019/5/16  15:42
	 * @param user 1
	 * @return com.hiynn.module.entity.ResponseResult
	 */
	@ApiOperation(value="添加用户", httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = RestUrlConstants.ADD_USER, method = RequestMethod.POST)
	public ResponseResult addUser(@RequestBody Map<String, Object> user) {
		LOGGER.info("coming into UserController.addUser,and params is : user : {}",user);
		userService.addUser(user);
		return ResponseResultUtil.success();
	}

	/**
	 * description  updateUser 
	 * @author LouLvLin
	 * @date  2019/5/16  15:42
	 * @param id 1
	 * @param user 2
	 * @return com.hiynn.module.entity.ResponseResult
	 */
	@ApiOperation(value="修改用户", httpMethod = "PUT",produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = RestUrlConstants.UPDATE_USER, method = RequestMethod.PUT)
	public ResponseResult updateUser(@PathVariable("id") Integer id,@RequestBody Map<String, Object> user) {
		LOGGER.info("coming into UserController.updateUser,and params is : id : {}, user : {}",id,user);
		userService.updateUser(id,user);
		return ResponseResultUtil.success();
	}

	/**
	 * description  deleteUser
	 * @author LouLvLin
	 * @date  2019/5/16  15:45
	 * @param id 1
	 * @return com.hiynn.module.entity.ResponseResult
	 */
	@ApiOperation(value="删除用户", httpMethod = "DELETE",produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = RestUrlConstants.DEL_USER, method = RequestMethod.DELETE)
	public ResponseResult deleteUser(@PathVariable("id") Integer id) {
		LOGGER.info("coming into UserController.deleteUser,and params is : id : {}",id);
		userService.deleteUserById(id);
		return ResponseResultUtil.success();
	}


}


