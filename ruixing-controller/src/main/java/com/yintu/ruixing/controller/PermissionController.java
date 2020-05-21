package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.PermissionEntity;
import com.yintu.ruixing.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author:mlf
 * @date:2020/5/19 17:40
 */
@RestController
public class PermissionController {
    @Autowired
    private PermissionService permissionService;


    @PostMapping("/permissions")
    public Map<String, Object> add(PermissionEntity permissionEntity) {
        Assert.notNull(permissionEntity.getParentId(), "父级id不能为空");
        Assert.notNull(permissionEntity.getUrl(), "URL不能为空");
        Assert.notNull(permissionEntity.getMethod(), "请求方法不能为空");
        permissionService.add(permissionEntity);
        return ResponseDataUtil.ok("添加权限成功");
    }

    @DeleteMapping("/permissions/{id}")
    public Map<String, Object> remove(@PathVariable Long id) {
        permissionService.remove(id);
        return ResponseDataUtil.ok("删除权限成功");
    }

    @PutMapping("/permissions/{id}")
    public Map<String, Object> edit(@PathVariable Long id, PermissionEntity permissionEntity) {
        permissionService.edit(permissionEntity);
        return ResponseDataUtil.ok("修改权限成功");
    }

    @GetMapping("/permissions/{id}")
    public Map<String, Object> find(@PathVariable Long id) {
        PermissionEntity permissionEntity = permissionService.findById(id);
        return ResponseDataUtil.ok("查询权限成功", permissionEntity);
    }
}
