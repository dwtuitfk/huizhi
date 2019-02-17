package com.huizhi.oa.service;

import com.huizhi.oa.entity.Attendanceinfo;

public interface AttendanceinfoService {
    int deleteByPrimaryKey(Integer aId);

    int insert(Attendanceinfo record);

    int insertSelective(Attendanceinfo record);

    Attendanceinfo selectByPrimaryKey(Integer aId);

    int updateByPrimaryKeySelective(Attendanceinfo record);

    int updateByPrimaryKey(Attendanceinfo record);
}