package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.RoleEntity;
import com.yintu.ruixing.entity.RoleEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleDao {
    long countByExample(RoleEntityExample example);

    int deleteByExample(RoleEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoleEntity record);

    int insertSelective(RoleEntity record);

    List<RoleEntity> selectByExample(RoleEntityExample example);

    RoleEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RoleEntity record, @Param("example") RoleEntityExample example);

    int updateByExample(@Param("record") RoleEntity record, @Param("example") RoleEntityExample example);

    int updateByPrimaryKeySelective(RoleEntity record);

    int updateByPrimaryKey(RoleEntity record);
}