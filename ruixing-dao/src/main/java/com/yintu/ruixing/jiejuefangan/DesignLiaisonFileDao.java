package com.yintu.ruixing.jiejuefangan;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DesignLiaisonFileDao {
    int deleteByPrimaryKey(Integer id);

    int insert(DesignLiaisonFileEntity record);

    int insertSelective(DesignLiaisonFileEntity record);

    DesignLiaisonFileEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DesignLiaisonFileEntity record);

    int updateByPrimaryKey(DesignLiaisonFileEntity record);

    List<DesignLiaisonFileEntity> selectByCondition(Integer year, String projectName, Integer[] ids, Short type);

}