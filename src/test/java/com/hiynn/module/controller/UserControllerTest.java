package com.hiynn.module.controller;

import com.hiynn.module.service.IUserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
* description  UserControllerTest
* @author LouLvLin
* @date  2019/4/17  14:41
* @param 
* @return 
**/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext ;
	@Autowired
	private IUserService userService;

	private MockMvc mockMvc ;

	private Integer idTemp;

	@Before
	public void setUp() throws Exception
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		//addUserTest
		String requestBody = "{\"name\":\"李四\",\"password\":\"hello5\",\"level\":\"1\",\"uid\":\"lisi12\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/users")
				.contentType(MediaType.APPLICATION_JSON).content(requestBody)
				.accept(MediaType.APPLICATION_JSON)) //执行请求
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) //验证响应contentType
				.andExpect(MockMvcResultMatchers.status().isOk());

		idTemp = userService.getMaxId();
	}

	@Test
	public void getUsersWithPageTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/users/1/3").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
				.andReturn();
	}
	@Test
	public void getUserByIdTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/users/" + idTemp)
				.accept(MediaType.APPLICATION_JSON)) //执行请求
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void updateUserTest() throws Exception {
		String requestBody = "{\"id\":" + idTemp + ",\"name\":\"李四11\",\"password\":\"hello6\",\"level\":\"1\",\"uid\":\"lisi162\"}";
		mockMvc.perform(MockMvcRequestBuilders.put("/users/" + idTemp)
				.contentType(MediaType.APPLICATION_JSON).content(requestBody)
				.accept(MediaType.APPLICATION_JSON)) //执行请求
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) //验证响应contentType
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@After
	public void after() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/users/" + idTemp)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)) //执行请求
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) //验证响应contentType
				.andExpect(MockMvcResultMatchers.status().isOk());
	}


}