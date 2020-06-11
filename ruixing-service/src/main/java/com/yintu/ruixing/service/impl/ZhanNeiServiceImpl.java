package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.QuDuanInfoDao;
import com.yintu.ruixing.dao.ZhanNeiDao;
import com.yintu.ruixing.entity.CheZhanEntity;
import com.yintu.ruixing.entity.QuDuanBaseEntity;
import com.yintu.ruixing.entity.QuDuanInfoEntity;
import com.yintu.ruixing.service.ZhanNeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:lcy
 * @date:2020-06-06 19
 * 站内相关
 */
@Service
@Transactional
public class ZhanNeiServiceImpl implements ZhanNeiService {
    @Autowired
    private ZhanNeiDao zhanNeiDao;

    @Autowired
    private QuDuanInfoDao quDuanInfoDao;

    @Override
    public List<QuDuanBaseEntity> findAllDianMaHua(Long id) {
        return zhanNeiDao.findAllDianMaHua(id);
    }

    @Override
    public List<CheZhanEntity> findAllWangLuoLianJie() {
        return zhanNeiDao.findAllWangLuoLianJie();
    }

    @Override
    public void editWangLuoLianJieById(CheZhanEntity cheZhanEntity) {
        zhanNeiDao.editWangLuoLianJieById(cheZhanEntity);
    }

    @Override
    public List<QuDuanInfoEntity> findDianMaHuaDatabById(Integer id) {
        return quDuanInfoDao.findDianMaHuaDatabById(id);
    }

    @Override
    public List<CheZhanEntity> findTieLuJuById(Integer page, Integer size) {
        return zhanNeiDao.findAllWangLuoLianJie();
    }
}
