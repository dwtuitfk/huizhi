package com.huizhi.oa.service;

import com.huizhi.oa.entity.Carinfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarinfoService {
    /**
     * 查询所有车辆信息
     * @return
     */
    List<Carinfo> getAllCarinfo();

    int deleteByPrimaryKey(String cId);

    int insert(Carinfo record);

    int insertSelective(Carinfo record);

    Carinfo selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Carinfo record);

    int updateByPrimaryKey(Carinfo record);
}