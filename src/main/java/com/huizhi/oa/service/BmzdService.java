package com.huizhi.oa.service;

import com.huizhi.oa.entity.Bmzd;

public interface BmzdService {
    int insert(Bmzd record);

    int insertSelective(Bmzd record);
}