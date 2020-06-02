package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:lcy
 * @date:2020-05-29 19
 * 送端的主机和备机的各种信息表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDuanEntity implements Serializable {
    private static final long serialVersionUID = -386731962028214111L;
    private Integer id;

    private Integer xid;//线段id

    private Integer cid;//车站id

    private Integer vOutZhu;//主机功出电压V

    private Integer vOutBei;

    private Integer maOutZhu;//主机功出电流mA

    private Integer maOutBei;

    private Integer hzUpZhu;//主机上边频Hz

    private Integer hzUpBei;

    private Integer hzDownZhu;//主机下边频Hz

    private Integer hzDownBei;

    private Integer hzLowZhu;//主机发送低频Hz

    private Integer hzLowBei;

    private String fbjDriveZhu;//主机FBJ驱动

    private String fbjDriveBei;

    private String fbjCollectionZhu;//主机FBJ采集

    private String fbjCollectionBei;

    private String yuliu;

    private Short type;//类型


}