package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
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
    public Map<String,Object>addSanJiShuXiangMu(AnZhuangTiaoShiXiangMuEntity anZhuangTiaoShiXiangMuEntity){
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
        anZhuangTiaoShiXiangMuService.deletSanJiShuById(id);
        return ResponseDataUtil.ok("删除项目成功");
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

    //上传文件
    @PostMapping("/uploads")
    @ResponseBody
    public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        String filePath = FileUploadUtil.save(multipartFile.getInputStream(), fileName);
        JSONObject jo = new JSONObject();
        jo.put("filePath", filePath);
        jo.put("fileName", fileName);
        return ResponseDataUtil.ok("上传文件成功", jo);
    }

    //根据id 下载文件
    @GetMapping("/downloads/{id}")
    public void downloadFile(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        AnZhuangTiaoShiFileEntity anZhuangTiaoShiFileEntity=anZhuangTiaoShiXiangMuService.findById(id);
        if (anZhuangTiaoShiFileEntity != null) {
            String filePath = anZhuangTiaoShiFileEntity.getFilePath();
            String fileName = anZhuangTiaoShiFileEntity.getFileName();
            if (filePath != null && !"".equals(filePath) && fileName != null && !"".equals(fileName)) {
                response.setContentType("application/octet-stream;charset=ISO8859-1");
                response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
                response.addHeader("Pargam", "no-cache");
                response.addHeader("Cache-Control", "no-cache");
                FileUploadUtil.get(response.getOutputStream(), filePath + "\\" + fileName);
            }
        }
    }

    //
}
