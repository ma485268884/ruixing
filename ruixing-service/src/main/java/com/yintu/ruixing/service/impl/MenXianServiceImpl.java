package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.dao.MenXianDao;
import com.yintu.ruixing.entity.MenXianEntity;
import com.yintu.ruixing.entity.MenXianPropertyEntity;
import com.yintu.ruixing.entity.QuDuanInfoEntity;
import com.yintu.ruixing.service.MenXianPropertyService;
import com.yintu.ruixing.service.MenXianService;
import com.yintu.ruixing.service.QuDuanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/12 11:54
 */
@Service
@Transactional
public class MenXianServiceImpl implements MenXianService {
    @Autowired
    private MenXianDao menXianDao;

    @Autowired
    private MenXianPropertyService menXianPropertyService;

    @Autowired
    private QuDuanInfoService quDuanInfoService;

    @Override
    public void add(MenXianEntity menXianEntity) {
        menXianDao.insertSelective(menXianEntity);
    }

    @Override
    public void remove(Integer id) {
        menXianDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(MenXianEntity menXianEntity) {
        menXianDao.updateByPrimaryKeySelective(menXianEntity);
    }

    @Override
    public MenXianEntity findById(Integer id) {
        return menXianDao.selectByPrimaryKey(id);
    }

    @Override
    public void addByQuDuan(MenXianEntity menXianEntity) {
        Integer quDuanId = menXianEntity.getQuduanId();
        QuDuanInfoEntity quDuanInfoEntity = quDuanInfoService.findById(quDuanId);
        if (quDuanInfoEntity != null) {
            Integer propertyId = menXianEntity.getPropertyId();
            MenXianPropertyEntity menXianPropertyEntity = menXianPropertyService.findById(propertyId);
            if (menXianPropertyEntity != null) {
                String name = menXianPropertyEntity.getName();
                Integer measuredValue;
                String measuredValueUnit;
                switch (name) {
                    case "功出电压V":
                        measuredValue = quDuanInfoEntity.getVOutZhu();
                        measuredValueUnit = "V";
                        break;
                    case "功出电流mA":
                        measuredValue = quDuanInfoEntity.getMaOutZhu();
                        measuredValueUnit = "mA";
                        break;
                    case "上边频Hz":
                        measuredValue = quDuanInfoEntity.getHzUpZhu();
                        measuredValueUnit = "Hz";
                        break;
                    case "下边频Hz":
                        measuredValue = quDuanInfoEntity.getHzDownZhu();
                        measuredValueUnit = "Hz";
                        break;
                    case "发送低频Hz":
                        measuredValue = quDuanInfoEntity.getHzLowZhu();
                        measuredValueUnit = "Hz";
                        break;
                    case "送端电缆侧电压V":
                        measuredValue = quDuanInfoEntity.getVSongduanCable();
                        measuredValueUnit = "V";
                        break;
                    case "送端电缆侧电流mA":
                        measuredValue = quDuanInfoEntity.getMaSongduanCable();
                        measuredValueUnit = "mA";
                        break;
                    case "受端电缆侧主电压V":
                        measuredValue = quDuanInfoEntity.getVShouduanCableHost();
                        measuredValueUnit = "V";
                        break;
                    case "受端电缆侧调电压V":
                        measuredValue = quDuanInfoEntity.getVShouduanCableSpare();
                        measuredValueUnit = "V";
                        break;
                    case "轨入电压V":
                        measuredValue = quDuanInfoEntity.getVInAll();
                        measuredValueUnit = "V";
                        break;
                    case "主接入电压mV":
                        measuredValue = quDuanInfoEntity.getMvInZhu();
                        measuredValueUnit = "mV";
                        break;

                    case "调接入电压mV":
                        measuredValue = quDuanInfoEntity.getMvInDiaoZhu();
                        measuredValueUnit = "mV";
                        break;
                    case "接收低频Hz":
                        measuredValue = quDuanInfoEntity.getHzInLowZhu();
                        measuredValueUnit = "Hz";
                        break;
                    case "FBP电缆电流mA":
                        measuredValue = quDuanInfoEntity.getMaCableFbp();
                        measuredValueUnit = "mA";
                        break;
                    case "FBP长内电流A":
                        measuredValue = quDuanInfoEntity.getALonginFbp();
                        measuredValueUnit = "A";
                        break;
                    case "FBP长外电流A":
                        measuredValue = quDuanInfoEntity.getALongoutFbp();
                        measuredValueUnit = "A";
                        break;
                    case "FBP短内电流A":
                        measuredValue = quDuanInfoEntity.getAShortinFbp();
                        measuredValueUnit = "A";
                        break;
                    case "FBP短外电流A":
                        measuredValue = quDuanInfoEntity.getAShortoutFbp();
                        measuredValueUnit = "A";
                        break;
                    case "FBP温度°C":
                        measuredValue = quDuanInfoEntity.getTFbp();
                        measuredValueUnit = "°C";
                        break;
                    case "FBA长内电流A":
                        measuredValue = quDuanInfoEntity.getALonginFbaZhu();
                        measuredValueUnit = "A";
                        break;
                    case "FBA长外电流A":
                        measuredValue = quDuanInfoEntity.getALongoutFbaZhu();
                        measuredValueUnit = "A";
                        break;
                    case "FBA短内电流A":
                        measuredValue = quDuanInfoEntity.getAShortinFbaZhu();
                        measuredValueUnit = "A";
                        break;
                    case "FBA短外电流A":
                        measuredValue = quDuanInfoEntity.getAShortoutFbaZhu();
                        measuredValueUnit = "A";
                        break;
                    case "JBA长内电流A":
                        measuredValue = quDuanInfoEntity.getALonginJbaZhu();
                        measuredValueUnit = "A";
                        break;
                    case "JBA长外电流A":
                        measuredValue = quDuanInfoEntity.getALongoutJbaZhu();
                        measuredValueUnit = "A";
                        break;
                    case "JBA短内电流A":
                        measuredValue = quDuanInfoEntity.getAShortinJbaZhu();
                        measuredValueUnit = "A";
                        break;
                    case "JBA短外电流A":
                        measuredValue = quDuanInfoEntity.getAShortoutJbaZhu();
                        measuredValueUnit = "A";
                        break;
                    case "JBP电缆电流mA":
                        measuredValue = quDuanInfoEntity.getMaCableJbp();
                        measuredValueUnit = "mA";
                        break;
                    case "JBP长内电流A":
                        measuredValue = quDuanInfoEntity.getALonginJbp();
                        measuredValueUnit = "A";
                        break;
                    case "JBP长外电流A":
                        measuredValue = quDuanInfoEntity.getALongoutJbp();
                        measuredValueUnit = "A";
                        break;
                    case "JBP短内电流A":
                        measuredValue = quDuanInfoEntity.getAShortinJbp();
                        measuredValueUnit = "A";
                        break;
                    case "JBP短外电流A":
                        measuredValue = quDuanInfoEntity.getAShortoutJbp();
                        measuredValueUnit = "A";
                        break;
                    case "JBP温度°C":
                        measuredValue = quDuanInfoEntity.getTJbp();
                        measuredValueUnit = "°C";
                        break;
                    default:
                        measuredValue = 0;
                        measuredValueUnit = "";
                }
                this.add(menXianEntity);
            }
        }
    }

}
