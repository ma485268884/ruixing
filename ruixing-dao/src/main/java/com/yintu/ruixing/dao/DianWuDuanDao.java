package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.DianWuDuanEntity;

import java.util.List;

/**
 * @author:lcy
 * @date:2020-05-26 11
 * 电务段相关dao
 */
public interface DianWuDuanDao {
    DianWuDuanEntity findDianWuDuanById(Long did);

    void addDianWuDuan(DianWuDuanEntity dianWuDuanEntity);

    void editDianWuDuan(DianWuDuanEntity dianWuDuanEntity);

    void delDianWuDuan(Long did);

    List<Integer> findId(Long did);

    List<DianWuDuanEntity> findDianWuDuan();

    Long dwdid(long parseLong);

    List<DianWuDuanEntity> findDianWuDuanByName(String dwdname);

    List<DianWuDuanEntity> findDianWuDuanBydid(long parseLong);
}
