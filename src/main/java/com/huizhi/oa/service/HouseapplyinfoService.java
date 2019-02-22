package com.huizhi.oa.service;

import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Houseapplyinfo;

import java.util.List;

public interface HouseapplyinfoService {
    int deleteByPrimaryKey(Integer haId);

    int insert(Houseapplyinfo record);

    int insertSelective(Houseapplyinfo record);

    Houseapplyinfo selectByPrimaryKey(Integer haId);

    int updateByPrimaryKeySelective(Houseapplyinfo record);

    int updateByPrimaryKey(Houseapplyinfo record);

    List<Houseapplyinfo> getAllHouseapplyinfo();

    PageInfo<Houseapplyinfo> getAllHouseapplyinfo(Integer pageNum, Integer pageSize);

}