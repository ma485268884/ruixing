package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.QuDuanBaseEntity;
import com.yintu.ruixing.entity.QuDuanInfoEntity;
import com.yintu.ruixing.entity.SheBeiEntity;

import java.util.Date;
import java.util.List;

/**
 * @author:lcy
 * @date:2020-06-11 17
 * 曲线相关
 */
public interface QuXianDao {
    List<SheBeiEntity> findSheBeiByCid(Integer id);

    List<QuDuanBaseEntity> findQuDuanById(Integer id);

    List<QuDuanInfoEntity> findQuDuanDataByTime(Date time);

    List<QuDuanBaseEntity> findQuDuanDataByTime1(Date time);
}
