package com.yintu.ruixing.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yintu.ruixing.common.util.StringUtil;
import com.yintu.ruixing.dao.QuDuanInfoDaoV2;
import com.yintu.ruixing.entity.QuDuanBaseEntity;
import com.yintu.ruixing.entity.QuDuanInfoEntityV2;
import com.yintu.ruixing.entity.QuDuanInfoPropertyEntity;
import com.yintu.ruixing.entity.QuDuanInfoTypesPropertyEntity;
import com.yintu.ruixing.service.QuDuanBaseService;
import com.yintu.ruixing.service.QuDuanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/3 11:53
 */
@Service
public class QuDuanInfoServiceimpl implements QuDuanInfoService {

    @Autowired
    private QuDuanInfoDaoV2 quDuanInfoDaoV2;

    @Autowired
    private QuDuanBaseService quDuanBaseService;

    @Autowired
    private QuDuanInfoTypesPropertyServiceImpl quDuanInfoTypesPropertyService;


    @Override
    public QuDuanInfoEntityV2 findById(Integer id) {
        return quDuanInfoDaoV2.selectByPrimaryKey(id);
    }


    @Override
    public QuDuanInfoEntityV2 findLastBycZId(Integer czId) {
        return quDuanInfoDaoV2.selectLastByCzId(czId);
    }

    @Override
    public List<QuDuanInfoEntityV2> findByCzIdAndTime(Integer czId, Date startTime, Date endTime) {
        return quDuanInfoDaoV2.selectByCzIdAndTime(czId, startTime, endTime);
    }


    @Override
    public QuDuanInfoEntityV2 findLastByQid(Integer qid) {
        return quDuanInfoDaoV2.selectLastByQid(qid);
    }


    @Override
    public List<QuDuanInfoEntityV2> findByCzIdAndTime(Integer czId, Date time) {
        return quDuanInfoDaoV2.selectByCzIdAndQid(czId, time);
    }

    @Override
    public List<Map<String, Object>> findStatisticsByCzIdAndTime(Integer czId, Date time) {
        return quDuanInfoDaoV2.selectStatisticsByCzIdAndTime(czId, time);
    }

    @Override
    public Integer[] findDistinctTypeByCzId(Integer czId) {
        return quDuanInfoDaoV2.selectDistinctTypeByCzId(czId);
    }

    @Override
    public List<JSONObject> findByCondition(Integer czId, Date time) {
        List<QuDuanInfoEntityV2> quDuanInfoEntityV2s = new ArrayList<>();
        if (time == null) {
            List<QuDuanBaseEntity> quDuanBaseEntities = quDuanBaseService.findByCzId(czId);
            for (QuDuanBaseEntity quDuanBaseEntity : quDuanBaseEntities) {
                QuDuanInfoEntityV2 quDuanInfoEntityV2 = quDuanInfoDaoV2.selectFirstByCzId1(czId, quDuanBaseEntity.getQdid());
                quDuanInfoEntityV2s.add(quDuanInfoEntityV2);
            }
        } else {
            quDuanInfoEntityV2s = quDuanInfoDaoV2.selectByCzIdAndTime1(czId, time);
        }
        Integer[] types = this.findDistinctTypeByCzId(czId);
        List<QuDuanInfoTypesPropertyEntity> quDuanInfoTypesPropertyEntities = quDuanInfoTypesPropertyService.connectFindByCondition(StringUtil.arrayToStrWithComma(types));
        //动态转换
        List<JSONObject> jsonObjects = new ArrayList<>();
        for (QuDuanInfoEntityV2 quDuanInfoEntityV2 : quDuanInfoEntityV2s) {
            if (quDuanInfoEntityV2 == null) {
                jsonObjects.add(null);
                continue;
            }
            JSONObject jo = this.convert(quDuanInfoTypesPropertyEntities, quDuanInfoEntityV2);
            jsonObjects.add(jo);
        }
        return jsonObjects;
    }


