package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:lcy
 * @date:2020-05-29 20
 * 分线盘
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FenXianPanEntity implements Serializable {
    private static final long serialVersionUID = -9023215222748028458L;
    private Integer id;

    private Integer xid;//线段id

    private Integer cid;//车站id

    private Integer vSongduanCable;//送端电缆侧电压V

    private Integer maSongduanCable;//送端电缆侧电流mA

    private Integer vShouduanCableHost;//受端电缆侧电流mA

    private Integer vShouduanCableSpare;//受端电缆侧主电压V

    private Integer maShouduanCable;//受端电缆侧调电压V

    private String yuliu;

    private Short type;//类型

}