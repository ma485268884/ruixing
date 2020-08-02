package com.yintu.ruixing.controller;


import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.DianWuDuanEntity;
import com.yintu.ruixing.entity.TieLuJuEntity;
import com.yintu.ruixing.entity.XianDuanEntity;
import com.yintu.ruixing.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


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

    @GetMapping("/getErJi")
    public Object getErJi(){
        return ResponseDataUtil.ok("查询数据成功",ls.getErJi());
    }

    @GetMapping("/getSanJi")
    public Object getSanJi(){
        return ResponseDataUtil.ok("查询数据成功",ls.getSanJi());
    }

    //获取第一级和第二级的数据
    @GetMapping("/findOneTwoDatas")
    public Map<String,Object>findOneTwoDatas(){
        List<TieLuJuEntity> datasList=ls.findOneTwoDatas();
        return ResponseDataUtil.ok("查询铁路局和电务段数据成功",datasList);
    }

    //根据电务段的id 查询对应的线段和车站
    @GetMapping("/findXDAndCZByDWDId/{dwdid}")
    public Map<String,Object>findXDAndCZByDWDId(@PathVariable Integer dwdid){
        List<DianWuDuanEntity>dianWuDuanEntityList=ls.findXDAndCZByDWDId(dwdid);
        return ResponseDataUtil.ok("查询电务段下面的数据成功",dianWuDuanEntityList);
    }
}
