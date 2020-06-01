package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:lcy
 * @date:2020-05-30 13
 * 送端匹配变压器
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDuanTransformer {

    private long xid;//线段id

    private long cid;//车站id

    private long id;

    private long mACableFBP;//FBP电缆电流mA

    private long ALongInFBP;//FBP长内电流A

    private long ALongOutFBP;//FBP长外电流A

    private long AShortInFBP;//FBP短内电流A

    private long AShortOutFBP;//FBP短外电流A

    private long tFBP;//FBP温度°C

}
