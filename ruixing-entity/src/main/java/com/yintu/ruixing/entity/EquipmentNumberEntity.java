package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentNumberEntity implements Serializable {

    private static final long serialVersionUID = -7048045003432143566L;

    private Integer id;
    @NotBlank
    private String rackNumber;
    @NotBlank
    private String equipmentNumber;
    @NotBlank
    private String hierarchy;
    @NotNull
    private Date createdDate;
    @NotBlank
    private String operator;
    @NotBlank
    private String photoPath;
    @NotBlank
    private String photoName;
    @NotNull
    private Integer equipmentId;

    private EquipmentEntity equipmentEntity;
}