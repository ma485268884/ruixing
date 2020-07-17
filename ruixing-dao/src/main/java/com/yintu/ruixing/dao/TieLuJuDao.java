package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.TieLuJuEntity;

import java.util.List;

/**
 * @author:lcy
 * @date:2020-05-26 11
 * 铁路局相关dao
 */
public interface TieLuJuDao {
    TieLuJuEntity findTieLuJuById(Long tid);

    void addTieLuJU(TieLuJuEntity tieLuJuEntity);

    void editTieLuJuById(TieLuJuEntity tieLuJuEntity);

    void delTieLuJu(Long tid);

    List<Integer> findId(Long tid);

    List<TieLuJuEntity> findAllTieLuJu();

    Long findTLJid(long parseLong);
}
