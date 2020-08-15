package com.yintu.ruixing.chanpinjiaofu;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.chanpinjiaofu.ChanPinJiaoFuCostZhiChuEntity;
import com.yintu.ruixing.chanpinjiaofu.ChanPinJiaoFuXiangMuEntity;
import com.yintu.ruixing.chanpinjiaofu.ChanPinJiaoFuCostZhiChuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author Mr.liu
 * @Date 2020/7/4 20:17
 * @Version 1.0
 * 需求:产品交付费用——支出
 */
@RestController
@RequestMapping("/chanPinJiaoFuCostZhiChuAll")
public class ChanPinJiaoFuCostZhiChuController {
    @Autowired
    private ChanPinJiaoFuCostZhiChuService chanPinJiaoFuCostZhiChuService;


    //查询所有的项目名
    @GetMapping("/findXiangMu")
    public Map<String,Object>findXiangMu(){
        List<ChanPinJiaoFuXiangMuEntity> xiangMuEntities=chanPinJiaoFuCostZhiChuService.findXiangMu();
        return ResponseDataUtil.ok("查询项目名成功",xiangMuEntities);
    }

    //新增支出费用
    @PostMapping("/addZhiChuCost")
    public Map<String,Object>addZhiChuCost(ChanPinJiaoFuCostZhiChuEntity chanPinJiaoFuCostZhiChuEntity){
        chanPinJiaoFuCostZhiChuService.addZhiChuCost(chanPinJiaoFuCostZhiChuEntity);
        return ResponseDataUtil.ok("新增支出费用成功");
    }

    //根据id  编辑对应的支出费用
    @PutMapping("/editZhiChuCost/{id}")
    public Map<String,Object>editZhiChuCost(@PathVariable Integer id,ChanPinJiaoFuCostZhiChuEntity chanPinJiaoFuCostZhiChuEntity){
        chanPinJiaoFuCostZhiChuService.editZhiChuCost(chanPinJiaoFuCostZhiChuEntity);
        return ResponseDataUtil.ok("编辑支出费用成功");
    }
    //查询所有的支出数据
    @GetMapping("/findAllZhiChuCost")
    public Map<String,Object>findAllZhiChuCost(Integer page,Integer size){
        PageHelper.startPage(page,size);
        List<ChanPinJiaoFuCostZhiChuEntity> chanPinJiaoFuCostZhiChuEntities=chanPinJiaoFuCostZhiChuService.findAllZhiChuCost(page,size);
        PageInfo<ChanPinJiaoFuCostZhiChuEntity> pageInfo =new PageInfo<>(chanPinJiaoFuCostZhiChuEntities);
        return ResponseDataUtil.ok("查询成功",pageInfo);
    }

    //根据项目名  进行模糊查询
    @GetMapping("/findZhiChuCostByName")
    public Map<String,Object>findZhiChuCostByName(Integer page,Integer size,String xiangMuName){
        PageHelper.startPage(page,size);
        List<ChanPinJiaoFuCostZhiChuEntity> chanPinJiaoFuCostZhiChuEntities=chanPinJiaoFuCostZhiChuService.findZhiChuCostByName(page,size,xiangMuName);
        PageInfo<ChanPinJiaoFuCostZhiChuEntity> pageInfo =new PageInfo<>(chanPinJiaoFuCostZhiChuEntities);
        return ResponseDataUtil.ok("模糊查询成功",pageInfo);
    }
    //根据id  进行批量或者 单个删除
    @DeleteMapping("/deletZhiChuCostByIds/{ids}")
    public Map<String,Object>deletZhiChuCostByIds(@PathVariable Integer[] ids){
        chanPinJiaoFuCostZhiChuService.deletZhiChuCostByIds(ids);
        return ResponseDataUtil.ok("删除成功");
    }

    //根据id  进行批量或者单个导出支出数据
    @GetMapping("/exportExcel/{ids}")
    public void exportFile(@PathVariable Integer[] ids, HttpServletResponse response) throws IOException {
        String fileName = "交付费用之支出费用列表" + System.currentTimeMillis() + ".xlsx";
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        chanPinJiaoFuCostZhiChuService.exportFile(response.getOutputStream(), ids);
    }
}
