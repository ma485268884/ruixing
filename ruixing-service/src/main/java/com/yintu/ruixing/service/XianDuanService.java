package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.XianDuanEntity;

import java.util.List;

/**
 * @author:lcy
 * @date:2020-05-26 11
 * 线段
 */
public interface XianDuanService {
    void addXianDuan(XianDuanEntity xianDuanEntity);

    void delXianDuan(Long xid);

    void editXianDuan(XianDuanEntity xianDuanEntity);

    XianDuanEntity findXianDuanById(Long xid);

    List<Integer> findId(Long xid);
}
