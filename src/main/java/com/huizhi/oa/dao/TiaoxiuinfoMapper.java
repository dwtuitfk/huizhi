package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Tiaoxiuinfo;

public interface TiaoxiuinfoMapper {
    int deleteByPrimaryKey(Integer txId);

    int insert(Tiaoxiuinfo record);

    int insertSelective(Tiaoxiuinfo record);

    Tiaoxiuinfo selectByPrimaryKey(Integer txId);

    int updateByPrimaryKeySelective(Tiaoxiuinfo record);

    int updateByPrimaryKey(Tiaoxiuinfo record);
}