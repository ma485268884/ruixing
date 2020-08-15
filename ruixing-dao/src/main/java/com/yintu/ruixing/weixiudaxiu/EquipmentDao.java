package com.yintu.ruixing.weixiudaxiu;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EquipmentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentEntity record);

    int insertSelective(EquipmentEntity record);

    EquipmentEntity selectByPrimaryKey(Integer id);

    List<EquipmentEntity> selectAll();

    int updateByPrimaryKeySelective(EquipmentEntity record);

    int updateByPrimaryKey(EquipmentEntity record);

    List<EquipmentEntity> selectByName(String name);
}