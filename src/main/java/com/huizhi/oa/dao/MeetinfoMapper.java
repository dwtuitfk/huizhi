package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Meetinfo;

import java.util.List;

public interface MeetinfoMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Meetinfo record);

    int insertSelective(Meetinfo record);

    Meetinfo selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Meetinfo record);

    int updateByPrimaryKey(Meetinfo record);

    List<Meetinfo> getAllMeetinfo();
}