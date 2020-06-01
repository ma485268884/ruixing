package com.yintu.ruixing.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author:mlf
 * @date:2020/6/1 14:00
 */

@Component
@ServerEndpoint("/websocket/{name}")
public class WebSocketServer {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    public static Map<String, Session> WebSocketServers = new HashMap<>();


    private final static Logger log = LoggerFactory.getLogger(WebSocketServer.class);

    /**
     * 连接建立成功调用的方法
     */
    public WebSocketServer() {
        System.out.println("初始化！");
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("open:" + session.getId());
        WebSocketServers.put(session.getId(), session); //加入set中
        addOnlineCount();           //在线数加1
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        System.out.println("close:" + session.getId());
        WebSocketServers.remove(session.getId());  //从set中删除
        subOnlineCount();           //在线数减1
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        for (String s : WebSocketServers.keySet()) {
            if (s.equals(session.getId()))
                continue;
            WebSocketServers.get(s).getBasicRemote().sendText(message);
        }
    }


    /**
     * @param session 每个会话
     * @param error   错误信息
     */
    @OnError
    public void onError(Session session, Throwable error) {
    }


    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

}
