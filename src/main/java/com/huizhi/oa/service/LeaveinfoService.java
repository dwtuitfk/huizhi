package com.huizhi.oa.service;

import com.huizhi.oa.entity.Leaveinfo;

import java.util.List;

public interface LeaveinfoService {
    int deleteByPrimaryKey(String lId);

    int insert(Leaveinfo record);

    int insertSelective(Leaveinfo record);

    /**
     * 测试查询条件
     * @param leaveinfo
     * @return
     */
    List<Leaveinfo> selectTest(Leaveinfo leaveinfo);

    Leaveinfo selectByPrimaryKey(String lId);


    /**
     * 多条件模糊查询信息
     * @param leaveinfo
     * @return
     */
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
     * 获取某个人所有请假信息,部门
     * @return
     */
    List<Leaveinfo> getAllLeaveInfoAndBM();
    /**
     * 获取某个人所有出差信息,部门
     * @return
     */
    List<Leaveinfo> getAllBusinessInfoAndBM();
}