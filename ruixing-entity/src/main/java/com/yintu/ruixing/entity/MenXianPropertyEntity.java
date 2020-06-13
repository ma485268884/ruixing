package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenXianPropertyEntity implements Serializable {
    private static final long serialVersionUID = 8888119404299800198L;
    private Integer id;

    private Integer parentId;

    private String name;

}