package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.BaseController;
import com.yintu.ruixing.common.util.FileUtil;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.MaintenancePlanInfoEntity;
import com.yintu.ruixing.service.MaintenancePlanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 维护计划详情
 *
 * @author:mlf
 * @date:2020/7/9 17:17
 */
@RestController
@RequestMapping("/maintenance/plan/infos")
public class MaintenancePlanInfoController extends SessionController implements BaseController<MaintenancePlanInfoEntity, Integer> {

    @Autowired
    private MaintenancePlanInfoService maintenancePlanInfoService;

    @PostMapping
    public Map<String, Object> add(@Validated MaintenancePlanInfoEntity entity) {
        maintenancePlanInfoService.add(entity);
        return ResponseDataUtil.ok("添加维护计划详情息成功");
    }

    @Override
    public Map<String, Object> remove(Integer id) {
        return null;
    }

    @DeleteMapping("/{ids}")
    public Map<String, Object> remove(@PathVariable Integer[] ids) {
        maintenancePlanInfoService.remove(ids);
        return ResponseDataUtil.ok("删除维护计划详情息成功");
    }

    @PutMapping("/{id}")
    public Map<String, Object> edit(@PathVariable Integer id, @Validated MaintenancePlanInfoEntity entity) {
        maintenancePlanInfoService.edit(entity);
        return ResponseDataUtil.ok("修改维护计划详情息成功");
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Integer id) {
        MaintenancePlanInfoEntity maintenancePlanInfoEntity = maintenancePlanInfoService.findMaintenancePlanById(id);
        return ResponseDataUtil.ok("查询维护计划详情息成功", maintenancePlanInfoEntity);
    }

    @PostMapping("/import")
    @ResponseBody
    public Map<String, Object> importInfoFile(@RequestParam("maintenancePlanId") Integer maintenancePlanId, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        maintenancePlanInfoService.importFile(multipartFile.getInputStream(), FileUtil.getExtensionName(multipartFile.getOriginalFilename()), maintenancePlanId);
        return ResponseDataUtil.ok("导入维护计划详情信息成功");
    }

    @GetMapping("/export/{ids}")
    public void exportInfoFile(@PathVariable Integer[] ids, HttpServletResponse response) throws IOException {
        String fileName = "维护计划详情列表" + System.currentTimeMillis() + ".xlsx";
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        maintenancePlanInfoService.exportFile(response.getOutputStream(), ids);
    }

}
