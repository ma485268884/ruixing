package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.MenXianPropertyEntity;
import com.yintu.ruixing.service.MenXianPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/12 15:53
 */
@RestController
@RequestMapping("/properties")
public class MenXianPropertyController extends BaseController {

    @Autowired
    private MenXianPropertyService menXianPropertyService;

    /**
     * 查询门限参数属性树成功
     *
     */
    @RequestMapping
    public Map<String, Object> findTreeByParentId() {
        List<TreeNodeUtil> treeNodeUtils = menXianPropertyService.findByParentId(-1);
        return ResponseDataUtil.ok("查询门限参数属性树成功", treeNodeUtils);
    }

    /**
     * 查询门限参数属性列表成功
     *
     */
    @RequestMapping("/list")
    public Map<String, Object> findByNotParentId() {
        List<MenXianPropertyEntity> menXianPropertyEntities = menXianPropertyService.findByNotParentId(-1);
        return ResponseDataUtil.ok("查询门限参数属性树成功", menXianPropertyEntities);
    }


}
