package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.*;
import com.yintu.ruixing.service.ZhanNeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author:lcy
 * @date:2020-06-06 19
 * 站内相关
 */
@RestController
@RequestMapping("/ZhanNei")
public class ZhanNeiController {

    @Autowired
    private ZhanNeiService zhanNeiService;

    //根据车站id 查询车站内电码化的信息
    @GetMapping("/findAllDianMaHua/{id}")
    public Map<String, Object> findAllDianMaHua(@PathVariable Long id) {
        List<QuDuanBaseEntity> list = new ArrayList<>();
        List<QuDuanBaseEntity> quDuanBaseEntities = zhanNeiService.findAllDianMaHua(id);
        //System.out.println("111111" + quDuanBaseEntities);
        for (QuDuanBaseEntity quDuanBaseEntity : quDuanBaseEntities) {
            if (quDuanBaseEntity.getDianmahuaguihao() != null && quDuanBaseEntity.getDianmahuaguihao() != "") {
                list.add(quDuanBaseEntity);
            }
        }
        return ResponseDataUtil.ok("查询电码化数据成功", list);
    }

    //根据电码化的区段id查询出数据展示在列表
    @GetMapping("/findDianMaHuaDatabById/{id}")
    public Map<String,Object>findDianMaHuaDatabById(@PathVariable Integer id){
        List<QuDuanInfoEntity> quDuanInfoEntities=zhanNeiService.findDianMaHuaDatabById(id);
        return ResponseDataUtil.ok("查询单单个数据成功",quDuanInfoEntities);
    }

    //网络连接
    @GetMapping("/findAllWangLuoLianJie")
    public Map<String, Object> findAllWangLuoLianJie(Integer page, Integer size) {
        JSONObject js = new JSONObject();
        //PageHelper.startPage(page, size);
        List<CheZhanEntity> cheZhanEntities = zhanNeiService.findAllWangLuoLianJie();
        js.put("cheZhanEntities",cheZhanEntities);
        System.out.println("车站信息1" + cheZhanEntities);
        PageHelper.startPage(page, size);
        List<CheZhanEntity> all = zhanNeiService.findTieLuJuById( page, size);
        PageInfo<CheZhanEntity> pageInfo = new PageInfo<>(all);
        System.out.println("车站信息2" + pageInfo);
        js.put("pageInfo", pageInfo);
        System.out.println("pageeee" + pageInfo);
        return ResponseDataUtil.ok("查询车站信息成功", js);
    }
    //根据id更改车站的各个状态
    @PutMapping("/editWangLuoLianJieById/{cid}")
    public Map<String, Object> editWangLuoLianJieById(@PathVariable Long cid, CheZhanEntity cheZhanEntity) {
        System.out.println("1111"+cheZhanEntity);
        zhanNeiService.editWangLuoLianJieById(cheZhanEntity);
        System.out.println("22222"+cheZhanEntity);
        return ResponseDataUtil.ok("修改信息成功");
    }


}
