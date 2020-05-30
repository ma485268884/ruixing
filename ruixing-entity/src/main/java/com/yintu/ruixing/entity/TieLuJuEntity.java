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

    private int tljId;

    private String tljName;

    private String tljMiaoShu;

    private String dwdName;

    List<DianWuDuanEntity> dianWuDuanEntities;

}
