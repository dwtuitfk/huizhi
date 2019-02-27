package com.huizhi.oa.controller.personal;

import com.huizhi.oa.entity.Userinfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@RequiresPermissions("/personal")//权限管理;
@Controller
@RequestMapping("/personal")
public class PageController {

    @RequestMapping("/{page}")
    public String showPage(@PathVariable("page") String page, Model model){
        Userinfo userinfo = (Userinfo) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("userinfo",userinfo);
        return "pages/personalTree/"+page;
    }
}
