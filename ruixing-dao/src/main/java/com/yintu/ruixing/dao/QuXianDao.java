package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.QuDuanBaseEntity;
import com.yintu.ruixing.entity.SheBeiEntity;

import java.util.List;

/**
 * @author:lcy
 * @date:2020-06-11 17
 * 曲线相关
 */
public interface QuXianDao {
    List<SheBeiEntity> findSheBeiByCid(Integer id);

    List<QuDuanBaseEntity> findQuDuanById(Integer id);
}
