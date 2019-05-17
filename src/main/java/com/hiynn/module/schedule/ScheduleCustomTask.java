package com.hiynn.module.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * description ScheduleCustomTask 普通定时任务
 *
 * @author LouLvLi
 * @version 1.0
 * @date 2019年05月13日 10:52
 */
@Component
public class ScheduleCustomTask {

	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleCustomTask.class);

	/**
	 * description  task01
	 * @author LouLvLin
	 * @date  2019/5/13  10:57
	 * @return void
	 */
	@Scheduled(cron = "0/1 * * * * ?")
	public void task01(){
		LOGGER.info("task01 executed");
	}
	/**
	 * description  task02
	 * @author LouLvLin
	 * @date  2019/5/13  10:57
	 * @return void
	 */
	@Scheduled(cron = "0/1 * * * * ?")
	public void task02(){
		LOGGER.info("task02 executed");
	}
	/**
	 * description  task03
	 * @author LouLvLin
	 * @date  2019/5/13  10:57
	 * @return void
	 */
	@Scheduled(cron = "0/1 * * * * ?")
	public void task03(){
		LOGGER.info("task03 executed");
	}

}


