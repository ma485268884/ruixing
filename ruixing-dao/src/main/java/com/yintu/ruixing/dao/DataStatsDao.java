package com.yintu.ruixing.dao;


import com.yintu.ruixing.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;


/**
 * @author:lcy
 * @date:2020-05-21 11
 * 数据统计
 */
@Mapper
public interface DataStatsDao {

    public List<DataStats> findAll();

    List<TieLuJuEntity> findTieLuJuById(Long id);

    List<DataStats> findDianWuDuanById(@Param("tid") Long tid, @Param("did") Long did);

    List<DataStats> findXianDuanById(@Param("tid") Long tid, @Param("did") Long did, @Param("xid") Long xid);

    DataStats findCheZhanById(@Param("tid") Long tid, @Param("did") Long did, @Param("xid") Long xid, @Param("cid") Long cid);

    int delCheZhanListById(int[] id);
}