    public JSONObject convert(List<QuDuanInfoTypesPropertyEntity> quDuanInfoTypesPropertyEntities, QuDuanInfoEntityV2 quDuanInfoEntityV2) {
        JSONObject jo = new JSONObject(true);
        jo.put("id", quDuanInfoEntityV2.getId());
        jo.put("cid", quDuanInfoEntityV2.getCid());
        jo.put("qid", quDuanInfoEntityV2.getQid());
        jo.put("time", quDuanInfoEntityV2.getTime());
        jo.put("type", quDuanInfoEntityV2.getType());
        jo.put("dataZhengchang", quDuanInfoEntityV2.getDataZhengchang());
        JSONArray jsonArray = new JSONArray();
        for (QuDuanInfoTypesPropertyEntity quDuanInfoTypesPropertyEntity : quDuanInfoTypesPropertyEntities) {
            JSONObject jsonObject = new JSONObject();
            QuDuanInfoPropertyEntity quDuanInfoPropertyEntity = quDuanInfoTypesPropertyEntity.getQuDuanInfoPropertyEntity();
            jsonObject.put("property", quDuanInfoPropertyEntity.getName());
            switch (quDuanInfoTypesPropertyEntity.getPropertyId()) {
                case 1:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getDesignCarrier());
                    jsonObject.put("column", 1);
                    break;
                case 2:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getDirection());
                    jsonObject.put("column", 1);
                    break;
                case 3:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getGjcollection());
                    jsonObject.put("column", 1);
                    break;
                case 4:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getDjcollection());
                    jsonObject.put("column", 1);
                    break;
                case 5:
                    JSONArray jsonArray5 = new JSONArray();
                    jsonArray5.add(quDuanInfoEntityV2.getVOutZhu());
                    jsonArray5.add(quDuanInfoEntityV2.getVOutBei());
                    jsonObject.put("propertyV", jsonArray5);
                    jsonObject.put("column", 2);
                    break;
                case 6:
                    JSONArray jsonArray6 = new JSONArray();
                    jsonArray6.add(quDuanInfoEntityV2.getMaOutZhu());
                    jsonArray6.add(quDuanInfoEntityV2.getMaOutBei());
                    jsonObject.put("propertyV", jsonArray6);
                    jsonObject.put("column", 2);
                    break;
                case 7:
                    JSONArray jsonArray7 = new JSONArray();
                    jsonArray7.add(quDuanInfoEntityV2.getHzUpZhu());
                    jsonArray7.add(quDuanInfoEntityV2.getHzUpBei());
                    jsonObject.put("propertyV", jsonArray7);
                    jsonObject.put("column", 2);
                    break;
                case 8:
                    JSONArray jsonArray8 = new JSONArray();
                    jsonArray8.add(quDuanInfoEntityV2.getHzDownZhu());
                    jsonArray8.add(quDuanInfoEntityV2.getHzDownBei());
                    jsonObject.put("propertyV", jsonArray8);
                    jsonObject.put("column", 2);
                    break;
                case 9:
                    JSONArray jsonArray9 = new JSONArray();
                    jsonArray9.add(quDuanInfoEntityV2.getHzLowZhu());
                    jsonArray9.add(quDuanInfoEntityV2.getHzLowBei());
                    jsonObject.put("propertyV", jsonArray9);
                    jsonObject.put("column", 2);
                    break;
                case 10:
                    JSONArray jsonArray10 = new JSONArray();
                    jsonArray10.add(quDuanInfoEntityV2.getFbjDriveZhu());
                    jsonArray10.add(quDuanInfoEntityV2.getFbjDriveBei());
                    jsonObject.put("propertyV", jsonArray10);
                    jsonObject.put("column", 2);
                    break;
                case 11:
                    JSONArray jsonArray11 = new JSONArray();
                    jsonArray11.add(quDuanInfoEntityV2.getFbjCollectionZhu());
                    jsonArray11.add(quDuanInfoEntityV2.getFbjCollectionBei());
                    jsonObject.put("propertyV", jsonArray11);
                    jsonObject.put("column", 2);
                    break;
                case 12:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getVSongduanCable());
                    jsonObject.put("column", 3);
                    break;
                case 13:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getMaSongduanCable());
                    jsonObject.put("column", 3);
                    break;
                case 14:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getVShouduanCableHost());
                    jsonObject.put("column", 3);
                    break;
                case 15:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getVShouduanCableSpare());
                    jsonObject.put("column", 3);
                    break;
                case 16:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getMaShouduanCable());
                    jsonObject.put("column", 3);
                    break;
                case 17:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getVInAll());
                    jsonObject.put("column", 4);
                    break;
                case 18:
                    JSONArray jsonArray18 = new JSONArray();
                    jsonArray18.add(quDuanInfoEntityV2.getMvInZhu());
                    jsonArray18.add(quDuanInfoEntityV2.getMvInBing());
                    jsonObject.put("propertyV", jsonArray18);
                    jsonObject.put("column", 4);
                    break;
                case 19:
                    JSONArray jsonArray19 = new JSONArray();
                    jsonArray19.add(quDuanInfoEntityV2.getMvInDiaoZhu());
                    jsonArray19.add(quDuanInfoEntityV2.getMvInDiaoBing());
                    jsonObject.put("propertyV", jsonArray19);
                    jsonObject.put("column", 4);
                    break;
                case 20:
                    JSONArray jsonArray20 = new JSONArray();
                    jsonArray20.add(quDuanInfoEntityV2.getHzInLowZhu());
                    jsonArray20.add(quDuanInfoEntityV2.getHzInLowBing());
                    jsonObject.put("propertyV", jsonArray20);
                    jsonObject.put("column", 4);
                    break;
                case 21:
                    JSONArray jsonArray21 = new JSONArray();
                    jsonArray21.add(quDuanInfoEntityV2.getGjDriveZhu());
                    jsonArray21.add(quDuanInfoEntityV2.getGjDriveBing());
                    jsonObject.put("propertyV", jsonArray21);
                    jsonObject.put("column", 4);
                    break;
                case 22:
                    JSONArray jsonArray22 = new JSONArray();
                    jsonArray22.add(quDuanInfoEntityV2.getGjRearCollectionZhu());
                    jsonArray22.add(quDuanInfoEntityV2.getGjRearCollectionBing());
                    jsonObject.put("propertyV", jsonArray22);
                    jsonObject.put("column", 5);
                    break;
                case 23:
                    JSONArray jsonArray23 = new JSONArray();
                    jsonArray23.add(quDuanInfoEntityV2.getBaojingZhu());
                    jsonArray23.add(quDuanInfoEntityV2.getBaojingBing());
                    jsonObject.put("propertyV", jsonArray23);
                    jsonObject.put("column", 5);
                    break;

                case 24:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getMaCableFbp());
                    jsonObject.put("column", 5);
                    break;
                case 25:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getALonginFbp());
                    jsonObject.put("column", 5);
                    break;
                case 26:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getALongoutFbp());
                    jsonObject.put("column", 5);
                    break;
                case 27:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getAShortinFbp());
                    jsonObject.put("column", 5);
                    break;
                case 28:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getAShortoutFbp());
                    jsonObject.put("column", 5);
                    break;
                case 29:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getTFbp());
                    jsonObject.put("column", 5);
                    break;

                case 30:
                    JSONArray jsonArray30 = new JSONArray();
                    jsonArray30.add(quDuanInfoEntityV2.getALonginFbaZhu());
                    jsonArray30.add(quDuanInfoEntityV2.getALonginFbaDiao());
                    jsonObject.put("propertyV", jsonArray30);
                    jsonObject.put("column", 6);
                    break;
                case 31:
                    JSONArray jsonArray31 = new JSONArray();
                    jsonArray31.add(quDuanInfoEntityV2.getALongoutFbaZhu());
                    jsonArray31.add(quDuanInfoEntityV2.getALongoutFbaDiao());
                    jsonObject.put("propertyV", jsonArray31);
                    jsonObject.put("column", 6);
                    break;
                case 32:
                    JSONArray jsonArray32 = new JSONArray();
                    jsonArray32.add(quDuanInfoEntityV2.getAShortinFbaZhu());
                    jsonArray32.add(quDuanInfoEntityV2.getAShortinFbaDiao());
                    jsonObject.put("propertyV", jsonArray32);
                    jsonObject.put("column", 6);
                    break;
                case 33:
                    JSONArray jsonArray33 = new JSONArray();
                    jsonArray33.add(quDuanInfoEntityV2.getAShortoutFbaZhu());
                    jsonArray33.add(quDuanInfoEntityV2.getAShortoutFbaDiao());
                    jsonObject.put("propertyV", jsonArray33);
                    jsonObject.put("column", 6);
                    break;
                case 34:
                    JSONArray jsonArray34 = new JSONArray();
                    jsonArray34.add(quDuanInfoEntityV2.getALonginJbaZhu());
                    jsonArray34.add(quDuanInfoEntityV2.getALonginJbaDiao());
                    jsonObject.put("propertyV", jsonArray34);
                    jsonObject.put("column", 6);
                    break;
                case 35:
                    JSONArray jsonArray35 = new JSONArray();
                    jsonArray35.add(quDuanInfoEntityV2.getALongoutJbaZhu());
                    jsonArray35.add(quDuanInfoEntityV2.getALongoutJbaDiao());
                    jsonObject.put("propertyV", jsonArray35);
                    jsonObject.put("column", 6);
                    break;
                case 36:
                    JSONArray jsonArray36 = new JSONArray();
                    jsonArray36.add(quDuanInfoEntityV2.getAShortinJbaZhu());
                    jsonArray36.add(quDuanInfoEntityV2.getAShortinJbaDiao());
                    jsonObject.put("propertyV", jsonArray36);
                    jsonObject.put("column", 6);
                    break;
                case 37:
                    JSONArray jsonArray37 = new JSONArray();
                    jsonArray37.add(quDuanInfoEntityV2.getAShortoutJbaZhu());
                    jsonArray37.add(quDuanInfoEntityV2.getAShortoutJbaZhu());
                    jsonObject.put("propertyV", jsonArray37);
                    jsonObject.put("column", 6);
                    break;
                case 38:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getMaCableJbp());
                    jsonObject.put("column", 7);
                    break;
                case 39:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getALonginJbp());
                    jsonObject.put("column", 7);
                    break;
                case 40:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getALongoutJbp());
                    jsonObject.put("column", 7);
                    break;
                case 41:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getAShortinJbp());
                    jsonObject.put("column", 7);
                    break;
                case 42:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getAShortoutJbp());
                    jsonObject.put("column", 7);
                    break;
                case 43:
                    jsonObject.put("propertyV", quDuanInfoEntityV2.getTJbp());
                    jsonObject.put("column", 7);
                    break;
            }
            jsonArray.add(jsonObject);
        }
        jo.put("properties", jsonArray);
        return jo;
    }
}
