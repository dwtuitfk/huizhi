package com.huizhi.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by dwtuitfk on 2019/2/15.
 */
@Controller
@RequestMapping("/")
public class layUI {
    @RequestMapping("login")
    private String login(){
        return "login";
    }

    @RequestMapping("index")
    private String index(){
        return "index";
    }

    @RequestMapping("welcome")
    private String welcome(){
        return "pages/welcome";
    }

    /*@RequestMapping("pages/{page}")
    private String showPage(@PathVariable("page") String page){
        return "/pages/"+page;
    }*/
}
