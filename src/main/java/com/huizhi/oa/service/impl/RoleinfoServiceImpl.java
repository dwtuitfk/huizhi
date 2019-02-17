package com.huizhi.oa.service.impl;

import com.huizhi.oa.dao.RoleinfoMapper;
import com.huizhi.oa.entity.Roleinfo;
import com.huizhi.oa.service.RoleinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by dwtuitfk on 2019/2/17.
 */
@Service
public class RoleinfoServiceImpl implements RoleinfoService {

    @Autowired
    private RoleinfoMapper roleinfoMapper;


    @Override
    public int deleteByPrimaryKey(Integer roleid) {
        return roleinfoMapper.deleteByPrimaryKey(roleid);
    }

    @Override
    public int insert(Roleinfo record) {
        return roleinfoMapper.insert(record);
    }

    @Override
    public int insertSelective(Roleinfo record) {
        return roleinfoMapper.insertSelective(record);
    }

    @Override
    public Roleinfo selectByPrimaryKey(Integer roleid) {
        return roleinfoMapper.selectByPrimaryKey(roleid);
    }

    @Override
    public int updateByPrimaryKeySelective(Roleinfo record) {
        return roleinfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Roleinfo record) {
        return roleinfoMapper.updateByPrimaryKey(record);
    }
}
