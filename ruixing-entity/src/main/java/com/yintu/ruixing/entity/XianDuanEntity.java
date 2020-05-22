package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 线段
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class XianDuanEntity {
    private Long id;

    private String xd_name;

    private String xd_zg_name;

    private Long dwd_id;

    private  String xd_miaoshu;

    private String yuliu1;

    private String yuliu2;

    private long xd_type;

}
