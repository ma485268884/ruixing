package com.yintu.ruixing.paigongguanli;

import com.yintu.ruixing.paigongguanli.PaiGongGuanLiTaskEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaiGongGuanLiTaskDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PaiGongGuanLiTaskEntity record);

    PaiGongGuanLiTaskEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(PaiGongGuanLiTaskEntity record);


    ////////////////////////////////////////////////////////

    int updateByPrimaryKeySelective(PaiGongGuanLiTaskEntity record);

    int insertSelective(PaiGongGuanLiTaskEntity record);

    List<PaiGongGuanLiTaskEntity> findSomeTask(String taskname);

    List<Integer> findId();

}