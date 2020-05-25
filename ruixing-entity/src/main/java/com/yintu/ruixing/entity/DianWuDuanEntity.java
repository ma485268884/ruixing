package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 电务段
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DianWuDuanEntity {
    private long id;

    private int dwd_id;

    private int tlj_id;

    private String dwd_name;

    private long tlj_dwd_id;

    private String dwd_miaoshu;

    private String yuliu1;

    private String yuliu2;

}
