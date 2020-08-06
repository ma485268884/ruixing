package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.XianDuanDao;
import com.yintu.ruixing.entity.DianWuDuanEntity;
import com.yintu.ruixing.entity.XianDuanEntity;
import com.yintu.ruixing.service.XianDuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:lcy
 * @date:2020-05-26 11
 * 线段的serviceimpl
 */
@Service
@Transactional
public class XianDuanServiceImpl implements XianDuanService {
    @Autowired
    private XianDuanDao xianDuanDao;

    @Override
    public void addXianDuan(XianDuanEntity xianDuanEntity,Long[] dwdids,Long[] dids) {
        for (int i = 0; i < dids.length; i++) {
            for (int i1 = 0; i1 < dids.length; i1++) {
                xianDuanEntity.setXdState(0);
                xianDuanEntity.setDwdId(dwdids[i]);
                xianDuanEntity.setDwdXdId(dids[i]);
                if (i1==i){
                    xianDuanDao.addXianDuan(xianDuanEntity);
                }
            }
        }
    }

    @Override
    public void delXianDuan(Long xid) {
        xianDuanDao.delXianDuan(xid);
    }

    @Override
    public void editXianDuan(XianDuanEntity xianDuanEntity) {
        xianDuanDao.editXianDuan(xianDuanEntity);
    }

    @Override
    public XianDuanEntity findXianDuanById(Long xid) {
        return xianDuanDao.findXianDuanById(xid);
    }

    @Override
    public List<Integer> findId(Long xid) {
        return xianDuanDao.findId(xid);
    }

    @Override
    public List<String> findAllJsonByDid(Integer did) {
        return xianDuanDao.findAllJsonByDid(did);
    }
}
