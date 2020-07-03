package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.DesignLiaisonFileEntity;

import java.util.List;

public interface DesignLiaisonFileDao {
    int deleteByPrimaryKey(Integer id);

    int insert(DesignLiaisonFileEntity record);

    int insertSelective(DesignLiaisonFileEntity record);

    DesignLiaisonFileEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DesignLiaisonFileEntity record);

    int updateByPrimaryKey(DesignLiaisonFileEntity record);

    List<DesignLiaisonFileEntity> selectByCondition(Integer year, String projectName, Integer[] ids, Short type);

}