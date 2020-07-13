package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentNumberEntity implements Serializable {
    private static final long serialVersionUID = -1720478108378724026L;
    private Integer id;
    @NotEmpty
    private String rackNumber;
    @NotEmpty
    private String equipmentNumber;
    @NotEmpty
    private String hierarchy;
    @NotNull
    @Past
    private Date createdDate;
    @NotEmpty
    private String operator;
    @NotEmpty
    private String photoPath;
    @NotEmpty
    private String photoName;

}