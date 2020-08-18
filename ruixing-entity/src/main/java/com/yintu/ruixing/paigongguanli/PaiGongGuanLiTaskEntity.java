package com.yintu.ruixing.paigongguanli;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PaiGongGuanLiTaskEntity {
    private Integer id;

    private String tasktotalname;

    private String taskname;

    private String businesstype;

    private String businesstask;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTasktotalname() {
        return tasktotalname;
    }

    public void setTasktotalname(String tasktotalname) {
        this.tasktotalname = tasktotalname == null ? null : tasktotalname.trim();
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname == null ? null : taskname.trim();
    }

    public String getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(String businesstype) {
        this.businesstype = businesstype == null ? null : businesstype.trim();
    }

    public String getBusinesstask() {
        return businesstask;
    }

    public void setBusinesstask(String businesstask) {
        this.businesstask = businesstask == null ? null : businesstask.trim();
    }
}