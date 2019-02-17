package com.huizhi.oa.service;

import com.huizhi.oa.entity.Emailinfo;

public interface EmailinfoService {
    int deleteByPrimaryKey(String eId);

    int insert(Emailinfo record);

    int insertSelective(Emailinfo record);

    Emailinfo selectByPrimaryKey(String eId);

    int updateByPrimaryKeySelective(Emailinfo record);

    int updateByPrimaryKey(Emailinfo record);
}