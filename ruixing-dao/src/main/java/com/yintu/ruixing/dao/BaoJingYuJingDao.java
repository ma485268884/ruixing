package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.BaoJingYuJingEntity;

import java.util.Date;
import java.util.List;

public interface BaoJingYuJingDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BaoJingYuJingEntity record);

    int insertSelective(BaoJingYuJingEntity record);

    BaoJingYuJingEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaoJingYuJingEntity record);

    int updateByPrimaryKey(BaoJingYuJingEntity record);






    List<BaoJingYuJingEntity> findAllYuJingBaoJing();

    List<BaoJingYuJingEntity> findYuJingBaoJingBySouSuo(Integer[] ids, Integer sid, Integer qid, Date startTime, Date endTime, Integer tianchang, Integer lvchuhuifu, Integer lvchuhuifu1);
}