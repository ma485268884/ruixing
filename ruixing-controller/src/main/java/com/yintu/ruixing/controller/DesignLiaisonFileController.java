package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.yintu.ruixing.common.util.BaseController;
import com.yintu.ruixing.common.util.FileUploadUtil;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.DesignLiaisonFileEntity;
import com.yintu.ruixing.entity.UserEntity;
import com.yintu.ruixing.service.DesignLiaisonFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/7/3 14:01
 */
@Controller
@RequestMapping("/design/liaisons/files")
public class DesignLiaisonFileController extends SessionController implements BaseController<DesignLiaisonFileEntity, Integer> {

    @Autowired
    private DesignLiaisonFileService designLiaisonFileService;


    @PostMapping
    @ResponseBody
    public Map<String, Object> add(DesignLiaisonFileEntity entity) {
        designLiaisonFileService.add(entity);
        return ResponseDataUtil.ok("添加设计联络及后续技术交流文件信息成功");
    }

    @Override
    public Map<String, Object> remove(Integer id) {
        return null;
    }

    @DeleteMapping("/{ids}")
    @ResponseBody
    public Map<String, Object> remove(@PathVariable Integer[] ids) {
        designLiaisonFileService.remove(ids);
        return ResponseDataUtil.ok("删除设计联络及后续技术交流文件信息成功");
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Map<String, Object> edit(@PathVariable Integer id, DesignLiaisonFileEntity entity) {
        designLiaisonFileService.edit(entity);
        return ResponseDataUtil.ok("修改设计联络及后续技术交流文件信息成功");
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Map<String, Object> findById(@PathVariable Integer id) {
        DesignLiaisonFileEntity designLiaisonFileEntity = designLiaisonFileService.findDesignLiaisonById(id);
        return ResponseDataUtil.ok("查询设计联络及后续技术交流文件信息成功", designLiaisonFileEntity);
    }

    @PostMapping("/upload")
    @ResponseBody
    public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        String filePath = FileUploadUtil.save(multipartFile.getInputStream(), fileName);
        JSONObject jo = new JSONObject();
        jo.put("filePath", filePath);
        jo.put("fileName", fileName);
        return ResponseDataUtil.ok("查询设计联络及后续技术交流文件信息成功", jo);
    }

    @GetMapping("/download/{id}")
    public void downloadFile(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        DesignLiaisonFileEntity designLiaisonFileEntity = designLiaisonFileService.findById(id);
        if (designLiaisonFileEntity != null) {
            String filePath = designLiaisonFileEntity.getPath();
            String fileName = designLiaisonFileEntity.getName();
            if (filePath != null && !"".equals(filePath) && fileName != null && !"".equals(fileName)) {
                response.setContentType("application/octet-stream;charset=ISO8859-1");
                response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
                response.addHeader("Pargam", "no-cache");
                response.addHeader("Cache-Control", "no-cache");
                FileUploadUtil.get(response.getOutputStream(), filePath + "\\" + fileName);
            }
        }
    }

    @GetMapping("/export/{ids}")
    public void exportFile(@PathVariable Integer[] ids, HttpServletResponse response) throws IOException {
        String fileName = "设计联络及后续技术交流列表" + System.currentTimeMillis() + ".xlsx";
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        designLiaisonFileService.exportFile(response.getOutputStream(), ids);
    }

    @GetMapping("/auditors")
    public Map<String, Object> findUserEntities() {
        List<UserEntity> userEntities = designLiaisonFileService.findUserEntities();
        return ResponseDataUtil.ok("查询审核人列表信息成功", userEntities);
    }


}
