package com.huizhi.oa.service;

import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Meethouse;

import java.util.List;

public interface MeethouseService {
    int deleteByPrimaryKey(Integer mhId);

    int insert(Meethouse record);

    int insertSelective(Meethouse record);

    Meethouse selectByPrimaryKey(Integer mhId);

    int updateByPrimaryKeySelective(Meethouse record);

    int updateByPrimaryKey(Meethouse record);

    List<Meethouse> getAllMeethouse();

    PageInfo<Meethouse> getAllMeethouse(Integer pageNum, Integer pageSize);

    int delMoreMeethouse(List<Integer> ids);
}