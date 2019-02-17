package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Carapplyinfo;

public interface CarapplyinfoMapper {
    int deleteByPrimaryKey(String caId);

    int insert(Carapplyinfo record);

    int insertSelective(Carapplyinfo record);

    Carapplyinfo selectByPrimaryKey(String caId);

    int updateByPrimaryKeySelective(Carapplyinfo record);

    int updateByPrimaryKey(Carapplyinfo record);
}