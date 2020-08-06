package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.AnZhuangTiaoShiTrainEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiXiangMuEntity;
import com.yintu.ruixing.service.AnZhuangTiaoShiTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author Mr.liu
 * @Date 2020/8/4 10:42
 * @Version 1.0
 * 需求:安装调试 培训管理
 */
@RestController
@RequestMapping("/TrainAll")
public class AnZhuangTiaoShiTrainController {
    @Autowired
    private AnZhuangTiaoShiTrainService anZhuangTiaoShiTrainService;

    //查询对应的线段名
    @GetMapping("/findXianDuan")
    public Map<String,Object>findXianDuan(){
        List<AnZhuangTiaoShiXiangMuEntity>xiangMuEntityList=anZhuangTiaoShiTrainService.findXianDuan();
        return ResponseDataUtil.ok("查询线段成功",xiangMuEntityList);
    }

    //新增培训数据
    @PostMapping("/addTrain")
    public Map<String,Object>addTrain(AnZhuangTiaoShiTrainEntity anZhuangTiaoShiTrainEntity){
        anZhuangTiaoShiTrainService.addTrain(anZhuangTiaoShiTrainEntity);
        return ResponseDataUtil.ok("新增培训成功");
    }

    //根据id 编辑对应的培训数据
    @PutMapping("/editTrainById/{id}")
    public Map<String,Object>editTrainById(@PathVariable Integer id,AnZhuangTiaoShiTrainEntity anZhuangTiaoShiTrainEntity){
        anZhuangTiaoShiTrainService.editTrainById(anZhuangTiaoShiTrainEntity);
        return ResponseDataUtil.ok("编辑培训成功");
    }
    //根据线段名  或者顾客名进行模糊查询 也是初始化页面
    @GetMapping("/findAllTrain")
    public Map<String,Object>findAllTrain(Integer page, Integer size, String xdName,String customer){
        PageHelper.startPage(page,size);
        List<AnZhuangTiaoShiTrainEntity> trainEntityList=anZhuangTiaoShiTrainService.findAllTrain(page,size,xdName,customer);
        PageInfo<AnZhuangTiaoShiTrainEntity> trainEntityPageInfo=new PageInfo<>(trainEntityList);
        return ResponseDataUtil.ok("查询成功",trainEntityPageInfo);
    }
}
