package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 车站   
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheZhanEntity {
    private long cid;

    private long tid;

    private long did;

    private long xid;

    private String czName;

    private long czId;

    private long xdId;

    private String czNameJianCheng;

    private String czIp;

    private Long czType;

    private Long czStutrs;

    private Long czOpenStutrs;

    private Date czLastTime;

    private long xdCzId;

    private String czMiaoShu;

    private String yuliu1;

    private String yuliu2;

    private long czDuanTou;

    private DianWuDuanEntity dianWuDuanEntity;

    private TieLuJuEntity tieLuJuEntity;

    private XianDuanEntity xianDuanEntity;

}
