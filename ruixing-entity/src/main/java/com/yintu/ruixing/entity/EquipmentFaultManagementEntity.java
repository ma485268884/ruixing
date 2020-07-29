package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentFaultManagementEntity implements Serializable {
    private static final long serialVersionUID = 5819619126955981241L;
    private Integer id;
    @NotNull
    private Integer equipmentNumberId;
    @NotNull
    private Integer tielujuId;
    @NotNull
    private Integer dianwuduanId;
    @NotNull
    private Integer xianduanId;
    @NotNull
    private Integer chezhanId;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;

    private EquipmentNumberEntity equipmentNumberEntity;

    private TieLuJuEntity tieLuJuEntity;

    private DianWuDuanEntity dianWuDuanEntity;

    private XianDuanEntity xianDuanEntity;

    private CheZhanEntity cheZhanEntity;

}