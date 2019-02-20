package com.huizhi.oa.service;

import com.huizhi.oa.entity.Roleinfo;

import java.util.List;

public interface RoleinfoService {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Roleinfo record);

    int insertSelective(Roleinfo record);

    Roleinfo selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Roleinfo record);

    int updateByPrimaryKey(Roleinfo record);

    //查询所有角色信息
    List<Roleinfo> getAllRoleinfo();
}