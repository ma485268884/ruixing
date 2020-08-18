package com.yintu.ruixing.guzhangzhenduan.impl;

import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.guzhangzhenduan.SkylightTimeDao;
import com.yintu.ruixing.guzhangzhenduan.SkylightTimeEntity;
import com.yintu.ruixing.guzhangzhenduan.SkylightTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/8/18 17:55
 */
@Service
@Transactional
public class SkylightTimeServiceImpl implements SkylightTimeService {
    @Autowired
    private SkylightTimeDao skylightTimeDao;

    @Override
    public void add(SkylightTimeEntity entity) {
        skylightTimeDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        skylightTimeDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(SkylightTimeEntity entity) {
        skylightTimeDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public SkylightTimeEntity findById(Integer id) {
        return skylightTimeDao.selectByPrimaryKey(id);
    }

    @Override
    public void add(SkylightTimeEntity entity, Integer[] qdIds) {
        for (Integer qbId : qdIds) {
            SkylightTimeEntity skylightTimeEntity = this.findByCzIdAndQdId(entity.getCzId(), qbId);
            if (skylightTimeEntity == null) {
                entity.setQdId(qbId);
                this.add(entity);
            }
        }
    }

    @Override
    public void remove(Integer[] ids) {
        for (Integer id : ids) {
            this.remove(id);
        }
    }

    @Override
    public SkylightTimeEntity findByCzIdAndQdId(Integer czId, Integer qdId) {
        return skylightTimeDao.selectByCzIdAndQdId(czId, qdId);
    }

    @Override
    public List<SkylightTimeEntity> findByCondition(Integer id, Date startTime, Date endTime) {
        return skylightTimeDao.connectSelectByCondition(id, startTime, endTime);
    }
}
