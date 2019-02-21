package com.huizhi.oa.dao;

import com.huizhi.oa.entity.UserJur;
import com.huizhi.oa.entity.UserRoleDep;
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
    List<UserRoleDep> getAllUserinfo();

    //查询所有用户权限
    List<UserJur>getUserJurInfo();

    //查询单个用户信息
    UserRoleDep getUserinfo (Integer userid);

    //模糊查询
    List<UserRoleDep> seachUserinfo(UserRoleDep userRoleDep);
}