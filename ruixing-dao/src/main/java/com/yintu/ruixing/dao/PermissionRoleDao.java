package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.PermissionRoleEntity;
import com.yintu.ruixing.entity.PermissionRoleEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionRoleDao {
    long countByExample(PermissionRoleEntityExample example);

    int deleteByExample(PermissionRoleEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PermissionRoleEntity record);

    int insertSelective(PermissionRoleEntity record);

    List<PermissionRoleEntity> selectByExample(PermissionRoleEntityExample example);

    PermissionRoleEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PermissionRoleEntity record, @Param("example") PermissionRoleEntityExample example);

    int updateByExample(@Param("record") PermissionRoleEntity record, @Param("example") PermissionRoleEntityExample example);

    int updateByPrimaryKeySelective(PermissionRoleEntity record);

    int updateByPrimaryKey(PermissionRoleEntity record);
}