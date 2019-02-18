package com.huizhi.oa.controller.personal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personal")
public class PageController {
    @RequestMapping("/{page}")
    public String showPage(@PathVariable("page") String page){
        return "pages/personalTree/"+page;
    }
}
