package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:lcy
 * @date:2020-05-29 19
 * 送端的主机和备机的各种信息表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDuanEntity {

    private long xid;//线段id

    private long cid;//车站id

    private long id;

    private long vOutZhu;//主机功出电压V

    private long vOutBie;

    private long mAOutZhu;//主机功出电流mA

    private long mAOutBie;

    private long HzUpZhu;//主机上边频Hz

    private long HzUpBie;

    private long HzDownZhu;//主机下边频Hz

    private long HzDownBie;

    private long HzLowZhu;//主机发送低频Hz

    private long HzLowBie;

    private String FBJDriveZhu;//主机FBJ驱动

    private String FBJDriveBei;

    private String FBJCollectionBie;//主机FBJ采集

    private String FBJCollectionZhu;


}
