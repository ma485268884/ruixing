package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.PermissionEntity;
import com.yintu.ruixing.entity.RoleEntity;
import com.yintu.ruixing.service.PermissionService;
import com.yintu.ruixing.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/5/19 17:36
 */
@RestController
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

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

    @GetMapping("/roles")
    public Map<String, Object> findAll(@RequestParam("page_number") Integer pageNumber, @RequestParam("page_size") Integer pageSize, @RequestParam(value = "search_text", required = false) String name) {
        JSONObject jo = new JSONObject();
        List<String> requestMethods = permissionService.findRequestMethodsByUserIdAndUrl(this.getLoginUserId(), "/users");
        jo.put("requestMethods", requestMethods);
        PageHelper.startPage(pageNumber, pageSize);
        List<RoleEntity> roleEntities = roleService.findAllOrByName(name);
        PageInfo<RoleEntity> pageInfo = new PageInfo<>(roleEntities);
        jo.put("pageInfo", pageInfo);
        return ResponseDataUtil.ok("查询角色列表成功", jo);
    }

    @GetMapping("/roles/{id}/permissions")
    public Map<String, Object> findRolesById(@PathVariable Long id) {
        List<TreeNodeUtil> treeNodeUtils = roleService.findPermissionsTreeById(id, -1L);
        return ResponseDataUtil.ok("查询角色权限成功", treeNodeUtils);
    }

    @PostMapping("/roles/{id}/permissions")
    public Map<String, Object> addRolesByIdAndRoleIds(@PathVariable Long id, @RequestParam Long[] permissionIds) {
        roleService.addPermissionsByIdAndPermissionIds(id, permissionIds);
        return ResponseDataUtil.ok("分配角色权限成功");
    }

}
