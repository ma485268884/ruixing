package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
/**
 * 设计联络以及后续技术交流 项目实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesignLiaisonEntity implements Serializable {
    private static final long serialVersionUID = -8938583455153408890L;
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
    @NotNull
    private Short meetingStatus;
    @NotNull
    private Short changeStatus;
    @NotEmpty
    private String bidder;
    @NotNull
    private Integer railwayAdministrationId;

    private Integer biddingId;

}