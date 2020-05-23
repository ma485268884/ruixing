package com.yintu.ruixing.service;


import com.yintu.ruixing.entity.DataStats;
import com.yintu.ruixing.entity.DianWuDuanEntity;
import com.yintu.ruixing.entity.PageResponseDto;
import com.yintu.ruixing.entity.TieLuJuEntity;


import java.util.List;


/**
 * @author:lcy
 * @date:2020-05-21 11
 * 数据统计
 */

public interface DataStatsService {
    //查询所有数据
    List<DataStats> findAll();
    //分页查询
    PageResponseDto<DataStats> getByPage(Integer page, Integer limit);
    //查询铁路局
    TieLuJuEntity findTieLuJuById(Long id);

    DianWuDuanEntity findDianWuDuanById(Long id);

    void addTieLuJU(TieLuJuEntity tieLuJuEntity);

    void editTieLuJuById(Long id);
}
