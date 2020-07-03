package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String projectName;

    private Short projectStatus;

    private Date projectDate;

    private Short taskStatus;

    private Date taskFinishDate;

    private Short meetingStatus;

    private Short changeStatus;

    private String bidder;

    private Integer railwayAdministrationId;

    private Integer biddingId;

}