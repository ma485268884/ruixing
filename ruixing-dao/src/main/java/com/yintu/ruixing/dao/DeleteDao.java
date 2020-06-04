package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.DataStats;


import java.util.List;

/**
 * @author:lcy
 * @date:2020-06-02 20
 * 分页
 */
public interface DeleteDao {
/*
    List<DataStats> tljPage();

    List<DataStats> dwdPage();

    List<DataStats> czPage();

    List<DataStats> xdPage();*/

    int delTieLuJU(int[] ids);

    int delDianDuDuan(int[] ids);

    int delXianDuan(int[] ids);

    int delCheZhan(int[] ids);
}
