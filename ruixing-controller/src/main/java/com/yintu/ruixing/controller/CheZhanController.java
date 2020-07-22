package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.CheZhanEntity;
import com.yintu.ruixing.entity.QuDuanBaseEntity;
import com.yintu.ruixing.service.CheZhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @description:
 * @author: Qiao
 * @time: 2020/5/25 17:20
 */
@RestController
@RequestMapping("/chezhanAll")
public class CheZhanController {

    @Autowired
    private CheZhanService cheZhanService;

    @PostMapping("/addCheZhan")
    public Map<String,Object> addCheZhan(CheZhanEntity cheZhanEntity){
        cheZhanService.add(cheZhanEntity);
        return ResponseDataUtil.ok("添加车站成功");
    }
    @PutMapping("/updateCheZhan/{cid}")
    public Map<String,Object> updateCheZhan(@PathVariable Long cid ,CheZhanEntity cheZhanEntity){
        cheZhanService.update(cheZhanEntity);
        return  ResponseDataUtil.ok("修改车站信息成功");
    }

    @GetMapping("/findByCheZhanId/{cid}")
    public  Map<String,Object> findByCheZhanId(@PathVariable Long cid){
        CheZhanEntity cheZhanEntity = cheZhanService.findByCheZhanId(cid);
        return ResponseDataUtil.ok("查询车站信息成功",cheZhanEntity);
    }
    //删除车站
    @DeleteMapping("/delCheZhan/{cid}")
    public Map<String,Object>delCheZhan(@PathVariable Long cid){
        List<QuDuanBaseEntity>quDuanBaseEntityList=cheZhanService.findQuDuanByCid(cid);
        if (quDuanBaseEntityList.size()==0){
            cheZhanService.delCheZhan(cid);
            return ResponseDataUtil.ok("删除车站成功");
        }else {
            return ResponseDataUtil.error("此车站不能删除");
        }
    }
}
