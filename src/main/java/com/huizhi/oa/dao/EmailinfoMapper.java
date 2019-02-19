package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Emailinfo;

import java.util.List;

public interface EmailinfoMapper {
    int deleteByPrimaryKey(String eId);

    int insert(Emailinfo record);

    int insertSelective(Emailinfo record);

    Emailinfo selectByPrimaryKey(String eId);

    int updateByPrimaryKeySelective(Emailinfo record);

    int updateByPrimaryKey(Emailinfo record);

    /**
     * 获取所有邮件
     * @return
     */
    List<Emailinfo> getAllEmailInfo();
}