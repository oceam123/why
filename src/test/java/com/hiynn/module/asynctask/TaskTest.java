package com.hiynn.module.asynctask;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

import static org.hamcrest.Matchers.equalTo;

/**
 * description TaskTest
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月13日 14:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskTest {

	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskTest.class);

	@Autowired
	private Task task;

	@Test
	public void doTaskOneTest() throws Exception {
		Future<String> result = task.doTaskOne();
		Assert.assertThat("hello doTaskOne !!!!", equalTo(result.get()));
	}

	@Test
	public void doTaskTwoTest() throws Exception {
		Future<String> result = task.doTaskTwo();
		Assert.assertThat("hello doTaskTwo !!!!", equalTo(result.get()));
	}
}


