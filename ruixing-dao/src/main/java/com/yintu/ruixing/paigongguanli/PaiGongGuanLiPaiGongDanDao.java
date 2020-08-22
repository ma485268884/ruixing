package com.yintu.ruixing.paigongguanli;

import com.yintu.ruixing.paigongguanli.PaiGongGuanLiPaiGongDanEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaiGongGuanLiPaiGongDanDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PaiGongGuanLiPaiGongDanEntity record);

    int insertSelective(PaiGongGuanLiPaiGongDanEntity record);

    PaiGongGuanLiPaiGongDanEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaiGongGuanLiPaiGongDanEntity record);

    int updateByPrimaryKey(PaiGongGuanLiPaiGongDanEntity record);
}