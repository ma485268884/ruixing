package com.yintu.ruixing.controller;

import com.yintu.ruixing.entity.CheZhanEntity;
import com.yintu.ruixing.service.DataStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author:lcy
 * @date:2020-05-21 11
 * 数据统计
 */
@RestController
@RequestMapping("chezhan")
public class DataStatsController {
    @Autowired
    private DataStatsService dataStatsService;

    @RequestMapping("/getAllData")
    public List<CheZhanEntity> getAllData(Map map){
        return dataStatsService.getAllData(map);
    }




}
