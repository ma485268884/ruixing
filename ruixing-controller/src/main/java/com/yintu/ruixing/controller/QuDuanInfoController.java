package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.QuDuanInfoEntity;
import com.yintu.ruixing.service.QuDuanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/3 12:00
 */
@RestController
@RequestMapping("/quduaninfo")
public class QuDuanInfoController extends BaseController {
    @Autowired
    private QuDuanInfoService quDuanInfoService;

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Integer id) {
        QuDuanInfoEntity quDuanInfoEntity = quDuanInfoService.findById(id);
        return ResponseDataUtil.ok("查询区段成功", quDuanInfoEntity);
    }

    @GetMapping("/{cid}/{xid}")
    public Map<String, Object> findByCidAndXid(@PathVariable("cid") Integer cid, @PathVariable("xid") Integer xid) {
        List<QuDuanInfoEntity> quDuanInfoEntities = quDuanInfoService.findByCidAndXid(cid, xid);
        return ResponseDataUtil.ok("查询区段列表成功", quDuanInfoEntities);
    }



    @GetMapping("/songduan")
    public Map<String, Object> findSongDuanAll() {
        List<Map<String, Object>> maps = quDuanInfoService.findSongDuanAll();
        return ResponseDataUtil.ok("查询区段列表成功", maps);
    }

    @GetMapping("/fenxianpansongduan")
    public Map<String, Object> findFenXianPanSongDuanAll() {
        List<Map<String, Object>> maps = quDuanInfoService.findFenXianPanSongDuanAll();
        return ResponseDataUtil.ok("查询区段列表成功", maps);
    }

    @GetMapping("/fenxianpanshouduan")
    public Map<String, Object> findFenXianPanShouDuanAll() {
        List<Map<String, Object>> maps = quDuanInfoService.findFenXianPanShouDuanAll();
        return ResponseDataUtil.ok("查询区段列表成功", maps);
    }

    @GetMapping("/shouduan")
    public Map<String, Object> findShouDuanAll() {
        List<Map<String, Object>> maps = quDuanInfoService.findShouDuanAll();
        return ResponseDataUtil.ok("查询区段列表成功", maps);
    }



    @GetMapping("/songduantransformer")
    public Map<String, Object> findSongDuanTransformerAll() {
        List<Map<String, Object>> maps = quDuanInfoService.findSongDuanTransformerAll();
        return ResponseDataUtil.ok("查询区段列表成功", maps);
    }

    @GetMapping("/songduantune")
    public Map<String, Object> findSongDuanTuneAll() {
        List<Map<String, Object>> maps = quDuanInfoService.findSongDuanTuneAll();
        return ResponseDataUtil.ok("查询区段列表成功", maps);
    }

    @GetMapping("/shouduantune")
    public Map<String, Object> findShouDuanTuneAll() {
        List<Map<String, Object>> maps = quDuanInfoService.findShouDuanTuneAll();
        return ResponseDataUtil.ok("查询区段列表成功", maps);
    }
    @GetMapping("/shouduantransformer")
    public Map<String, Object> findShouDuanTransformerAll() {
        List<Map<String, Object>> maps = quDuanInfoService.findShouDuanTransformerAll();
        return ResponseDataUtil.ok("查询区段列表成功", maps);
    }


}
