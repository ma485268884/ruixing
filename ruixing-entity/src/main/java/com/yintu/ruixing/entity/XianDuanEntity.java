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
    private Long xid;

    private int xdId;

    private int dwdId;

    private String xdName;

    private String xdZgName;

    private Long dwdXdId;

    private  String xdMiaoShu;

    private String yuliu1;

    private String yuliu2;

    private long xdType;

    List<CheZhanEntity> cheZhanEntities;

}
