package com.huizhi.oa.service;

import com.huizhi.oa.entity.Jurinfo;

public interface JurinfoService {
    int deleteByPrimaryKey(Integer jurid);

    int insert(Jurinfo record);

    int insertSelective(Jurinfo record);

    Jurinfo selectByPrimaryKey(Integer jurid);

    int updateByPrimaryKeySelective(Jurinfo record);

    int updateByPrimaryKey(Jurinfo record);
}