package com.yintu.ruixing.controller;


import com.alibaba.fastjson.JSONObject;
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
        List<DataStatsEntity> list = dataStatsService.findAll();
        return new Result(true, "查询数据成功", list);

    }

    //分页查询
    @GetMapping("/findPage/{page}/{size}")
    public PageInfo<DataStatsEntity> findPage(@PathVariable Integer page, @PathVariable Integer size) {
        PageInfo<DataStatsEntity> pageInfo = dataStatsService.findPage(page, size);
        return pageInfo;
    }

    //批量删除车站
    @DeleteMapping("/delCheZhanListById/{ids}")
    public Map<String, Object> delCheZhanListById(@PathVariable int[] ids) {
        dataStatsService.delCheZhanListById(ids);
        return ResponseDataUtil.ok("批量删除车站信息成功");
    }

    //查询所有的车站  展示在列表
    @RequestMapping("/findAllCheZhan")
    public Map<String, Object> findAllCheZhan(@RequestParam(value = "page", required = false) Integer page,
                                              @RequestParam(value = "size", required = false) Integer size) {
        JSONObject jo = new JSONObject();
        PageHelper.startPage(page, size);
        List<DataStatsEntity> dataStatEntities = dataStatsService.findAllCheZhan(page, size);
        jo.put("dataStatEntities", dataStatEntities);
        PageInfo<DataStatsEntity> pageInfo = new PageInfo<>(dataStatEntities);
        jo.put("pageInfo", pageInfo);
        return ResponseDataUtil.ok("查询所有车站信息成功", jo);
    }

    //根据铁路局id  查询此铁路局下的所有车站
    @GetMapping("/findTieLuJuById/{tid}")
    public Map<String, Object> findTieLuJuById(@PathVariable Long tid,
                                               @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        JSONObject jo = new JSONObject();
        List<DataStatsEntity> tieLuJuEntity = dataStatsService.findTieLuJuById(tid, page, size);
        jo.put("tieLuJuEntity", tieLuJuEntity);
        PageHelper.startPage(page, size);
        List<DataStatsEntity> all = dataStatsService.findTieLuJuById(tid, page, size);
        PageInfo<DataStatsEntity> pageInfo = new PageInfo<DataStatsEntity>(all);
        jo.put("pageInfo", pageInfo);
        //System.out.println("分页为" + pageInfo);
        return ResponseDataUtil.ok("查询铁路局成功", jo);
    }

    //根据电务段id  查询此电务段下的所有车站
    @GetMapping("/findDianWuDuanCheZhanById/{did}")
    public Map<String, Object> findDianWuDuanById(@PathVariable Long did,
                                                  @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        JSONObject jo = new JSONObject();
        List<DataStatsEntity> dianwuduan = dataStatsService.findDianWuDuanCheZhanById(did, page, size);
        jo.put("dianwuduan", dianwuduan);
        PageHelper.startPage(page, size);
        List<DataStatsEntity> all = dataStatsService.findDianWuDuanCheZhanById(did, page, size);
        PageInfo<DataStatsEntity> pageInfo = new PageInfo<DataStatsEntity>(all);
        jo.put("pageInfo", pageInfo);
        //System.out.println("分页为" + pageInfo);
        return ResponseDataUtil.ok("查询铁路局成功", jo);
    }

    //根据线段id  查询此线段下的所有车站
    @GetMapping("/findXianDuanCheZhanById/{xid}")
    public Map<String, Object> findXianDuanCheZhanById(@PathVariable Long xid,
                                                       @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        JSONObject jo = new JSONObject();
        List<DataStatsEntity> xianduan = dataStatsService.findXianDuanCheZhanById(xid, page, size);
        jo.put("xianduan", xianduan);
        PageHelper.startPage(page, size);
        List<DataStatsEntity> all = dataStatsService.findXianDuanCheZhanById(xid, page, size);
        PageInfo<DataStatsEntity> pageInfo = new PageInfo<DataStatsEntity>(all);
        jo.put("pageInfo", pageInfo);
        //System.out.println("分页为" + pageInfo);
        return ResponseDataUtil.ok("查询铁路局成功", jo);
    }

    //根据车站id  查询车站信息
    @GetMapping("/findCheZhanById/{cid}")
    public Map<String, Object> findCheZhanById(@PathVariable Long cid,
                                               @RequestParam(value = "page", required = false) Integer page,
                                               @RequestParam(value = "size", required = false) Integer size) {
        JSONObject jo = new JSONObject();
        List<DataStatsEntity> chezhan = dataStatsService.findCheZhanById(cid, page, size);
        jo.put("chezhan", chezhan);
        PageHelper.startPage(page, size);
        List<DataStatsEntity> all = dataStatsService.findCheZhanById(cid, page, size);
        PageInfo<DataStatsEntity> pageInfo = new PageInfo<DataStatsEntity>(all);
        jo.put("pageInfo", pageInfo);
        //System.out.println("分页为" + pageInfo);
        return ResponseDataUtil.ok("查询铁路局成功", jo);
    }


    //根据线段id更改状态
    @PutMapping("/editStateByXid/{xid}")
    public Map<String, Object> editStateByXid(@PathVariable Integer xid, XianDuanEntity xianDuanEntity) {
        dataStatsService.editStateByXid(xianDuanEntity);
        return ResponseDataUtil.ok("更改线段状态成功");
    }

    //根据车站id更改状态
    @PutMapping("/editStateByCid/{cid}")
    public Map<String, Object> editStateByCid(@PathVariable Integer cid, CheZhanEntity cheZhanEntity) {
        dataStatsService.editStateByCid(cheZhanEntity);
        return ResponseDataUtil.ok("更改车站状态成功");
    }

    //根据线段id 清除json  和更改状态
    @PutMapping("/qingChuaByXid/{xid}")
    public Map<String,Object>qingChuaByXid(@PathVariable Integer xid,XianDuanEntity xianDuanEntity){
       dataStatsService.qingChuaByXid(xianDuanEntity);
       return ResponseDataUtil.ok("清除线段成功");
    }
    //根据车站id  清除json  和更改状态
    @PutMapping("/qingChuaByCid/{cid}")
    public Map<String,Object>qingChuaByCid(@PathVariable Integer cid,CheZhanEntity cheZhanEntity){
        dataStatsService.qingChuaByCid(cheZhanEntity);
        return ResponseDataUtil.ok("清除车站成功");
    }

    //查询所有的铁路局的名字  和 id
    @GetMapping("/findAllTieLuJu")
    public Map<String, Object> findAllTieLuJu(TieLuJuEntity tieLuJuEntity) {
        List<TieLuJuEntity> tieLuJuEntities = dataStatsService.findAllTieLuJu(tieLuJuEntity);
        return ResponseDataUtil.ok("查询铁路局成功", tieLuJuEntities);
    }

    //根据铁路局的id  查询对应的电务段
    @GetMapping("/findDianWuDuanByTid/{tid}")
    public Map<String, Object> findDianWuDuanByTid(@PathVariable Integer tid) {
        List<DianWuDuanEntity> dianWuDuanEntities = dataStatsService.findDianWuDuanByTid(tid);
        return ResponseDataUtil.ok("查询电务段成功", dianWuDuanEntities);
    }

    //根据电务段的id  查找线段的名字和id
    @GetMapping("/findXianDuanByDid/{did}")
    public Map<String, Object> findXianDuanByDid(@PathVariable Integer did) {
        List<XianDuanEntity> xianDuanEntities = dataStatsService.findXianDuanByDid(did);
        return ResponseDataUtil.ok("查询线段成功", xianDuanEntities);
    }

    //根据线段的id  查找车站的名字和id
    @GetMapping("/findCheZhanByXid/{xid}")
    public Map<String, Object> findCheZhanByXid(@PathVariable Integer xid) {
        List<CheZhanEntity> cheZhanEntities = dataStatsService.findCheZhanByXid(xid);
        return ResponseDataUtil.ok("查询车站成功", cheZhanEntities);
    }


    //查询站外所有的区段信息  排除电码化
    @GetMapping("/findAllQuDuan")
    public Map<String, Object> findAllQuDuan(@RequestParam(value = "page", required = false) Integer page,
                                             @RequestParam(value = "size", required = false) Integer size) {
        JSONObject jo = new JSONObject();
        PageHelper.startPage(page, size);
        List<QuDuanBaseEntity> quDuanBaseEntities = dataStatsService.findAllQuDuan(page, size);
        jo.put("quDuanBaseEntities", quDuanBaseEntities);
        PageInfo<QuDuanBaseEntity> quDuanBaseEntityPageInfo = new PageInfo<>(quDuanBaseEntities);
        jo.put("quDuanBaseEntityPageInfo", quDuanBaseEntityPageInfo);
        return ResponseDataUtil.ok("查询所有站外区段成功", quDuanBaseEntityPageInfo);
    }

    //查询所有的电码化区段
    @GetMapping("/findAllDianMaHua")
    public Map<String, Object> findAllDianMaHua(@RequestParam(value = "page", required = false) Integer page,
                                                @RequestParam(value = "size", required = false) Integer size) {
        JSONObject jo = new JSONObject();
        PageHelper.startPage(page, size);
        List<QuDuanBaseEntity> quDuanBaseEntities = dataStatsService.findAllDianMaHua(page, size);
        jo.put("quDuanBaseEntities", quDuanBaseEntities);
        PageInfo<QuDuanBaseEntity> pageInfo = new PageInfo<>(quDuanBaseEntities);
        jo.put("pageInfo", pageInfo);
        return ResponseDataUtil.ok("查询电码化成功", jo);
    }

    //根据车站的cid  查找本车站下的所有站外的区段

    @GetMapping("/findAllQuDuanByCid/{cid}")
    public Map<String, Object> findAllQuDuanByCid(@PathVariable Integer cid,
                                                  @RequestParam(value = "page", required = false) Integer page,
                                                  @RequestParam(value = "size", required = false) Integer size) {
        JSONObject jo = new JSONObject();
        PageHelper.startPage(page, size);
        List<QuDuanBaseEntity> quDuanBaseEntities = dataStatsService.findAllQuDuanByCid(cid, page, size);
        jo.put("quDuanBaseEntities", quDuanBaseEntities);
        PageInfo<QuDuanBaseEntity> quDuanBaseEntityPageInfo = new PageInfo<>(quDuanBaseEntities);
        jo.put("quDuanBaseEntityPageInfo", quDuanBaseEntityPageInfo);
        return ResponseDataUtil.ok("查询所有站外区段成功", quDuanBaseEntityPageInfo);
    }

    //根据车站的cid  查询所有的电码化区段

    @GetMapping("/findAllDianMaHuaByCid/{cid}")
    public Map<String, Object> findAllDianMaHuaByCid(@PathVariable Integer cid,
                                                     @RequestParam(value = "page", required = false) Integer page,
                                                     @RequestParam(value = "size", required = false) Integer size) {
        JSONObject jo = new JSONObject();
        PageHelper.startPage(page, size);
        List<QuDuanBaseEntity> quDuanBaseEntities = dataStatsService.findAllDianMaHuaByCid(cid, page, size);
        jo.put("quDuanBaseEntities", quDuanBaseEntities);
        PageInfo<QuDuanBaseEntity> quDuanBaseEntityPageInfo = new PageInfo<>(quDuanBaseEntities);
        jo.put("quDuanBaseEntityPageInfo", quDuanBaseEntityPageInfo);
        return ResponseDataUtil.ok("查询所有站外区段成功", quDuanBaseEntityPageInfo);
    }

    //新增站外区段  包括电码化
    @PostMapping("/addQuDuan")
    public Map<String, Object> addQuDuan(QuDuanBaseEntity quDuanBaseEntity) {
        dataStatsService.addQuDuan(quDuanBaseEntity);
        return ResponseDataUtil.ok("添加站外区段数据成功");
    }
    //根据区段id编辑区段信息  包括电码化
    @PutMapping("/editQuDuanById/{id}")
    public Map<String,Object>editQuDuanById(@PathVariable Integer id,QuDuanBaseEntity quDuanBaseEntity){
        dataStatsService.editQuDuanById(quDuanBaseEntity);
        return ResponseDataUtil.ok("修改区段信息成功");
    }

    //根据区段id删除区段信息
    @DeleteMapping("/deletQuDuanById/{id}")
    public Map<String,Object>deletQuDuanById(@PathVariable Integer id){
        dataStatsService.deletQuDuanById(id);
        return ResponseDataUtil.ok("删除区段数据成功");
    }

    //根据id批量删除区段数据
    @DeleteMapping("/deletQuDuanByIds/{ids}")
    public Map<String,Object>deletQuDuanByIds(@PathVariable Integer[] ids){
        dataStatsService.deletQuDuanByIds(ids);
        return ResponseDataUtil.ok("批量删除成功");
    }




























