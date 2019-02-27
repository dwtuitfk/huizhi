package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Meethouse;
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

    /**
     * 多项删除
     * @param ids
     * @return
     */
    int delMoreMeetinfo(List<Integer> ids);

    /**
     * 模糊查询
     * @param meetinfo
     * @return
     */
    List<Meetinfo> seachMeetinfo(Meetinfo meetinfo);
}