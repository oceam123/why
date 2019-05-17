package com.hiynn.module.schedule;

import org.awaitility.Duration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

/**
 * description ScheduleCustomTaskTest
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月13日 11:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ScheduleCustomTaskTest {

	@SpyBean
	private ScheduleCustomTask scheduleCustomTask;

	@Test
	public void task01Test() throws InterruptedException {
		await().atMost(Duration.TWO_SECONDS)
				.untilAsserted(() -> verify(scheduleCustomTask, atLeast(1)).task01());
	}

	@Test
	public void task02Test() throws InterruptedException {
		await().atMost(Duration.TWO_SECONDS)
				.untilAsserted(() -> verify(scheduleCustomTask, atLeast(1)).task02());
	}

	@Test
	public void task03Test() throws InterruptedException {
		await().atMost(Duration.TWO_SECONDS)
				.untilAsserted(() -> verify(scheduleCustomTask, atLeast(1)).task03());
	}

}


