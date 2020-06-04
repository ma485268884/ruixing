package com.yintu.ruixing.service;

import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.entity.DataStats;


/**
 * @author:lcy
 * @date:2020-06-02 20
 * 分页
 */
public interface DeleteService {


   /* PageInfo<DataStats> tljPage(String id, Integer page, Integer size );

    PageInfo<DataStats> dwdPage(String id, Integer page, Integer size);

    PageInfo<DataStats> czPage(String id, Integer page, Integer size);

    PageInfo<DataStats> xdPage(String id, Integer page, Integer size);
*/

    int  delTieLuJU(int[] ids);

    int delDianDuDuan(int[] ids);

    int delXianDuan(int[] ids);

    int delCheZhan(int[] ids);
}
