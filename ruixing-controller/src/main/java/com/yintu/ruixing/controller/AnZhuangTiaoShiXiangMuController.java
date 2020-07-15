package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.FileUploadUtil;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.AnZhuangTiaoShiCheZhanXiangMuTypeEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiFileEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiXiangMuEntity;
import com.yintu.ruixing.entity.ChanPinJiaoFuXiangMuFileEntity;
import com.yintu.ruixing.service.AnZhuangTiaoShiXiangMuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author Mr.liu
 * @Date 2020/7/10 20:43
 * @Version 1.0
 * 需求:安装调试模块
 */
@RestController
@RequestMapping("/AnZhuangTiaoShiAll")
public class AnZhuangTiaoShiXiangMuController {
    @Autowired
    private AnZhuangTiaoShiXiangMuService anZhuangTiaoShiXiangMuService;

    //安装调试的三级树
    @RequestMapping
    public Map<String, Object> findSanJiShu() {
        List<TreeNodeUtil> treeNodeUtils = anZhuangTiaoShiXiangMuService.findSanJiShu();
        return ResponseDataUtil.ok("查询成功", treeNodeUtils);
    }

    //新增三级树中的项目
    @PostMapping("/addSanJiShuXiangMu")
    public Map<String,Object>addSanJiShuXiangMu(AnZhuangTiaoShiXiangMuEntity anZhuangTiaoShiXiangMuEntity)throws Exception{
        anZhuangTiaoShiXiangMuService.addSanJiShuXiangMu(anZhuangTiaoShiXiangMuEntity);
        return ResponseDataUtil.ok("新增项目成功");
    }

    //  根据id  编辑三级树的项目
    @PutMapping("/editSanJiShuById/{id}")
    public Map<String, Object> editSanJiShu(@PathVariable Integer id, AnZhuangTiaoShiXiangMuEntity anZhuangTiaoShiXiangMuEntity) {
        anZhuangTiaoShiXiangMuService.editSanJiShu(anZhuangTiaoShiXiangMuEntity);
        return ResponseDataUtil.ok("修改项目成功");
    }
    //根据id   删除三级树的项目
    @DeleteMapping("/deletSanJiShuById/{id}")
    public Map<String,Object>deletSanJiShuById(@PathVariable Integer id){
        Integer chezhantotal=anZhuangTiaoShiXiangMuService.findCheZhanTotal(id);
        if (chezhantotal==0){
            anZhuangTiaoShiXiangMuService.deletSanJiShuById(id);
            return ResponseDataUtil.ok("删除项目成功");
        }else {
            return ResponseDataUtil.error("不能删除带有车站的线段");
        }
    }

    //查询所有的项目类型
    @GetMapping("/findAllXiangMuType")
    public Map<String,Object>findAllXiangMuType(){
        List<AnZhuangTiaoShiCheZhanXiangMuTypeEntity> xiangMuTypeEntities=anZhuangTiaoShiXiangMuService.findAllXiangMuType();
        return ResponseDataUtil.ok("查询项目类型成功",xiangMuTypeEntities);
    }

    //查询关联项目及其编号
    @GetMapping("/findXiangMuAndBianHao")
    public Map<String,Object>findXiangMuAndBianHao(){
        List<ChanPinJiaoFuXiangMuFileEntity> chanPinJiaoFuXiangMuFileEntities=anZhuangTiaoShiXiangMuService.findXiangMuAndBianHao();
        return ResponseDataUtil.ok("查询关联项目及其编号成功",chanPinJiaoFuXiangMuFileEntities);
    }


    //根据三级树的类型  查询类型下的数据
    @GetMapping("/findXianDuanDataByLeiXing")
    public Map<String,Object>findXianDuanDataByLeiXing(Integer leiXingId ,Integer page,Integer size){
        PageHelper.startPage(page,size);
        List<AnZhuangTiaoShiXiangMuEntity>xiangMuEntities=anZhuangTiaoShiXiangMuService.findXianDuanDataByLeiXing(leiXingId,page,size);
        PageInfo<AnZhuangTiaoShiXiangMuEntity>xiangMuEntityPageInfo=new PageInfo<>(xiangMuEntities);
        return ResponseDataUtil.ok("查询数据成功",xiangMuEntityPageInfo);
    }

    //查询所有的项目 和 年份
    @GetMapping("/findXianDuanNameAndYear")
    public Map<String,Object>findXianDuanNameAndYear(){
        List<AnZhuangTiaoShiXiangMuEntity> xiangMuEntities=anZhuangTiaoShiXiangMuService.findXianDuanNameAndYear();
        return ResponseDataUtil.ok("查询线段名和年份成功",xiangMuEntities);
    }

    //根据项目名 或年份 或项目类型 或项目状态查询数据
    @GetMapping("/findXianDuanBySomedata")
    public Map<String,Object>findXianDuanBySomedata(Integer page,Integer size,
                                                    String xdname,String year,
                                                    String xdtype,Integer xdleixing){
        PageHelper.startPage(page,size);
        List<AnZhuangTiaoShiXiangMuEntity> xiangMuEntities=anZhuangTiaoShiXiangMuService.findXianDuanBySomedata(page,size,xdname,year,xdtype,xdleixing);
        PageInfo<AnZhuangTiaoShiXiangMuEntity> xiangMuEntityPageInfo=new PageInfo<>(xiangMuEntities);
        return ResponseDataUtil.ok("查询数据成功",xiangMuEntityPageInfo);
    }

    //根据id 进行单个或者批量下载到Excel
    @GetMapping("/downLoadByIds/{ids}")
    public void exportFile(@PathVariable Integer[] ids, HttpServletResponse response) throws IOException {
        String fileName = "安装调试线段列表" + System.currentTimeMillis() + ".xlsx";
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        anZhuangTiaoShiXiangMuService.exportFile(response.getOutputStream(), ids);
    }
}
