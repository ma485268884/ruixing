package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.QuDuanBaseEntity;
import com.yintu.ruixing.entity.QuDuanInfoEntity;
import com.yintu.ruixing.entity.QuDuanShuXingEntity;
import com.yintu.ruixing.entity.SheBeiEntity;

import java.util.Date;
import java.util.List;

/**
 * @author:lcy
 * @date:2020-06-11 17
 * 曲线相关
 */
public interface QuXianService {
    //List<SheBeiEntity> findSheBeiByCid(Integer id);

    List<String> findQuDuanById(Integer id);

    //List<QuDuanInfoEntity> findQuDuanDataByTime(Date time);

    List<QuDuanBaseEntity> findQuDuanDataByTime1(Date time);

    Integer findQuDuanDataByTime2(String format,String name);


    List<Integer> findQuDuanData(Long starttime, Long endtime, String shuxingname, String quduanname,Integer qdid);


    List<QuDuanShuXingEntity> shuXingMing();

    List<String> findShuXingName(Integer[] shuxingId);

    List<String> findShuXingHanZiName(Integer[] shuxingId);

    Integer findQDid(String quduanname);

}
