package com.yintu.ruixing.guzhangzhenduan;

import java.util.Map;

/**
 * @author:lcy
 * @date:2020-05-30 16
 * 车站数据展示
 */
public interface DataShowService {
    Map<String, Object> allData(Long xid, Long cid, String quduan);
}
