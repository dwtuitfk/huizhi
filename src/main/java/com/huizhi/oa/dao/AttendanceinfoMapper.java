package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Attendanceinfo;

public interface AttendanceinfoMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(Attendanceinfo record);

    int insertSelective(Attendanceinfo record);

    Attendanceinfo selectByPrimaryKey(Integer aId);

    int updateByPrimaryKeySelective(Attendanceinfo record);

    int updateByPrimaryKey(Attendanceinfo record);
}