package com.yintu.ruixing.xitongguanli;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleEntity implements Serializable {
    private static final long serialVersionUID = 5648734088166412767L;
    private Long id;

    private Long userId;

    private Long roleId;
}