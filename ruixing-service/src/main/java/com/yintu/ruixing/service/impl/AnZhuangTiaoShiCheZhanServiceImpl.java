package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.AnZhuangTiaoShiCheZhanDao;
import com.yintu.ruixing.entity.AnZhuangTiaoShiCheZhanEntity;
import com.yintu.ruixing.service.AnZhuangTiaoShiCheZhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @Author Mr.liu
 * @Date 2020/7/11 16:47
 * @Version 1.0
 * 需求:安装调试的车站
 */
@Service
@Transactional
public class AnZhuangTiaoShiCheZhanServiceImpl implements AnZhuangTiaoShiCheZhanService {

    @Autowired
    private AnZhuangTiaoShiCheZhanDao anZhuangTiaoShiCheZhanDao;

    @Override
    public List<AnZhuangTiaoShiCheZhanEntity> findCheZhanByName(String czname, Integer page, Integer size) {
        return anZhuangTiaoShiCheZhanDao.findCheZhanByName(czname);
    }

    @Override
    public void deleteCheZhanByIds(Integer[] ids) {
        anZhuangTiaoShiCheZhanDao.deleteCheZhanByIds(ids);
    }

    @Override
    public void editCheZhanById(AnZhuangTiaoShiCheZhanEntity anZhuangTiaoShiCheZhanEntity) {
        anZhuangTiaoShiCheZhanDao.editCheZhanById(anZhuangTiaoShiCheZhanEntity);
    }

    @Override
    public List<AnZhuangTiaoShiCheZhanEntity> findCheZhanById(Integer id, Integer page, Integer size) {
        List<AnZhuangTiaoShiCheZhanEntity> cheZhanEntities=anZhuangTiaoShiCheZhanDao.findCheZhanById(id);
       /* //获取当天的日期
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM.dd");
        String today = simpleDateFormat.format( new Date() );*/

        for (AnZhuangTiaoShiCheZhanEntity cheZhanEntity : cheZhanEntities) {
            if (cheZhanEntity.getWanchengpeixianPlanStartTime()!=null){
                Date wanchengpeixianPlanStartTime = cheZhanEntity.getWanchengpeixianPlanStartTime();
                Date wanchengpeixianPlanEndTime = cheZhanEntity.getWanchengpeixianPlanEndTime();
                int wanchengpeixianPlanToalTime=(int) ((wanchengpeixianPlanEndTime.getTime()-wanchengpeixianPlanStartTime.getTime())/(1000*3600*24))+1;
                int wanchengpeixianPlanOneTime=(int) ((new Date().getTime()-wanchengpeixianPlanStartTime.getTime())/(1000*3600*24))+1;
                cheZhanEntity.setWanchengpeixianPlanToalTime(wanchengpeixianPlanToalTime);
                cheZhanEntity.setWanchengpeixianPlanOneTime(wanchengpeixianPlanOneTime);
            }
            if (cheZhanEntity.getShangdiantiaojianPlanStartTime() !=null){
                Date shangdiantiaojianPlanStartTime = cheZhanEntity.getShangdiantiaojianPlanStartTime();
                Date shangdiantiaojianPlanEndTime = cheZhanEntity.getShangdiantiaojianPlanEndTime();
                int shangdiantiaojianPlanToalTime = (int) ((shangdiantiaojianPlanEndTime.getTime() - shangdiantiaojianPlanStartTime.getTime()) / (1000*3600*24))+1;
                int shangdiantiaojianPlanOneTime = (int) ((new Date().getTime() - shangdiantiaojianPlanStartTime.getTime()) / (1000*3600*24))+1;
                cheZhanEntity.setShangdiantiaojianPlanToalTime(shangdiantiaojianPlanToalTime);
                cheZhanEntity.setShangdiantiaojianPlanOneTime(shangdiantiaojianPlanOneTime);
            }
            if (cheZhanEntity.getJingtaiyanshouPlanStartTime()!=null){
                Date jingtaiyanshouPlanStartTime = cheZhanEntity.getJingtaiyanshouPlanStartTime();
                Date jingtaiyanshouPlanEndTime = cheZhanEntity.getJingtaiyanshouPlanEndTime();
                int jingtaiyanshouPlanToalTime=(int) ((jingtaiyanshouPlanEndTime.getTime()-jingtaiyanshouPlanStartTime.getTime())/(1000*3600*24))+1;
                int jingtaiyanshouPlanOneTime=(int) ((new Date().getTime()-jingtaiyanshouPlanStartTime.getTime())/(1000*3600*24))+1;
                cheZhanEntity.setJingtaiyanshouPlanToalTime(jingtaiyanshouPlanToalTime);
                cheZhanEntity.setJingtaiyanshouPlanOneTime(jingtaiyanshouPlanOneTime);
            }
            if (cheZhanEntity.getDongtaiyanshouPlanStartTime()!=null){
                Date dongtaiyanshouPlanStartTime = cheZhanEntity.getDongtaiyanshouPlanStartTime();
                Date dongtaiyanshouPlanEndTime = cheZhanEntity.getDongtaiyanshouPlanEndTime();
                int dongtaiyanshouPlanToalTime=(int) ((dongtaiyanshouPlanEndTime.getTime()-dongtaiyanshouPlanStartTime.getTime())/(1000*3600*24))+1;
                int dongtaiyanshouPlanOneTime=(int) ((new Date().getTime()-dongtaiyanshouPlanStartTime.getTime())/(1000*3600*24))+1;
                cheZhanEntity.setDongtaiyanshouPlanToalTime(dongtaiyanshouPlanToalTime);
                cheZhanEntity.setDongtaiyanshouPlanOneTime(dongtaiyanshouPlanOneTime);
            }
            if (cheZhanEntity.getLiantiaolianshiPlanStartTime()!=null){
                Date liantiaolianshiPlanStartTime = cheZhanEntity.getLiantiaolianshiPlanStartTime();
                Date liantiaolianshiPlanEndTime = cheZhanEntity.getLiantiaolianshiPlanEndTime();
                int liantiaolianshiPlanToalTime=(int) ((liantiaolianshiPlanEndTime.getTime()-liantiaolianshiPlanStartTime.getTime())/(1000*3600*24))+1;
                int liantiaolianshiPlanOneTime=(int) ((new Date().getTime()-liantiaolianshiPlanStartTime.getTime())/(1000*3600*24))+1;
                cheZhanEntity.setLiantiaolianshiPlanToalTime(liantiaolianshiPlanToalTime);
                cheZhanEntity.setLiantiaolianshiPlanOneTime(liantiaolianshiPlanOneTime);
            }
            if (cheZhanEntity.getShiyunxingPlanStartTime()!=null){
                Date shiyunxingPlanStartTime = cheZhanEntity.getShiyunxingPlanStartTime();
                Date shiyunxingPlanEndTime = cheZhanEntity.getShiyunxingPlanEndTime();
                int shiyunxingPlanToalTime=(int) ((shiyunxingPlanEndTime.getTime()-shiyunxingPlanStartTime.getTime())/(1000*3600*24))+1;
                int shiyunxingPlanOneTime=(int) ((new Date().getTime()-shiyunxingPlanStartTime.getTime())/(1000*3600*24))+1;
                cheZhanEntity.setShiyunxingPlanToalTime(shiyunxingPlanToalTime);
                cheZhanEntity.setShiyunxingPlanOneTime(shiyunxingPlanOneTime);
            }
            if (cheZhanEntity.getKaitongPlanStartTime()!=null){
                Date kaitongPlanStartTime = cheZhanEntity.getKaitongPlanStartTime();
                Date kaitongPlanEndTime = cheZhanEntity.getKaitongPlanEndTime();
                int kaitongPlanToalTime=(int) ((kaitongPlanEndTime.getTime()-kaitongPlanStartTime.getTime())/(1000*3600*24))+1;
                int kaitongPlanOneTime=(int) ((new Date().getTime()-kaitongPlanStartTime.getTime())/(1000*3600*24))+1;
                cheZhanEntity.setKaitongPlanToalTime(kaitongPlanToalTime);
                cheZhanEntity.setKaitongPlanOneTime(kaitongPlanOneTime);
            }
        }
        return cheZhanEntities;
    }

