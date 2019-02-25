package com.huizhi.oa.controller.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.UserRoleDep;
import com.huizhi.oa.entity.Userinfo;
import com.huizhi.oa.service.UserinfoService;
import com.huizhi.oa.util.ResultMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
public class UserRoleController {

        @Autowired
        private UserinfoService userinfoService;

        @RequiresPermissions("/userRole")//权限管理;
        @RequestMapping("/userRole")
        public String userRole() {
            return "pages/userTree/userRole";
        }

        //职位变更数据分页显示
        @ResponseBody
        @RequestMapping("selectUserRoleALL")
        public ResultMap<List<UserRoleDep>> getallUserRole(Integer page, Integer limit) throws Exception {
            PageHelper.startPage(page==null?1:page, limit);
            List<UserRoleDep> list=userinfoService.getAllUserinfo();
            PageInfo<UserRoleDep> pageinfo=new PageInfo<>(list);
            return new ResultMap<List<UserRoleDep>>("",list,0,(int)pageinfo.getTotal());
        }

    }

