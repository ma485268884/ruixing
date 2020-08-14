package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.PaiGongGuanLiBusinessTypeEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaiGongGuanLiBusinessTypeDao {
    int insert(PaiGongGuanLiBusinessTypeEntity record);

    PaiGongGuanLiBusinessTypeEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(PaiGongGuanLiBusinessTypeEntity record);



    /////////////////////////////////////////////////////////////////
    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaiGongGuanLiBusinessTypeEntity record);

    int insertSelective(PaiGongGuanLiBusinessTypeEntity record);

    List<PaiGongGuanLiBusinessTypeEntity> findBusinessType(@Param("typeName") String typeName,@Param("businessName") String businessName);
}