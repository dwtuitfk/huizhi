package com.huizhi.oa.controller.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.UserJur;
import com.huizhi.oa.entity.Userinfo;
import com.huizhi.oa.service.UserinfoService;
import com.huizhi.oa.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * created by dwtuitfk on 2019/2/19.
 */
@Controller
@RequestMapping("/system")
public class UserJurController {

    @Autowired
    private UserinfoService userinfoService;

    @RequestMapping("/userJur")
    public String userRole() {
        return "pages/userTree/userJur";
    }

    //权限配置数据分页显示
    @ResponseBody
    @RequestMapping("selectUserJurALL")
    public ResultMap<List<UserJur>> getallUserRole(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<UserJur> list=userinfoService.getUserJurInfo();
        PageInfo<UserJur> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<UserJur>>("",list,0,(int)pageinfo.getTotal());
    }
}
