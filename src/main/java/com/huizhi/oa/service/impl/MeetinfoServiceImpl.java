/**
 * System Name： SDN Platform
 * <p>
 * File Name： MeetinfoServiceImpl
 * <p>
 * Creating Time： 2019-02-17 17:36
 * <p>
 * Copyright (c) 2015-2025 Fiberhome Technologies.
 * 88,YouKeYuan Road, Hongshan District.,Wuhan,P.R.China,
 * Wuhan Research Institute of Post & Telecommunication.
 * <p>
 * All rights reserved.
 */

package com.huizhi.oa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.dao.MeetinfoMapper;
import com.huizhi.oa.entity.Meethouse;
import com.huizhi.oa.entity.Meetinfo;
import com.huizhi.oa.service.MeetinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function Description:  <br>
 * Writer: Administrator . <br>
 * Creating Time: 2019-02-17 17:36 <br>
 * Version:  <br>
 */
@Service
public class MeetinfoServiceImpl implements MeetinfoService {

    @Autowired
    private MeetinfoMapper meetinfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer mId) {
        int tmp = meetinfoMapper.deleteByPrimaryKey(mId);
        return tmp;
    }

    @Override
    public int insert(Meetinfo record) {
        int tmp = meetinfoMapper.insert(record);
        return tmp;
    }

    @Override
    public int insertSelective(Meetinfo record) {
        int tmp = meetinfoMapper.insertSelective(record);
        return tmp;
    }

    @Override
    public Meetinfo selectByPrimaryKey(Integer mId) {
        return meetinfoMapper.selectByPrimaryKey(mId);
    }

    @Override
    public int updateByPrimaryKeySelective(Meetinfo record) {
        int tmp = meetinfoMapper.updateByPrimaryKeySelective(record);
        return tmp;
    }

    @Override
    public int updateByPrimaryKey(Meetinfo record) {
        int tmp = meetinfoMapper.updateByPrimaryKey(record);
        return tmp;
    }

    @Override
    public List<Meetinfo> getAllMeetinfo() {
        return meetinfoMapper.getAllMeetinfo();
    }

    @Override
    public PageInfo<Meetinfo> getAllMeetinfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Meetinfo> list = meetinfoMapper.getAllMeetinfo();
        return new PageInfo<>(list);
    }

    @Override
    public int delMoreMeetinfo(List<Integer> ids) {
        return meetinfoMapper.delMoreMeetinfo(ids);
    }

    @Override
    public List<Meetinfo> seachMeetinfo(Meetinfo meetinfo) {
        return meetinfoMapper.seachMeetinfo(meetinfo);
    }


}