package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChanPinJiaoFuCostZhiChuEntity {
    private Integer id;

    private String xiangmuName;

    private BigDecimal cailiaoMoney;//材料费

    private BigDecimal rengongMoney;//人工费

    private BigDecimal jijuzhejiuMoney;//机具折旧维护

    private BigDecimal dizhiyihaoMoney;//低值易耗品

    private BigDecimal shuidianMoney;//水电费

    private BigDecimal yunzaMoney;//运杂费

    private BigDecimal jianceMoney;//检测费

    private BigDecimal zhizaocost;//直接制造费用总计
    private BigDecimal allcost;//所有数据的总计

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