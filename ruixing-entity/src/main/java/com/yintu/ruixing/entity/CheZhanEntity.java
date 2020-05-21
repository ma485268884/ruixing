package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 车站   
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheZhanEntity {
    private long id;

    private String cz_name;

    private String cz_name_jiancheng;

    private String cz_ip;

    private Long cz_type;

    private Long cz_stutrs;

    private Long cz_open_stutrs;

    private Date cz_lasttime;

    private long xd_id;

    private String cz_miaoshu;

    private String yuliu1;

    private String yuliu2;

    private long cz_duantou;

}