/*
    //根据id查询铁路局下的电务段
    @PostMapping("/findDianWuDuanById/{tid}/{did}")
    public Map<String, Object> findDianWuDuanById(@PathVariable Long tid, @PathVariable Long did,
                                                  @RequestParam Integer page, @RequestParam Integer size) {

        List<DataStatsEntity> dataStatEntities = dataStatsService.findDianWuDuanById(tid, did, page, size);
        List<DataStatsEntity> list = new ArrayList<>();
        for (DataStatsEntity dataStat : dataStatEntities) {
            if (dataStat.getTid() == tid && dataStat.getDid() == did) {
                list.add(dataStat);
                System.out.println("查询结果是" + list);
            }
        }
        JSONObject jo = new JSONObject();
        jo.put("list", list);
        PageHelper.startPage(page, size);
        PageInfo<DataStatsEntity> pageInfo = new PageInfo<DataStatsEntity>(list);
        System.out.println("pageInfo" + pageInfo);
        jo.put("pageInfo", pageInfo);
        return ResponseDataUtil.ok("查询电务段信息成功", jo);
    }

    //根据id查询铁路局下的电务段下的线段
    @PostMapping("/findXianDuanById/{tid}/{did}/{xid}")
    public Map<String, Object> findXianDuanById(@PathVariable Long tid, @PathVariable Long did, @PathVariable Long xid,
                                                @RequestParam Integer page, @RequestParam Integer size) {
        List<DataStatsEntity> dataStatEntities = dataStatsService.findXianDuanById(tid, did, xid, page, size);
        List<DataStatsEntity> list = new ArrayList<>();
        for (DataStatsEntity dataStat : dataStatEntities) {
            if (dataStat.getTid() == tid && dataStat.getDid() == did && dataStat.getXid() == xid) {
                list.add(dataStat);
            }
        }
        JSONObject jo = new JSONObject();
        jo.put("list", list);
        PageHelper.startPage(page, size);
        PageInfo<DataStatsEntity> pageInfo = new PageInfo<DataStatsEntity>(list);
        System.out.println("pageInfo" + pageInfo);
        jo.put("pageInfo", pageInfo);
        return ResponseDataUtil.ok("查询线段信息成功", jo);
    }

    //根据id查询铁路局下的电务段下的线段的车站
    @PostMapping("/findCheZhanById/{tid}/{did}/{xid}/{cid}")
    public Map<String, Object> findCheZhanById(@PathVariable Long tid, @PathVariable Long did, @PathVariable Long xid, @PathVariable Long cid,
                                               @RequestParam Integer page, @RequestParam Integer size) {
        List<DataStatsEntity> dataStatEntities = dataStatsService.findCheZhanById(tid, did, xid, cid, page, size);
        JSONObject jo = new JSONObject();
        jo.put("dataStatEntities", dataStatEntities);
        PageHelper.startPage(page, size);
        PageInfo<DataStatsEntity> pageInfo = new PageInfo<DataStatsEntity>(dataStatEntities);
        jo.put("pageInfo", pageInfo);
        System.out.println("分页为" + pageInfo);
        return ResponseDataUtil.ok("查询车站信息成功", jo);
    }*/

}
