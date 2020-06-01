package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:lcy
 * @date:2020-06-01 17
 * 数据展示的所有实体类的集合
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataShowDto {

    private QuDuanEntity quDuanEntity;

    private ShouDuanEntity shouDuanEntity;

    private FenXianPanEntity fenXianPanEntity;

    private SongDuanEntity songDuanEntity;

    private SongDuanTransformer songDuanTransformer;

    private TuningEntity tuningEntity;

    private ShouDuanTransformer shouDuanTransformer;


}
