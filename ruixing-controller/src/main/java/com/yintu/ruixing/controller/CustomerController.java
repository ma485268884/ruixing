package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.DepartmentEntity;
import com.yintu.ruixing.entity.RoleEntity;
import com.yintu.ruixing.entity.UserEntity;
import com.yintu.ruixing.service.PermissionService;
import com.yintu.ruixing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/5/28 14:15
 */
@RestController
@RequestMapping("/customers")
public class CustomerController extends SessionController {
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;


    @PostMapping
    public Map<String, Object> add(UserEntity userEntity, @RequestParam Long[] roleIds, @RequestParam Long[] departmentIds) {
        Assert.notNull(userEntity.getUsername(), "用户名不能为空");
        Assert.notNull(userEntity.getPassword(), "密码不能为空");
        Assert.notNull(userEntity.getEnableds(), "状态不能为空");
        userEntity.setIsCustomer((short) 1);
        userService.addUserAndRoles(userEntity, roleIds, departmentIds, this.getLoginUserName());
        return ResponseDataUtil.ok("添加客户成功");
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> remove(@PathVariable Long id) {
        userService.remove(id);
        return ResponseDataUtil.ok("删除客户成功");
    }

    @PutMapping("/{id}")
    public Map<String, Object> edit(@PathVariable Long id, UserEntity userEntity, @RequestParam Long[] roleIds, @RequestParam Long[] departmentIds) {
        Assert.notNull(userEntity.getUsername(), "用户名不能为空");
        Assert.notNull(userEntity.getPassword(), "密码不能为空");
        Assert.notNull(userEntity.getEnableds(), "状态不能为空");
        userEntity.setIsCustomer((short) 1);
        userService.editUserAndRoles(userEntity, roleIds, departmentIds, this.getLoginUserName());
        return ResponseDataUtil.ok("修改客户成功");
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Long id) {
        UserEntity userEntity = userService.findById(id);
        return ResponseDataUtil.ok("查询客户成功", userEntity);
    }

    @GetMapping
    public Map<String, Object> findAll(@RequestParam("page_number") Integer pageNumber,
                                       @RequestParam("page_size") Integer pageSize,
                                       @RequestParam(value = "order_by", required = false, defaultValue = "id DESC") String orderBy,
                                       @RequestParam(value = "search_text", required = false) String username) {
        JSONObject jo = new JSONObject();
        List<String> requestMethods = permissionService.findRequestMethodsByUserIdAndUrl(this.getLoginUserId(), "/customers");
        jo.put("requestMethods", requestMethods);
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<UserEntity> userEntities = userService.findAllOrByUsername(username, (short) 1);
        PageInfo<UserEntity> pageInfo = new PageInfo<>(userEntities);
        jo.put("pageInfo", pageInfo);
        return ResponseDataUtil.ok("查询客户列表成功", jo);
    }

    @GetMapping("/{id}/roles")
    public Map<String, Object> findRolesById(@PathVariable Long id) {
        List<RoleEntity> roleEntities = userService.findRolesById(id);
        return ResponseDataUtil.ok("查询客户角色成功", roleEntities);
    }

    @GetMapping("/{id}/departments")
    public Map<String, Object> findDepartmentsById(@PathVariable Long id) {
        List<DepartmentEntity> departmentEntities = userService.findDepartmentsById(id);
        return ResponseDataUtil.ok("查询客户部门成功", departmentEntities);
    }

}
