package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.QuDuanBaseDao;
import com.yintu.ruixing.dao.QuDuanInfoDao;
import com.yintu.ruixing.dao.QuDuanInfoDaoV2;
import com.yintu.ruixing.dao.QuXianDao;
import com.yintu.ruixing.entity.*;
import com.yintu.ruixing.service.QuXianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:lcy
 * @date:2020-06-11 17
 * 曲线相关
 */
@Service
@Transactional
public class QuXianServiceImpl implements QuXianService {
    @Autowired
    private QuXianDao quXianDao;
    @Autowired
    private QuDuanInfoDao quDuanInfoDao;
    @Autowired
    private QuDuanInfoDaoV2 quDuanInfoDaoV2;
    @Autowired
    private QuDuanBaseDao quDuanBaseDao;

   /* @Override
    public List<SheBeiEntity> findSheBeiByCid(Integer id) {
        return quXianDao.findSheBeiByCid(id);
    }
*/
    @Override
    public List<String> findQuDuanById(Integer id) {
        return quXianDao.findQuDuanById(id);
    }

   /* @Override
    public List<QuDuanInfoEntity> findQuDuanDataByTime(Date time) {
        return quDuanInfoDao.findQuDuanDataByTime(time);
    }
*/
    @Override
    public List<QuDuanBaseEntity> findQuDuanDataByTime1(Date time) {
        return quXianDao.findQuDuanDataByTime1(time);
    }

    @Override
    public Integer findQuDuanDataByTime2(String format,String name) {
        return quDuanInfoDao.findQuDuanDataByTime2(format,name);
    }



    @Override
    public  Integer findQuDuanData(Long starttimee,  String shuxingname, String quduanname,Integer qdid) {
        return quDuanInfoDaoV2.findQuDuanData(starttimee,shuxingname,quduanname,qdid);
    }

    @Override
    public List<QuDuanShuXingEntity> shuXingMing() {
        return quXianDao.shuXingMing();
    }

    @Override
    public List<String> findShuXingName(Integer[] shuxingId) {
        List<String> name=null;
        for (int i = 0; i < shuxingId.length; i++) {
          name= quXianDao.findShuXingName(shuxingId[i]);
        }
        return name;
    }

    @Override
    public Integer findQDid(String quduanname) {
        return quDuanBaseDao.findQDid(quduanname);
    }

    @Override
    public List<String> findShuXingHanZiName(Integer[] shuxingId) {
        return quXianDao.findShuXingHanZiName(shuxingId);
    }

    @Override
    public List<quduanEntity> findQuDuanDatas(long starttime, long endtime, String shuxingname, String quduanname, Integer qdid) {
        return quDuanInfoDaoV2.findQuDuanDatas(starttime,endtime,shuxingname,quduanname,qdid);
    }
}
