package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.RoleEntity;
import com.yintu.ruixing.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author:mlf
 * @date:2020/5/19 17:36
 */
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/roles")
    public Map<String, Object> add(RoleEntity roleEntity) {
        roleService.add(roleEntity);
        return ResponseDataUtil.ok("添加角色成功");
    }

    @DeleteMapping("/roles/{id}")
    public Map<String, Object> remove(@PathVariable Long id) {
        roleService.remove(id);
        return ResponseDataUtil.ok("删除角色成功");
    }

    @PutMapping("/roles/{id}")
    public Map<String, Object> edit(@PathVariable Long id, RoleEntity roleEntity) {
        roleService.edit(roleEntity);
        return ResponseDataUtil.ok("修改角色成功");
    }

    @GetMapping("/roles/{id}")
    public Map<String, Object> find(@PathVariable Long id) {
        RoleEntity roleEntity = roleService.findById(id);
        return ResponseDataUtil.ok("查询角色成功", roleEntity);
    }
}
