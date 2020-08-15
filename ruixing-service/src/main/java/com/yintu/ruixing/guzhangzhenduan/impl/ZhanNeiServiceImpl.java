package com.yintu.ruixing.guzhangzhenduan.impl;

import com.yintu.ruixing.guzhangzhenduan.QuDuanInfoDao;
import com.yintu.ruixing.guzhangzhenduan.QuDuanInfoDaoV2;
import com.yintu.ruixing.guzhangzhenduan.ZhanNeiDao;
import com.yintu.ruixing.guzhangzhenduan.CheZhanEntity;
import com.yintu.ruixing.guzhangzhenduan.QuDuanBaseEntity;
import com.yintu.ruixing.guzhangzhenduan.QuDuanInfoEntity;
import com.yintu.ruixing.guzhangzhenduan.QuDuanInfoEntityV2;
import com.yintu.ruixing.guzhangzhenduan.ZhanNeiService;
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

    @Autowired
    private QuDuanInfoDaoV2 quDuanInfoDaoV2;

    @Override
    public List<QuDuanInfoEntityV2> findDianMaHuaDatasByCZids(Integer czid,String tableName) {
        return quDuanInfoDaoV2.findDianMaHuaDatasByCZids(czid,tableName);
    }

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
        return quDuanInfoDaoV2.findDianMaHuaDatabById(id);
    }

    @Override
    public List<CheZhanEntity> findTieLuJuById(Integer page, Integer size) {
        return zhanNeiDao.findAllWangLuoLianJie();
    }

    @Override
    public List<QuDuanInfoEntityV2> findDianMaHuaDatasByCZid(Integer czid, long time,String tableName) {
        return quDuanInfoDaoV2.findDianMaHuaDatasByCZid(czid,time,tableName);
    }
}
