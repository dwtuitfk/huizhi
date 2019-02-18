package com.huizhi.oa.controller;

import com.huizhi.oa.service.EmailinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EmailInfoController {
    @Autowired
    private EmailinfoService emailinfoService;

    @RequestMapping("email")
    public String page(){
        System.out.print("1111");
        return "pages/personalTree/email";
    }
}
