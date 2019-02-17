package com.huizhi.oa.controller;

import com.huizhi.oa.entity.Noticeinfo;
import com.huizhi.oa.service.NoticeinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *郭恩
 */

@RestController
@RequestMapping("/")
public class NoticeinfoController {

    @Autowired
    private NoticeinfoService noticeinfoService;

    @RequestMapping("noticeinfo")
    public List<Noticeinfo> getAllNoticeinfo(){
        List<Noticeinfo> list =noticeinfoService.getAllNoticeinfo();
        return list;
    }
}
