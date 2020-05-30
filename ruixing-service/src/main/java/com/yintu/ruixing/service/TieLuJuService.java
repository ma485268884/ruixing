package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.TieLuJuEntity;

/**
 * @author:lcy
 * @date:2020-05-26 11
 * 铁路局
 */
public interface TieLuJuService {
    TieLuJuEntity findTieLuJuById(Long id);

    void addTieLuJU(TieLuJuEntity tieLuJuEntity);

    void editTieLuJuById(Long tid);

    void delTieLuJu(Long tid);
}
