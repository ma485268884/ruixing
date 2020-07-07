package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.MessageEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/7 14:44
 */
public interface MessageService extends BaseService<MessageEntity, Integer> {

    /**
     * 按照类型和状态查询消息
     *
     * @param type   类型
     * @param Status 状态
     * @return 消息集
     */
    List<MessageEntity> findByTypeAndStatus(Short type, Short Status);

    /**
     * @param messageEntity 消息实体类
     */
    void sendMessage(MessageEntity messageEntity);

}
