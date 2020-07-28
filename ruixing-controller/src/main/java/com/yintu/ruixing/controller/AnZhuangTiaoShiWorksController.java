package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.AnZhuangTiaoShiWorksCheZhanEntity;
import com.yintu.ruixing.service.AnZhuangTiaoShiWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //根据
}
