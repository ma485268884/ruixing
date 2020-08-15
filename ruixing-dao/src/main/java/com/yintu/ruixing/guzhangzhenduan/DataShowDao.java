package com.yintu.ruixing.guzhangzhenduan;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @author:lcy
 * @date:2020-05-30 16
 *车站数据展示
 */
@Mapper
public interface DataShowDao {
    Map<String, Object> allData(Long xid, Long cid, String quduan);
}
