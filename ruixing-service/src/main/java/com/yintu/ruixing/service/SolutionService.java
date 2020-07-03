package com.yintu.ruixing.service;

import java.util.Date;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/7/3 18:03
 */
public interface SolutionService {

    /**
     * 统计工作完成进度
     *
     * @return
     */
    /**
     * 统计工作完成进度
     *
     * @param selectType 1.年  2.年-月  3.年-月-日
     * @param date       日期
     * @return 解决方案中每个模块工作完成情况
     */
    Map<String, Object> workCompletion(Integer selectType, Date date);
}
