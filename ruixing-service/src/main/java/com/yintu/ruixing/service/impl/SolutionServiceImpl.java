package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.service.BiddingService;
import com.yintu.ruixing.service.DesignLiaisonService;
import com.yintu.ruixing.service.PreSaleService;
import com.yintu.ruixing.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/7/3 18:07
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class SolutionServiceImpl implements SolutionService {

    @Autowired
    private PreSaleService preSaleService;

    @Autowired
    private BiddingService biddingService;

    @Autowired
    private DesignLiaisonService designLiaisonService;


    @Override
    public Map<String, Object> workCompletion(Integer selectType, Date date) {
        Map<String, Object> map = new HashMap<>();
        map.put("preSale", preSaleService.countTaskStatusByGroupBy(selectType, date));
        map.put("bidding", biddingService.countTaskStatusByGroupBy(selectType, date));
        map.put("designLiaison", designLiaisonService.countTaskStatusByGroupBy(selectType, date));
        return map;
    }
}
