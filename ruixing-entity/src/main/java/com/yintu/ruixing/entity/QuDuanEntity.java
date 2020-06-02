package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:lcy
 * @date:2020-05-29 14
 * 区段相关的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuDuanEntity implements Serializable {
    private static final long serialVersionUID = 4434286455780258213L;
    private Integer id;

    private Integer xid;//线段id

    private Integer cid;//车站id

    private String qdName;

    private String designCarrier;//设计载频

    private String direction;//方向

    private String gjcollection;//GJ采集

    private String yuliu;

    private Short type;//类型

    //    private SongDuanEntity songDuanEntity;
//
//    private FenXianPanEntity fenXianPanEntity;
//
//    private ShouDuanEntity shouDuanEntity;
//
//    private ShouDuanTransformer shouDuanTransformer;
//
//    private SongDuanTransformer songDuanTransformer;
//
//    private TuningEntity tuningEntity;


}