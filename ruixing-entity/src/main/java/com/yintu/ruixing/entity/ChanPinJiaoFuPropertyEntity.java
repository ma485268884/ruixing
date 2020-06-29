package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Mis.liu
 * @Date 2020/6/23 16:29
 * @Version 1.0
 * 需求:产品交付三级树 实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChanPinJiaoFuPropertyEntity {
    private Integer id;

    private String name;

    private Integer parentId;

    private Integer nameType;//名称类型 1：项目编号 2.项目名称 3.输入文件 4：输出文件',
}
