package com.hiynn.module.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
* description  UserMapperTest
* @author LouLvLin
* @date  2019/4/10  10:29
* @param 
* @return 
**/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserMapperTest.class);

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
			count += userMapper.insertUser(user);
			ids.add(userMapper.getMaxId());
		}
		Assert.assertThat(count, Matchers.greaterThanOrEqualTo(6));
	}

	@Test
	public void getUsersTest(){
		Page page = PageHelper.startPage(2, 3);
		List<Map<String,Object>> result = userMapper.getUsers();
		LOGGER.info("getUsersTest: {}", result);
		Assert.assertThat(result.size(), Matchers.greaterThanOrEqualTo(1));

	}

	@Test
	public void getMaxIdTest(){
		int result = userMapper.getMaxId();
		LOGGER.info("getMaxIdTest: {}", result);
		Assert.assertThat(result, Matchers.greaterThanOrEqualTo(0));
	}

	@Test
	public void getUserByIdTest(){
		Map<String, Object> result = userMapper.getUserById(ids.get(0));
		LOGGER.info("getUserByIdTest: {}", result);
		Assert.assertThat(result.size(), Matchers.greaterThanOrEqualTo(1));
	}


	@Test
	public void updateUserTest(){
		Map<String,Object> user = new LinkedHashMap<>();
		user.put("name", "张三");
		user.put("password", "hello11");
		user.put("level", "1");
		user.put("uid", "zhangshan");
		user.put("id", ids.get(0));
		int result = userMapper.updateUser(user);
		Assert.assertThat(result, Matchers.equalTo(1));
	}

	@After
	public void after(){
		int id;
		int count = 0;
		for (int i = 0; i < ids.size(); i++) {
			id = ids.get(i);
			count += userMapper.deleteUserById(id);
		}
		Assert.assertThat(count, Matchers.greaterThanOrEqualTo(6));
	}
}