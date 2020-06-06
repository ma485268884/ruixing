package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:lcy
 * @date:2020-06-06 19
 * 路线的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineEntity {

    private Integer id;

    private String lineNumber;// 线路号

    private String leftRight;//左右侧 ，站内为空

    private Integer xid;//线段id

    private String xianDuan;//所属线段

    private Integer xianBie;//0：空 ，1：上行， 2：下行

    private Integer type;//0：空 ， 1：接近，2：离去

    private QuDuanBaseEntity quDuanBaseEntity;

}
