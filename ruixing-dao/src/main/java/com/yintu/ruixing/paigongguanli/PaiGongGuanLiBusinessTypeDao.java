package com.yintu.ruixing.paigongguanli;

import com.yintu.ruixing.paigongguanli.PaiGongGuanLiBusinessTypeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaiGongGuanLiBusinessTypeDao {
    int insert(PaiGongGuanLiBusinessTypeEntity record);

    PaiGongGuanLiBusinessTypeEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(PaiGongGuanLiBusinessTypeEntity record);



    //////////////////////////////////////////////////////////
    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaiGongGuanLiBusinessTypeEntity record);

    int insertSelective(PaiGongGuanLiBusinessTypeEntity record);

    List<PaiGongGuanLiBusinessTypeEntity> findSomeBusinessTypea(String businessTypeaName);

    List<PaiGongGuanLiBusinessTypeEntity> findSomeChuChaRenWu(Integer id, String businessTypeaName);

    List<PaiGongGuanLiBusinessTypeEntity> findChuChaRenWu(Integer id);
}