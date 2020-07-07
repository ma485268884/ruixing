package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.DesignLiaisonFileAuditorEntity;

import java.util.List;

public interface DesignLiaisonFileAuditorDao {
    int deleteByPrimaryKey(Integer id);

    int insert(DesignLiaisonFileAuditorEntity record);

    int insertSelective(DesignLiaisonFileAuditorEntity record);

    DesignLiaisonFileAuditorEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DesignLiaisonFileAuditorEntity record);

    int updateByPrimaryKey(DesignLiaisonFileAuditorEntity record);

    List<DesignLiaisonFileAuditorEntity> selectByDesignLiaisonFileId(Integer designLiaisonFileId);

    void insertMuch(List<DesignLiaisonFileAuditorEntity> designLiaisonFileAuditorEntities);

    void deleteByDesignLiaisonFileId(Integer designLiaisonFileId);
}