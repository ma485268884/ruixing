package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.QuDuanInfoEntity;
import com.yintu.ruixing.service.QuDuanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 实时报表
     *
     * @param pageNumber 页码
     * @param pageSize   页数
     * @return
     */
    @GetMapping("/realreport")
    public Map<String, Object> findAll(@RequestParam(value = "page_number") Integer pageNumber,
                                       @RequestParam(value = "page_size") Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<QuDuanInfoEntity> quDuanInfoEntities = quDuanInfoService.findAll();
        PageInfo<QuDuanInfoEntity> pageInfo = new PageInfo<>(quDuanInfoEntities);
        return ResponseDataUtil.ok("查询实时报表成功", pageInfo);
    }

    /**
     * 日报
     *
     * @param pageNumber 页码
     * @param pageSize   页数
     * @param time       日期
     * @return
     */
    @GetMapping("/dailypaper")
    public Map<String, Object> findStatisticsByDate(@RequestParam(value = "page_number") Integer pageNumber,
                                                    @RequestParam(value = "page_size") Integer pageSize,
                                                    @RequestParam("time") Date time) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Map<String, Object>> maps = quDuanInfoService.findStatisticsByDate(time);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(maps);
        return ResponseDataUtil.ok("查询日报表成功", pageInfo);
    }


}
