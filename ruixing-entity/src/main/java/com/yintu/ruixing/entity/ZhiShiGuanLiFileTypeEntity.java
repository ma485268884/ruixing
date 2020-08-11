package com.yintu.ruixing.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhiShiGuanLiFileTypeEntity {
    private Integer id;

    private String filetype;

    private String filemiaoshu;

    private String yuliu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }

    public String getFilemiaoshu() {
        return filemiaoshu;
    }

    public void setFilemiaoshu(String filemiaoshu) {
        this.filemiaoshu = filemiaoshu == null ? null : filemiaoshu.trim();
    }

    public String getYuliu() {
        return yuliu;
    }

    public void setYuliu(String yuliu) {
        this.yuliu = yuliu == null ? null : yuliu.trim();
    }
}