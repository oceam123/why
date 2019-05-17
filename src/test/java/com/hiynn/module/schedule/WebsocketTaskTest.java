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
 * description WebsocketTaskTest
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月14日 13:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebsocketTaskTest {

	@SpyBean
	private WebsocketTask websocketTask;

	@Test
	public void websocketTaskTest(){
		await().atMost(Duration.TEN_SECONDS)
				.untilAsserted(() -> verify(websocketTask, atLeast(1)).websocketTask());

	}



}


