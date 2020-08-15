package com.yintu.ruixing.jiejuefangan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesignLiaisonFileAuditorEntity implements Serializable {
    private static final long serialVersionUID = -7791281967674411902L;
    private Integer id;
    @NotNull
    private Integer designLiaisonFileId;
    @NotNull
    private Integer auditorId;
    @NotNull
    private Short isPass;
}