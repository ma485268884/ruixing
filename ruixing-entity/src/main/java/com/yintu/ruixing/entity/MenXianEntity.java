package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenXianEntity implements Serializable {
    private static final long serialVersionUID = 837969792425718533L;
    private Integer id;

    private Integer quduanId;

    private Integer propertyId;

    private Integer measuredValue;

    private String measuredValueUnit;

    private Integer superiorLimitValue;

    private String superiorLimitValueUnit;

    private Integer lowerLimitValue;

    private String lowerLimitValueUnit;

    private Integer outburstValue;

    private String outburstValueUnit;

    private QuDuanInfoEntity quDuanInfoEntity;

    private MenXianPropertyEntity menXianPropertyEntity;
}