package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Userzd;

import java.util.List;

public interface UserzdMapper {
    int insert(Userzd record);

    int insertSelective(Userzd record);

    List<Userzd> getAllUserzd();

    int updateUserzd(Userzd record);

    Userzd getUserzd(int userzdid);

    int delMoreUserzd(List<Integer> ids);
}