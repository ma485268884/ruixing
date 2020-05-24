package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.PermissionEntity;
import com.yintu.ruixing.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/5/19 17:40
 */
@RestController
@RequestMapping("/permissions")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;


    @PostMapping
    public Map<String, Object> add(PermissionEntity permissionEntity) {
        Assert.notNull(permissionEntity.getParentId(), "父级id不能为空");
        Assert.notNull(permissionEntity.getUrl(), "URL不能为空");
        Assert.notNull(permissionEntity.getMethod(), "请求方法不能为空");
        permissionService.add(permissionEntity);
        return ResponseDataUtil.ok("添加权限成功");
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> remove(@PathVariable Long id) {
        permissionService.remove(id);
        return ResponseDataUtil.ok("删除权限成功");
    }

    @PutMapping("/{id}")
    public Map<String, Object> edit(@PathVariable Long id, PermissionEntity permissionEntity) {
        permissionService.edit(permissionEntity);
        return ResponseDataUtil.ok("修改权限成功");
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Long id) {
        PermissionEntity permissionEntity = permissionService.findById(id);
        return ResponseDataUtil.ok("查询权限成功", permissionEntity);
    }

    @GetMapping
    public Map<String, Object> findAll() {
        List<TreeNodeUtil> treeNodeUtils = permissionService.findPermissionTree(-1L);
        return ResponseDataUtil.ok("查询权限列表成功", treeNodeUtils);
    }
}
