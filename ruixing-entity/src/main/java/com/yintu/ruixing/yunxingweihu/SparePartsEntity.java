package com.yintu.ruixing.yunxingweihu;

import com.yintu.ruixing.guzhangzhenduan.CheZhanEntity;
import com.yintu.ruixing.weixiudaxiu.EquipmentEntity;
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
    private static final long serialVersionUID = 1549917467396112105L;
    private Integer id;
    @NotNull
    private Integer cheZhanId;
    @NotNull
    private Integer equipmentId;
    @NotEmpty
    private String equipmentNumber;
    @NotNull
    private Short equipmentStatus;
    @NotNull
    private Short isReplace;
    @NotNull
    private Date createDate;
    @NotNull
    private Short storageTime;

    private Date endDate;

    private CheZhanEntity cheZhanEntity;

    private EquipmentEntity equipmentEntity;

}