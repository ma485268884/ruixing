package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity implements Serializable {
    private static final long serialVersionUID = -7661289940878957764L;
    private Long id;

    private String name;

    private String description;


}