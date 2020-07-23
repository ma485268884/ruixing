package com.yintu.ruixing.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class QuDuanInfoEntityV2 implements Serializable {
    private static final long serialVersionUID = 1928680102275598019L;
    private Integer id;

    private Integer cid;

    private Integer qid;

    private Integer time;

    private Integer type;

    private Integer typeid;

    private Integer dataZhengchang;

    private String designCarrier;

    private Integer direction;

    private Integer signalPosition;

    private String gjcollection;

    private BigDecimal vInAll;

    private BigDecimal mvInZhu;

    private BigDecimal mvInBing;

    private BigDecimal mvInDiaoZhu;

    private BigDecimal mvInDiaoBing;

    private BigDecimal hzInLowZhu;

    private BigDecimal hzInLowBing;

    private Integer gjDriveZhu;

    private Integer gjDriveBing;

    private String gjRearCollectionZhu;

    private String gjRearCollectionBing;

    private Integer baojingZhu;

    private Integer baojingBing;

    private String v31;

    private String v32;

    private String v33;

    private String v34;

    private String v35;

    private String v36;

    private String v37;

    private String v38;

    private String v39;

    private BigDecimal vOutZhu;

    private BigDecimal vOutBei;

    private BigDecimal maOutZhu;

    private BigDecimal maOutBei;

    private BigDecimal hzUpZhu;

    private BigDecimal hzUpBei;

    private BigDecimal hzDownZhu;

    private BigDecimal hzDownBei;

    private BigDecimal hzLowZhu;

    private BigDecimal hzLowBei;

    private Integer fbjDriveZhu;

    private Integer fbjDriveBei;

    private String fbjCollectionZhu;

    private String fbjCollectionBei;

    private BigDecimal vSongduanCable;

    private BigDecimal maSongduanCable;

    private BigDecimal vShouduanCableHost;

    private BigDecimal vShouduanCableSpare;

    private BigDecimal maShouduanCable;

    private BigDecimal maCableJbp;

    private BigDecimal aLonginJbp;

    private BigDecimal aLongoutJbp;

    private BigDecimal aShortinJbp;

    private BigDecimal aShortoutJbp;

    private Integer tJbp;

    private BigDecimal maCableFbp;

    private BigDecimal aLonginFbp;

    private BigDecimal aLongoutFbp;

    private BigDecimal aShortinFbp;

    private BigDecimal aShortoutFbp;

    private Integer tFbp;

    private BigDecimal aLonginFbaZhu;

    private BigDecimal aLonginFbaDiao;

    private BigDecimal aLongoutFbaZhu;

    private BigDecimal aLongoutFbaDiao;

    private BigDecimal aShortinFbaZhu;

    private BigDecimal aShortinFbaDiao;

    private BigDecimal aShortoutFbaZhu;

    private BigDecimal aShortoutFbaDiao;

    private BigDecimal aLonginJbaZhu;

    private BigDecimal aLonginJbaDiao;

    private BigDecimal aLongoutJbaZhu;

    private BigDecimal aLongoutJbaDiao;

    private BigDecimal aShortinJbaZhu;

    private BigDecimal aShortinJbaDiao;

    private BigDecimal aShortoutJbaZhu;

    private BigDecimal aShortoutJbaDiao;

    private String rackAddress;

    private String yuliu;

    private QuDuanBaseEntity quDuanBaseEntity;

    private SheBeiEntity sheBeiEntity;


}