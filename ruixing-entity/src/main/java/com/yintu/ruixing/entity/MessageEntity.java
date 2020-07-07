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

    private String title;

    private Short type;

    private Integer senderId;

    private Integer receiverId;

    private Short status;

    private Date createdDate;

    private String context;

}