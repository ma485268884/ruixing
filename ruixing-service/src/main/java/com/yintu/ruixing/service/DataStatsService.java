package com.yintu.ruixing.service;


import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.entity.*;
import org.springframework.web.bind.annotation.RequestParam;


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
    PageInfo<DataStats> findPage(Integer page, Integer size);


    List<TieLuJuEntity> findTieLuJuById(Long tid,Integer page, Integer size);

    List<DataStats> findDianWuDuanById(Long tid, Long did,Integer page, Integer size);

    List<DataStats> findXianDuanById(Long tid, Long did, Long xid,Integer page, Integer size);

    List<DataStats> findCheZhanById(Long tid, Long did, Long xid, Long cid,Integer page, Integer size);

    int delCheZhanListById(int[] ids);
}
