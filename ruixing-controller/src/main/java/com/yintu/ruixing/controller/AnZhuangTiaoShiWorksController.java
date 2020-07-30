package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.AnZhuangTiaoShiCheZhanEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiWorksCheZhanEntity;
import com.yintu.ruixing.service.AnZhuangTiaoShiWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author Mr.liu
 * @Date 2020/7/27 19:36
 * @Version 1.0
 * 需求:安装调试现场作业
 */
@RestController
@RequestMapping("/AnZhuangTiaoShiWorksAll")
public class AnZhuangTiaoShiWorksController {
    @Autowired
    private AnZhuangTiaoShiWorksService anZhuangTiaoShiWorksService;

    //新增车站
    @PostMapping("/addWorksCheZhan")
    public Map<String,Object>addWorksCheZhan(AnZhuangTiaoShiWorksCheZhanEntity anZhuangTiaoShiWorksCheZhanEntity,String[] chezhanname){
        anZhuangTiaoShiWorksService.addWorksCheZhan(anZhuangTiaoShiWorksCheZhanEntity,chezhanname);
        return ResponseDataUtil.ok("新增车站成功");
    }

    //根据线段id  批量编辑对应的车站数据
    @PutMapping("/editWorksCheZhanByXid/{xid}")
    public Map<String,Object>editWorksCheZhanByXid(@PathVariable Integer xid,AnZhuangTiaoShiWorksCheZhanEntity anZhuangTiaoShiWorksCheZhanEntity){
        anZhuangTiaoShiWorksService.editWorksCheZhanByXid(anZhuangTiaoShiWorksCheZhanEntity);
        return ResponseDataUtil.error("编辑成功");
    }

    //根据线段id 查询对应的车站
    @GetMapping("/findCheZhanByXid/{xid}")
    public Map<String,Object>findCheZhanByXid(@PathVariable Integer xid){
        List<AnZhuangTiaoShiCheZhanEntity>cheZhanEntities=anZhuangTiaoShiWorksService.findCheZhanByXid(xid);
        return ResponseDataUtil.ok("查询对应车站成功",cheZhanEntities);
    }

    //
}
