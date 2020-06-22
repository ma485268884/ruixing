package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *解决方案
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolutionEntity implements Serializable {
    private static final long serialVersionUID = 3656256502105407861L;
    private Integer id;

    private Integer parentId;

    private String name;

    private Short nameType;

    private Short type;

}