package com.yintu.ruixing.weixiudaxiu;

import com.yintu.ruixing.common.DistrictEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentSparePartsManagementDbEntity implements Serializable {
    private static final long serialVersionUID = -1966722304562442600L;
    private Integer id;
    @NotNull
    private Integer equipmentId;
    @NotBlank
    private String materialNumber;
    @NotNull
    private Integer quantity;
    @NotNull
    private Integer provinceId;
    @NotNull
    private Integer cityId;
    @NotNull
    private Integer districtId;
    @NotBlank
    private String detailedAddress;
    @NotBlank
    private String contactPerson;
    @NotBlank
    private String phone;

    private EquipmentEntity equipmentEntity;

    private DistrictEntity provinceEntity;

    private DistrictEntity cityEntity;

    private DistrictEntity districtEntity;

}