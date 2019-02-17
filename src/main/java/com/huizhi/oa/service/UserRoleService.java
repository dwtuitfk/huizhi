package com.huizhi.oa.service;

import com.huizhi.oa.entity.UserRole;

public interface UserRoleService {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}