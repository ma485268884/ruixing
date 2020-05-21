package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 铁路局
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TieLuJuEntity {
    private long id;

    private String tlj_name;

    private String tlj_miaoshu;

    private String tlj_beiyong;

}
