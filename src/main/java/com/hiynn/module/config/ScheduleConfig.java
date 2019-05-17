package com.hiynn.module.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * description ScheduleConfig
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月13日 10:46
 */
@Configuration
@EnableScheduling
@EnableAsync
public class ScheduleConfig {
	/**
	 * description  taskExecutor
	 * @author LouLvLin
	 * @date  2019/5/13  10:49
	 * @return org.springframework.scheduling.TaskScheduler
	 */
	@Bean
	public ThreadPoolTaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(20);
		taskScheduler.setThreadNamePrefix("task-");
		taskScheduler.setWaitForTasksToCompleteOnShutdown(true);
		taskScheduler.setAwaitTerminationSeconds(60);
		return taskScheduler;
	}

	@Bean("taskExecutor")
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(20);
		executor.setQueueCapacity(200);
		executor.setKeepAliveSeconds(60);
		executor.setThreadNamePrefix("taskExecutor-");
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		return executor;
	}
}


