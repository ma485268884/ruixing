package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaoJingEntity {
    private Integer id;

    private String bjQuduandaihao;

    private String bjGuzhangdengji;

    private Date bjTime;

    private Date bjHuifuTime;

    private String bjMessage;

    private Integer bjStatus;

    private Integer bjGzStatus;
}