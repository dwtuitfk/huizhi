package com.huizhi.oa.service;

import com.huizhi.oa.entity.Leaveinfo;

public interface LeaveinfoService {
    int deleteByPrimaryKey(String lId);

    int insert(Leaveinfo record);

    int insertSelective(Leaveinfo record);

    Leaveinfo selectByPrimaryKey(String lId);

    int updateByPrimaryKeySelective(Leaveinfo record);

    int updateByPrimaryKey(Leaveinfo record);
}