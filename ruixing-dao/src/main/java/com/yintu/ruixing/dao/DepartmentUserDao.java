package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.DepartmentUserEntity;
import com.yintu.ruixing.entity.DepartmentUserEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentUserDao {
    long countByExample(DepartmentUserEntityExample example);

    int deleteByExample(DepartmentUserEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DepartmentUserEntity record);

    int insertSelective(DepartmentUserEntity record);

    List<DepartmentUserEntity> selectByExample(DepartmentUserEntityExample example);

    DepartmentUserEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DepartmentUserEntity record, @Param("example") DepartmentUserEntityExample example);

    int updateByExample(@Param("record") DepartmentUserEntity record, @Param("example") DepartmentUserEntityExample example);

    int updateByPrimaryKeySelective(DepartmentUserEntity record);

    int updateByPrimaryKey(DepartmentUserEntity record);
}