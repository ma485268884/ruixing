package com.yintu.ruixing.common.util;

import java.io.Serializable;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/8/8 20:40
 */
public interface AdvancedService<T extends Serializable, PK extends Serializable> extends BaseService<T, PK> {

    List<T> findByExample(T entity);

    void removeByIds(PK[] ids);

}
