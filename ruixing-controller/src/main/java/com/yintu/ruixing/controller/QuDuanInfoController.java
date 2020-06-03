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

}
