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
public class DataReceiveController extends SessionController {
    @Autowired
    private QuDuanDownloadService quDuanDownloadService;
    @Autowired
    private WebSocketServer webSocketServer;

    @PostMapping("/data/receives")
    public Map<String, Object> changeDataStatus(@RequestParam("czId") Integer czId, @RequestParam("dataStatus") Short dataStatus) {
        Integer id = quDuanDownloadService.changeDataStatus(czId, this.getLoginUserId().intValue(), dataStatus);
        webSocketServer.sendMessage(czId, id);
        return ResponseDataUtil.ok("改变数据接收状态成功");
    }

    @PostMapping("/data/switchs")
    public Map<String, Object> changeSwitchStatus(@RequestParam("czId") Integer czId, @RequestParam("switchStatus") Short switchStatus) {
        quDuanDownloadService.changeSwitchStatus(czId, this.getLoginUserId().intValue(), switchStatus);
        return ResponseDataUtil.ok("改变防呆开关状态成功");
    }

    @PostMapping("/data/update/time")
    public Map<String, Object> changeUpdateTime(@RequestParam("czId") Integer czId) {
        Short switchStatus = quDuanDownloadService.changeUpdateTime(czId, this.getLoginUserId().intValue());
        return ResponseDataUtil.ok("改变更新时间成功", switchStatus);
    }

}
