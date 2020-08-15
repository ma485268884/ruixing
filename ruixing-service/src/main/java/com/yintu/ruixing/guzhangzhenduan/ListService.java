package com.yintu.ruixing.guzhangzhenduan;


import java.util.List;

/**
 * @author Qiao
 * @date 2020/5/21 17:06
 * @return 以列表的形式展示铁路局、电务段、线段、车站名称service
 */
public interface ListService {

    Object getMenuList();


    Object getErJi();

    Object getSanJi();

    List<TieLuJuEntity> findOneTwoDatas();

    List<DianWuDuanEntity> findXDAndCZByDWDId(Integer dwdid);
}
