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
 * @date:2020/6/18 15:53
 */

@Component
@ServerEndpoint("/websocket/quduans/add")
public class WebSocketClientServer {
    private final static Logger logger = LoggerFactory.getLogger(WebSocketClientServer.class);
    //当前数据浏览器会话
    private static Session session;

    public WebSocketClientServer() {
        logger.info("WebSocketClientServer.......");
    }

    @OnOpen
    public void onOpen(Session session) {
        WebSocketClientServer.session = session;
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        try {
            WebSocketClientServer.session.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message) {
        logger.info("onMessage................原始数据：" + message);
        JSONObject jo = JSONObject.parseObject(message);
        Integer id = jo.getInteger("id");

    }

    /**
     * @param error 错误信息
     */
    @OnError
    public void onError(Throwable error) {
        logger.error("onError.................错误消息：" + error.getMessage());
        try {
            WebSocketClientServer.session.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public void sendMessage(JSONObject jsonObject) {
        try {
            WebSocketClientServer.session.getBasicRemote().sendText(jsonObject.toJSONString());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

}
