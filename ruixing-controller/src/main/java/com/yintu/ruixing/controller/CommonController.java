package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.enumobject.EnumAuthType;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.MessageEntity;
import com.yintu.ruixing.service.MessageService;
import com.yintu.ruixing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/20 9:17
 */
@RestController
@RequestMapping("/common")
public class CommonController extends SessionController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    /**
     * 获取当前用户菜单栏
     *
     * @return 当前用户权限
     */
    @GetMapping("/menu")
    public Map<String, Object> findUserMenuBar() {
        List<TreeNodeUtil> treeNodeUtils = this.getLoginAuthType().equals((EnumAuthType.ADMIN.getValue())) ?
                userService.findPermission(-1L, (short) 1) :
                userService.findPermissionById(this.getLoginUserId(), -1L, (short) 1);
        return ResponseDataUtil.ok("获取菜单栏成功", treeNodeUtils);
    }

    /**
     * 获取公共消息列表
     *
     * @param pageNumber 页码
     * @param pageSize   每页大小
     * @param orderBy    排序字段
     * @param type       模块标识类型
     * @param status     消息状态
     * @return
     */
    @GetMapping("/message")
    public Map<String, Object> findById(@RequestParam("page_number") Integer pageNumber,
                                        @RequestParam("page_size") Integer pageSize,
                                        @RequestParam(value = "order_by", required = false, defaultValue = "id DESC") String orderBy,
                                        @RequestParam(value = "type", required = false) Short type,
                                        @RequestParam(value = "status", required = false) Short status) {
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<MessageEntity> messageEntities = messageService.findByTypeAndStatus(type, status);
        PageInfo<MessageEntity> pageInfo = new PageInfo<>(messageEntities);
        return ResponseDataUtil.ok("查询消息列表成功", pageInfo);
    }


}
