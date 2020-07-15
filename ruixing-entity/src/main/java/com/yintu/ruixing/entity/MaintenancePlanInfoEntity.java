package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenancePlanInfoEntity implements Serializable {
    private static final long serialVersionUID = 5855998045982124844L;
    private Integer id;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;
    @NotNull
    private Integer maintenancePlanId;
    @NotNull
    private Integer cheZhanId;
    @NotNull
    private Integer equipmentId;

    private Date createdDate;

    private MaintenancePlanEntity maintenancePlanEntity;

    private CheZhanEntity cheZhanEntity;

    private EquipmentEntity equipmentEntity;


}