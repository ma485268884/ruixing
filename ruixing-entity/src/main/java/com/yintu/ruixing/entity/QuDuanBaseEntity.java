package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuDuanBaseEntity {
    private Integer id;

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
}