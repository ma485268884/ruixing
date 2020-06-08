package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.QuDuanBaseEntity;
import com.yintu.ruixing.service.ZhanNeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author:lcy
 * @date:2020-06-06 19
 * 站内相关
 */
@RestController
@RequestMapping("/ZhanNei")
public class ZhanNeiController {

    @Autowired
    private ZhanNeiService zhanNeiService;


    @GetMapping("/findAllDianMaHua/{id}")
    public Map<String,Object>findAllDianMaHua(@PathVariable Long id){
       List<QuDuanBaseEntity> quDuanBaseEntities= zhanNeiService.findAllDianMaHua(id);
       return ResponseDataUtil.ok("查询电码化数据成功",quDuanBaseEntities);
    }


}
