package com.yintu.ruixing.entity;

import java.math.BigDecimal;

public class ChanPinJiaoFuCostShouRuEntity {
    private Integer id;

    private String xiangmuName;

    private BigDecimal shebeiXiaoshouHetongMoney;

    private BigDecimal beipinXiaoshouHetongMoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getXiangmuName() {
        return xiangmuName;
    }

    public void setXiangmuName(String xiangmuName) {
        this.xiangmuName = xiangmuName == null ? null : xiangmuName.trim();
    }

    public BigDecimal getShebeiXiaoshouHetongMoney() {
        return shebeiXiaoshouHetongMoney;
    }

    public void setShebeiXiaoshouHetongMoney(BigDecimal shebeiXiaoshouHetongMoney) {
        this.shebeiXiaoshouHetongMoney = shebeiXiaoshouHetongMoney;
    }

    public BigDecimal getBeipinXiaoshouHetongMoney() {
        return beipinXiaoshouHetongMoney;
    }

    public void setBeipinXiaoshouHetongMoney(BigDecimal beipinXiaoshouHetongMoney) {
        this.beipinXiaoshouHetongMoney = beipinXiaoshouHetongMoney;
    }
}