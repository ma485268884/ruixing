package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.BaseController;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.MaintenancePlanInfoEntity;
import com.yintu.ruixing.service.MaintenancePlanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
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
        MaintenancePlanInfoEntity maintenancePlanInfoEntity = maintenancePlanInfoService.findById(id);
        return ResponseDataUtil.ok("查询维护计划详情息成功", maintenancePlanInfoEntity);
    }


}
