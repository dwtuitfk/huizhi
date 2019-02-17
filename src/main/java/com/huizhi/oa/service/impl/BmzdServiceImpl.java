package com.huizhi.oa.service.impl;

import com.huizhi.oa.dao.BmzdMapper;
import com.huizhi.oa.entity.Bmzd;
import com.huizhi.oa.service.BmzdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by dwtuitfk on 2019/2/17.
 */
@Service
public class BmzdServiceImpl implements BmzdService {
    @Autowired
    protected BmzdMapper bmzdMapper;

    @Override
    public int insert(Bmzd record) {
        return bmzdMapper.insert(record);
    }

    @Override
    public int insertSelective(Bmzd record) {
        return bmzdMapper.insertSelective(record);
    }
}
