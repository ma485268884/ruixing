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
public class IndexAnalysisEquipmentEntity implements Serializable {
    private static final long serialVersionUID = 2993558940084234082L;
    private Integer id;
    @NotNull
    private Integer equipmentNumberId;
    @Past
    @NotNull
    private Date onlineTime;
    @Past
    @NotNull
    private Date logoutTime;
    @NotEmpty
    private String usingHistory;
    @NotEmpty
    private String usingLocal;
    @NotEmpty
    private String usingTime;
    @NotEmpty
    private String faultSection;
    @NotNull
    private Short faultType;
    @NotEmpty
    private String equipmentMttf;
    @NotEmpty
    private String typeMttf;

}