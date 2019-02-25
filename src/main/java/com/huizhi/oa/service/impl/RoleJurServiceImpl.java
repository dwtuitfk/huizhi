package com.huizhi.oa.service.impl;

import com.huizhi.oa.dao.RoleJurMapper;
import com.huizhi.oa.entity.RoleJur;
import com.huizhi.oa.service.RoleJurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * created by dwtuitfk on 2019/2/17.
 */
@Service
@Transactional
public class RoleJurServiceImpl implements RoleJurService {

    @Autowired
    private RoleJurMapper roleJurMapper;


    @Override
    public int insert(RoleJur record) {
        return roleJurMapper.insert(record);
    }

    @Override
    public int insertSelective(RoleJur record) {
        return roleJurMapper.insertSelective(record);
    }

    @Override
    public List<RoleJur> getJurinfo(Integer roleid) {
        return roleJurMapper.getJurinfo(roleid);
    }

    @Override
    public int DelRolejur(Integer roleid) {
        return roleJurMapper.DelRolejur(roleid);
    }
}
