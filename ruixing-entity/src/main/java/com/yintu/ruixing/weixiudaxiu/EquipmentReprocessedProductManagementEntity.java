package com.yintu.ruixing.weixiudaxiu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentReprocessedProductManagementEntity implements Serializable {
    private static final long serialVersionUID = 3716572830874019962L;

    private Integer id;
    @NotNull
    private Integer equipmentNumberId;

    private String factoryInformation;

    private String repairRequest;

    private String dispositionRequest;

    private String testInformation;

    private String repairInformation;

    private String checkoutInformation;

    private String incomingInformation;

    private String deliveryInformation;

    private EquipmentNumberEntity equipmentNumberEntity;

}