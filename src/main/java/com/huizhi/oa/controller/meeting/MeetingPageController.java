package com.huizhi.oa.controller.meeting;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Function Description:  <br>
 * Writer: Administrator . <br>
 * Creating Time: 2019-02-23 16:09 <br>
 * Version:  <br>
 */
@Controller
@RequestMapping("/meeting")
public class MeetingPageController {
    /**
     * 会议记录控制页面
     * @param page
     * @return
     */
    @RequiresPermissions("/houseapplyinfo")//权限管理;
    @RequestMapping("/houseapplyinfo/{page}")
    public String houseapplyinfoShow(@PathVariable("page") String page){
        return "pages/meetingTree/houseapplyinfo/"+page;
    }

    /**
     * 会议室控制页面
     * @param page
     * @return
     */
    @RequiresPermissions("/meethouse")//权限管理;
    @RequestMapping("/meethouse/{page}")
    public String meethouseShow(@PathVariable("page") String page){
        return "pages/meetingTree/meethouse/"+page;

    }

    /**
     * 会议记录控制页面
     * @param page
     * @return
     */
    @RequiresPermissions("/meetinfo")//权限管理;
    @RequestMapping("/meetinfo/{page}")
    public String meetinfoShow(@PathVariable("page") String page){
        return "pages/meetingTree/meetinfo/"+page;

    }
}