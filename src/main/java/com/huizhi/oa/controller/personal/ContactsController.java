package com.huizhi.oa.controller.personal;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Bmzd;
import com.huizhi.oa.entity.UserRoleDep;
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
@RequestMapping("/")
public class ContactsController {
    @Autowired
    private UserinfoService userinfoService;

    @ResponseBody
    @RequestMapping("getAllContacts")
    public ResultMap<List<UserRoleDep>> getAllContacts(Integer page, Integer limit, String userid,String turename,String qq,String address,String sex,String depName,String roleName) throws Exception {
        PageHelper.startPage(page == null ? 1 : page, limit);
        List<UserRoleDep> list=null;
        UserRoleDep userRoleDep = new UserRoleDep();
        if (userid==null&&turename==null&&qq==null&&sex==null&&depName==null&&roleName==null&&address==null){

            list=userinfoService.seachContacts(userRoleDep);
            PageInfo<UserRoleDep> pageinfo = new PageInfo<>(list);
            return new ResultMap<List<UserRoleDep>>("", list, 0, (int) pageinfo.getTotal());

        }else {
            if (!userid.equals("")){
                if(this.isDigit(userid))
                    userRoleDep.setUserid(Integer.parseInt(userid));
            }
            if (!turename.equals(""))
                userRoleDep.setTurename(turename);
            if (!qq.equals(""))
                userRoleDep.setQq(qq);
            if (!address.equals(""))
                userRoleDep.setAddress(address);
            if (!sex.equals(""))
                userRoleDep.setSex(sex);

            if (!depName.equals(""))
                if(this.isDigit(depName)) {
                    userRoleDep.setDepName(Integer.parseInt(depName));
                }

            if (!roleName.equals(""))
                if(this.isDigit(roleName)){
                    userRoleDep.setRoleName(Integer.parseInt(roleName));
                }


        }
        list=userinfoService.seachContacts(userRoleDep);
        PageInfo<UserRoleDep> pageinfo = new PageInfo<>(list);
        return new ResultMap<List<UserRoleDep>>("", list, 0, (int) pageinfo.getTotal());

    }



    public boolean isDigit(String strNum) {
        return strNum.matches("[0-9]{1,}");
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
