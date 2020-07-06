package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreSaleFileAuditorEntity implements Serializable {
    private static final long serialVersionUID = -3516771071121003349L;
    private Integer id;
    @NotNull
    private Integer preSaleFileId;
    @NotNull
    private Integer auditorId;
    @NotNull
    private Short isPass;

}