package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.PreSaleFileAuditorEntity;

import java.util.List;

public interface PreSaleFileAuditorDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PreSaleFileAuditorEntity record);

    int insertSelective(PreSaleFileAuditorEntity record);

    PreSaleFileAuditorEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PreSaleFileAuditorEntity record);

    int updateByPrimaryKey(PreSaleFileAuditorEntity record);

    List<PreSaleFileAuditorEntity> selectByPreSaleFileId(Integer preSaleFileId);

    void insertMuch(List<PreSaleFileAuditorEntity> preSaleFileAuditorEntities);

    void deleteByPreSaleFileId(Integer preSaleFileId);


}