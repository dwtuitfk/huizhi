package com.huizhi.oa.service;

import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.UserJur;
import com.huizhi.oa.entity.UserRoleDep;
import com.huizhi.oa.entity.Userinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserinfoService {
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

    //用户登陆
    UserRoleDep userlogin (Integer userid,Integer password);

    Userinfo  findById(Integer userid);

    Userinfo finduserById(Integer userid);

}