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
public class SparePartsEntity implements Serializable {
    private static final long serialVersionUID = 2278639226184850872L;
    private Integer id;
    @NotEmpty
    private String equipmentName;
    @NotEmpty
    private String storageTime;
    @NotEmpty
    private String examinationPeriod;
    @NotNull
    private Short examinationStatus;
    @NotNull
    private Short functionalStatus;

    private Date createdDate;


}