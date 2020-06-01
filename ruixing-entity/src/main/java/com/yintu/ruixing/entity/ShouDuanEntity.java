package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:lcy
 * @date:2020-05-30 13
 * 受端实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShouDuanEntity {

    private long xid;//线段id

    private long cid;//车站id

    private long id;

    private long VInAll;//全机型轨入电压V

    private long mVInZhu;//主机主接入电压mV

    private long mVInBing;//并机机主接入电压mV

    private long mVInDiaoZhu;//主机调接入电压mV

    private long mVInDiaoBing;

    private long HzInLowZhu;//主机接收低频Hz

    private long HzInLowBing;

    private String GJDriverZhu;//主机GJ驱动

    private String GJDriverBing;

    private String GJRearCollectionZhu;//主机后方GJ采集

    private String GJRearCollectionBing;

    private String BaoJingZhu;//主机接收器报警

    private String BaoJingBing;

}
