package com.huizhi.oa.service;

import com.huizhi.oa.entity.Carinfo;

public interface CarinfoService {
    int deleteByPrimaryKey(String cId);

    int insert(Carinfo record);

    int insertSelective(Carinfo record);

    Carinfo selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Carinfo record);

    int updateByPrimaryKey(Carinfo record);
}