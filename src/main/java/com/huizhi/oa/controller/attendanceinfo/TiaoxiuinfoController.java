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

import java.text.ParsePosition;
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
        Date tempDate = new Date();
        if(tureName==null && userid==null && oneDate==null){
            List<Tiaoxiuinfo> list = tiaoxiuinfoService.searchTiaoxiuinfo(tiaoxiuinfo);

            for (Tiaoxiuinfo tiao:list) {
                //tempDate = tiao.getTxOvertime()-tiao.getTxStarttime();

                System.out.println("开始时间："+tiao.getTxStarttime());
                System.out.println("结束时间："+tiao.getTxOvertime());
                String mtimeTemp = sdf.format(tiao.getTxStarttime());
                String atimeTemp = sdf.format(tiao.getTxOvertime());
//                long time1 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(mtimeTemp, new ParsePosition(0)).getTime();
//                long time2 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(atimeTemp, new ParsePosition(0)).getTime();
//                long time = time2-time1;
//                String format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
//                Date date = new Date(sdf.parse(atimeTemp).getTime()-sdf.parse(mtimeTemp).getTime());

//                System.out.println(sdf.format(format2));
            }
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
            for (Tiaoxiuinfo tiao:list) {
                //tempDate = tiao.getTxOvertime()-tiao.getTxStarttime();
                Date date = new Date(String.valueOf(tiao.getTxStarttime()));
                Date date2 = new Date(String.valueOf(tiao.getTxOvertime()));
                System.out.println("开始时间："+tiao.getTxStarttime());
                System.out.println(date);

                System.out.println("结束时间："+tiao.getTxOvertime());
                System.out.println(date2);

                //System.out.println("结束时间："+tiao.getTxOvertime()-tiao.getTxStarttime());
            }
            System.out.println(list);
            PageInfo<Tiaoxiuinfo> pageinfo=new PageInfo<>(list);
            return new ResultMap<List<Tiaoxiuinfo>>("",list,0,(int)pageinfo.getTotal());
        }

    }


}
