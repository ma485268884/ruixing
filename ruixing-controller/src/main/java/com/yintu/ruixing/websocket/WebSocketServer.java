package com.yintu.ruixing.websocket;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.yintu.ruixing.common.util.SpringContextUtil;
import com.yintu.ruixing.service.QuDuanDownloadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:mlf
 * @date:2020/6/1 14:00
 */

@Component
@ServerEndpoint("/websocket")
public class WebSocketServer {
    private final static Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
    /**
     * 存放不同连接的回话信息以及额外的信息
     */
    public static Map<String, SessionInfo> webSocketSession = new ConcurrentHashMap<>();

    public WebSocketServer() {
        logger.info("WebSocketBrowserServer初始化.......");
    }

    @OnOpen
    public void onOpen(Session session) {
        logger.info("onOpen..............");
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.setSession(session);
        webSocketSession.put(session.getId(), sessionInfo);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        logger.info("onClose..............");
        String sessionId = session.getId();
        SessionInfo sessionInfo = webSocketSession.get(sessionId);
        if (sessionInfo != null && sessionInfo.getSession() != null) {
            try {
                sessionInfo.getSession().close();
            } catch (IOException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            } finally {
                webSocketSession.remove(session.getId());
            }
        }

    }

    /**
     * @param session 每个会话
     * @param error   错误信息
     */
    @OnError
    public void onError(Session session, Throwable error) {
        logger.error("onError.................错误消息：" + error.getMessage());
    }


    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(Session session, String message) {
        String sessionId = session.getId();
        SessionInfo sessionInfo = webSocketSession.get(sessionId);

        JSONObject jo = JSONObject.parseObject(message);
        Integer stationId = jo.getInteger("stationId");
        if (sessionInfo != null) {
            sessionInfo.setCid(stationId);
        }

    }

    /**
     * @param sessionInfo 标识信息
     * @param taskId      任务id
     */
    public void sendMessage(SessionInfo sessionInfo, Integer taskId) {
        for (String sessionId : webSocketSession.keySet()) {
            SessionInfo s = webSocketSession.get(sessionId);
            if (s != null && s.getCid() != null && s.getCid().equals(sessionInfo.getCid())) {
                Session session = s.getSession();
                if (session != null && session.isOpen()) {
                    try {
                        JSONObject jo = new JSONObject();
                        jo.put("taskId", taskId);
                        session.getBasicRemote().sendText(jo.toJSONString());
                    } catch (IOException e) {
                        logger.error(e.getMessage());
                    }
                }

            }
        }
    }


}
