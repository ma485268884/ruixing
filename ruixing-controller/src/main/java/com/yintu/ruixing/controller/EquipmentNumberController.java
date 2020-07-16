package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.common.util.*;
import com.yintu.ruixing.entity.EquipmentEntity;
import com.yintu.ruixing.entity.EquipmentNumberEntity;
import com.yintu.ruixing.service.EquipmentNumberService;
import com.yintu.ruixing.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 器材编号管理
 *
 * @author:mlf
 * @date:2020/7/13 11:13
 */
@Controller
@RequestMapping("/equipment/numbers")
public class EquipmentNumberController implements BaseController<EquipmentNumberEntity, Integer> {
    @Autowired
    private EquipmentNumberService equipmentNumberService;
    @Autowired
    private EquipmentService equipmentService;

    @PostMapping
    @ResponseBody
    public Map<String, Object> add(@Validated EquipmentNumberEntity entity) {
        equipmentNumberService.add(entity);
        return ResponseDataUtil.ok("添加器材编号信息成功");
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Map<String, Object> remove(@PathVariable Integer id) {
        equipmentNumberService.remove(id);
        return ResponseDataUtil.ok("删除器材编号信息成功");

    }

    @PutMapping("/{id}")
    @ResponseBody
    public Map<String, Object> edit(@PathVariable Integer id, @Validated EquipmentNumberEntity entity) {
        equipmentNumberService.edit(entity);
        return ResponseDataUtil.ok("修改器材编号信息成功");
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Map<String, Object> findById(@PathVariable Integer id) {
        EquipmentNumberEntity equipmentNumberEntity = equipmentNumberService.findById(id);
        return ResponseDataUtil.ok("查询器材编号信息成功", equipmentNumberEntity);
    }

    @GetMapping
    @ResponseBody
    public Map<String, Object> findAll(@RequestParam("page_number") Integer pageNumber,
                                       @RequestParam("page_size") Integer pageSize,
                                       @RequestParam(value = "order_by", required = false, defaultValue = "en.id DESC") String orderBy,
                                       @RequestParam(value = "equipment_number", required = false) String equipmentNumber) {
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<EquipmentNumberEntity> equipmentNumberEntities = equipmentNumberService.findByCondition(null, equipmentNumber);
        PageInfo<EquipmentNumberEntity> pageInfo = new PageInfo<>(equipmentNumberEntities);
        return ResponseDataUtil.ok("查询器材编号列表信息成功", pageInfo);

    }

    @PostMapping("/upload")
    @ResponseBody
    public Map<String, Object> uploadFile(@RequestParam("photo") MultipartFile multipartFile) throws IOException {
        String photoName = multipartFile.getOriginalFilename();
        String photoPath = FileUploadUtil.save(multipartFile.getInputStream(), photoName);

        String defaultBaseFilePath = OSInfoUtil.isWindows() ? FileUploadUtil.WINDOW_BASE_FILE_PATH : OSInfoUtil.isLinux() ? FileUploadUtil.LINUX_BASE_FILE_PATH : FileUploadUtil.WINDOW_BASE_FILE_PATH;
        if (!FileUtil.isImage(new File(defaultBaseFilePath + photoPath + File.separator + photoName)))//判断是否为图片文件
            throw new BaseRuntimeException("此文件不是图片文件");
        JSONObject jo = new JSONObject();
        jo.put("photoPath", photoPath);
        jo.put("photoName", photoName);
        return ResponseDataUtil.ok("上传器材编号图片成功", jo);
    }

    @GetMapping("/photo/{id}")
    public void downloadFile(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        EquipmentNumberEntity equipmentNumberEntity = equipmentNumberService.findById(id);
        if (equipmentNumberEntity != null) {
            String filePath = equipmentNumberEntity.getPhotoPath();
            String fileName = equipmentNumberEntity.getPhotoName();
            if (filePath != null && !"".equals(filePath) && fileName != null && !"".equals(fileName)) {
                response.setContentType("application/octet-stream;charset=ISO8859-1");
                response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
                response.addHeader("Pargam", "no-cache");
                response.addHeader("Cache-Control", "no-cache");
                FileUploadUtil.get(response.getOutputStream(), filePath + File.separator + fileName);
            }
        }
    }

    /**
     * 查询设备全部信息
     *
     * @return
     */
    @GetMapping("/equipments")
    @ResponseBody
    public Map<String, Object> findEquipmentAll() {
        List<EquipmentEntity> equipmentEntities = equipmentService.findAll();
        return ResponseDataUtil.ok("查询设备信息列表成功", equipmentEntities);
    }
}
