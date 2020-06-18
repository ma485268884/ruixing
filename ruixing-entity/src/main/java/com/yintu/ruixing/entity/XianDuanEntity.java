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
    private long xid;

    private long tid;

    private long did;

    private long xdId;

    private long dwdId;

    private String xdName;

    private String xdZgName;

    private Long dwdXdId;

    private  String xdMiaoShu;

    private String yuliu1;

    private String yuliu2;

    private long xdType;

    private int xdState;//线段设置状态  0：未设置  1：已设置

    private String xdJson;//储存的json

    List<CheZhanEntity> cheZhanEntities;

    private DianWuDuanEntity dianWuDuanEntity;

    private TieLuJuEntity tieLuJuEntity;

}
