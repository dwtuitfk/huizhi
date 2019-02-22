/**
 * System Name： SDN Platform
 * <p>
 * File Name： MeethouseServiceImpl
 * <p>
 * Creating Time： 2019-02-17 17:34
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
import com.huizhi.oa.dao.MeethouseMapper;
import com.huizhi.oa.dao.MeetinfoMapper;
import com.huizhi.oa.entity.Meethouse;
import com.huizhi.oa.service.MeethouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function Description:  <br>
 * Writer: Administrator . <br>
 * Creating Time: 2019-02-17 17:34 <br>
 * Version:  <br>
 */
@Service
public class MeethouseServiceImpl implements MeethouseService {

    @Autowired
    private MeethouseMapper meethouseMapper;

    @Override
    public int deleteByPrimaryKey(Integer mhId) {
        return meethouseMapper.deleteByPrimaryKey(mhId);
    }

    @Override
    public int insert(Meethouse record) {
        return meethouseMapper.insert(record);
    }

    @Override
    public int insertSelective(Meethouse record) {
        return meethouseMapper.insertSelective(record);
    }

    @Override
    public Meethouse selectByPrimaryKey(Integer mhId) {
        return meethouseMapper.selectByPrimaryKey(mhId);
    }

    @Override
    public int updateByPrimaryKeySelective(Meethouse record) {
        return meethouseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Meethouse record) {
        return meethouseMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Meethouse> getAllMeethouse() {
        return meethouseMapper.getAllMeethouse();
    }

    @Override
    public PageInfo<Meethouse> getAllMeethouse(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Meethouse> list = meethouseMapper.getAllMeethouse();
        return new PageInfo<>(list);
    }

    @Override
    public int delMoreMeethouse(List<Integer> ids) {
        return meethouseMapper.delMoreMeethouse(ids);
    }
}