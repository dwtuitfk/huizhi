package com.huizhi.oa.service.impl;

import com.huizhi.oa.dao.JurinfoMapper;
import com.huizhi.oa.entity.Jurinfo;
import com.huizhi.oa.service.JurinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by dwtuitfk on 2019/2/17.
 */
@Service
public class JurinfoServiceImpl implements JurinfoService {

    @Autowired
    private JurinfoMapper jurinfoMapper;


    @Override
    public int deleteByPrimaryKey(Integer jurid) {
        return jurinfoMapper.deleteByPrimaryKey(jurid);
    }

    @Override
    public int insert(Jurinfo record) {
        return jurinfoMapper.insert(record);
    }

    @Override
    public int insertSelective(Jurinfo record) {
        return jurinfoMapper.insertSelective(record);
    }

    @Override
    public Jurinfo selectByPrimaryKey(Integer jurid) {
        return jurinfoMapper.selectByPrimaryKey(jurid);
    }

    @Override
    public int updateByPrimaryKeySelective(Jurinfo record) {
        return jurinfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Jurinfo record) {
        return jurinfoMapper.updateByPrimaryKey(record);
    }
}
