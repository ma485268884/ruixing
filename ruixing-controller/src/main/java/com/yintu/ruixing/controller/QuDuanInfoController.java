package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.QuDuanInfoEntity;
import com.yintu.ruixing.service.QuDuanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/3 12:00
 */
@RestController
@RequestMapping("/quduans")
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

    @GetMapping("/realreport")
    public Map<String, Object> findAll(@RequestParam("type") Integer selectType) {
        List<Map<String, Object>> maps = new ArrayList<>();
        switch (selectType) {
            case 1:
                maps = quDuanInfoService.findSongDuanAll();
                break;
            case 2:
                maps = quDuanInfoService.findFenXianPanSongDuanAll();
                break;
            case 3:
                maps = quDuanInfoService.findFenXianPanShouDuanAll();
                break;
            case 4:
                maps = quDuanInfoService.findShouDuanAll();
                break;
            case 5:
                maps = quDuanInfoService.findSongDuanTransformerAll();
                break;
            case 6:
                maps = quDuanInfoService.findSongDuanTuneAll();
                break;
            case 7:
                maps = quDuanInfoService.findShouDuanTuneAll();
                break;
            case 8:
                maps = quDuanInfoService.findShouDuanTransformerAll();
                break;
            default:
                break;
        }
        return ResponseDataUtil.ok("查询区段列表成功", maps);
    }

    @GetMapping("/dailypaper")
    public Map<String, Object> findStatisticsSongDuanByDate(@RequestParam("type") Integer selectType, @RequestParam("time") Date time) {
        List<Map<String, Object>> maps = new ArrayList<>();
        switch (selectType) {
            case 1:
                maps = quDuanInfoService.findStatisticsSongDuanByDate(time);
                break;
            case 2:
                maps = quDuanInfoService.findStatisticsFenXianPanSongDuanByDate(time);
                break;
            case 3:
                maps = quDuanInfoService.findStatisticsFenXianPanShouDuanByDate(time);
                break;
            case 4:
                maps = quDuanInfoService.findStatisticsShouDuanByDate(time);
                break;
            default:
                break;
        }
        return ResponseDataUtil.ok("查询区段统计列表成功", maps);
    }


}
