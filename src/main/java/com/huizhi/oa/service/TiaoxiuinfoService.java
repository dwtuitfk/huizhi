package com.huizhi.oa.service;

import com.huizhi.oa.entity.Tiaoxiuinfo;

import java.util.List;

public interface TiaoxiuinfoService {
    int deleteByPrimaryKey(Integer txId);

    int insert(Tiaoxiuinfo record);

    int insertSelective(Tiaoxiuinfo record);

    Tiaoxiuinfo selectByPrimaryKey(Integer txId);

    List<Tiaoxiuinfo> selectGetAll();

    List<Tiaoxiuinfo> selectTiaoxiuinfo(Tiaoxiuinfo tiaoxiuinfo);

    int updateByPrimaryKeySelective(Tiaoxiuinfo record);

    int updateByPrimaryKey(Tiaoxiuinfo record);

    /**
     * 索引查询
     * @param tiaoxiuinfo
     * @return
     */
    List<Tiaoxiuinfo> searchTiaoxiuinfo(Tiaoxiuinfo tiaoxiuinfo);
}