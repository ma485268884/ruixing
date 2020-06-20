package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.enumobject.EnumAuthType;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.service.UserService;
import org.apache.commons.collections4.list.TreeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/20 9:17
 */
@RestController
@RequestMapping("/common")
public class CommonController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 获取当前用户菜单栏
     *
     * @return 当前用户权限
     */
    @GetMapping("/menu")
    public Map<String, Object> findUserMenuBar() {
        List<TreeNodeUtil> treeNodeUtils = this.getLoginUser() == null ? new ArrayList<>() : this.getLoginAuthType().equals((EnumAuthType.ADMIN.getValue())) ?
                userService.findPermission(-1L, (short) 1) :
                userService.findPermissionById(this.getLoginUserId(), -1L, (short) 1);
        return ResponseDataUtil.ok("获取菜单栏成功", treeNodeUtils);
    }


}
