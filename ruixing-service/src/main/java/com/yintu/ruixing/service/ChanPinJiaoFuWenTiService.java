package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.ChanPinJiaoFuWenTiEntity;
import com.yintu.ruixing.entity.DepartmentEntity;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/7/3 20:40
 * @Version 1.0
 * 需求:产品交付的问题反馈
 */
public interface ChanPinJiaoFuWenTiService {

    List<ChanPinJiaoFuWenTiEntity> findAllData(Integer page, Integer size);

    List<DepartmentEntity> findAllDepartment();

    void addWenTi(ChanPinJiaoFuWenTiEntity chanPinJiaoFuWenTiEntity);

    void editWenTiById(ChanPinJiaoFuWenTiEntity chanPinJiaoFuWenTiEntity);

    List<ChanPinJiaoFuWenTiEntity> findWenTiByName(String xiangMuName, Integer page, Integer size);

    void deletWenTiByIds(Integer[] ids);
}
