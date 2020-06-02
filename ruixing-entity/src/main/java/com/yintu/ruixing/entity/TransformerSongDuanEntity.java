package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:lcy
 * @date:2020-05-30 13
 * 送端匹配变压器
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransformerSongDuanEntity implements Serializable {
    private static final long serialVersionUID = 3820832463518140347L;
    private Integer id;

    private Integer xid;//线段id

    private Integer cid;//车站id

    private Integer maCableFbp;//FBP电缆电流mA

    private Integer aLonginFbp;//FBP长内电流A

    private Integer aLongoutFbp;//FBP长外电流A

    private Integer aShortinFbp;//FBP短内电流A

    private Integer aShortoutFbp;//FBP短外电流A

    private Integer tFbp;//FBP温度°C

    private String yuliu;

    private Short type;//类型


}