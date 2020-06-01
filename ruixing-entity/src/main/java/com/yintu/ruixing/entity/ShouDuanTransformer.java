package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:lcy
 * @date:2020-05-30 14
 * 受端匹配变压器
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShouDuanTransformer {

    private long xid;//线段id

    private long cid;//车站id

    private long id;

    private long mACableJBP;//JBP电缆电流mA

    private long ALongInJBP;//JBP长内电流A

    private long ALongOutJBP;//JBP长外电流A

    private long AShortInJBP;//JBP短内电流A

    private long AShortOutJBP;//JBP短外电流A

    private long tJBP;//JBP温度°C
}
