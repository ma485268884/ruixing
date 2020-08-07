package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:mlf
 * @date:2020/8/7 10:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuDuanInfoPropertyClassEntity implements Serializable {
    private static final long serialVersionUID = 3073032034611641047L;
    private Integer id;
    private String name;
}
