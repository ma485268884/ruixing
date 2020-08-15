package com.yintu.ruixing.guzhangzhenduan.impl;

import com.yintu.ruixing.guzhangzhenduan.DataShowDao;
import com.yintu.ruixing.guzhangzhenduan.DataShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author:lcy
 * @date:2020-05-30 16
 */
@Service
@Transactional
public class DataShowServiceImpl implements DataShowService {
    @Autowired
    private DataShowDao dataShowDao;

    @Override
    public Map<String, Object> allData(Long xid, Long cid, String quduan) {
        return dataShowDao.allData(xid,cid,quduan);
    }
}
