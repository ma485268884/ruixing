package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.CheZhanEntity;
import com.yintu.ruixing.entity.DianWuDuanEntity;
import com.yintu.ruixing.entity.TieLuJuEntity;
import com.yintu.ruixing.entity.XianDuanEntity;

import java.util.List;
/**
 * @author Qiao
 * @date 2020/5/21 17:06
 * @return 以列表的形式展示铁路局、电务段、线段、车站名称service
 */
public interface ListService {
    //查询所有的铁路局
    public List<TieLuJuEntity> findall();
    //根据铁路局id查询下面的电务段名称
    public List<DianWuDuanEntity> findallBytljid(Long tlj_id);
    //根据电务段id查询下面的线段名称
    public List<XianDuanEntity> findallBydwdid(Long dwd_id);
    //根据线段id查询下面的车站名称
    public List<CheZhanEntity> findallByxdid(Long xd_id);


}
