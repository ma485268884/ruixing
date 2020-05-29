package com.yintu.ruixing.controller;


import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * TODO
 *
 * @description:  首页列表展示
 * @author: Qiao
 * @time: 2020/5/21 17:17
 */
@RestController
@RequestMapping("/lieBiao")
public class ListController {
    @Autowired
    private ListService ls;

    @GetMapping("/getLieBiao")
    public Object getLieBiao(){
        return ResponseDataUtil.ok("查询数据成功",ls.getMenuList());
    }
}
