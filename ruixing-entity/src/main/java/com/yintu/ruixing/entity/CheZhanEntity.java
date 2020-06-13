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
    private String xdName;
    private String dwdName;
    private String tljName;

    private long czId;

    private long xdId;

    private String czNameJianCheng;//图中简称

    private String czIp;//车站IP

    private long czType;//车站类型 0：未启用/实验站点  1：正式启用

    private long czStutrs;//车站连接状态  0：已配置未连接  1：连接中

    private long czOpenStutrs;//开通状态   0：未连接   1：已连接

    private Date czLastTime;//最后连接时间

    private long xdCzId;

    private String czMiaoShu;//车站运用概况

    private long czCaoZuo;//操作 0：断开  ，1：连接

    private String yuliu1;

    private String yuliu2;

    private long czDuanTou;//是否为端头站   0：是  1：否

    private DianWuDuanEntity dianWuDuanEntity;

    private TieLuJuEntity tieLuJuEntity;

    private XianDuanEntity xianDuanEntity;

}
