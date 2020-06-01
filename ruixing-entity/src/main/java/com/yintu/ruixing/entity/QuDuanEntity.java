package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:lcy
 * @date:2020-05-29 14
 * 区段相关的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class QuDuanEntity {

    private long id;

    private long xid;//线段id

    private long cid;//车站id

    private  String qdName;

    private String designCarrier; //设计载频

    private String direction;  //方向

    private String GJcollection;//GJ采集

    private SongDuanEntity songDuanEntity;

    private FenXianPanEntity fenXianPanEntity;

    private ShouDuanEntity shouDuanEntity;

    private ShouDuanTransformer shouDuanTransformer;

    private SongDuanTransformer songDuanTransformer;

    private TuningEntity tuningEntity;
}
