package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Noticeinfo;

public interface NoticeinfoMapper {
    int deleteByPrimaryKey(Integer nId);

    int insert(Noticeinfo record);

    int insertSelective(Noticeinfo record);

    Noticeinfo selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(Noticeinfo record);

    int updateByPrimaryKey(Noticeinfo record);
}