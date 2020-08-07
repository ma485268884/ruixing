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

    private static final long serialVersionUID = -2742251652831479682L;
    private Long id;

    private Long parentId;

    private String name;

    private String url;

    private String method;

    private Short isMenu;

    private String path;

    private String iconCls;

    private String description;

    private List<RoleEntity> roleEntities;

}