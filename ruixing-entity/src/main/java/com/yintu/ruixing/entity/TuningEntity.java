package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:lcy
 * @date:2020-05-30 14
 * 调谐单元
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TuningEntity implements Serializable {
    private static final long serialVersionUID = 2710287429548371708L;
    private Integer id;

    private Integer xid;//线段id

    private Integer cid;//车站id

    private Integer aLonginFbaZhu;//主信号FBA长内电流A

    private Integer aLonginFbaDiao;//调信号FBA长内电流A

    private Integer aLongoutFbaZhu;//主信号FBA长外电流A

    private Integer aLongoutFbaDiao;

    private Integer aShortinFbaZhu;//主信号FBA短内电流A

    private Integer aShortinFbaDiao;

    private Integer aShortoutFbaZhu;//主信号FBA短外电流A

    private Integer aShortoutFbaDiao;

    private Integer aLonginJbaZhu;//主信号JBA长内电流A

    private Integer aLonginJbaDiao;

    private Integer aLongoutJbaZhu;//主信号JBA长外电流A

    private Integer aLongoutJbaDiao;

    private Integer aShortinJbaZhu;//主信号JBA短内电流A

    private Integer aShortinJbaDiao;

    private Integer aShortoutJbaZhu;//主信号JBA短外电流A

    private Integer aShortoutJbaDiao;//调信号JBA短外电流A

    private String yuliu;

    private Short type;//类型

}