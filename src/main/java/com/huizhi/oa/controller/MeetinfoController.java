/**
 * System Name： SDN Platform
 * <p>
 * File Name： MeetinfoController
 * <p>
 * Creating Time： 2019-02-17 18:09
 * <p>
 * Copyright (c) 2015-2025 Fiberhome Technologies.
 * 88,YouKeYuan Road, Hongshan District.,Wuhan,P.R.China,
 * Wuhan Research Institute of Post & Telecommunication.
 * <p>
 * All rights reserved.
 */

package com.huizhi.oa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Houseapplyinfo;
import com.huizhi.oa.entity.Meetinfo;
import com.huizhi.oa.service.MeetinfoService;
import com.huizhi.oa.util.LayUIResult;
import com.huizhi.oa.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Function Description:  <br>
 * Writer: Administrator . <br>
 * Creating Time: 2019-02-17 18:09 <br>
 * Version:  <br>
 */

@Controller
@RequestMapping("/meeting")
public class MeetinfoController {

    @Autowired
    private MeetinfoService meetinfoService;

    /**
     * 显示会议记录页面
     * @return
     */
    @RequestMapping("/meetinfoShowPage")
    public String show() {
        return "pages/meetingTree/meetinfo/show";
    }

    /**
     * 添加会议记录页面
     * @return
     */
    @RequestMapping("/meetinfoAddPage")
    public String add(){
        return "pages/meetingTree/meetinfo/add";
    }

    /**
     * 删除会议记录
     * @return
     */
    @RequestMapping("/meetinfoDelPage")
    public String del(){
        return "pages/meetingTree/meetinfo/del";
    }
    /**
     * 更新会议记录页面
     * @return
     */
    @RequestMapping("/meetinfoUpdatePage")
    public String update(){
        return "pages/meetingTree/meetinfo/update";
    }

    /**
     * 查询所有会议记录
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllMeetinfo")
    public ResultMap<List<Meetinfo>> getAllMeetinfo(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Meetinfo> list=meetinfoService.getAllMeetinfo();
        PageInfo<Meetinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Meetinfo>>("",list,0,(int)pageinfo.getTotal());
    }
    /*public Object getAllMeetinfo(@RequestParam("page") Integer pageNum, @RequestParam("limit") Integer pageSize){
        PageInfo<Meetinfo> list = meetinfoService.getAllMeetinfo(pageNum,pageSize);
        int count = (int) list.getTotal();
        LayUIResult result = LayUIResult.build(0, "", list); // 这个是我返回的数据格式，可以可以自己定义
        result.setCount(count); // 尾部以把该封装类贴出来
        return result;
    }*/

    /**
     * 查询单条会议记录
     * @return
     */
    @ResponseBody
    @RequestMapping("/getMeetinfo")
    public Meetinfo getMeetinfo(){
        int id = 1;
        return meetinfoService.selectByPrimaryKey(id);
    }

    /**
     * 添加会议记录
     * @param meetinfo
     * @return
     */
    @RequestMapping("/meetinfoAdd")
    public String addMeetinfo(Meetinfo meetinfo){
        int tmp = -1;
        tmp = meetinfoService.insertSelective(meetinfo);
        return "getAllMeetinfo";
    }

    /**
     * 更新会议记录
     * @param record
     * @return
     */
    @RequestMapping("/meetinfoUpdate")
    public String updateMeetinfo(Meetinfo record){
        int tmp = -1;
        tmp = meetinfoService.updateByPrimaryKeySelective(record);
        return "getAllMeetinfo";
    }

    /**
     * 删除会议记录
     * @param mId
     * @return
     */
    @RequestMapping("/meetinfoDel")
    public String delMeetinfo(Integer mId){
        int tmp = -1;
        tmp = meetinfoService.deleteByPrimaryKey(mId);
        return "getAllMeetinfo";
    }

}