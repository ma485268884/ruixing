package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 电务段
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DianWuDuanEntity {
    private long id;

    private String dwd_name;

    private long tlj_id;

    private String dud_miaoshu;

    private String yuliu1;

    private String yuliu2;
}
