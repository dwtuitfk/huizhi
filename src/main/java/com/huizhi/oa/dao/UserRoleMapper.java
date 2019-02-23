package com.huizhi.oa.dao;

import com.huizhi.oa.entity.UserRole;

import java.util.List;

public interface UserRoleMapper {

    //插入单个用户角色
    int insert(UserRole record);

    //选择插入用户角色
    int insertSelective(UserRole record);

    //查询单个用户角色roleid
    UserRole getUserRoleinfo(Integer roleid);

    //删除单个用户角色信息
    int delUserRoleinfo (Integer roleid);

    //根据userid查询对应角色roleid
    List<UserRole> getAllUserRoleinfo(Integer roleid);
}