package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.PreSaleFileEntity;

public interface PreSaleFileDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PreSaleFileEntity record);

    int insertSelective(PreSaleFileEntity record);

    PreSaleFileEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PreSaleFileEntity record);

    int updateByPrimaryKey(PreSaleFileEntity record);
}