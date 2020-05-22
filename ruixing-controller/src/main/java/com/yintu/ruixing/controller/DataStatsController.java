package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.result.Result;
import com.yintu.ruixing.entity.DataStats;
import com.yintu.ruixing.entity.PageResponseDto;
import com.yintu.ruixing.service.DataStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

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
    //查询所有车站信息
    @GetMapping("/findAll")
    public Result findAll(){
            List<DataStats> list=dataStatsService.findAll();
            return new  Result(true,"查询数据成功",list);

    }
    //分页查询
    @GetMapping("/page")
    public PageResponseDto<DataStats> getByPage(Integer page, Integer limit){
        return dataStatsService.getByPage(page, limit);
    }




}
