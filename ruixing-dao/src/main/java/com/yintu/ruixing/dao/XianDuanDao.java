package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.XianDuanEntity;

import java.util.List;

/**
 * @author:lcy
 * @date:2020-05-26 11
 * 线段相关Dao
 */
public interface XianDuanDao {
    void addXianDuan(XianDuanEntity xianDuanEntity);

    void delXianDuan(Long xid);

    void editXianDuan(XianDuanEntity xianDuanEntity);

    XianDuanEntity findXianDuanById(Long xid);

    List<Integer> findId(Long xid);

    List<XianDuanEntity> findAllXianDuan();

    Long findid(long parseLong);

    List<XianDuanEntity> findAllXianDuanByName(String xdname);

	List<XianDuanEntity> findAllXianDuanByDwdid(long parseLong);
}
