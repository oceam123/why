package com.hiynn.module.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * description WebSocketConfig
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月07日 13:52
 */
@Configuration
public class WebSocketConfig {
	/**
	 * description  serverEndpointExporter
	 * @author LouLvLin
	 * @date  2019/5/13  11:41
	 * @return org.springframework.web.socket.server.standard.ServerEndpointExporter
	 */
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}


