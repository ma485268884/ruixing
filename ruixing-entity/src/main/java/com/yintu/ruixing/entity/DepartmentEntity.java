package com.yintu.ruixing.entity;

import com.alibaba.fastjson.annotation.JSONField;
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

    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;

}