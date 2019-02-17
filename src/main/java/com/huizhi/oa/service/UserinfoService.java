package com.huizhi.oa.service;

import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Userinfo;

import java.util.List;

public interface UserinfoService {
    int deleteByPrimaryKey(Integer userid);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    //查询所有用户信息
    List<Userinfo> getAllUserinfo();

    //LagUI分页显示
    PageInfo<Userinfo> selectUserinfoALL(Integer pageNum, Integer pageSize);
}