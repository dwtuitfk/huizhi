package com.huizhi.oa.service;

import com.huizhi.oa.entity.Leaveinfo;

import java.util.List;

public interface LeaveinfoService {
    int deleteByPrimaryKey(String lId);

    int insert(Leaveinfo record);

    int insertSelective(Leaveinfo record);

    Leaveinfo selectByPrimaryKey(String lId);

    int updateByPrimaryKeySelective(Leaveinfo record);

    int updateByPrimaryKey(Leaveinfo record);

    /**
     * 获取所有请假、出差信息
     * @return
     */
    List<Leaveinfo> getAllLeaveInfo();
}