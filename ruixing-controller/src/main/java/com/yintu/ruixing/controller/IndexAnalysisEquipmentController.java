package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.BaseController;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.IndexAnalysisEquipmentEntity;
import com.yintu.ruixing.service.IndexAnalysisEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author:mlf
 * @date:2020/7/14 10:41
 */
@RestController
@RequestMapping("/Index/analysis/equipment")
public class IndexAnalysisEquipmentController implements BaseController<IndexAnalysisEquipmentEntity, Integer> {
    @Autowired
    private IndexAnalysisEquipmentService indexAnalysisEquipmentService;

    @PostMapping
    public Map<String, Object> add(@Validated IndexAnalysisEquipmentEntity entity) {
        indexAnalysisEquipmentService.add(entity);
        return ResponseDataUtil.ok("添加器材成功");
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> remove(@PathVariable Integer id) {
        indexAnalysisEquipmentService.remove(id);
        return ResponseDataUtil.ok("删除器材成功");
    }

    @PutMapping("/{id}")
    public Map<String, Object> edit(@PathVariable Integer id, @Validated IndexAnalysisEquipmentEntity entity) {
        indexAnalysisEquipmentService.edit(entity);
        return ResponseDataUtil.ok("修改器材成功");
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Integer id) {
        IndexAnalysisEquipmentEntity indexAnalysisEquipmentEntity = indexAnalysisEquipmentService.findById(id);
        return ResponseDataUtil.ok("查询器材成功", indexAnalysisEquipmentEntity);
    }
}
