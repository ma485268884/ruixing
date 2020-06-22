package com.yintu.ruixing.common.util;

import java.io.Serializable;

/**
 * @author:mlf
 * @date:2020/6/22 15:36
 */
public interface BaseService<T extends Serializable, PK extends Serializable> {

    void add(T entity);

    void remove(PK id);

    void edit(T entity);

    T findById(PK id);

}
