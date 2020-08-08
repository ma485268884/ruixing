package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.CheZhanEntity;
import com.yintu.ruixing.entity.LineEntity;
import com.yintu.ruixing.entity.QuDuanBaseEntity;
import com.yintu.ruixing.entity.QuDuanInfoEntityV2;

import java.util.List;

/**
 * @author:lcy
 * @date:2020-06-06 19
 * 站内相关
 */
public interface ZhanNeiDao {
    List<QuDuanBaseEntity> findAllDianMaHua(Long id);

    List<CheZhanEntity> findAllWangLuoLianJie();

    void editWangLuoLianJieById(CheZhanEntity cheZhanEntity);
}
