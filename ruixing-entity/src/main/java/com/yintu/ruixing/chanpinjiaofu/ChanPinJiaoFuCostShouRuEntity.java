package com.yintu.ruixing.chanpinjiaofu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChanPinJiaoFuCostShouRuEntity {
    private Integer id;

    private String xiangmuName;

    private BigDecimal shebeiXiaoshouHetongMoney;//设备销售合同金额

    private BigDecimal beipinXiaoshouHetongMoney;//备品销售合同金额

    private BigDecimal allcost;//总计金额


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