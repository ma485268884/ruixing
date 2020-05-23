package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.result.Result;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.DataStats;
import com.yintu.ruixing.entity.DianWuDuanEntity;
import com.yintu.ruixing.entity.PageResponseDto;
import com.yintu.ruixing.entity.TieLuJuEntity;
import com.yintu.ruixing.service.DataStatsService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    //查询所有车站信息
    @GetMapping("/findAll")
    public Result findAll() {
        List<DataStats> list = dataStatsService.findAll();
        return new Result(true, "查询数据成功", list);

    }

    //分页查询
    @GetMapping("/page")
    public PageResponseDto<DataStats> getByPage(Integer page, Integer limit) {
        return dataStatsService.getByPage(page, limit);
    }


    //查询铁路局
    @GetMapping("/tieluju/{id}")
    public Result findTieLuJuById(@PathVariable Long id) {
        TieLuJuEntity tieLuJuEntity = dataStatsService.findTieLuJuById(id);
        return new Result(true, "查询铁路局成功", tieLuJuEntity);
    }

    //查询铁路局下的查电务段

    @GetMapping("/dianwuduan/{id}")
    public Result findDianWuDuanById(@PathVariable Long id){
        DianWuDuanEntity dianWuDuanEntity=dataStatsService.findDianWuDuanById(id);
        return new Result(true,"查询电务段成功",dianWuDuanEntity);
    }

    //新增铁路局
    @PostMapping("/addTieLuJU")
    public Map<String,Object> addTieLuJU(TieLuJuEntity tieLuJuEntity){
        dataStatsService.addTieLuJU(tieLuJuEntity);
        return ResponseDataUtil.ok("添加铁路局成功");
    }
    //修改铁路局信息
    @PutMapping("/editTieLuJu/{id}")
    public Map<String,Object> editTieLuJu(Long id){
        dataStatsService.editTieLuJuById(id);
        return ResponseDataUtil.ok("修改铁路局信息成功");
    }
}
