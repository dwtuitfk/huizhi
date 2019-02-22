package com.huizhi.oa.service;

import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Userzd;

import java.util.List;

public interface UserzdService {

    //插入单条岗位信息
    int insert(Userzd record);

    //选择插入单条岗位信息
    int insertSelective(Userzd record);

    //查询所有岗位信息
    List<Userzd> getAllUserzd();

    //修改岗位信息
    int updateUserzd(Userzd record);

    //查询单条岗位信息
    Userzd getUserzd(int userzdid);

    //删除岗位信息
    int delMoreUserzd(List<Integer> ids);

    //根据rolename查询对应岗位名称
    Userzd getRoleName(int rolename);
}