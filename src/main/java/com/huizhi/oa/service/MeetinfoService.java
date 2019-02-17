package com.huizhi.oa.service;

import com.huizhi.oa.entity.Meetinfo;

public interface MeetinfoService {
    int deleteByPrimaryKey(Integer mId);

    int insert(Meetinfo record);

    int insertSelective(Meetinfo record);

    Meetinfo selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Meetinfo record);

    int updateByPrimaryKey(Meetinfo record);
}