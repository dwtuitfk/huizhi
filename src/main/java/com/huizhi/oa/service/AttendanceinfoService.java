package com.huizhi.oa.service;

import com.huizhi.oa.entity.Attendanceinfo;

import java.util.List;

public interface AttendanceinfoService {
    int deleteByPrimaryKey(Integer aId);

    int insert(Attendanceinfo record);

    int insertSelective(Attendanceinfo record);

    Attendanceinfo selectByPrimaryKey(Integer aId);

    List<Attendanceinfo> selectGetAll();

    List<Attendanceinfo> selectAttendanceinfo(Attendanceinfo attendanceinfo);

    int updateByPrimaryKeySelective(Attendanceinfo record);

    int updateByPrimaryKey(Attendanceinfo record);
}