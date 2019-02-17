package com.huizhi.oa.service;

import com.huizhi.oa.entity.Noticeinfo;

public interface NoticeinfoService {
    int deleteByPrimaryKey(Integer nId);

    int insert(Noticeinfo record);

    int insertSelective(Noticeinfo record);

    Noticeinfo selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(Noticeinfo record);

    int updateByPrimaryKey(Noticeinfo record);
}