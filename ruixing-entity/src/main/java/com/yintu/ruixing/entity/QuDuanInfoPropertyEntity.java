package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuDuanInfoPropertyEntity implements Serializable {
    private static final long serialVersionUID = -4741393488541565507L;
    private Integer id;

    private String name;

}