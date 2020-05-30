package com.yintu.ruixing.controller;



import com.github.pagehelper.PageInfo;
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
@RequestMapping("/dataStats")
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
    @GetMapping("/findPage/{page}/{size}")
    public PageInfo<DataStats>findPage(@PathVariable Integer page, @PathVariable Integer size){
        PageInfo<DataStats> pageInfo= dataStatsService.findPage(page,size);
        return pageInfo;
    }

    //批量删除车站
    @DeleteMapping("/delCheZhanListById/{ids}")
    public Map<String,Object> delCheZhanListById(@PathVariable int[] ids){
        dataStatsService.delCheZhanListById(ids);
        return ResponseDataUtil.ok("批量删除车站信息成功");
    }

    //查询层级下的铁路局
    @GetMapping("/findTieLuJuById/{tid}")
    public Map<String, Object> findTieLuJuById(@PathVariable Long tid) {
       List<TieLuJuEntity> tieLuJuEntity = dataStatsService.findTieLuJuById(tid);
        return ResponseDataUtil.ok("查询铁路局成功", tieLuJuEntity);
    }

    //根据id查询铁路局下的电务段
    @GetMapping("/findDianWuDuanById/{tid}/{did}")
    public Map<String, Object> findDianWuDuanById(@PathVariable Long tid, @PathVariable Long did) {
        List<DataStats> dataStats = dataStatsService.findDianWuDuanById(tid, did);
        return ResponseDataUtil.ok("查询电务段信息成功", dataStats);
    }

    //根据id查询铁路局下的电务段下的线段
    @GetMapping("/findXianDuanById/{tid}/{did}/{xid}")
    public Map<String, Object> findXianDuanById(@PathVariable Long tid, @PathVariable Long did, @PathVariable Long xid) {
        List<DataStats> dataStats = dataStatsService.findXianDuanById(tid, did, xid);
        return ResponseDataUtil.ok("查询线段信息成功", dataStats);
    }

    //根据id查询铁路局下的电务段下的线段的车站
    @GetMapping("/findCheZhanById/{tid}/{did}/{xid}/{cid}")
    public Map<String, Object> findCheZhanById(@PathVariable Long tid, @PathVariable Long did, @PathVariable Long xid, @PathVariable Long cid) {
        DataStats dataStats = dataStatsService.findCheZhanById(tid, did, xid, cid);
        return ResponseDataUtil.ok("查询车站信息成功", dataStats);
    }

}
