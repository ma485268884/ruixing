package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.ListDao;
import com.yintu.ruixing.entity.CheZhanEntity;
import com.yintu.ruixing.entity.DianWuDuanEntity;
import com.yintu.ruixing.entity.TieLuJuEntity;
import com.yintu.ruixing.entity.XianDuanEntity;
import com.yintu.ruixing.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO
 *
 * @description:
 * @author: Qiao
 * @time: 2020/5/21 17:08
 */
@Service
@Transactional
public class ListServiceImpl implements ListService {
    @Autowired
    private ListDao ld;


    @Override
    public List<TieLuJuEntity> findall() {
        return ld.getListTieLuJuAll();
    }

    @Override
    public List<DianWuDuanEntity> findallBytljid(Long tlj_id) {
        return ld.getDianWuDuan(tlj_id);
    }

    @Override
    public List<XianDuanEntity> findallBydwdid(Long dwd_id) {
        return ld.getXianDuan(dwd_id);
    }

    @Override
    public List<CheZhanEntity> findallByxdid(Long xd_id) {
        return ld.getCheZhan(xd_id);
    }
}
