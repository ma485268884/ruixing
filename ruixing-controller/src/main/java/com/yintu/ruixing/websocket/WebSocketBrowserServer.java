package com.yintu.ruixing.websocket;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/1 14:00
 */

@Component
@ServerEndpoint("/websocket/browser")
public class WebSocketBrowserServer {
    private final static Logger logger = LoggerFactory.getLogger(WebSocketBrowserServer.class);

    public static Map<String, Session> webSocketClientSession = new HashMap<>();

    public WebSocketBrowserServer() {
        logger.info("WebSocketBrowserServer初始化.......");
    }

    @OnOpen
    public void onOpen(Session session) {
        logger.info("onOpen.............." + session);
        webSocketClientSession.put(session.getId(), session);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        logger.info("onClose.............." + session);
        webSocketClientSession.remove(session.getId());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(Session session, String message) {
        logger.info("onMessage..............." + session);
        logger.info("onMessage................原始数据：" + message);
        JSONObject jo = JSONObject.parseObject(message);
    }

    /**
     * @param session 每个会话
     * @param error   错误信息
     */
    @OnError
    public void onError(Session session, Throwable error) {
        logger.error("onError.............." + session);
        logger.error("onError.................错误消息：" + error.getMessage());
    }

    public void sendMessage(JSONObject jsonObject, Session session) {
        try {
            session.getBasicRemote().sendText(jsonObject.toJSONString());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

}
