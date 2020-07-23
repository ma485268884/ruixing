package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.CheZhanEntity;
import com.yintu.ruixing.entity.QuDuanInfoEntityV2;
import com.yintu.ruixing.service.CheZhanService;
import com.yintu.ruixing.service.QuDuanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/3 12:00
 */
@RestController
@RequestMapping("/quduan/infos")
public class QuDuanInfoController extends SessionController {
    @Autowired
    private QuDuanInfoService quDuanInfoService;
    @Autowired
    private CheZhanService cheZhanService;


    /**
     * 查询区段基础信息列表
     *
     * @param czId 车站id
     * @return 区段基本信息列表
     */
    @GetMapping("/base")
    public Map<String, Object> findJsonConfigByCid(@RequestParam("czId") Integer czId) {
        CheZhanEntity cheZhanEntity = cheZhanService.findByCzId(czId);
        return ResponseDataUtil.ok("查询区段基础信息列表", cheZhanEntity.getCzJson());
    }

    /**
     * 按照车站随机取出一条区段详情
     *
     * @param czId 区段id
     * @return
     */
    @GetMapping("/chezhan")
    public Map<String, Object> findLastBycZId(@RequestParam("czId") Integer czId) {
        QuDuanInfoEntityV2 quDuanInfoEntity = quDuanInfoService.findLastBycZId(czId);
        return ResponseDataUtil.ok("查询区段详情", quDuanInfoEntity);
    }


    /**
     * 数据分析
     *
     * @param qid 区段id
     * @return 实时的数据
     */
    @GetMapping("/dataanalysis")
    public Map<String, Object> findLastByQid(@RequestParam("qid") Integer qid) {
        QuDuanInfoEntityV2 quDuanInfoEntity = quDuanInfoService.findLastByQid(qid);
        return ResponseDataUtil.ok("查询区段详情", quDuanInfoEntity);
    }


    /**
     * 实时报表
     *
     * @param pageNumber 页码
     * @param pageSize   页数
     * @return
     */
    @GetMapping("/realreport")
    public Map<String, Object> findByCzId(@RequestParam("page_number") Integer pageNumber,
                                          @RequestParam("page_size") Integer pageSize,
                                          @RequestParam(value = "order_by", required = false, defaultValue = "qb.id ASC") String orderBy,
                                          @RequestParam("cz_id") Integer cZid) {
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<QuDuanInfoEntityV2> quDuanInfoEntities = quDuanInfoService.findByCzIdAndTime(cZid, new Date());
        PageInfo<QuDuanInfoEntityV2> pageInfo = new PageInfo<>(quDuanInfoEntities);
        return ResponseDataUtil.ok("查询实时报表成功", pageInfo);
    }

    /**
     * 日报表
     *
     * @param pageNumber 页码
     * @param pageSize   页数
     * @param time       日期
     */
    @GetMapping("/dailypaper")
    public Map<String, Object> findStatisticsByDate(@RequestParam("page_number") Integer pageNumber,
                                                    @RequestParam("page_size") Integer pageSize,
                                                    @RequestParam(value = "order_by", required = false, defaultValue = "qb.id ASC") String orderBy,
                                                    @RequestParam("cz_id") Integer cZid,
                                                    @RequestParam("time") Date time) {
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<Map<String, Object>> maps = quDuanInfoService.findStatisticsByCzIdAndTime(cZid, time);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(maps);
        return ResponseDataUtil.ok("查询日报表成功", pageInfo);
    }


}
