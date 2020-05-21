package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.UserEntity;
import com.yintu.ruixing.service.PermissionService;
import com.yintu.ruixing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/5/19 17:20
 */
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;

    @PostMapping("/users")
    public Map<String, Object> add(UserEntity userEntity) {
        Assert.notNull(userEntity.getUsername(), "用户名不能为空");
        Assert.notNull(userEntity.getPassword(), "密码不能为空");
        Assert.notNull(userEntity.getEnableds(), "状态不能为空");
        userService.add(userEntity);
        return ResponseDataUtil.ok("添加用户成功");
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Object> remove(@PathVariable Long id) {
        userService.remove(id);
        return ResponseDataUtil.ok("删除用户成功");
    }

    @PutMapping("/users/{id}")
    public Map<String, Object> edit(@PathVariable Long id, UserEntity userEntity) {
        userService.edit(userEntity);
        return ResponseDataUtil.ok("修改用户成功");
    }

    @GetMapping("/users/{id}")
    public Map<String, Object> findById(@PathVariable Long id) {
        UserEntity userEntity = userService.findById(id);
        return ResponseDataUtil.ok("查询用户成功", userEntity);
    }

    @GetMapping("/users")
    public Map<String, Object> findAll(@RequestParam("page_number") Integer pageNumber, @RequestParam("page_size") Integer pageSize, @RequestParam(value = "search_text", required = false) String username) {
        PageInfo<JSONObject> pageInfo = userService.findAllAndUrlByUserIdAndUrl(pageNumber, pageSize, username, this.getLoginUserId(), "/users");
        return ResponseDataUtil.ok("查询用户列表成功", pageInfo);
    }


}
