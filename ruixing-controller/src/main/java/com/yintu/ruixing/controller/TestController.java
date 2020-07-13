package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.yintu.ruixing.common.util.FileUploadUtil;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.UserEntity;
import com.yintu.ruixing.websocket.WebSocketServer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/1 16:06
 */
@Controller
@RequestMapping("/test")
public class TestController {


    @PostMapping("/test1")
    @ResponseBody
    public Map<String, Object> test1(@RequestBody JSONObject jsonObject) throws IOException {
//        Map<String, Session> webSocketServers = WebSocketServer
//        for (String s : webSocketServers.keySet()) {
//            webSocketServers.get(s).getBasicRemote().sendText(jsonObject.toString());
//        }
        return ResponseDataUtil.ok("提交成功");
    }

    @PostMapping("/test2")
    @ResponseBody
    public Map<String, Object> test2(@RequestBody UserEntity userEntity) throws IOException {
//        Map<String, Session> webSocketServers = WebSocketServer
//        for (String s : webSocketServers.keySet()) {
//            webSocketServers.get(s).getBasicRemote().sendText(jsonObject.toString());
//        }
        return ResponseDataUtil.ok("提交成功");
    }

    @GetMapping("/test3")
    public void test3(HttpServletResponse response) throws IOException {
        String fileName="图片测试";
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        FileUploadUtil.get(response.getOutputStream(), "\\eade425b-b299-451f-b8bb-3ad7599e7fc0\\01.jpg");
    }

}
