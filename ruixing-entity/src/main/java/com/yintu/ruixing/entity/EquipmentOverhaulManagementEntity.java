package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentOverhaulManagementEntity implements Serializable {

    private static final long serialVersionUID = 1380796148705602000L;

    private Integer id;
    @NotNull
    private Integer equipmentNumberId;

    private String problemAnalysis;

    private String reason;

    private String procedure;

    private String evaluate;
    @NotNull
    private Integer number;
    @NotNull
    private Integer sendNumber;
    @NotNull
    private Integer returnNumber;

    private EquipmentNumberEntity equipmentNumberEntity;

}