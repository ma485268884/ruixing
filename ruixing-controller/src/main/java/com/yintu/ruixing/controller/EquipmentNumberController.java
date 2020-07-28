package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.BaseController;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.EquipmentEntity;
import com.yintu.ruixing.entity.EquipmentNumberEntity;
import com.yintu.ruixing.service.EquipmentNumberService;
import com.yintu.ruixing.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @Override
    public Map<String, Object> remove(Integer id) {
        return null;
    }

    @DeleteMapping("/{ids}")
    @ResponseBody
    public Map<String, Object> remove(@PathVariable Integer[] ids) {
        equipmentNumberService.removeMuch(ids);
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
