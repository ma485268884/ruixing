package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageEntity implements Serializable {
    private static final long serialVersionUID = -6696722812248660445L;
    private Integer id;

    private String title;//标题

    private Short type;//类型 1. 解决方案 2.产品交付 3.安装调试 4.故障诊断

    private Integer senderId;

    private Integer receiverId;

    private Short status;//状态 1.未读 2.OPEN 3.CLOSE',

    private Date createdDate;//创建时间

    private String context;

}