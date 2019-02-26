package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Carinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CarinfoMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Carinfo record);

    int insertSelective(Carinfo record);

    Carinfo selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Carinfo record);

    int updateByPrimaryKey(Carinfo record);

    //查询所有车辆信息
    List<Carinfo> getAllCarinfo();
    //删去更多信息
    int delMoreCar(List<String> ids);
    //高级搜索
    List<Carinfo> seachCarinfo(Carinfo c);
}