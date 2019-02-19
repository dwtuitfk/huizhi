package com.huizhi.oa.controller.personal;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Bmzd;
import com.huizhi.oa.entity.Userinfo;
import com.huizhi.oa.service.BmzdService;
import com.huizhi.oa.service.UserinfoService;
import com.huizhi.oa.util.LayUIResult;
import com.huizhi.oa.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ContactsController {
    @Autowired
    private UserinfoService userinfoService;

    @ResponseBody
    @RequestMapping("getAllContacts")
    /*http://localhost:8080/getAllContacts?page=1&limit=10测试成功*/
    /*获取了所有人员信息*/
    public ResultMap<List<Userinfo>> getAllContacts(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Userinfo> list=userinfoService.getAllUserinfo();
        PageInfo<Userinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Userinfo>>("",list,0,(int)pageinfo.getTotal());
    }


    @Autowired
    private BmzdService bmzdService;
    /*http://localhost:8080/getAllEmp?page=1&limit=10测试成功*/
    /*获取了所有部门信息*/
    @ResponseBody
    @RequestMapping("getAllEmp")
    public ResultMap<List<Bmzd>> getalldep(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Bmzd> list=bmzdService.getAllBmzd();
        PageInfo<Bmzd> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Bmzd>>("",list,0,(int)pageinfo.getTotal());
    }
}
