package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author:lcy
 * @date:2020-05-22 11
 * 分页数据响应类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseDto<T> {

    private Integer size;  //每页记录数
    private Integer page; //页码
    private Long total;   //总数
    private List<T> result;

}
