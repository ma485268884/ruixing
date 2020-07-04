package com.yintu.ruixing.entity;

import java.math.BigDecimal;

public class ChanPinJiaoFuCostZhiChuEntity {
    private Integer id;

    private String xiangmuName;

    private BigDecimal cailiaoMoney;

    private BigDecimal rengongMoney;

    private BigDecimal jijuzhejiuMoney;

    private BigDecimal dizhiyihaoMoney;

    private BigDecimal shuidianMoney;

    private BigDecimal yunzaMoney;

    private BigDecimal jianceMoney;

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

    public BigDecimal getCailiaoMoney() {
        return cailiaoMoney;
    }

    public void setCailiaoMoney(BigDecimal cailiaoMoney) {
        this.cailiaoMoney = cailiaoMoney;
    }

    public BigDecimal getRengongMoney() {
        return rengongMoney;
    }

    public void setRengongMoney(BigDecimal rengongMoney) {
        this.rengongMoney = rengongMoney;
    }

    public BigDecimal getJijuzhejiuMoney() {
        return jijuzhejiuMoney;
    }

    public void setJijuzhejiuMoney(BigDecimal jijuzhejiuMoney) {
        this.jijuzhejiuMoney = jijuzhejiuMoney;
    }

    public BigDecimal getDizhiyihaoMoney() {
        return dizhiyihaoMoney;
    }

    public void setDizhiyihaoMoney(BigDecimal dizhiyihaoMoney) {
        this.dizhiyihaoMoney = dizhiyihaoMoney;
    }

    public BigDecimal getShuidianMoney() {
        return shuidianMoney;
    }

    public void setShuidianMoney(BigDecimal shuidianMoney) {
        this.shuidianMoney = shuidianMoney;
    }

    public BigDecimal getYunzaMoney() {
        return yunzaMoney;
    }

    public void setYunzaMoney(BigDecimal yunzaMoney) {
        this.yunzaMoney = yunzaMoney;
    }

    public BigDecimal getJianceMoney() {
        return jianceMoney;
    }

    public void setJianceMoney(BigDecimal jianceMoney) {
        this.jianceMoney = jianceMoney;
    }
}