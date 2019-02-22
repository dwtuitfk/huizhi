package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Tiaoxiuinfo;

import java.util.List;

public interface TiaoxiuinfoMapper {
    int deleteByPrimaryKey(Integer txId);

    int insert(Tiaoxiuinfo record);

    int insertSelective(Tiaoxiuinfo record);

    Tiaoxiuinfo selectByPrimaryKey(Integer txId);

    //<select id="selectGetAll">
    List<Tiaoxiuinfo> selectGetAll();

    //<select id="selectTiaoxiuinfo"
    List<Tiaoxiuinfo> selectTiaoxiuinfo(Tiaoxiuinfo tiaoxiuinfo);

    int updateByPrimaryKeySelective(Tiaoxiuinfo record);

    int updateByPrimaryKey(Tiaoxiuinfo record);
}