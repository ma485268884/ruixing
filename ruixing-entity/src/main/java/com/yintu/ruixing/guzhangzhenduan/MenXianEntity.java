package com.yintu.ruixing.guzhangzhenduan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenXianEntity implements Serializable {
    private static final long serialVersionUID = 837969792425718533L;
    private Integer id;
    @NotNull
    private Integer quduanId;
    @NotNull
    private Integer propertyId;

    private String measuredValue;

    private String measuredValueUnit;
    @NotNull
    private Integer superiorLimitValue;
    @NotBlank
    private String superiorLimitValueUnit;
    @NotNull
    private Integer lowerLimitValue;
    @NotBlank
    private String lowerLimitValueUnit;
    @NotNull
    private Integer outburstValue;
    @NotBlank
    private String outburstValueUnit;

    private QuDuanBaseEntity quDuanBaseEntity;

    private MenXianPropertyEntity menXianPropertyEntity;
}