package com.yintu.ruixing.paigongguanli.impl;

import com.yintu.ruixing.paigongguanli.PaiGongGuanLiPaiGongDanDao;
import com.yintu.ruixing.paigongguanli.PaiGongGuanLiPaiGongDanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Mr.liu
 * @Date 2020/8/22 19:32
 * @Version 1.0
 * 需求: 派工单
 */
@Service
@Transactional
public class PaiGongGuanLiPaiGongDanServiceImpl implements PaiGongGuanLiPaiGongDanService {
    @Autowired
    private PaiGongGuanLiPaiGongDanDao paiGongGuanLiPaiGongDanDao;
}
