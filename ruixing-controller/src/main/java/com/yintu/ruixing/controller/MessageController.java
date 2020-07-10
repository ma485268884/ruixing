package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.MessageEntity;
import com.yintu.ruixing.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/7/7 16:25
 */
@RestController
@RequestMapping("/messages")
public class MessageController extends SessionController {
    @Autowired
    private MessageService messageService;

    @GetMapping
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
