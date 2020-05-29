package com.yintu.ruixing.service;


import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.entity.*;


import java.util.List;
import java.util.Map;


/**
 * @author:lcy
 * @date:2020-05-21 11
 * 数据统计
 */

public interface DataStatsService {
    //查询所有数据
    List<DataStats> findAll();
    //分页查询
    PageInfo<DataStats> findPage(Integer page, Integer size);


    List<TieLuJuEntity> findTieLuJuById(Long id);

    List<DataStats> findDianWuDuanById(Long tid, Long did);

    List<DataStats> findXianDuanById(Long tid, Long did, Long xid);

    DataStats findCheZhanById(Long tid, Long did, Long xid, Long cid);


    int delCheZhanListById(int[] ids);
}
