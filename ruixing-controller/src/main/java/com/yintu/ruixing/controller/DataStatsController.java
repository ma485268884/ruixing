package com.yintu.ruixing.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.result.Result;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.*;
import com.yintu.ruixing.service.DataStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public PageInfo<DataStats> findPage(@PathVariable Integer page, @PathVariable Integer size) {
        PageInfo<DataStats> pageInfo = dataStatsService.findPage(page, size);
        return pageInfo;
    }

    //批量删除车站
    @DeleteMapping("/delCheZhanListById/{ids}")
    public Map<String, Object> delCheZhanListById(@PathVariable int[] ids) {
        dataStatsService.delCheZhanListById(ids);
        return ResponseDataUtil.ok("批量删除车站信息成功");
    }

    //查询层级下的铁路局
    @PostMapping("/findTieLuJuById/{tid}")
    public Map<String, Object> findTieLuJuById(@PathVariable Long tid,
                                               @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        JSONObject jo = new JSONObject();
        List<TieLuJuEntity> tieLuJuEntity = dataStatsService.findTieLuJuById(tid, page, size);
        jo.put("tieLuJuEntity", tieLuJuEntity);
        PageHelper.startPage(page, size);
        List<TieLuJuEntity> all = dataStatsService.findTieLuJuById(tid, page, size);
        PageInfo<TieLuJuEntity> pageInfo = new PageInfo<TieLuJuEntity>(all);
        jo.put("pageInfo", pageInfo);
        //System.out.println("分页为" + pageInfo);
        return ResponseDataUtil.ok("查询铁路局成功", jo);
    }

    //根据id查询铁路局下的电务段
    @PostMapping("/findDianWuDuanById/{tid}/{did}")
    public Map<String, Object> findDianWuDuanById(@PathVariable Long tid, @PathVariable Long did,
                                                  @RequestParam Integer page, @RequestParam Integer size) {

        List<DataStats> dataStats = dataStatsService.findDianWuDuanById(tid, did, page, size);
        List<DataStats> list = new ArrayList<>();
        for (DataStats dataStat : dataStats) {
            if (dataStat.getTid() == tid && dataStat.getDid() == did) {
                list.add(dataStat);
                System.out.println("查询结果是" + list);
            }
        }
        JSONObject jo = new JSONObject();
        jo.put("list", list);
        PageHelper.startPage(page, size);
        PageInfo<DataStats> pageInfo = new PageInfo<DataStats>(list);
        System.out.println("pageInfo" + pageInfo);
        jo.put("pageInfo", pageInfo);
        return ResponseDataUtil.ok("查询电务段信息成功", jo);
    }

    //根据id查询铁路局下的电务段下的线段
    @PostMapping("/findXianDuanById/{tid}/{did}/{xid}")
    public Map<String, Object> findXianDuanById(@PathVariable Long tid, @PathVariable Long did, @PathVariable Long xid,
                                                @RequestParam Integer page, @RequestParam Integer size) {
        List<DataStats> dataStats = dataStatsService.findXianDuanById(tid, did, xid, page, size);
        List<DataStats> list = new ArrayList<>();
        for (DataStats dataStat : dataStats) {
            if (dataStat.getTid() == tid && dataStat.getDid() == did && dataStat.getXid() == xid) {
                list.add(dataStat);
            }
        }
        JSONObject jo = new JSONObject();
        jo.put("list", list);
        PageHelper.startPage(page, size);
        PageInfo<DataStats> pageInfo = new PageInfo<DataStats>(list);
        System.out.println("pageInfo" + pageInfo);
        jo.put("pageInfo", pageInfo);
        return ResponseDataUtil.ok("查询线段信息成功", jo);
    }

    //根据id查询铁路局下的电务段下的线段的车站
    @PostMapping("/findCheZhanById/{tid}/{did}/{xid}/{cid}")
    public Map<String, Object> findCheZhanById(@PathVariable Long tid, @PathVariable Long did, @PathVariable Long xid, @PathVariable Long cid,
                                               @RequestParam Integer page, @RequestParam Integer size) {
        List<DataStats> dataStats = dataStatsService.findCheZhanById(tid, did, xid, cid, page, size);
        JSONObject jo = new JSONObject();
        jo.put("dataStats", dataStats);
        PageHelper.startPage(page, size);
        PageInfo<DataStats> pageInfo = new PageInfo<DataStats>(dataStats);
        jo.put("pageInfo", pageInfo);
        System.out.println("分页为" + pageInfo);
        return ResponseDataUtil.ok("查询车站信息成功", jo);
    }

}
