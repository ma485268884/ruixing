package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:lcy
 * @date:2020-05-29 14
 * 区段相关的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class QuDuanEntity {

    private long id;

    private  String qdName;

    private String designCarrier; //设计载频

    private String direction;  //方向
}
