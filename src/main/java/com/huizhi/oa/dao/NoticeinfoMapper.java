package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Noticeinfo;
import com.huizhi.oa.entity.Userinfo;

import java.util.List;

public interface NoticeinfoMapper {
    int deleteByPrimaryKey(Integer nId);

    int insert(Noticeinfo record);

    int insertSelective(Noticeinfo record);

    Noticeinfo selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(Noticeinfo record);

    int updateByPrimaryKey(Noticeinfo record);

    //查询所有公告信息
    List<Noticeinfo> getAllNoticeinfo();

    //查询所有用户信息
    List<Userinfo> getAllUserid();
}