package com.huizhi.oa.controller.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.*;
import com.huizhi.oa.service.JurinfoService;
import com.huizhi.oa.service.RoleJurService;
import com.huizhi.oa.service.RoleinfoService;
import com.huizhi.oa.service.UserinfoService;
import com.huizhi.oa.util.ResultMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.relation.Role;
import javax.management.relation.RoleInfo;
import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * created by dwtuitfk on 2019/2/19.
 */
@Controller
@RequestMapping("/system")
public class UserJurController {

    @Autowired
    private UserinfoService userinfoService;

    @Autowired
    private JurinfoService jurinfoService;

    @Autowired
    private RoleJurService roleJurService;

    @Autowired
    private RoleinfoService roleinfoService;

    @RequiresPermissions("/userJur")//权限管理;
    @RequestMapping("/userJur")
    public String userRole() {
        return "pages/systemTree/userJur";
    }

    //权限配置数据分页显示
    @ResponseBody
    @RequestMapping("selectUserJurALL")
    public ResultMap<List<Jurinfo>> getallUserRole(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Jurinfo> list=jurinfoService.getAllJurinfo();
        PageInfo<Jurinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Jurinfo>>("",list,0,(int)pageinfo.getTotal());
    }


    //查询所有权限
    @ResponseBody
    @RequestMapping("getALLJur")
    public List<Jurinfo> getAllJur(){
        List<Jurinfo> list = jurinfoService.getAllJurinfo();
        return list;
    }

    //添加权限
    @RequestMapping("/jurAdd")
    public String jurAdd() {
        return "pages/systemTree/jurAdd";
    }

    //添加权限信息
    @RequestMapping("/jurAddInfo")
    @ResponseBody
    public String jurAddInfo(Integer rolename, Integer [] jurid) {

        System.out.println("获取rolename"+rolename);
        //通过角色名称查询对应roleid
        List<Roleinfo> list = roleinfoService.getAllRoleid(rolename);
        //获取所有角色名称对应用户roleid

        int temp=0;

        for (Roleinfo r: list){

            int temp2= roleJurService.DelRolejur(r.getRoleid());
            System.out.println("删除："+temp2);
        }




        for(Integer j:jurid){

        for(Roleinfo roleinfo:list){

            System.out.println("获取的角色ID:"+roleinfo.getRoleid());
            System.out.println("获取的权限:"+j);
            RoleJur roleJur = new RoleJur();
            roleJur.setRoleid(roleinfo.getRoleid());
            roleJur.setJurid(j);
            temp =temp+roleJurService.insert(roleJur);
            System.out.println(temp);
        }



        }

        System.out.println("添加了"+temp+"记录");
       // temp=200;
      //  return "200";

       if (temp>0)
            return "400";
        else
            return "500";
    }



   //根据下拉列表角色名称查询对应的权限信息并进行回显
    @ResponseBody
    @RequestMapping("getAllJurid")
    public List<Jurinfo> getAllJurid(Integer rolename){
        List<Jurinfo> list = jurinfoService.getAllJurid(rolename);
        return list;
    }

}
