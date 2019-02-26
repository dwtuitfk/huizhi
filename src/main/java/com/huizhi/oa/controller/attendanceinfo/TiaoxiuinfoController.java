package com.huizhi.oa.controller.attendanceinfo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Tiaoxiuinfo;
import com.huizhi.oa.service.TiaoxiuinfoService;
import com.huizhi.oa.util.ResultMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/kaoqin/tiaoxiuinfo")
public class TiaoxiuinfoController {
    @Autowired
    private TiaoxiuinfoService tiaoxiuinfoService;

    @RequiresPermissions("/tiaoxiu")//权限管理;
    @RequestMapping("/tiaoxiu")
    public String dep() {
        return "pages/tiaoxiuinfoTree/searchTiaoxiuinfo";
    }

    @ResponseBody
    @RequestMapping("/selectInfo")
    public ResultMap<List<Tiaoxiuinfo>> getTiaoxiuinfo(Tiaoxiuinfo tiaoxiuinfo, Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Tiaoxiuinfo> list = tiaoxiuinfoService.selectGetAll();
        PageInfo<Tiaoxiuinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Tiaoxiuinfo>>("",list,0,(int)pageinfo.getTotal());
    }


    public List<Tiaoxiuinfo> getTiao(){
        List<Tiaoxiuinfo> list = tiaoxiuinfoService.selectGetAll();
        return list;
    }



    public List<Tiaoxiuinfo> getTiaoxiuinfo(Tiaoxiuinfo tiaoxiuinfo) throws Exception {
        //tiaoxiuinfo.setTxReason("%adwad%");
        List<Tiaoxiuinfo> list = tiaoxiuinfoService.selectTiaoxiuinfo(tiaoxiuinfo);
        return list;
    }


    @ResponseBody
    @RequestMapping("/searchTiaoxiuinfo")
    public ResultMap<List<Tiaoxiuinfo>> searchTiaoxiuinfo(Tiaoxiuinfo tiaoxiuinfo, Integer page, Integer limit, String tureName, String userid, String oneDate) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("天"+oneDate);
        System.out.println("用户id"+userid);

        System.out.println("名称"+tureName);


        if(tureName==null && userid==null && oneDate==null){
            List<Tiaoxiuinfo> list = tiaoxiuinfoService.searchTiaoxiuinfo(tiaoxiuinfo);
            PageInfo<Tiaoxiuinfo> pageinfo=new PageInfo<>(list);
            return new ResultMap<List<Tiaoxiuinfo>>("",list,0,(int)pageinfo.getTotal());
        }else{
            if(!tureName.equals("")){
                tiaoxiuinfo.setTureName(tureName);
            }



            if(!oneDate.equals("")){
                tiaoxiuinfo.setSelectTime(sdf.parse(oneDate));
            }
            System.out.println("调休时间"+tiaoxiuinfo.getSelectTime());

            if(!userid.equals("")){
                tiaoxiuinfo.setUserid(Integer.parseInt(userid));
            }

            List<Tiaoxiuinfo> list = tiaoxiuinfoService.searchTiaoxiuinfo(tiaoxiuinfo);
            System.out.println(list);
            PageInfo<Tiaoxiuinfo> pageinfo=new PageInfo<>(list);
            return new ResultMap<List<Tiaoxiuinfo>>("",list,0,(int)pageinfo.getTotal());
        }

    }


}
