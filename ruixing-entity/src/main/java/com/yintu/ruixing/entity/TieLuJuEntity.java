package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 铁路局
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TieLuJuEntity {
    private long id;

    private int tlj_id;

    private String tlj_name;

    private String tlj_miaoshu;

    private String tlj_beiyong;

}
