package com.yintu.ruixing.controller.rbac;

import com.github.pagehelper.PageHelper;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.dao.rbac.UserDao;
import com.yintu.ruixing.entity.rbac.UserEntity;
import com.yintu.ruixing.entity.rbac.UserEntityExample;
import com.yintu.ruixing.service.rbac.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public Map<String, Object> add(UserEntity userEntity) {
        Assert.notNull(userEntity.getUsername(), "用户名不能为空");
        Assert.notNull(userEntity.getPassword(), "密码不能为空");
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
    public Map<String, Object> find(@PathVariable Long id) {
        UserEntity userEntity = userService.findById(id);
        return ResponseDataUtil.ok("查询用户成功", userEntity);
    }
    
}
