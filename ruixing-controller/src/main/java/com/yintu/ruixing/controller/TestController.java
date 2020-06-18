package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.websocket.WebSocketBrowserServer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/1 16:06
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @PostMapping("/baojing")
    public Map<String, Object> test(@RequestBody JSONObject jsonObject) throws IOException {
        Map<String, Session> webSocketServers = WebSocketBrowserServer.webSocketClientSession;
        for (String s : webSocketServers.keySet()) {
            webSocketServers.get(s).getBasicRemote().sendText(jsonObject.toString());
        }
        return ResponseDataUtil.ok("提交成功");
    }
}
