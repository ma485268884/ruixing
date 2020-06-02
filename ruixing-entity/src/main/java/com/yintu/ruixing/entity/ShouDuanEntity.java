package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:lcy
 * @date:2020-05-30 13
 * 受端实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShouDuanEntity implements Serializable {
    private static final long serialVersionUID = -2713944121051881563L;
    private Integer id;

    private Integer xid;//线段id

    private Integer cid;//车站id

    private Integer vInAll;//全机型轨入电压V

    private Integer mvInZhu;//主机主接入电压mV

    private Integer mvInBing;//并机机主接入电压mV

    private Integer mvInDiaoZhu;//主机调接入电压mV

    private Integer mvInDiaoBing;

    private Integer hzInLowZhu;//主机接收低频Hz

    private Integer hzInLowBing;

    private String gjDriveZhu;//主机GJ驱动

    private String gjDriveBing;

    private String gjRearCollectionZhu;//主机后方GJ采集

    private String gjRearCollectionBing;

    private String baojingZhu;//主机接收器报警

    private String baojingBing;

    private String yuliu;

    private Short type;//类型


}