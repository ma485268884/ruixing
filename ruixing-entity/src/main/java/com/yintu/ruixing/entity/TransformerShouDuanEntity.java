package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:lcy
 * @date:2020-05-30 14
 * 受端匹配变压器
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransformerShouDuanEntity implements Serializable {
    private static final long serialVersionUID = -52159543220197227L;
    private Integer id;

    private Integer xid;//线段id

    private Integer cid;//车站id

    private Integer maCableJbp;//JBP电缆电流mA

    private Integer aLonginJbp;//JBP长内电流A

    private Integer aLongoutJbp;//JBP长外电流A

    private Integer aShortinJbp;//JBP短内电流A

    private Integer aShortoutJbp;//JBP短外电流A

    private Integer tJbp;//JBP温度°C

    private String yuliu;

    private Short type;//类型

}