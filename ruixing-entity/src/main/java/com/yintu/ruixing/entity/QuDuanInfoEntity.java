package com.yintu.ruixing.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class QuDuanInfoEntity implements Serializable {

    private static final long serialVersionUID = 6316073388211334021L;
    private Integer id;

    private Integer xid;//线段id

    private Integer qid;//区段id

    private Integer cid;//车站id

    private Integer sid; //设备id

    private Integer typeid;//类型id

    private Integer dataZhengchang;

    private String designCarrier;

    private String direction;

    private String gjcollection;

    private Integer vInAll;

    private Integer mvInZhu;

    private Integer mvInBing;

    private Integer mvInDiaoZhu;

    private Integer mvInDiaoBing;

    private Integer hzInLowZhu;

    private Integer hzInLowBing;

    private String gjDriveZhu;

    private String gjDriveBing;

    private String gjRearCollectionZhu;

    private String gjRearCollectionBing;

    private String baojingZhu;

    private String baojingBing;

    private Integer vOutZhu;

    private Integer vOutBei;

    private Integer maOutZhu;

    private Integer maOutBei;

    private Integer hzUpZhu;

    private Integer hzUpBei;

    private Integer hzDownZhu;

    private Integer hzDownBei;

    private Integer hzLowZhu;

    private Integer hzLowBei;

    private String fbjDriveZhu;

    private String fbjDriveBei;

    private String fbjCollectionZhu;

    private String fbjCollectionBei;

    private Integer vSongduanCable;

    private Integer maSongduanCable;

    private Integer vShouduanCableHost;

    private Integer vShouduanCableSpare;

    private Integer maShouduanCable;

    private Integer maCableJbp;

    private Integer aLonginJbp;

    private Integer aLongoutJbp;

    private Integer aShortinJbp;

    private Integer aShortoutJbp;

    private Integer tJbp;

    private Integer maCableFbp;

    private Integer aLonginFbp;

    private Integer aLongoutFbp;

    private Integer aShortinFbp;

    private Integer aShortoutFbp;

    private Integer tFbp;

    private Integer aLonginFbaZhu;

    private Integer aLonginFbaDiao;

    private Integer aLongoutFbaZhu;

    private Integer aLongoutFbaDiao;

    private Integer aShortinFbaZhu;

    private Integer aShortinFbaDiao;

    private Integer aShortoutFbaZhu;

    private Integer aShortoutFbaDiao;

    private Integer aLonginJbaZhu;

    private Integer aLonginJbaDiao;

    private Integer aLongoutJbaZhu;

    private Integer aLongoutJbaDiao;

    private Integer aShortinJbaZhu;

    private Integer aShortinJbaDiao;

    private Integer aShortoutJbaZhu;

    private Integer aShortoutJbaDiao;

    private String yuliu;

    /*private String quduanyunyingName;
    private String carrier;
    private String diduanType;
    private Integer bianjie;
    private String xianluqingkuang;
    private Integer zhanqufenjie;*/
    //private Integer id;

    private QuDuanBaseEntity quDuanBaseEntity;

    private SheBeiEntity sheBeiEntity;

}