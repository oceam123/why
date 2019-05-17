package com.hiynn.module.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * description WebSocketServer
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月13日 15:31
 */
@ServerEndpoint("/socket/{ip}")
@Component
public class WebSocketServer {

	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketServer.class);

	//用来记录当前在线连接数
	private static int onLineCount = 0;

	//用来存放每个客户端对应的WebSocketServer对象
	private static ConcurrentMap<String,WebSocketServer> webSocketMap = new ConcurrentHashMap<>();

	//某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;

	//客户端的ip地址
	private String ip;

	/**
	 * 连接建立成功,调用的方法,与前台页面的onOpen相对应
	 * @param ip ip地址
	 * @param session 会话
	 */
	@OnOpen
	public void onOpen(@PathParam("ip")String ip, Session session){
		//根据业务,自定义逻辑实现
		this.session = session;
		this.ip = ip;
		webSocketMap.put(ip,this);  //将当前对象放入map中
		addOnLineCount();  //在线人数加一
		LOGGER.info("有新的连接加入,ip:{}!当前在线人数:{}",ip,getOnLineCount());
	}

	/**
	 * 连接关闭调用的方法,与前台页面的onClose相对应
	 * @param ip
	 */
	@OnClose
	public void onClose(@PathParam("ip")String ip){
		webSocketMap.remove(ip);  //根据ip(key)移除WebSocketServer对象
		subOnLineCount();
		LOGGER.info("WebSocket关闭,ip:{},当前在线人数:{}",ip,getOnLineCount());
	}

	/**
	 * 当服务器接收到客户端发送的消息时所调用的方法,与前台页面的onMessage相对应
	 * @param message
	 * @param session
	 */
	@OnMessage
	public void onMessage(String message,Session session){
		//根据业务,自定义逻辑实现
		LOGGER.info("收到客户端的消息:{}",message);
	}

	/**
	 * 发生错误时调用,与前台页面的onError相对应
	 * @param session
	 * @param e
	 */
	@OnError
	public void onError(Session session,Throwable e){
		LOGGER.error("WebSocket发生错误",e);
	}


	/**
	 * 给当前用户发送消息
	 * @param message
	 */
	public void sendMessage(String message){
		try{
			//getBasicRemote()是同步发送消息,这里我就用这个了，推荐大家使用getAsyncRemote()异步
			this.session.getBasicRemote().sendText(message);
		}catch (IOException e){
			LOGGER.error("WebSocket发生错误",e);
			LOGGER.error("发送数据错误:,ip:{},message:{}",ip,message);
		}
	}

	/**
	 * 给所有用户发消息
	 * @param message
	 */
	public static void sendMessageAll(final String message){
		//使用entrySet而不是用keySet的原因是,entrySet体现了map的映射关系,遍历获取数据更快。
		Set<Map.Entry<String, WebSocketServer>> entries = webSocketMap.entrySet();
		for (Map.Entry<String, WebSocketServer> entry : entries) {
			final WebSocketServer webSocketServer = entry.getValue();
			//这里使用线程来控制消息的发送,这样效率更高。
			new Thread(()->webSocketServer.sendMessage(message)).start();
		}
	}

	/**
	 * 获取当前的连接数
	 * @return
	 */
	public static synchronized int getOnLineCount(){
		return WebSocketServer.onLineCount;
	}

	/**
	 * 有新的用户连接时,连接数自加1
	 */
	public static synchronized void addOnLineCount(){
		WebSocketServer.onLineCount++;
	}

	/**
	 * 断开连接时,连接数自减1
	 */
	public static synchronized void subOnLineCount(){
		WebSocketServer.onLineCount--;
	}

	/**
	 * Gets the value of webSocketMap
	 *
	 * @return the value of webSocketMap
	 */
	public static ConcurrentMap<String, WebSocketServer> getWebSocketMap() {
		return webSocketMap;
	}

	/**
	 * Sets the webSocketMap
	 * <p>You can use getWebSocketMap() to get the value of webSocketMap</p>
	 *
	 * @param webSocketMap webSocketMap
	 */
	public static void setWebSocketMap(ConcurrentMap<String, WebSocketServer> webSocketMap) {
		WebSocketServer.webSocketMap = webSocketMap;
	}

	/**
	 * Gets the value of session
	 *
	 * @return the value of session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * Sets the session
	 * <p>You can use getSession() to get the value of session</p>
	 *
	 * @param session session
	 */
	public void setSession(Session session) {
		this.session = session;
	}
}


