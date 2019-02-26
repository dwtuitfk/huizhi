package com.huizhi.oa.service;

import com.huizhi.oa.entity.Carinfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarinfoService {
    int deleteByPrimaryKey(String cId);

    int insert(Carinfo record);

    int insertSelective(Carinfo record);

    Carinfo selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Carinfo record);

    int updateByPrimaryKey(Carinfo record);

    /*
    显示所有车辆信息
     */
    List<Carinfo>  getAllCarinfo();

    /**
     * 删去更多
     * @param ids
     * @return
     */
    int delMoreCar(List<String> ids);

    /**
     * 高级搜索信息
     * @return
     */
    List<Carinfo> seachCarinfo(Carinfo c);
}