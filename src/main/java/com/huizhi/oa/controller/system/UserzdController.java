package com.huizhi.oa.controller.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Userzd;
import com.huizhi.oa.service.UserzdService;
import com.huizhi.oa.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * created by dwtuitfk on 2019/2/18.
 */
@Controller
@RequestMapping("/system")
public class UserzdController {

    @Autowired
    private UserzdService userzdService;
    //岗位管理显示入口
    @RequestMapping("/post")
    public String post() {
        return "pages/systemTree/post";
    }

    //岗位信息数据分页显示
    @ResponseBody
    @RequestMapping("selectUserzdALL")
    public ResultMap<List<Userzd>> getalldep(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Userzd> list=userzdService.getAllUserzd();
        PageInfo<Userzd> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Userzd>>("",list,0,(int)pageinfo.getTotal());
    }
    public Integer userzdid2;

    //岗位修改
    @RequestMapping("/postUpdate")
    public String postUpdate(Integer userzdid) {
        userzdid2=userzdid;
        System.out.println("------------");
        System.out.println("控制得到：");
        System.out.println(userzdid2);
        return "pages/systemTree/postUpdata";
    }



    //查询单条岗位记录
    @RequestMapping("getPost")
    @ResponseBody
    public Userzd getDep(){
        System.out.println("------------");
        System.out.println("ajax得到：");
        System.out.println(userzdid2);
        Userzd userzd = userzdService.getUserzd(userzdid2);
        return userzd;
    }

    //岗位修改
    @RequestMapping("/postUpdateInfo")
    @ResponseBody
    public String postUpdateInfo(Integer userzdid,Integer rolename,String rolenamemc) {
        System.out.println(userzdid+rolename+rolenamemc);
        Userzd userzd=new Userzd();
        userzd.setUserzdid(userzdid);
        userzd.setRolename(rolename);
        userzd.setRolenamemc(rolenamemc);
        int temp=userzdService.updateUserzd(userzd);
        if (temp>0)
            return "400";
        else
            return "500";
    }

    //岗位删除
    @RequestMapping("delPost")
    @ResponseBody
    public String delpost(String ids) {
        List<Integer> id = null;
        if(ids.contains(",")){
            String []arr=ids.split(",");
            id=new ArrayList<>();
            for (String a:arr) {
                id.add(Integer.parseInt(a));
            }
        }else{
            id=new ArrayList<>();
            id.add(Integer.parseInt(ids));
        }
        int temp= userzdService.delMoreUserzd(id);
        if (temp>0)
            return "400";
        else
            return "500";
    }
}

