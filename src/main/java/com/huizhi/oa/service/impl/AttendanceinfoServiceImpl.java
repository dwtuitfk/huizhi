package com.huizhi.oa.service.impl;

import com.huizhi.oa.dao.AttendanceinfoMapper;
import com.huizhi.oa.entity.Attendanceinfo;
import com.huizhi.oa.service.AttendanceinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceinfoServiceImpl implements AttendanceinfoService {
    @Autowired
    private AttendanceinfoMapper attendanceinfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer aId) {
        return attendanceinfoMapper.deleteByPrimaryKey(aId);
    }

    @Override
    public int insert(Attendanceinfo record) {
        return attendanceinfoMapper.insert(record);
    }

    @Override
    public int insertSelective(Attendanceinfo record) {
        return attendanceinfoMapper.insertSelective(record);
    }

    @Override
    public Attendanceinfo selectByPrimaryKey(Integer aId) {
        return attendanceinfoMapper.selectByPrimaryKey(aId);
    }

    @Override
    public List<Attendanceinfo> selectGetAll() {
        return attendanceinfoMapper.selectGetAll();
    }

    @Override
    public List<Attendanceinfo> selectAttendanceinfo() {
        return attendanceinfoMapper.selectAttendanceinfo();
    }

    @Override
    public int updateByPrimaryKeySelective(Attendanceinfo record) {
        return attendanceinfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKey(Attendanceinfo record) {
        return attendanceinfoMapper.updateByPrimaryKeySelective(record);
    }
}
