package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.DesignLiaisonEntity;

import java.util.Date;
import java.util.List;

public interface DesignLiaisonDao {
    int deleteByPrimaryKey(Integer id);

    int insert(DesignLiaisonEntity record);

    int insertSelective(DesignLiaisonEntity record);

    DesignLiaisonEntity selectByPrimaryKey(Integer id);

    List<DesignLiaisonEntity> selectAll();

    List<DesignLiaisonEntity> selectByYear(Integer year);

    int updateByPrimaryKeySelective(DesignLiaisonEntity record);

    int updateByPrimaryKey(DesignLiaisonEntity record);

    List<Integer> selectByDistinctProjectDate();

}