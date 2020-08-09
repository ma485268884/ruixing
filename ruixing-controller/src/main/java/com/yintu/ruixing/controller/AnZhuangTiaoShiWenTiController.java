package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.AnZhuangTiaoShiWenTiEntity;
import com.yintu.ruixing.service.AnZhuangTiaoShiWenTiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author Mr.liu
 * @Date 2020/8/9 10:29
 * @Version 1.0
 * 需求:
 */
@RestController
@RequestMapping("/wenTiAll")
public class AnZhuangTiaoShiWenTiController {
    @Autowired
    private AnZhuangTiaoShiWenTiService anZhuangTiaoShiWenTiService;

    //新增问题
    @PostMapping("/addWenTi")
    public Map<String, Object> addWenTi(AnZhuangTiaoShiWenTiEntity anZhuangTiaoShiWenTiEntity) {
        anZhuangTiaoShiWenTiService.addWenTi(anZhuangTiaoShiWenTiEntity);
        return ResponseDataUtil.ok("新增问题成功");
    }

    //根据id 编辑问题
    @PutMapping("/editWenTiById/{id}")
    public Map<String,Object>editWenTiById(@PathVariable Integer id,AnZhuangTiaoShiWenTiEntity anZhuangTiaoShiWenTiEntity){
        anZhuangTiaoShiWenTiService.editWenTiById(anZhuangTiaoShiWenTiEntity);
        return ResponseDataUtil.ok("编辑问题成功");
    }

    //初始化页面   或者根据线段名 或问题描述查询数据
    @GetMapping("/findSomeWenTi")
    public Map<String,Object>findSomeWenTi(Integer page,Integer size,String xdname,String wenTiMiaoShu){
        PageHelper.startPage(page,size);
        List<AnZhuangTiaoShiWenTiEntity>wenTiEntityList=anZhuangTiaoShiWenTiService.findSomeWenTi(page,size,xdname,wenTiMiaoShu);
        PageInfo<AnZhuangTiaoShiWenTiEntity>wenTiEntityPageInfo=new PageInfo<>(wenTiEntityList);
        return ResponseDataUtil.ok("查询成功",wenTiEntityPageInfo);
    }

    //批量删除  或者单个删除
    @DeleteMapping("/deleteWenTiByIds/{ids}")
    public Map<String,Object>deleteWenTiByIds(@PathVariable Integer[] ids){
        anZhuangTiaoShiWenTiService.deleteWenTiByIds(ids);
        return ResponseDataUtil.ok("删除成功");
    }


    ////////////////////////文件/////////////////////////////


}
