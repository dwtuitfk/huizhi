package com.huizhi.oa.dao;

import com.huizhi.oa.entity.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}