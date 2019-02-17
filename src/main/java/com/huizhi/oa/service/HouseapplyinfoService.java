package com.huizhi.oa.service;

import com.huizhi.oa.entity.Houseapplyinfo;

public interface HouseapplyinfoService {
    int deleteByPrimaryKey(Integer haId);

    int insert(Houseapplyinfo record);

    int insertSelective(Houseapplyinfo record);

    Houseapplyinfo selectByPrimaryKey(Integer haId);

    int updateByPrimaryKeySelective(Houseapplyinfo record);

    int updateByPrimaryKey(Houseapplyinfo record);
}