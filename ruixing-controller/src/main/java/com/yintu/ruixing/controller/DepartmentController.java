package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.DepartmentEntity;
import com.yintu.ruixing.entity.DepartmentEntityExample;
import com.yintu.ruixing.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/5/27 13:12
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController extends SessionController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Map<String, Object> add(DepartmentEntity departmentEntity) {
        Assert.notNull(departmentEntity.getParentId(), "上级部门id不能为空");
        Assert.notNull(departmentEntity.getName(), "名称不能为空");
        departmentService.add(departmentEntity);
        return ResponseDataUtil.ok("添加部门成功");
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> remove(@PathVariable Long id) {
        departmentService.removeByIdAndIsFirst(id, true);
        return ResponseDataUtil.ok("删除部门成功");
    }

    @PutMapping("/{id}")
    public Map<String, Object> edit(@PathVariable Long id, DepartmentEntity departmentEntity) {
        Assert.notNull(id, "id不能为空");
        Assert.notNull(departmentEntity.getParentId(), "上级部门id不能为空");
        Assert.notNull(departmentEntity.getName(), "名称不能为空");
        departmentService.edit(departmentEntity);
        return ResponseDataUtil.ok("修改部门成功");
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Long id) {
        DepartmentEntity departmentEntity = departmentService.findById(id);
        return ResponseDataUtil.ok("查询部门成功", departmentEntity);
    }

    @GetMapping
    public Map<String, Object> findAll() {
        List<TreeNodeUtil> treeNodeUtils = departmentService.findDepartmentTree(-1L);
        return ResponseDataUtil.ok("查询部门树成功", treeNodeUtils);
    }

    @GetMapping("/list")
    public Map<String, Object> findList() {
        List<DepartmentEntity> departmentEntities = departmentService.findByExample(new DepartmentEntityExample());
        return ResponseDataUtil.ok("查询部门成功", departmentEntities);
    }
}
