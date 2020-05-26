package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.CheZhanEntity;
import com.yintu.ruixing.service.CheZhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/updateCheZhan/{id}")
    public Map<String,Object> updateCheZhan(@PathVariable Long id ,CheZhanEntity cheZhanEntity){
        cheZhanService.update(cheZhanEntity);
        return  ResponseDataUtil.ok("修改车站信息成功");
    }

    @GetMapping("/findByCheZhanId/{id}")
    public  Map<String,Object> findByCheZhanId(@PathVariable Long id){
        CheZhanEntity cheZhanEntity = cheZhanService.findByCheZhanId(id);
        return ResponseDataUtil.ok("查询车站信息成功",cheZhanEntity);
    }
    //删除车站
    @DeleteMapping("/delCheZhan/{id}")
    public Map<String,Object>delCheZhan(@PathVariable Long id){
        cheZhanService.delCheZhan(id);
        return ResponseDataUtil.ok("删除车站成功");
    }
}
