package com.yintu.ruixing.paigongguanli;

import com.yintu.ruixing.paigongguanli.PaiGongGuanLiTaskUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaiGongGuanLiTaskUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PaiGongGuanLiTaskUserEntity record);

    int insertSelective(PaiGongGuanLiTaskUserEntity record);

    PaiGongGuanLiTaskUserEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaiGongGuanLiTaskUserEntity record);

    int updateByPrimaryKey(PaiGongGuanLiTaskUserEntity record);

    /////////////////////////////////////////////

    List<Integer> findUid();

    void addTask(@Param("id") Integer id,@Param("uid") Integer uid);

    List<PaiGongGuanLiTaskUserEntity> findSomeUserPowerScore(@Param("userName")String userName);

    List<PaiGongGuanLiTaskUserEntity> findUserPowerScoreById(Integer id);
}