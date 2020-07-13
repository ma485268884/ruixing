package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.AnZhuangTiaoShiCheZhanXiangMuTypeEntity;
import com.yintu.ruixing.service.AnZhuangTiaoShiCheZhanXiangMuTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author Mr.liu
 * @Date 2020/7/11 17:38
 * @Version 1.0
 * 需求:安装调试项目类型
 */
@RestController
@RequestMapping("/AnZhuangTiaoShiCheZhanXiangMuTypeAll")
public class AnZhuangTiaoShiCheZhanXiangMuTypeController {
    @Autowired
    private AnZhuangTiaoShiCheZhanXiangMuTypeService anZhuangTiaoShiCheZhanXiangMuTypeService;

    //新增项目类型
    @PostMapping("/addXiangMuType")
    public Map<String,Object>addXiangMuType(AnZhuangTiaoShiCheZhanXiangMuTypeEntity anZhuangTiaoShiCheZhanXiangMuTypeEntity){
        anZhuangTiaoShiCheZhanXiangMuTypeService.addXiangMuType(anZhuangTiaoShiCheZhanXiangMuTypeEntity);
        return ResponseDataUtil.ok("添加项目类型成功");
    }
}
