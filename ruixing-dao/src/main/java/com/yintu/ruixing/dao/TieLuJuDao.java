package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.TieLuJuEntity;

/**
 * @author:lcy
 * @date:2020-05-26 11
 * 铁路局相关dao
 */
public interface TieLuJuDao {
    TieLuJuEntity findTieLuJuById(Long id);

    void addTieLuJU(TieLuJuEntity tieLuJuEntity);

    void editTieLuJuById(Long id);

    void delTieLuJu(Long id);
}