    @Override
    public void addCheZhan(AnZhuangTiaoShiCheZhanEntity anZhuangTiaoShiCheZhanEntity) {
        anZhuangTiaoShiCheZhanEntity.setDongtaiyanshouIsNo(0);
        anZhuangTiaoShiCheZhanEntity.setJingtaiyanshouIsNo(0);
        anZhuangTiaoShiCheZhanEntity.setKaitongIsNo(0);
        anZhuangTiaoShiCheZhanEntity.setShiyunxingIsNo(0);
        anZhuangTiaoShiCheZhanEntity.setLiantiaolianshiIsNo(0);
        anZhuangTiaoShiCheZhanEntity.setShangdiantiaojianIsNo(0);
        anZhuangTiaoShiCheZhanEntity.setWanchengpeixianIsNo(0);
        /*anZhuangTiaoShiCheZhanEntity.setDongtaiyanshouActualEndTime(new Date());
        anZhuangTiaoShiCheZhanEntity.setDongtaiyanshouActualStartTime(new Date());
        anZhuangTiaoShiCheZhanEntity.setJingtaiyanshouActualEndTime(new Date());
        anZhuangTiaoShiCheZhanEntity.setJingtaiyanshouActualStartTime(new Date());
        anZhuangTiaoShiCheZhanEntity.setKaitongActualEndTime(new Date());
        anZhuangTiaoShiCheZhanEntity.setKaitongActualStartTime(new Date());
        anZhuangTiaoShiCheZhanEntity.setLiantiaolianshiActualEndTime(new Date());
        anZhuangTiaoShiCheZhanEntity.setLiantiaolianshiActualStartTime(new Date());
        anZhuangTiaoShiCheZhanEntity.setShangdiantiaojianActualEndTime(new Date());
        anZhuangTiaoShiCheZhanEntity.setShangdiantiaojianActualStartTime(new Date());
        anZhuangTiaoShiCheZhanEntity.setShiyunxingActualEndTime(new Date());
        anZhuangTiaoShiCheZhanEntity.setShiyunxingActualStartTime(new Date());
        anZhuangTiaoShiCheZhanEntity.setWanchengpeixianActualEndTime(new Date());
        anZhuangTiaoShiCheZhanEntity.setWanchengpeixianActualStartTime(new Date());*/
        anZhuangTiaoShiCheZhanDao.addCheZhan(anZhuangTiaoShiCheZhanEntity);
    }
}
