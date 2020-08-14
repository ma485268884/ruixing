package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.PaiGongGuanLiBusinessTypeEntity;
import com.yintu.ruixing.service.PaiGongGuanLiBusinessTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author Mr.liu
 * @Date 2020/8/14 15:17
 * @Version 1.0
 * 需求:派工管理 任务类型
 */
@RestController
@RequestMapping("/BusinessTypeaAll")
public class PaiGongGuanLiBusinessTypeController {
    @Autowired
    private PaiGongGuanLiBusinessTypeService paiGongGuanLiBusinessTypeService;

    //新增任务类型
    @PostMapping("/addBusinessType")
    public Map<String,Object>addBusinessType(PaiGongGuanLiBusinessTypeEntity paiGongGuanLiBusinessTypeEntity){
        paiGongGuanLiBusinessTypeService.addBusinessType(paiGongGuanLiBusinessTypeEntity);
        return ResponseDataUtil.ok("新增任务类型成功");
    }

    //根据id  编辑对应的任务类型
    @PutMapping("/editBusinessTypeById/{id}")
    public Map<String,Object>editBusinessTypeById(@PathVariable Integer id,PaiGongGuanLiBusinessTypeEntity paiGongGuanLiBusinessTypeEntity){
        paiGongGuanLiBusinessTypeService.editBusinessTypeById(paiGongGuanLiBusinessTypeEntity);
        return ResponseDataUtil.ok("编辑任务类型成功");
    }

    //初始化页面   或者根据业务类别   或者出差任务查询
    @GetMapping("/findBusinessType")
    public Map<String,Object>findBusinessType(Integer page,Integer size,String typeName,String businessName){
        PageHelper.startPage(page,size);
        List<PaiGongGuanLiBusinessTypeEntity>businessTypeEntityList=paiGongGuanLiBusinessTypeService.findBusinessType(page,size,typeName,businessName);
        PageInfo<PaiGongGuanLiBusinessTypeEntity> businessTypeEntityPageInfo=new PageInfo<>(businessTypeEntityList);
        return ResponseDataUtil.ok("查询任务成功",businessTypeEntityPageInfo);
    }

    //根据id 单独  或者批量删除任务
    @DeleteMapping("/deleteBusinessTypeByIds/{ids}")
    public Map<String,Object>deleteBusinessTypeByIds(@PathVariable Integer[] ids){
        paiGongGuanLiBusinessTypeService.deleteBusinessTypeByIds(ids);
        return ResponseDataUtil.ok("删除任务成功");
    }


}
