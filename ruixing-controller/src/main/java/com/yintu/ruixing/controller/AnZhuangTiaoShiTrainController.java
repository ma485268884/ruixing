package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.FileUploadUtil;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.AnZhuangTiaoShiFileEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiTrainEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiTrainFileEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiXiangMuEntity;
import com.yintu.ruixing.service.AnZhuangTiaoShiTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    //根据id 批量或者单个删除培训数据
    @DeleteMapping("deleteTrainByIds/{ids}")
    public Map<String,Object>deleteTrainByIds(@PathVariable Integer[] ids){
        for (int i = 0; i < ids.length; i++) {
            List<AnZhuangTiaoShiTrainFileEntity>fileEntityList=anZhuangTiaoShiTrainService.findTrainFile(ids[i]);
            if (fileEntityList.size()!=0){
                return ResponseDataUtil.error("不能删除，存在文件");
            }
            anZhuangTiaoShiTrainService.deleteTrainByIds(ids);
            return ResponseDataUtil.ok("删除成功");
        }
        return ResponseDataUtil.ok("ok");
    }

    /////////////////////文件上传/////////////////////
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

    //添加线段的文件
    @PostMapping("/addFile")
    public Map<String,Object>addFile(AnZhuangTiaoShiTrainFileEntity anZhuangTiaoShiFileEntity){
        anZhuangTiaoShiTrainService.addFile(anZhuangTiaoShiFileEntity);
        return ResponseDataUtil.ok("新增文件成功");
    }

    //根据id 下载文件
    @GetMapping("/downloads/{id}")
    public void downloadFile(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        AnZhuangTiaoShiTrainFileEntity anZhuangTiaoShiFileEntity=anZhuangTiaoShiTrainService.findById(id);
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

    //根据文件名 或者初始化查询
    @GetMapping("/findAllTrainFiles")
    public Map<String,Object>findAllTrainFiles(Integer page,Integer size,String filename){
        PageHelper.startPage(page,size);
        List<AnZhuangTiaoShiTrainFileEntity>fileEntityList=anZhuangTiaoShiTrainService.findAllTrainFiles(page,size,filename);
        PageInfo<AnZhuangTiaoShiTrainFileEntity> fileEntityPageInfo=new PageInfo<>(fileEntityList);
        return ResponseDataUtil.ok("查询文件成功",fileEntityPageInfo);
    }

    //根据id  单个 或者批量删除
    @DeleteMapping("/deleteTrainFilesByIds/{ids}")
    public Map<String,Object>deleteTrainFilesByIds(@PathVariable Integer[] ids){
        anZhuangTiaoShiTrainService.deleteTrainFilesByIds(ids);
        return ResponseDataUtil.ok("删除文件成功");
    }

}
