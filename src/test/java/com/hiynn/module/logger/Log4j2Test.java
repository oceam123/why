package com.hiynn.module.logger;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * description log4j2测试
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年04月04日 14:14
 */
@SpringBootTest
public class Log4j2Test {

	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(Log4j2Test.class);

	@Test
	public void loggerTest(){
		LOGGER.error("Hello error");
		LOGGER.warn("Hello warn");
		LOGGER.info("Hello world");
		LOGGER.debug("Hello debug");
	}

}


