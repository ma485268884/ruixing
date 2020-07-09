package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.MessageEntity;

import java.util.List;

public interface MessageDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MessageEntity record);

    int insertSelective(MessageEntity record);

    MessageEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageEntity record);

    int updateByPrimaryKeyWithBLOBs(MessageEntity record);

    int updateByPrimaryKey(MessageEntity record);

    List<MessageEntity> selectByTypeAndStatus(Short type, Short status);

    List<MessageEntity> findXiaoXi();


}