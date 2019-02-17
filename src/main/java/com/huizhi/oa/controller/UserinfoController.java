package com.huizhi.oa.controller;

import com.huizhi.oa.entity.Userinfo;
import com.huizhi.oa.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * created by dwtuitfk on 2019/2/17.
 */
@ResponseBody
@Controller
@RequestMapping("/")
public class UserinfoController {

    @Autowired
    private UserinfoService userinfoService;


    @RequestMapping("userinfo")
    public List<Userinfo> userinfo(){
        List<Userinfo> list = userinfoService.getAllUserinfo();
        return list;
    }

}
