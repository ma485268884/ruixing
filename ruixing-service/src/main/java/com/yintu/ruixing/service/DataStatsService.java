package com.yintu.ruixing.service;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.entity.*;


import java.util.List;


/**
 * @author:lcy
 * @date:2020-05-21 11
 * 数据统计
 */

public interface DataStatsService {
    //查询所有数据
    List<DataStatsEntity> findAll();
    //分页查询
    PageInfo<DataStatsEntity> findPage(Integer page, Integer size);


    List<DataStatsEntity> findTieLuJuById(Long tid, Integer page, Integer size);
    List<DataStatsEntity> findDianWuDuanCheZhanById(Long did, Integer page, Integer size);
    List<DataStatsEntity> findXianDuanCheZhanById(Long xid, Integer page, Integer size);
    List<DataStatsEntity> findCheZhanById(Long cid, Integer page, Integer size);






  /*  List<DataStatsEntity> findDianWuDuanById(Long tid, Long did, Integer page, Integer size);

    List<DataStatsEntity> findXianDuanById(Long tid, Long did, Long xid, Integer page, Integer size);

    List<DataStatsEntity> findCheZhanById(Long tid, Long did, Long xid, Long cid, Integer page, Integer size);
    */

    int delCheZhanListById(int[] ids);




    List<DataStatsEntity> findAllCheZhan(Integer page, Integer size);

    void editStateByXid(XianDuanEntity xianDuanEntity);
    void editStateByCid(CheZhanEntity cheZhanEntity);

    List<TieLuJuEntity> findAllTieLuJu();

    List<DianWuDuanEntity> findDianWuDuanByTid(Integer tid);

    List<XianDuanEntity> findXianDuanByDid(Integer did);

    List<CheZhanEntity> findCheZhanByXid(Integer xid);

    List<QuDuanBaseEntity> findAllQuDuan(Integer page,Integer size);

    List<QuDuanBaseEntity> findAllDianMaHua(Integer page, Integer size);

    List<QuDuanBaseEntity> findAllQuDuanByCid(Integer cid, Integer page, Integer size);

    List<QuDuanBaseEntity> findAllDianMaHuaByCid(Integer cid, Integer page, Integer size);

    void addQuDuan(QuDuanBaseEntity quDuanBaseEntity);

    void editQuDuanById(QuDuanBaseEntity quDuanBaseEntity);

    void deletQuDuanById(Integer id);

    void deletQuDuanByIds(Integer[] ids);

    void qingChuaByXid(XianDuanEntity xianDuanEntity);

    void qingChuaByCid(CheZhanEntity cheZhanEntity);

    void addTieLuJU(TieLuJuEntity stringList);

    List<DianWuDuanEntity> findDianWuDuan();

    Long findTLJid(long parseLong);

    void addDianWuDuan(DianWuDuanEntity duanEntity);

    List<XianDuanEntity> findAllXianDuan();

    Long findDWDid(long parseLong);

    void addXianDuan(XianDuanEntity xianDuanEntity1);

    List<CheZhanEntity> findallChezhan();

    Long findXDid(long parseLong);

    void addCheZhan(CheZhanEntity cheZhan);

    List<TieLuJuEntity> findAllTieLuJuByName(String tljName);

    List<DianWuDuanEntity> findDianWuDuanByName(String dwdname);

    List<XianDuanEntity> findAllXianDuanByName(String xdname);

    List<CheZhanEntity> findallChezhanByName(String czname);

    Long findchezhanid(long parseLong);

    List<QuDuanBaseEntity> findQuDuanByCid(Long cid);

    Integer findLastParentid();

    Integer findxianduanid(long parseLong);

	List<XianDuanEntity> findAllXianDuanByDwdid(long parseLong);

    List<DianWuDuanEntity> findDianWuDuanBydid(long parseLong);

    List<QuDuanBaseEntity> findQuDuanByQuDuanYunYingName(String qudunyunyingname);

    List<CheZhanEntity> findSomeCheZhanByXid(Integer xid);

    String findXDJsonByXid(Integer xid);

    String findQDJsonByCid(Integer cid);

    Integer findFirstCZid(Integer xid);

    Integer findEndCZid(Integer xid);

    List<CheZhanEntity> findStartCheZhan(Integer firstCZid);

    List<CheZhanEntity> findEndCheZhan(Integer endCZid);
}
