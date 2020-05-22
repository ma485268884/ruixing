package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.PermissionEntity;
import com.yintu.ruixing.entity.PermissionEntityExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PermissionDao {
    long countByExample(PermissionEntityExample example);

    int deleteByExample(PermissionEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PermissionEntity record);

    int insertSelective(PermissionEntity record);

    List<PermissionEntity> selectByExample(PermissionEntityExample example);

    PermissionEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PermissionEntity record, @Param("example") PermissionEntityExample example);

    int updateByExample(@Param("record") PermissionEntity record, @Param("example") PermissionEntityExample example);

    int updateByPrimaryKeySelective(PermissionEntity record);

    int updateByPrimaryKey(PermissionEntity record);

    List<String> selectByUserIdAndUrl(Long userId,String url);
}