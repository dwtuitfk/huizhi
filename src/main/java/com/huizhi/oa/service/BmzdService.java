package com.huizhi.oa.service;

import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Bmzd;

import java.util.List;

public interface BmzdService {
    int insert(Bmzd record);

    int insertSelective(Bmzd record);

    List<Bmzd> getAllBmzd();

    PageInfo<Bmzd> selectBmzdALL(Integer pageNum, Integer pageSize);

    int updateBmzd(Bmzd record);

    Bmzd getBmzd(int bmzdid);

    int delMoreBmzd(List<Integer> ids);
}