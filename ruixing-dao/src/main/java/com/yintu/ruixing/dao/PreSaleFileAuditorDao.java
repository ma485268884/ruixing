package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.PreSaleFileAuditorEntity;

public interface PreSaleFileAuditorDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PreSaleFileAuditorEntity record);

    int insertSelective(PreSaleFileAuditorEntity record);

    PreSaleFileAuditorEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PreSaleFileAuditorEntity record);

    int updateByPrimaryKey(PreSaleFileAuditorEntity record);
}