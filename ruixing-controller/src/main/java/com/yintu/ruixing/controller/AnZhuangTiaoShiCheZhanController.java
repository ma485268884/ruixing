package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.AnZhuangTiaoShiCheZhanEntity;
import com.yintu.ruixing.service.AnZhuangTiaoShiCheZhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author Mr.liu
 * @Date 2020/7/11 16:46
 * @Version 1.0
 * 需求:安装调试的车站
 */
@RestController
@RequestMapping("/AnZhuangTiaoShiCheZhanAll")
public class AnZhuangTiaoShiCheZhanController {
    @Autowired
    private AnZhuangTiaoShiCheZhanService anZhuangTiaoShiCheZhanService;

    //在线段  下面添加车站信息
    @PostMapping("addCheZhan")
    public Map<String,Object>addCheZhan(AnZhuangTiaoShiCheZhanEntity anZhuangTiaoShiCheZhanEntity){
        anZhuangTiaoShiCheZhanService.addCheZhan(anZhuangTiaoShiCheZhanEntity);
        return ResponseDataUtil.ok("添加车站信息成功");
    }

}
