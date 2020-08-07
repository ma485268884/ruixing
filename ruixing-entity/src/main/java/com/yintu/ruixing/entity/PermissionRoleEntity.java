package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionRoleEntity implements Serializable {


    private static final long serialVersionUID = -7242102245855505129L;
    private Long id;

    private Long roleId;

    private Long permissionId;

}