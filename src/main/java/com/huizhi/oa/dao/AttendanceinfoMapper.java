package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Attendanceinfo;

import java.util.List;

public interface AttendanceinfoMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(Attendanceinfo record);

    int insertSelective(Attendanceinfo record);

    Attendanceinfo selectByPrimaryKey(Integer aId);

    //<select id="selectGetAll"  resultMap="BaseResultMap">
    List<Attendanceinfo> selectGetAll();

    //<select id="selectAttendanceinfo"
    List<Attendanceinfo> selectAttendanceinfo(Attendanceinfo attendanceinfo);

    int updateByPrimaryKeySelective(Attendanceinfo record);

    int updateByPrimaryKey(Attendanceinfo record);
    //<select id="searchSelect"

    /**
     * 索引查询
     * @param attendanceinfo
     * @return
     */
    List<Attendanceinfo> searchSelect(Attendanceinfo attendanceinfo);


//    <select id="selectAddTime"

    /**
     * 打卡前的查询
     * @param attendanceinfo
     * @return
     */
    List<Attendanceinfo> selectAddTime(Attendanceinfo attendanceinfo);
}