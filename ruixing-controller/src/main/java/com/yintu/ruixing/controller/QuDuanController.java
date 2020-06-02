package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.service.QuDuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/2 17:54
 */
@RestController
@RequestMapping("/quduan")
public class QuDuanController extends BaseController {
    @Autowired
    private QuDuanService quDuanService;

    @GetMapping("/{cid}/{xid}")
    public Map<String, Object> findByCidAndXid(@PathVariable("cid") Integer cid, @PathVariable("xid") Integer xid) {
        Map<String, List<?>> map = quDuanService.findAll(cid, xid);
        return ResponseDataUtil.ok("查询部门树成功", map);
    }


}
