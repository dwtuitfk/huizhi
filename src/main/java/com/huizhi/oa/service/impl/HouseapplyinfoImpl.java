/**
 * System Name： SDN Platform
 * <p>
 * File Name： HouseapplyinfoImpl
 * <p>
 * Creating Time： 2019-02-17 17:24
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
import com.huizhi.oa.dao.HouseapplyinfoMapper;
import com.huizhi.oa.entity.Houseapplyinfo;
import com.huizhi.oa.service.HouseapplyinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function Description:  <br>
 * Writer: Administrator . <br>
 * Creating Time: 2019-02-17 17:24 <br>
 * Version:  <br>
 */
@Service
public class HouseapplyinfoImpl implements HouseapplyinfoService {

    @Autowired
    private HouseapplyinfoMapper houseapplyinfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer haId) {
        int tmp = houseapplyinfoMapper.deleteByPrimaryKey(haId);
        return tmp;
    }

    @Override
    public int insert(Houseapplyinfo record) {
        int tmp = houseapplyinfoMapper.insert(record);
        return tmp;
    }

    @Override
    public int insertSelective(Houseapplyinfo record) {
        int tmp = houseapplyinfoMapper.insertSelective(record);
        return tmp;
    }

    @Override
    public Houseapplyinfo selectByPrimaryKey(Integer haId) {
        return houseapplyinfoMapper.selectByPrimaryKey(haId);
    }

    @Override
    public int updateByPrimaryKeySelective(Houseapplyinfo record) {
        int tmp = houseapplyinfoMapper.updateByPrimaryKeySelective(record);
        return tmp;
    }

    @Override
    public int updateByPrimaryKey(Houseapplyinfo record) {
        int tmp = houseapplyinfoMapper.updateByPrimaryKey(record);
        return tmp;
    }

    @Override
    public List<Houseapplyinfo> getAllHouseapplyinfo() {
        return houseapplyinfoMapper.getAllHouseapplyinfo();
    }

    @Override
    public PageInfo<Houseapplyinfo> getAllHouseapplyinfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Houseapplyinfo> list = houseapplyinfoMapper.getAllHouseapplyinfo();
        return new PageInfo<>(list);
    }

    /**
     * 多项删除
     * @param ids
     * @return
     */
    @Override
    public int delMoreHouseapplyinfo(List<Integer> ids) {
        return houseapplyinfoMapper.delMoreHouseapplyinfo(ids);
    }

    @Override
    public List<Houseapplyinfo> seachHouseapplyinfo(Houseapplyinfo houseapplyinfo) {
        return houseapplyinfoMapper.seachHouseapplyinfo(houseapplyinfo);
    }


}