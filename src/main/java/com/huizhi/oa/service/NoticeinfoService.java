package com.huizhi.oa.service;

import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Noticeinfo;

import java.util.List;

public interface NoticeinfoService {
    int deleteByPrimaryKey(Integer nId);

    int insert(Noticeinfo record);

    int insertSelective(Noticeinfo record);

    Noticeinfo selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(Noticeinfo record);

    int updateByPrimaryKey(Noticeinfo record);

    //查询所有公告信息
    List<Noticeinfo> getAllNoticeinfo();

    //LayUI分页显示
//    PageInfo<Noticeinfo> selectNoticeinfoALL(Integer pageNum, Integer pageSize);

}