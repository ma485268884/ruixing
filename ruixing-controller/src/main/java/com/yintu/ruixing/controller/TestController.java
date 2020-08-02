package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.yintu.ruixing.common.util.FileUploadUtil;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.common.util.VerificationCode;
import com.yintu.ruixing.entity.UserEntity;
import com.yintu.ruixing.service.UserService;
import com.yintu.ruixing.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:mlf
 * @date:2020/6/1 16:06
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService;
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

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

    @PostMapping("/test3")
    @ResponseBody
    public Map<String, Object> test3(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        String filePath = FileUploadUtil.save(multipartFile.getInputStream(), fileName);
        JSONObject jo = new JSONObject();
        jo.put("filePath", request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/files" +
                "/" + filePath.substring(1, filePath.length()) + "/" + fileName);
        jo.put("fileName", fileName);
        return ResponseDataUtil.ok("上传售前技术支持文件信息成功", jo);
    }

    @GetMapping("/test4")
    public void test4(HttpServletResponse response) throws IOException {
        String fileName = "图片测试";
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        FileUploadUtil.get(response.getOutputStream(), "\\eade425b-b299-451f-b8bb-3ad7599e7fc0\\01.jpg");
    }

    @GetMapping("/test5")
    public void test5() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            executorService.submit(() -> {
                synchronized (TestController.class) {
                    List<UserEntity> userEntities = userService.findByTruename("马葳严");
                    if (userEntities.isEmpty()) {
                        UserEntity userEntity = new UserEntity();
                        userEntity.setUsername("1111");
                        userEntity.setPassword("123456");
                        userEntity.setTrueName("马葳严");
                        userEntity.setIsCustomer((short) 0);
                        userEntity.setEnableds((short) 1);
                        userService.add(userEntity);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        Thread.sleep(10000);
    }

    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        HttpSession session = request.getSession(true);
        session.setAttribute("verify_code", text);
        VerificationCode.output(image, resp.getOutputStream());
    }

    @GetMapping("/test6")
    @ResponseBody
    public Map<String, Object> test6(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        JSONObject jo = new JSONObject();
        jo.put("getRequestURI", request.getRequestURI());
        jo.put("getContextPath", request.getContextPath());
        jo.put("getServletPath", request.getServletPath());
        jo.put("getPathInfo", request.getPathInfo());
        jo.put("getRequestURL", request.getRequestURL());
        jo.put("getRequestedSessionId", request.getRequestedSessionId());
        return ResponseDataUtil.ok("上传售前技术支持文件信息成功", jo);
    }


}
