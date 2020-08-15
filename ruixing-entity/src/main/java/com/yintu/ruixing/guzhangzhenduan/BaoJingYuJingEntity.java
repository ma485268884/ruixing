package com.yintu.ruixing.guzhangzhenduan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BaoJingYuJingEntity {

    private Integer id;

    private Integer bid;//报警预警树列id

    private Integer qid;//区段id

    private Integer sid;//设备id

    private Date startTime;//开始时间

    private Date huifuTime;//恢复时间

    private Integer tianChuang;//天窗状态  0：关   1：开',

    private Integer lvChuHuiFu;//滤除恢复状态  0：否  1：是',

    private Integer lvChuKaiTong;//滤除开通状态  0：关   1：开',


    private BaoJingYuJingPropertyEntity baoJingYuJingPropertyEntity;
}