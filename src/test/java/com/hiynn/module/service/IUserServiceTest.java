package com.hiynn.module.service;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
* description  IUserServiceTest
* @author LouLvLin
* @date  2019/4/17  14:23
* @param
* @return
**/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IUserServiceTest {

	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(IUserServiceTest.class);

	@Autowired
	private IUserService userService;

	private List<Integer> ids = new ArrayList<>();


	@Before
	public void before(){
		Map<String,Object> user;
		int count = 0;
		for (int i = 0; i < 6; i++) {
			user = new LinkedHashMap<>();
			user.put("name", "张三");
			user.put("password", "hello");
			user.put("level", i + "");
			user.put("uid", "zhangshan" + i);
			userService.addUser(user);
			ids.add(userService.getMaxId());
		}
	}


	@Test
	public void getUsersTest(){
		Map<String, Object> result = userService.getUsers(1, 3);
		Assert.assertThat(result.size(), Matchers.greaterThanOrEqualTo(2));
		LOGGER.info("getUsersTest : {}", result);
	}

	@Test
	public void getUserByIdTest(){
		Map<String, Object> result = userService.getUserById(ids.get(0));
		LOGGER.info("getUserByIdTest : {}", result);
		Assert.assertThat(result.size(), Matchers.greaterThanOrEqualTo(1));
	}

	@Test
	public void updateUserTest(){
		int id = ids.get(0);
		Map<String,Object> user = new LinkedHashMap<>();
		user.put("name", "张三");
		user.put("password", "hello11");
		user.put("level", "1");
		user.put("uid", "zhangshan");
		user.put("id", id);
		userService.updateUser(id,user);

		Map<String,Object> userNew = new LinkedHashMap<>();
		userNew = userService.getUserById(ids.get(0));
		Assert.assertThat(userNew.get("password"), Matchers.equalTo("hello11"));
	}

	@Test
	public void getMaxIdTest(){
		int result = userService.getMaxId();
		LOGGER.info("getMaxIdTest : {} " , result);
		Assert.assertThat(result, Matchers.greaterThanOrEqualTo(0));
	}


	@After
	public void after(){
		int id;
		for (int i = 0; i < ids.size(); i++) {
			id = ids.get(i);
			userService.deleteUserById(id);
		}
	}

}