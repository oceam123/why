package com.hiynn.module.asynctask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * description 异步任务
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月13日 14:46
 */
@Component
public class Task {

	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(Task.class);

	/**
	 * description  doTaskOne
	 * @author LouLvLin
	 *@date  2019/5/13  14:53
	 * @return void
	 */
	@Async("taskExecutor")
	public Future<String> doTaskOne() throws InterruptedException {
		LOGGER.info("开始做任务一");
		long start = System.currentTimeMillis();
		Thread.sleep(3000);
		long end = System.currentTimeMillis();
		LOGGER.info("完成任务一，耗时：{} 毫秒" , end - start);
		return new AsyncResult<>("hello doTaskOne !!!!");
	}
	/**
	 * description  doTaskTwo
	 * @author LouLvLin
	 * @date  2019/5/13  14:53
	 * @return void
	 */
	@Async("taskExecutor")
	public Future<String> doTaskTwo() throws InterruptedException {
		LOGGER.info("开始做任务二");
		long start = System.currentTimeMillis();
		Thread.sleep(4000);
		long end = System.currentTimeMillis();
		LOGGER.info("完成任务二，耗时：{} 毫秒" , end - start);
		return new AsyncResult<>("hello doTaskTwo !!!!");
	}
}


