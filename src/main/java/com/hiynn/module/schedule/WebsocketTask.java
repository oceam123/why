package com.hiynn.module.schedule;

import com.hiynn.module.service.IUserService;
import com.hiynn.module.util.ConstansUtil;
import com.hiynn.module.websocket.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * description WebsocketTask
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月13日 15:36
 */
@Component
public class WebsocketTask {

	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(WebsocketTask.class);


	@Autowired
	private IUserService userService;

	/**
	 * description  websocketTask
	 * @author LouLvLin
	 * @date  2019/5/13  16:01
	 * @return void
	 */
	@Scheduled(cron = "0/10 * * * * ?")
	public void websocketTask() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		//获取WebSocketServer对象的映射。
		ConcurrentMap<String, WebSocketServer> map = WebSocketServer.getWebSocketMap();
		if (map.size() != 0) {
			String messageString = ConstansUtil.COMM_GSON.toJson(userService.getUsers(1,3));
			for (Map.Entry<String, WebSocketServer> entry : map.entrySet()) {
				WebSocketServer webSocketServer = entry.getValue();
				try {
					//向客户端推送消息
					webSocketServer.getSession().getBasicRemote().sendText(messageString);
				} catch (IOException e) {
					LOGGER.error("websocketTask:推送消息发生IO异常", e);
				}
			}
		} else {
			LOGGER.info("websocketTask:WebSocket未连接");
		}
	}

}


