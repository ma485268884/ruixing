package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.service.QuDuanDownloadService;
import com.yintu.ruixing.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author:mlf
 * @date:2020/8/3 20:25
 */
@RestController
@RequestMapping("/data/receives")
public class DataReceiveController extends SessionController {
    @Autowired
    private QuDuanDownloadService quDuanDownloadService;
    @Autowired
    private WebSocketServer webSocketServer;

    @PostMapping
    public Map<String, Object> changeDataStatus(@RequestParam("czId") Integer czId, @RequestParam("dataStatus") Short dataStatus) {
        Integer id = quDuanDownloadService.changeDataStatus(czId, dataStatus);
        webSocketServer.sendMessage(czId, id);
        return ResponseDataUtil.ok("改变数据接收状态成功");
    }

}
