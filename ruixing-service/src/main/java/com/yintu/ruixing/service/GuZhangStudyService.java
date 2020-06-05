package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.GuZhangStudyEntity;

import java.util.List;
import java.util.Map;

/**
 * @author:lcy
 * @date:2020-06-04 16
 */
public interface GuZhangStudyService {
    List<GuZhangStudyEntity> findGuZhangList(Integer page, Integer size);

    GuZhangStudyEntity findGuZhangById(Long id);

    void addGuZhang(GuZhangStudyEntity guZhangStudyEntity);

    void editGuZhang(Long id);

    void deletGuZhang(Long id);

    void deletGuZhangList(int[] ids);
}
