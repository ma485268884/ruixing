package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:lcy
 * @date:2020-05-29 20
 * 分线盘
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FenXianPanEntity {

    private long id;

    private long xid;//线段id

    private long cid;//车站id

    private long VSongDuanCable;//送端电缆侧电压V

    private long mASongDuanCable;//送端电缆侧电流mA

    private long mAShouDuanCable;//受端电缆侧电流mA

    private long VShouDuanCableHost;//受端电缆侧主电压V

    private long VShouDuanCableSpare;//受端电缆侧调电压V


}
