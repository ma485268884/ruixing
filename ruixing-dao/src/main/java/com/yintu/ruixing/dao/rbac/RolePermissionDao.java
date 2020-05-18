package com.yintu.ruixing.dao.rbac;

import com.yintu.ruixing.entity.rbac.RolePermissionEntity;
import com.yintu.ruixing.entity.rbac.RolePermissionEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionDao {
    long countByExample(RolePermissionEntityExample example);

    int deleteByExample(RolePermissionEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RolePermissionEntity record);

    int insertSelective(RolePermissionEntity record);

    List<RolePermissionEntity> selectByExample(RolePermissionEntityExample example);

    RolePermissionEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RolePermissionEntity record, @Param("example") RolePermissionEntityExample example);

    int updateByExample(@Param("record") RolePermissionEntity record, @Param("example") RolePermissionEntityExample example);

    int updateByPrimaryKeySelective(RolePermissionEntity record);

    int updateByPrimaryKey(RolePermissionEntity record);
}