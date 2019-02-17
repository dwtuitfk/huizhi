package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Houseapplyinfo;

public interface HouseapplyinfoMapper {
    int deleteByPrimaryKey(Integer haId);

    int insert(Houseapplyinfo record);

    int insertSelective(Houseapplyinfo record);

    Houseapplyinfo selectByPrimaryKey(Integer haId);

    int updateByPrimaryKeySelective(Houseapplyinfo record);

    int updateByPrimaryKey(Houseapplyinfo record);
}