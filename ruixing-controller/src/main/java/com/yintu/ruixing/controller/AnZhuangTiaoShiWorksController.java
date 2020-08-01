package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.*;
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
        return ResponseDataUtil.ok("编辑成功");
    }

    //根据线段id 查询对应的车站
    @GetMapping("/findCheZhanByXid/{xid}")
    public Map<String,Object>findCheZhanByXid(@PathVariable Integer xid){
        List<AnZhuangTiaoShiCheZhanEntity>cheZhanEntities=anZhuangTiaoShiWorksService.findCheZhanByXid(xid);
        return ResponseDataUtil.ok("查询对应车站成功",cheZhanEntities);
    }

    //根据线段id  查询对应的车站数据
    @GetMapping("findCheZhanDatasByXid/{xid}")
    public Map<String,Object>findCheZhanDatasByXid(@PathVariable Integer xid,Integer page,Integer size){
        PageHelper.startPage(page,size);
        List<AnZhuangTiaoShiWorksCheZhanEntity>cheZhanEntities=anZhuangTiaoShiWorksService.findCheZhanDatasByXid(xid,page,size);
        PageInfo<AnZhuangTiaoShiWorksCheZhanEntity> cheZhanEntityPageInfo=new PageInfo<>(cheZhanEntities);
        return ResponseDataUtil.ok("查询对应的车站信息成功",cheZhanEntityPageInfo);
    }

    //根据车站id  查询对应的数据
    @GetMapping("/findWorksDatasByCid/{cid}")
    public Map<String,Object>findWorksDatasByCid(@PathVariable Integer cid,Integer page,Integer size){
        PageHelper.startPage(page,size);
        List<AnZhuangTiaoShiWorkNameLibraryEntity> libraryEntityList=anZhuangTiaoShiWorksService.findWorksDatasByCid(cid,page,size);
        PageInfo<AnZhuangTiaoShiWorkNameLibraryEntity> libraryEntityPageInfo=new PageInfo<>(libraryEntityList);
        return ResponseDataUtil.ok("查询对应的作业项数据成功",libraryEntityPageInfo);
    }

    //对车站下的作业项 进行编辑
    @PostMapping("/addWorksDatas")
    public Map<String,Object>addWorksDatas(AnZhuangTiaoShiWorksDingEntity anZhuangTiaoShiWorksDingEntity){
        anZhuangTiaoShiWorksService.addWorksDatas(anZhuangTiaoShiWorksDingEntity);
        return ResponseDataUtil.ok("编辑成功");
    }

    //自动显示登录人的名字
    @GetMapping("/findWorker")
    public Map<String,Object>findWorker(){
        SessionController sessionController=new SessionController();
        String username = sessionController.getLoginUser().getUsername();
        return ResponseDataUtil.ok("查询姓名成功",username);
    }

    //查询所有的作业项配置版本
    @GetMapping("/findAllWorks")
    public Map<String,Object>findAllWorks(){
        List<AnZhuangTiaoShiWorkNameTotalEntity> workNameTotalEntityList=anZhuangTiaoShiWorksService.findAllWorks();
        return ResponseDataUtil.ok("查询所有的版本数据成功",workNameTotalEntityList);
    }
}
