package com.huizhi.oa.service;

import com.huizhi.oa.entity.Carapplyinfo;

public interface CarapplyinfoService {
    int deleteByPrimaryKey(String caId);

    int insert(Carapplyinfo record);

    int insertSelective(Carapplyinfo record);

    Carapplyinfo selectByPrimaryKey(String caId);

    int updateByPrimaryKeySelective(Carapplyinfo record);

    int updateByPrimaryKey(Carapplyinfo record);
}