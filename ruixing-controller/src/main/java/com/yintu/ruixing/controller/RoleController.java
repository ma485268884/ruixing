package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.RoleEntity;
import com.yintu.ruixing.service.PermissionService;
import com.yintu.ruixing.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/5/19 17:36
 */
@RestController
@RequestMapping("/roles")
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @PostMapping
    public Map<String, Object> add(RoleEntity roleEntity) {
        Assert.notNull(roleEntity.getName(), "角色名不能为空");
        roleService.add(roleEntity);
        return ResponseDataUtil.ok("添加角色成功");
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> remove(@PathVariable Long id) {
        roleService.remove(id);
        return ResponseDataUtil.ok("删除角色成功");
    }

    @PutMapping("/{id}")
    public Map<String, Object> edit(@PathVariable Long id, RoleEntity roleEntity) {
        roleService.edit(roleEntity);
        return ResponseDataUtil.ok("修改角色成功");
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Long id) {
        RoleEntity roleEntity = roleService.findById(id);
        return ResponseDataUtil.ok("查询角色成功", roleEntity);
    }

    @GetMapping
    public Map<String, Object> findAll(@RequestParam("page_number") Integer pageNumber,
                                       @RequestParam("page_size") Integer pageSize,
                                       @RequestParam(value = "search_text", required = false) String name,
                                       @RequestParam(value = "sortby", required = false) String sortby,
                                       @RequestParam(value = "order", required = false) String order) {
        JSONObject jo = new JSONObject();
        List<String> requestMethods = permissionService.findRequestMethodsByUserIdAndUrl(this.getLoginUserId(), "/users");
        jo.put("requestMethods", requestMethods);
        String orderBy = "id DESC";
        if (sortby != null && !"".equals(sortby) && order != null && !"".equals(order))
            orderBy = sortby + " " + order;
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<RoleEntity> roleEntities = roleService.findAllOrByName(name);
        PageInfo<RoleEntity> pageInfo = new PageInfo<>(roleEntities);
        jo.put("pageInfo", pageInfo);
        return ResponseDataUtil.ok("查询角色列表成功", jo);
    }

//    @GetMapping("/{id}/permissions")
//    public Map<String, Object> findRolesById(@PathVariable Long id) {
//        List<TreeNodeUtil> treeNodeUtils = roleService.findPermissionsTreeById(id, -1L);
//        return ResponseDataUtil.ok("查询角色权限成功", treeNodeUtils);
//    }

    @GetMapping("/{id}/permissions")
    public Map<String, Object> findRolesById(@PathVariable Long id) {
        List<TreeNodeUtil> treeNodeUtils = roleService.findPermissionsById(id, 0L);
        return ResponseDataUtil.ok("查询角色权限成功", treeNodeUtils);
    }

    @PostMapping("/{id}/permissions")
    public Map<String, Object> addRolesByIdAndRoleIds(@PathVariable Long id, @RequestParam Long[] permissionIds) {
        roleService.addPermissionsByIdAndPermissionIds(id, permissionIds);
        return ResponseDataUtil.ok("分配角色权限成功");
    }

}
