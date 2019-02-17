package com.huizhi.oa.service;

import com.huizhi.oa.entity.Bmzd;

import java.util.List;

public interface BmzdService {
    int insert(Bmzd record);

    int insertSelective(Bmzd record);

    List<Bmzd> getAllBmzd();
}