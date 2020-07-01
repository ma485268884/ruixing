package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.FileUploadUtil;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.ChanPinJiaoFuXiangMuEntity;
import com.yintu.ruixing.entity.ChanPinJiaoFuXiangMuFileEntity;
import com.yintu.ruixing.service.ChanPinJiaoFuXiangMuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author Mr.liu
 * @Date 2020/7/1 13:43
 * @Version 1.0
 * 需求:产品需求所有
 */
@RestController
@RequestMapping("/ChanPinJiaoFuXiangMuAll")
public class ChanPinJiaoFuXiangMuController {
    @Autowired
    private ChanPinJiaoFuXiangMuService chanPinJiaoFuXiangMuService;

    //创建三级树
    @GetMapping
    public Map<String, Object> findSanJiShu() {
        List<TreeNodeUtil> treeNodeUtils = chanPinJiaoFuXiangMuService.findSanJiShu();
        return ResponseDataUtil.ok("查询成功", treeNodeUtils);
    }

    //新增项目
    @PostMapping("/addXiangMu")
    public Map<String, Object> addXiangMu(ChanPinJiaoFuXiangMuEntity chanPinJiaoFuXiangMuEntity) {
        chanPinJiaoFuXiangMuService.addXiangMu(chanPinJiaoFuXiangMuEntity);
        return ResponseDataUtil.ok("添加项目成功");
    }

    //根据选择的id  修改对应的项目内容
    @PutMapping("/editXiangMuById/{id}")
    public Map<String, Object> editXiangMuById(@PathVariable Integer id, ChanPinJiaoFuXiangMuEntity chanPinJiaoFuXiangMuEntity) {
        chanPinJiaoFuXiangMuService.editXiangMuById(chanPinJiaoFuXiangMuEntity);
        return ResponseDataUtil.ok("修改项目数据成功");
    }

    //根据id  删除对应的项目
    @DeleteMapping("/deletXiagMuById/{id}")
    public Map<String, Object> deletXiagMuById(@PathVariable Integer id) {
        chanPinJiaoFuXiangMuService.deletXiagMuById(id);
        return ResponseDataUtil.ok("删除数据成功");
    }

    //查询所有的数据
    @GetMapping("/findAll")
    public Map<String, Object> findAll(Integer page,Integer size) {
        JSONObject js=new JSONObject();
        PageHelper.startPage(page,size);
        List<ChanPinJiaoFuXiangMuEntity> chanPinJiaoFuXiangMuEntities = chanPinJiaoFuXiangMuService.findAll(page,size);
        js.put("chanPinJiaoFuXiangMuEntities",chanPinJiaoFuXiangMuEntities);
        PageInfo<ChanPinJiaoFuXiangMuEntity> pageInfo=new PageInfo<>(chanPinJiaoFuXiangMuEntities);
        js.put("pageInfo",pageInfo);
        return ResponseDataUtil.ok("查询所有数据成功", pageInfo);
    }

    //新增文件列表
    @PostMapping("/addXiangMuFile")
    public Map<String, Object> addXiangMuFile(ChanPinJiaoFuXiangMuFileEntity chanPinJiaoFuXiangMuFileEntity) {
        chanPinJiaoFuXiangMuService.addXiangMuFile(chanPinJiaoFuXiangMuFileEntity);
        return ResponseDataUtil.ok("新增文件列表成功");
    }
    //根据id  修改文件列表
    @PutMapping("/editXiangMuFileById/{id}")
    public Map<String,Object>editXiangMuFileById(@PathVariable Integer id ,ChanPinJiaoFuXiangMuFileEntity chanPinJiaoFuXiangMuFileEntity){
        chanPinJiaoFuXiangMuService.editXiangMuFileById(chanPinJiaoFuXiangMuFileEntity);
        return ResponseDataUtil.ok("修改数据成功");
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
        ChanPinJiaoFuXiangMuFileEntity chanPinJiaoFuXiangMuFileEntity = chanPinJiaoFuXiangMuService.findById(id);
        if (chanPinJiaoFuXiangMuFileEntity != null) {
            String filePath = chanPinJiaoFuXiangMuFileEntity.getFilePath();
            String fileName = chanPinJiaoFuXiangMuFileEntity.getFileName();
            if (filePath != null && !"".equals(filePath) && fileName != null && !"".equals(fileName)) {
                response.setContentType("application/octet-stream;charset=ISO8859-1");
                response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
                response.addHeader("Pargam", "no-cache");
                response.addHeader("Cache-Control", "no-cache");
                FileUploadUtil.get(response.getOutputStream(), filePath + "\\" + fileName);
            }
        }
    }

    //根据id  删除对应的文件
    @DeleteMapping("/deletXiangMuFileById/{id}")
    public Map<String,Object>deletXiangMuFileById(@PathVariable Integer id){
        chanPinJiaoFuXiangMuService.deletXiangMuFileById(id);
        return ResponseDataUtil.ok("删除文件成功");
    }

    //根据id  批量删除文件
    @DeleteMapping("/deletXiangMuFileByIds/{ids}")
    public Map<String,Object>deletXiangMuFileByIds(@PathVariable Integer[] ids){
        chanPinJiaoFuXiangMuService.deletXiangMuFileByIds(ids);
        return ResponseDataUtil.ok("批量删除文件成功");
    }

}
