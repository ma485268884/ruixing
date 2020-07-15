package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.BaseController;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.IndexAnalysisEquipmentEntity;
import com.yintu.ruixing.service.IndexAnalysisEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 系统可靠性指标分析----->器材
 *
 * @author:mlf
 * @date:2020/7/14 10:41
 */
@RestController
@RequestMapping("/index/analysis/equipments")
public class IndexAnalysisEquipmentController implements BaseController<IndexAnalysisEquipmentEntity, Integer> {
    @Autowired
    private IndexAnalysisEquipmentService indexAnalysisEquipmentService;

    @PostMapping
    public Map<String, Object> add(@Validated IndexAnalysisEquipmentEntity entity) {
        indexAnalysisEquipmentService.add(entity);
        return ResponseDataUtil.ok("添加器材信息成功");
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> remove(@PathVariable Integer id) {
        indexAnalysisEquipmentService.remove(id);
        return ResponseDataUtil.ok("删除器材信息成功");
    }

    @PutMapping("/{id}")
    public Map<String, Object> edit(@PathVariable Integer id, @Validated IndexAnalysisEquipmentEntity entity) {
        indexAnalysisEquipmentService.edit(entity);
        return ResponseDataUtil.ok("修改器材信息成功");
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Integer id) {
        IndexAnalysisEquipmentEntity indexAnalysisEquipmentEntity = indexAnalysisEquipmentService.findById(id);
        return ResponseDataUtil.ok("查询器材信息成功", indexAnalysisEquipmentEntity);
    }

    @GetMapping
    public Map<String, Object> findByAll(@RequestParam("page_number") Integer pageNumber,
                                         @RequestParam("page_size") Integer pageSize,
                                         @RequestParam(value = "order_by", required = false, defaultValue = "iae.id DESC") String orderBy,
                                         @RequestParam(value = "equipment_number", required = false) String equipmentNumber) {
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<IndexAnalysisEquipmentEntity> indexAnalysisEquipmentEntities = indexAnalysisEquipmentService.findByCondition(equipmentNumber);
        PageInfo<IndexAnalysisEquipmentEntity> pageInfo = new PageInfo<>(indexAnalysisEquipmentEntities);
        return ResponseDataUtil.ok("查询器材信息列表成功", pageInfo);
    }

}
