package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author:lcy
 * @date:2020-05-22 10
 * 封装数据统计
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class
DataStats {

    private long tid;
    private long did;
    private long xid;
    private long cid;
    private String tljName;

    private String dwdName;

    private String dwdMiaoShu;

    private String xdName;

    private  String xdMiaoShu;

    private long id;

    private String czName;

    private int czId;

    private int xdId;

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


}
