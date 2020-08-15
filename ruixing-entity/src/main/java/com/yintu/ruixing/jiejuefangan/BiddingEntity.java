package com.yintu.ruixing.jiejuefangan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
/**
 * 投招标技术支持 项目实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BiddingEntity implements Serializable {
    private static final long serialVersionUID = 5743348273904345051L;
    private Integer id;
    @NotEmpty
    private String projectName;
    @NotNull
    private Short projectStatus;
    @NotNull
    private Date projectDate;
    @NotNull
    private Short taskStatus;

    private Date taskFinishDate;
    @NotEmpty
    private String bidder;
    @NotNull
    private Integer railwayAdministrationId;

    private Integer preSaleId;


}