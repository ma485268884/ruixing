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
    @GetMapping("/findPage")
    public PageInfo<DataStats>findPage(Integer page,Integer size){
        PageInfo<DataStats> pageInfo= dataStatsService.findPage(page,size);
        return pageInfo;
    }

    //分页查询
    @GetMapping("/page")
    public PageResponseDto<DataStats> getByPage(Integer page, Integer size) {
        return dataStatsService.getByPage(page, size);
    }

    //查询层级下的铁路局
    @GetMapping("/findTieLuJuById/{id}")
    public Map<String, Object> findTieLuJuById(@PathVariable Long id) {
        TieLuJuEntity tieLuJuEntity = dataStatsService.findTieLuJuById(id);
        return ResponseDataUtil.ok("查询铁路局成功", tieLuJuEntity);
    }

    //根据id查询铁路局下的电务段
    @GetMapping("/findDianWuDuanById/{tid}/{did}")
    public Map<String, Object> findDianWuDuanById(@PathVariable Long tid, @PathVariable Long did) {
        DataStats dataStats = dataStatsService.findDianWuDuanById(tid, did);
        return ResponseDataUtil.ok("查询电务段信息成功", dataStats);
    }

    //根据id查询铁路局下的电务段下的线段
    @GetMapping("/findXianDuanById/{tid}/{did}/{xid}")
    public Map<String, Object> findXianDuanById(@PathVariable Long tid, @PathVariable Long did, @PathVariable Long xid) {
        DataStats dataStats = dataStatsService.findXianDuanById(tid, did, xid);
        return ResponseDataUtil.ok("查询线段信息成功", dataStats);
    }

    //根据id查询铁路局下的电务段下的线段的车站
    @GetMapping("/findCheZhanById/{tid}/{did}/{xid}/{cid}")
    public Map<String, Object> findCheZhanById(@PathVariable Long tid, @PathVariable Long did, @PathVariable Long xid, @PathVariable Long cid) {
        DataStats dataStats = dataStatsService.findCheZhanById(tid, did, xid, cid);
        return ResponseDataUtil.ok("查询车站信息成功", dataStats);
    }


    /**
     * 获取用户分页信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    /*@GetMapping(value = "/getUserPageList")
    public PageInfo<DataStats> getUserPageList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "3") int pageSize) {

        // pageNum:表示第几页  pageSize:表示一页展示的数据
        PageHelper.startPage(pageNum, pageSize);
        List<DataStats> systemUserPojoList = null;

        try {

            systemUserPojoList = iSystemUserService.select();
            // 将查询到的数据封装到PageInfo对象
            PageInfo<SystemUserPojo> systemUserPojoPageInfo = new PageInfo(systemUserPojoList, pageSize);
            // 分割数据成功
            return systemUserPojoPageInfo;

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            // 将查询到的数据封装到PageInfo对象
            PageInfo<SystemUserPojo> systemUserPojoPageInfo = new PageInfo(null, pageSize);
            // 分割数据成功
            return systemUserPojoPageInfo;

        }

    }*/


}
