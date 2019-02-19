package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Userinfo;

import java.util.List;

public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    //查询所有用户信息
    List<Userinfo> getAllUserinfo();

    //查询所有用户角色
    List<Userinfo>getUserRoleDepInfo();

    //查询所有用户权限
    List<Userinfo>getUserJurInfo();
}