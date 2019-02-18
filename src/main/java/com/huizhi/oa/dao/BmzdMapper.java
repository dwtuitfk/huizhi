package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Bmzd;

import java.util.List;

public interface BmzdMapper {
    int insert(Bmzd record);

    int insertSelective(Bmzd record);

    List<Bmzd>getAllBmzd();

    int updateBmzd(Bmzd record);

    Bmzd getBmzd(int bmzdid);

    int delMoreBmzd(List<Integer> ids);
}