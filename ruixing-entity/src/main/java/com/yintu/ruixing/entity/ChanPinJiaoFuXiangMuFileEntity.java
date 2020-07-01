package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Mr.liu
 * @Date 2020/7/1 17:47
 * @Version 1.0
 * 需求:产品交付的文件
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChanPinJiaoFuXiangMuFileEntity {

    private Integer id;

    private Integer xmId;//项目的id

    private Integer fileType;//文件类型 1：输入文件 ，2：输出文件',

    private String fileName;//文件名

    private String filePath;//  文件路径

    private Integer fabuType;//发布状态 1：录入  2：发布'

    private Integer auditorId;//审核人id

}
