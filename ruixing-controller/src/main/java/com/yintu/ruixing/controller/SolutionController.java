package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/7/3 18:01
 */
@RestController
@RequestMapping("/solutions")
public class SolutionController extends SessionController {
    @Autowired
    private SolutionService solutionService;


    @GetMapping
    public Map<String, Object> workCompletion(@RequestParam("selectType") Integer selectType, @RequestParam("date") Date date) {
        Map<String, Object> map = solutionService.workCompletion(selectType, date);
        return ResponseDataUtil.ok("查询统计工作完成进度信息成功", map);
    }
}
