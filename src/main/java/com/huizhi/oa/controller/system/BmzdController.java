package com.huizhi.oa.controller.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Bmzd;
import com.huizhi.oa.service.BmzdService;
import com.huizhi.oa.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * created by dwtuitfk on 2019/2/17.
 */
@Controller
@RequestMapping("/system")
public class BmzdController {

    @Autowired
    private BmzdService bmzdService;

    //部门管理显示入口
    @RequestMapping("/dep")
    public String dep() {
        return "pages/systemTree/department";
    }

    //部门管理数据分页显示
    @ResponseBody
    @RequestMapping("selectBmzdALL")
    public ResultMap<List<Bmzd>> getalldep(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Bmzd> list=bmzdService.getAllBmzd();
        PageInfo<Bmzd> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Bmzd>>("",list,0,(int)pageinfo.getTotal());
    }

    //部门添加
    @RequestMapping("/depAdd")
    public String depAdd() {
        return "pages/systemTree/depAdd";
    }

    @RequestMapping("/depAddInfo")
    @ResponseBody
    public String depAddinfo(Integer depname,String depnamemc) {
        System.out.println(depname+depnamemc);
        Bmzd bmzd=new Bmzd();
        bmzd.setDepname(depname);
        bmzd.setDepnamemc(depnamemc);
        int temp=bmzdService.insertSelective(bmzd);
        if (temp>0)
            return "400";
        else
            return "500";
    }


    public Integer bmzdid2;

    //部门修改
    @RequestMapping("/depUpdata")
    public String depUpdate(Integer bmzdid) {
        bmzdid2=bmzdid;
        System.out.println("------------");
        System.out.println("控制得到：");
        System.out.println(bmzdid2);
        return "pages/systemTree/depUpdata";
    }



    //查询单条部门记录
    @RequestMapping("getDep")
    @ResponseBody
    public Bmzd getDep(){
        System.out.println("------------");
        System.out.println("ajax得到：");
        System.out.println(bmzdid2);
        Bmzd bmzd = bmzdService.getBmzd(bmzdid2);
        return bmzd;
    }


    @RequestMapping("/depUpdateInfo")
    @ResponseBody
    public String depUpdateInfo(Integer bmzdid,Integer depname,String depnamemc) {
        System.out.println(bmzdid+depname+depnamemc);
        Bmzd bmzd=new Bmzd();
        bmzd.setBmzdid(bmzdid);
        bmzd.setDepname(depname);
        bmzd.setDepnamemc(depnamemc);
        int temp=bmzdService.updateBmzd(bmzd);
        if (temp>0)
            return "400";
        else
            return "500";
    }

    //部门删除
    @RequestMapping("delDep")
    @ResponseBody
    public String delDep(String ids) {
        List<Integer> id=null;
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
        int temp=bmzdService.delMoreBmzd(id);
        if (temp>0)
            return "400";
        else
            return "500";
    }
}
