package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.SolutionDao;
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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author:mlf
 * @date:2020/7/3 18:07
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class SolutionServiceImpl implements SolutionService {


    @Autowired
    private SolutionDao solutionDao;

    @Override
    public Map<String, Object> workCompletion(Integer selectType, Date date) {
        Map<String, Object> map = new HashMap<>();
        List<Integer> projectFinishCount = solutionDao.countTaskStatusByGroupBy(selectType, date);
        map.put("preSale", projectFinishCount.stream().limit(2).collect(Collectors.toList()));
        map.put("bidding", projectFinishCount.stream().skip(2).limit(2).collect(Collectors.toList()));
        map.put("designLiaison", projectFinishCount.stream().skip(4).limit(2).collect(Collectors.toList()));
        return map;
    }

    @Override
    public List<Map<String, Object>> biddingProject(Date startDate, Date endDate, Short projectStatus) {
        return solutionDao.selectByDateSectionAndProjectStatus(startDate, endDate, projectStatus);
    }
}
