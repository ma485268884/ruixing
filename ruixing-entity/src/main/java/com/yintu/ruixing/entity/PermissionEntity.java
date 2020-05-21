package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionEntity implements Serializable {
    private static final long serialVersionUID = 3408375540791629308L;
    private Long id;

    private Long parentId;

    private String url;

    private String method;

    private String iconCls;

    private String description;

    private List<RoleEntity> roleEntities;

}