package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Roleinfo;

public interface RoleinfoMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Roleinfo record);

    int insertSelective(Roleinfo record);

    Roleinfo selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Roleinfo record);

    int updateByPrimaryKey(Roleinfo record);
}