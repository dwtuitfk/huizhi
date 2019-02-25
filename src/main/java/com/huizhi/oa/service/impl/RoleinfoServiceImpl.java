package com.huizhi.oa.service.impl;

import com.huizhi.oa.dao.RoleinfoMapper;
import com.huizhi.oa.entity.Roleinfo;
import com.huizhi.oa.service.RoleinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * created by dwtuitfk on 2019/2/17.
 */
@Service
@Transactional
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

    @Transactional(propagation= Propagation.NOT_SUPPORTED)
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

    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    @Override
    public List<Roleinfo> getAllRoleinfo() {
        return roleinfoMapper.getAllRoleinfo();
    }

    @Override
    public Roleinfo getRoleinfo(Integer roleid) {
        return roleinfoMapper.getRoleinfo(roleid);
    }

    @Override
    public List<Roleinfo> getAllRoleid(Integer rolename) {
        return roleinfoMapper.getAllRoleid(rolename);
    }
}
