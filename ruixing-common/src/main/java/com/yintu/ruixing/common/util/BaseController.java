package com.yintu.ruixing.common.util;

import java.io.Serializable;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/30 19:16
 */
public interface BaseController<T extends Serializable, PK extends Serializable> {

    Map<String, Object> add(T entity);

    Map<String, Object> remove(PK id);

    Map<String, Object> edit(PK id, T entity);

    Map<String, Object> findById(PK id);
}
