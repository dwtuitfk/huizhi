package com.huizhi.oa.service;

import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Meetinfo;

import java.util.List;

public interface MeetinfoService {
    int deleteByPrimaryKey(Integer mId);

    int insert(Meetinfo record);

    int insertSelective(Meetinfo record);

    Meetinfo selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Meetinfo record);

    int updateByPrimaryKey(Meetinfo record);

    List<Meetinfo> getAllMeetinfo();

    PageInfo<Meetinfo> getAllMeetinfo(Integer pageNum, Integer pageSize);

    int delMoreMeetinfo(List<Integer> ids);

    /**
     * 模糊查询
     * @param meetinfo
     * @return
     */
    List<Meetinfo> seachMeetinfo(Meetinfo meetinfo);
}