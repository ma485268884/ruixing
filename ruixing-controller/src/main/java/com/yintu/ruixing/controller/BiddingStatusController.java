package com.yintu.ruixing.controller;

import com.yintu.ruixing.service.SolutionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:mlf
 * @date:2020/6/28 17:16
 */
@RestController
@RequestMapping("/bidding/status")
public class BiddingStatusController extends BaseController {
    @Autowired
    private SolutionStatusService solutionStatusService;
    private final Short FLAG = new Short("2");//模块标识

}
