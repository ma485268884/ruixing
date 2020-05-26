package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.result.Result;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.*;
import com.yintu.ruixing.service.DataStatsService;
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
    public Map<String,Object> editTieLuJu(@PathVariable Long id){
        dataStatsService.editTieLuJuById(id);
        return ResponseDataUtil.ok("修改铁路局信息成功");
    }
    //删除铁路局
    @DeleteMapping("/delTieLuJu/{id}")
    public Map<String,Object> delTieLuJu(@PathVariable Long id){
        dataStatsService.delTieLuJu(id);
        return ResponseDataUtil.ok("删除铁路局成功");
    }
    //新增电务段
    @PostMapping("/addDianWuDuan")
    public Map<String,Object> addDianWuDuan(DianWuDuanEntity dianWuDuanEntity){
      dataStatsService.addDianWuDuan(dianWuDuanEntity);

        return ResponseDataUtil.ok("新增电务段成功");
    }

    //修改电务段
    @PutMapping("/editDianWuDuan/{id}")
    public Map<String,Object>editDianWuDuan(Long id, DianWuDuanEntity dianWuDuanEntity){
        dataStatsService.editDianWuDuan(dianWuDuanEntity);
        return ResponseDataUtil.ok("修改电务段信息成功");
    }
    //删除电务段
    @DeleteMapping("/delDianWuDuan/{id}")
    public Map<String,Object>delDianWuDuan(@PathVariable Long id){
        dataStatsService.delDianWuDuan(id);
        return ResponseDataUtil.ok("删除电务段成功");
    }
    //新增线段
    @PostMapping("/addXianDuan")
    public Map<String,Object>addXianDuan(XianDuanEntity xianDuanEntity){
       dataStatsService.addXianDuan(xianDuanEntity);
        return ResponseDataUtil.ok("新增线段成功");
    }
    //删除线段
    @DeleteMapping("/delXianDuan/{id}")
    public Map<String,Object>delXianDuan(@PathVariable Long id){
        dataStatsService.delXianDuan(id);
        return ResponseDataUtil.ok("删除线段成功");
    }


}
