package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.PermissionEntity;
import com.yintu.ruixing.entity.UserEntity;
import com.yintu.ruixing.entity.UserEntityExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserDao {
    long countByExample(UserEntityExample example);

    int deleteByExample(UserEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    List<UserEntity> selectByExample(UserEntityExample example);

    UserEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserEntity record, @Param("example") UserEntityExample example);

    int updateByExample(@Param("record") UserEntity record, @Param("example") UserEntityExample example);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);

    List<PermissionEntity> selectPermissionById(Long id, Long parentId, Short isMenu);

    List<PermissionEntity> selectPermission(@Param("parentId") Long parentId, @Param("isMenu") Short isMenu);

}