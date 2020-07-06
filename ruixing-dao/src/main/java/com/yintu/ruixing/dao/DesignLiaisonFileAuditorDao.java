package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.DesignLiaisonFileAuditorEntity;

public interface DesignLiaisonFileAuditorDao {
    int deleteByPrimaryKey(Integer id);

    int insert(DesignLiaisonFileAuditorEntity record);

    int insertSelective(DesignLiaisonFileAuditorEntity record);

    DesignLiaisonFileAuditorEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DesignLiaisonFileAuditorEntity record);

    int updateByPrimaryKey(DesignLiaisonFileAuditorEntity record);
}