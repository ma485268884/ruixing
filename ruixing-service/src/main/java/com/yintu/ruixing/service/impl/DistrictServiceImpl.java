package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.DistrictDao;
import com.yintu.ruixing.entity.DistrictEntity;
import com.yintu.ruixing.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/28 13:43
 */
@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictDao districtDao;

    @Override
    public DistrictEntity findById(Integer id) {
        return districtDao.selectByPrimaryKey(id);
    }

    @Override
    public List<DistrictEntity> findByParentId(Integer parentId) {
        return districtDao.selectByParentId(parentId);
    }
}
