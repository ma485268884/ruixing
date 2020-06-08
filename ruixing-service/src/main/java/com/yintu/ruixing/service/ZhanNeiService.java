package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.QuDuanBaseEntity;

import java.util.List;

/**
 * @author:lcy
 * @date:2020-06-06 19
 * 站内相关
 */
public interface ZhanNeiService  {
    List<QuDuanBaseEntity> findAllDianMaHua(Long id);
}
