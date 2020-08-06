package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionRoleEntity implements Serializable {
    private static final long serialVersionUID = 7667009621254933740L;

    private Long id;

    private Long roleId;

    private Long permissionId;

}