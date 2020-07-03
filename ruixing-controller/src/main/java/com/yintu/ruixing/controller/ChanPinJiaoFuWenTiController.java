package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.ChanPinJiaoFuWenTiEntity;
import com.yintu.ruixing.entity.DepartmentEntity;
import com.yintu.ruixing.service.ChanPinJiaoFuWenTiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author Mr.liu
 * @Date 2020/7/3 20:39
 * @Version 1.0
 * 需求:产品交付的问题反馈
 */
@RestController
@RequestMapping("/chanPinJiaoFuWenTiAll")
public class ChanPinJiaoFuWenTiController {
    @Autowired
    private ChanPinJiaoFuWenTiService chanPinJiaoFuWenTiService;


    //查询所有的数据
    @GetMapping("/findAllData")
    public Map<String,Object>findAllData(Integer page,Integer size){
        PageHelper.startPage(page,size);
        List<ChanPinJiaoFuWenTiEntity> chanPinJiaoFuWenTiEntities=chanPinJiaoFuWenTiService.findAllData(page,size);
        PageInfo<ChanPinJiaoFuWenTiEntity> pageInfo=new PageInfo<>(chanPinJiaoFuWenTiEntities);
        return ResponseDataUtil.ok("查询数据成功",pageInfo);
    }
    //查询所有的部门
    @GetMapping("/findAllDepartment")
    public Map<String,Object>findAllDepartment(){
        List<DepartmentEntity> departmentEntities=chanPinJiaoFuWenTiService.findAllDepartment();
        return ResponseDataUtil.ok("查询部门成功",departmentEntities);
    }
    //新增问题
    @PostMapping("/addWenTi")
    public Map<String,Object>addWenTi(ChanPinJiaoFuWenTiEntity chanPinJiaoFuWenTiEntity){
        chanPinJiaoFuWenTiService.addWenTi(chanPinJiaoFuWenTiEntity);
        return ResponseDataUtil.ok("新增问题成功");
    }
    //根据id  编辑问题
    @PutMapping("/editWenTiById/{id}")
    public Map<String,Object>editWenTiById(@PathVariable Integer id,ChanPinJiaoFuWenTiEntity chanPinJiaoFuWenTiEntity){
        chanPinJiaoFuWenTiService.editWenTiById(chanPinJiaoFuWenTiEntity);
        return ResponseDataUtil.ok("新增问题成功");
    }

    //根据项目名称  进行模糊查询
    @GetMapping("/findWenTiByName")
    public Map<String,Object>findWenTiByName(String xiangMuName,Integer page,Integer size){
        PageHelper.startPage(page,size);
        List<ChanPinJiaoFuWenTiEntity> chanPinJiaoFuWenTiEntities=chanPinJiaoFuWenTiService.findWenTiByName(xiangMuName,page,size);
        PageInfo<ChanPinJiaoFuWenTiEntity> pageInfo=new PageInfo<>(chanPinJiaoFuWenTiEntities);
        return ResponseDataUtil.ok("查询成功",pageInfo);
    }

    //根据id  进行单个或者批量删除
    @DeleteMapping("/deletWenTiByIds/{ids}")
    public Map<String,Object>deletWenTiByIds(@PathVariable Integer[] ids){
        chanPinJiaoFuWenTiService.deletWenTiByIds(ids);
        return ResponseDataUtil.ok("删除数据成功");
    }
}
