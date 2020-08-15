package com.yintu.ruixing.guzhangzhenduan;


/**
 * @author:lcy
 * @date:2020-06-02 20
 * 分页
 */
public interface DeleteService {


   /* PageInfo<DataStatsEntity> tljPage(String id, Integer page, Integer size );

    PageInfo<DataStatsEntity> dwdPage(String id, Integer page, Integer size);

    PageInfo<DataStatsEntity> czPage(String id, Integer page, Integer size);

    PageInfo<DataStatsEntity> xdPage(String id, Integer page, Integer size);
*/

    int  delTieLuJU(int[] ids);

    int delDianDuDuan(int[] ids);

    int delXianDuan(int[] ids);

    int delCheZhan(int[] ids);
}
