package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntity {
    private Long id;

    private Long parentId;

    private String name;

    private Date createTime;
    
}