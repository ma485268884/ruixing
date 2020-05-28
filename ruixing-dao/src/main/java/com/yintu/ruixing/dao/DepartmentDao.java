package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.DepartmentEntity;
import com.yintu.ruixing.entity.DepartmentEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentDao {
    long countByExample(DepartmentEntityExample example);

    int deleteByExample(DepartmentEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DepartmentEntity record);

    int insertSelective(DepartmentEntity record);

    List<DepartmentEntity> selectByExample(DepartmentEntityExample example);

    DepartmentEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DepartmentEntity record, @Param("example") DepartmentEntityExample example);

    int updateByExample(@Param("record") DepartmentEntity record, @Param("example") DepartmentEntityExample example);

    int updateByPrimaryKeySelective(DepartmentEntity record);

    int updateByPrimaryKey(DepartmentEntity record);
}