package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuDuanBaseEntity implements Serializable {
    private static final long serialVersionUID = -8897336182977509111L;
    private Integer id;

    private Integer parentId;

    private Integer xid;//线段id

    private Integer cid;//车站id

    private Integer sid; //设备id

    private Integer typeid;//类型id

    private Integer czQuDuanId;

    private Integer lineId;

    private String zongheId;

    private String quduanshejiName;

    private String quduanyunyingName;

    private Integer quduanLength;

    private String carrier;

    private String diduanType;

    private String xianluqingkuang;

    private Integer bianjie;

    private String fenjiedianWhere;

    private Integer zhanqufenjie;

    private String jinzhanxinhaojiName;

    private String xinhaojiorbiaozhiming;

    private String xinhaobiaozhipaiWhere;

    private String xinhaojiWhere;

    private String zuocejueyuanType;

    private String youcejueyuanType;

    private String zhengxianhoufangquduanId;

    private String zhengxianqianfangquduanId;

    private String daochaguanlianquduan1Id;

    private String daochaguanlianquduan2Id;

    private String dianmahuaguihao;

    private Integer guineidizhi;

    private Date time;

    private String yuliu;

    private LineEntity lineEntity;
}