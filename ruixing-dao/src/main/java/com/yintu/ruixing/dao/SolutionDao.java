package com.yintu.ruixing.dao;

import java.util.Date;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/4 9:49
 */
public interface SolutionDao {

    List<Integer> countTaskStatusByGroupBy(Integer selectType, Date date);
}
