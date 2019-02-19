package com.huizhi.oa.controller.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Bmzd;
import com.huizhi.oa.entity.Userinfo;
import com.huizhi.oa.service.UserinfoService;
import com.huizhi.oa.util.LayUIResult;
import com.huizhi.oa.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * created by dwtuitfk on 2019/2/17.
 */

@Controller
@RequestMapping("/system")
public class UserinfoController {

    @Autowired
    private UserinfoService userinfoService;

    @RequestMapping("/user")
    public String user() {
        return "pages/userTree/userinfo";
    }

    //档案管理数据分页显示
    @ResponseBody
    @RequestMapping("selectUserinfoALL")
    public ResultMap<List<Userinfo>> getalldep(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Userinfo> list=userinfoService.getAllUserinfo();
        PageInfo<Userinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Userinfo>>("",list,0,(int)pageinfo.getTotal());
    }
}
