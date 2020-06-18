package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.service.BaoJingYuJingPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author:lcy
 * @date:2020-06-17 10
 */
@RestController
@RequestMapping("/BaoJingYuJing")
public class BaoJingYuJingPropertyController {
    @Autowired
    private BaoJingYuJingPropertyService baoJingYuJingPropertyService;

    //查询报警预警树形结构
    @RequestMapping
    public Map<String,Object>findBaoJingYuJingTree(){
        List<TreeNodeUtil> treeNodeUtils=baoJingYuJingPropertyService.findBaoJingYuJingTree(-1);
        return ResponseDataUtil.ok("查询报警预警树结构成功",treeNodeUtils);
    }
}
