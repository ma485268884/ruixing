package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.ChanPinJiaoFuWenTiEntity;
import com.yintu.ruixing.entity.DepartmentEntity;

import java.util.List;

public interface ChanPinJiaoFuWenTiDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ChanPinJiaoFuWenTiEntity record);

    int insertSelective(ChanPinJiaoFuWenTiEntity record);

    ChanPinJiaoFuWenTiEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChanPinJiaoFuWenTiEntity record);

    int updateByPrimaryKey(ChanPinJiaoFuWenTiEntity record);

    //////////////////////////////////////////////////////////////

    List<ChanPinJiaoFuWenTiEntity> findAllData();

    List<DepartmentEntity> findAllDepartment();

    void addWenTi(ChanPinJiaoFuWenTiEntity chanPinJiaoFuWenTiEntity);

    void editWenTiById(ChanPinJiaoFuWenTiEntity chanPinJiaoFuWenTiEntity);

    List<ChanPinJiaoFuWenTiEntity> findWenTiByName(String xiangMuName);

    void deletWenTiByIds(Integer[] ids);
}