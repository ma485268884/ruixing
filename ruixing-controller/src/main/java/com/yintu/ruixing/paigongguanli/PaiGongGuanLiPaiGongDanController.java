package com.yintu.ruixing.paigongguanli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Mr.liu
 * @Date 2020/8/22 19:31
 * @Version 1.0
 * 需求:  派工单
 */
@RestController
@RequestMapping("/PaiGongDanAll")
public class PaiGongGuanLiPaiGongDanController {
    @Autowired
    private PaiGongGuanLiPaiGongDanService paiGongGuanLiPaiGongDanService;

}
