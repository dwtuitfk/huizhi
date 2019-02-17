package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Meethouse;

public interface MeethouseMapper {
    int deleteByPrimaryKey(Integer mhId);

    int insert(Meethouse record);

    int insertSelective(Meethouse record);

    Meethouse selectByPrimaryKey(Integer mhId);

    int updateByPrimaryKeySelective(Meethouse record);

    int updateByPrimaryKey(Meethouse record);
}