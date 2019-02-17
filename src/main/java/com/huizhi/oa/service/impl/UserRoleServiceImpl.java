package com.huizhi.oa.service.impl;

import com.huizhi.oa.dao.UserRoleMapper;
import com.huizhi.oa.entity.UserRole;
import com.huizhi.oa.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by dwtuitfk on 2019/2/17.
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;


    @Override
    public int insert(UserRole record) {
        return userRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(UserRole record) {
        return userRoleMapper.insertSelective(record);
    }
}
