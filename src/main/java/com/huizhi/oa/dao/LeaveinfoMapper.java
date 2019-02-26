package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Leaveinfo;

import java.util.List;

public interface LeaveinfoMapper {
    int deleteByPrimaryKey(String lId);

    int insert(Leaveinfo record);

    int insertSelective(Leaveinfo record);

    //<select id="selectTest"
    List<Leaveinfo> selectTest(Leaveinfo leaveinfo);

    Leaveinfo selectByPrimaryKey(String lId);

    //<select id="selectLeaveinfo"
    List<Leaveinfo> selectLeaveinfo(Leaveinfo leaveinfo);

    int updateByPrimaryKeySelective(Leaveinfo record);

    int updateByPrimaryKey(Leaveinfo record);

    /**
     * 获取所有请假、出差信息
     * @return
     */
    List<Leaveinfo> getAllLeaveInfo();
    /**
     * 获取某个人所有请假、出差信息,部门
     * @return
     */
    List<Leaveinfo> getOneLeaveInfoAndBM(Integer userId);
    /**
     * 获取所有请假信息,部门
     * @return
     */
    List<Leaveinfo> getAllLeaveInfoAndBM();
    /**
     * 获取所有出差信息,部门
     * @return
     */
    List<Leaveinfo> getAllBusinessInfoAndBM();
}