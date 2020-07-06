package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.ChanPinJiaoFuCostShouRuEntity;
import com.yintu.ruixing.service.ChanPinJiaoFuCostShouRuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author Mr.liu
 * @Date 2020/7/4 19:38
 * @Version 1.0
 * 需求:产品交付的费用-收入
 */
@RestController
@RequestMapping("/chanPinJiaoFuCostShouRuAll")
public class ChanPinJiaoFuCostShouRuController {
    @Autowired
    private ChanPinJiaoFuCostShouRuService chanPinJiaoFuCostShouRuService;

    //新增收入费用
    @PostMapping("/addShouRuCost")
    public Map<String,Object> addShouRuCost(ChanPinJiaoFuCostShouRuEntity chanPinJiaoFuCostShouRuEntity){
        chanPinJiaoFuCostShouRuService.addShouRuCost(chanPinJiaoFuCostShouRuEntity);
        return ResponseDataUtil.ok("新增收入费用成功");
    }

    //根据id  编辑对应的收入费用
    @PutMapping("/editShouRuCost/{id}")
    public Map<String,Object>editShouRuCost(@PathVariable Integer id, ChanPinJiaoFuCostShouRuEntity chanPinJiaoFuCostShouRuEntity){
        chanPinJiaoFuCostShouRuService.editShouRuCost(chanPinJiaoFuCostShouRuEntity);
        return ResponseDataUtil.ok("编辑收入费用成功");
    }
    //查询所有的收入数据
    @GetMapping("/findAllShouRuCost")
    public Map<String,Object>findAllShouRuCost(Integer page,Integer size){
        PageHelper.startPage(page,size);
        List<ChanPinJiaoFuCostShouRuEntity> chanPinJiaoFuCostShouRuEntities=chanPinJiaoFuCostShouRuService.findAllShouRuCost(page,size);
        PageInfo<ChanPinJiaoFuCostShouRuEntity> pageInfo =new PageInfo<>(chanPinJiaoFuCostShouRuEntities);
        return ResponseDataUtil.ok("查询成功",pageInfo);
    }

    //根据项目名  进行模糊查询
    @GetMapping("/findShouRuCostByName")
    public Map<String,Object>findShouRuCostByName(Integer page,Integer size,String xiangMuName){
        PageHelper.startPage(page,size);
        List<ChanPinJiaoFuCostShouRuEntity> chanPinJiaoFuCostShouRuEntities=chanPinJiaoFuCostShouRuService.findShouRuCostByName(page,size,xiangMuName);
        PageInfo<ChanPinJiaoFuCostShouRuEntity> pageInfo =new PageInfo<>(chanPinJiaoFuCostShouRuEntities);
        return ResponseDataUtil.ok("模糊查询成功",pageInfo);
    }
    //根据id  进行批量或者 单个删除
    @DeleteMapping("/deletShouRuCostByIds/{ids}")
    public Map<String,Object>deletShouRuCostByIds(@PathVariable Integer[] ids){
        chanPinJiaoFuCostShouRuService.deletShouRuCostByIds(ids);
        return ResponseDataUtil.ok("删除成功");
    }
    //根据id  进行批量或者单个导出收入数据
    @GetMapping("/exportExcel/{ids}")
    public void exportFile(@PathVariable Integer[] ids, HttpServletResponse response) throws IOException {
        String fileName = "交付费用之收入费用列表" + System.currentTimeMillis() + ".xlsx";
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        chanPinJiaoFuCostShouRuService.exportFile(response.getOutputStream(), ids);
    }
}
