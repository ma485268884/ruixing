package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.ChanPinJiaoFuPropertyEntity;
import com.yintu.ruixing.service.ChanPinJiaoFuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author Mis.liu
 * @Date 2020/6/23 16:16
 * @Version 1.0
 * 产品交付模块
 */
@RestController
@RequestMapping("/chanPinJiaoFuAll")
public class ChanPinJiaoFuController {
    @Autowired
    private ChanPinJiaoFuService chanPinJiaoFuService;

    //查询树形结构
    @GetMapping
    public Map<String,Object>findChanPinJiaoFuShuXing(){
        List<TreeNodeUtil> treeNodeUtils=chanPinJiaoFuService.findChanPinJiaoFuShuXing(-1);
        return ResponseDataUtil.ok("查询产品交付树结构成功",treeNodeUtils);
    }

    @PostMapping("/addDataShu")  //当表中没有数据时  添加第一条数据
    public Map<String,Object>addDataShu(ChanPinJiaoFuPropertyEntity chanPinJiaoFuPropertyEntity){
       Integer parendid=chanPinJiaoFuService.findAllDataShu();
       if (parendid ==null){
           chanPinJiaoFuService.addfristData(chanPinJiaoFuPropertyEntity);
           return ResponseDataUtil.ok("添加第一条数据成功");
       }else {
            chanPinJiaoFuService.addDataShu(chanPinJiaoFuPropertyEntity);
           return ResponseDataUtil.ok("添加数据成功");
       }
    }
}
