package com.huizhi.oa.dao;

import com.huizhi.oa.entity.RoleJur;

import java.util.List;

public interface RoleJurMapper {
    int insert(RoleJur record);

    int insertSelective(RoleJur record);

    //根据角色id查询对应的权限信息
    List<RoleJur> getJurinfo(Integer roleid);
}