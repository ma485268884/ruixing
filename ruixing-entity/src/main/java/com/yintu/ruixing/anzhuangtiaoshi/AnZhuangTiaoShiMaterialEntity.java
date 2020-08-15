package com.yintu.ruixing.anzhuangtiaoshi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnZhuangTiaoShiMaterialEntity {
    private Integer id;

    private String materialsname;

    private String materialsnumber;

    private String materialstype;

    private String usemode;

    private String materialsguige;

    private Integer yujingnumber;

    private Integer totalnumber;

    private String yuliu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterialsname() {
        return materialsname;
    }

    public void setMaterialsname(String materialsname) {
        this.materialsname = materialsname == null ? null : materialsname.trim();
    }

    public String getMaterialsnumber() {
        return materialsnumber;
    }

    public void setMaterialsnumber(String materialsnumber) {
        this.materialsnumber = materialsnumber == null ? null : materialsnumber.trim();
    }

    public String getMaterialstype() {
        return materialstype;
    }

    public void setMaterialstype(String materialstype) {
        this.materialstype = materialstype == null ? null : materialstype.trim();
    }

    public String getUsemode() {
        return usemode;
    }

    public void setUsemode(String usemode) {
        this.usemode = usemode == null ? null : usemode.trim();
    }

    public String getMaterialsguige() {
        return materialsguige;
    }

    public void setMaterialsguige(String materialsguige) {
        this.materialsguige = materialsguige == null ? null : materialsguige.trim();
    }

    public Integer getYujingnumber() {
        return yujingnumber;
    }

    public void setYujingnumber(Integer yujingnumber) {
        this.yujingnumber = yujingnumber;
    }

    public Integer getTotalnumber() {
        return totalnumber;
    }

    public void setTotalnumber(Integer totalnumber) {
        this.totalnumber = totalnumber;
    }

    public String getYuliu() {
        return yuliu;
    }

    public void setYuliu(String yuliu) {
        this.yuliu = yuliu == null ? null : yuliu.trim();
    }
}