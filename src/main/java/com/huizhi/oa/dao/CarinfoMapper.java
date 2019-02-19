package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Carinfo;

import java.util.List;

public interface CarinfoMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Carinfo record);

    int insertSelective(Carinfo record);

    Carinfo selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Carinfo record);

    int updateByPrimaryKey(Carinfo record);

    //查询所有车辆信息
    List<Carinfo> getAllCarinfo();
}