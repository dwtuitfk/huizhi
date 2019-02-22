package com.huizhi.oa.controller.attendanceinfo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Attendanceinfo;
import com.huizhi.oa.service.AttendanceinfoService;
import com.huizhi.oa.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/kaoqin/attendanceinfo")
public class AttendanceinfoController {
    @Autowired
    private AttendanceinfoService attendanceinfoService;

    //@ResponseBody
    @RequestMapping("/attendance")
    public String showAttendance() {
       // return "kdjflajladl";
        return "pages/attendanceTree/attendanceinfo";
    }

    @ResponseBody
    @RequestMapping("/getAll")
    public ResultMap<List<Attendanceinfo>> getAllAttendanceinfo(Integer page, Integer limit, Attendanceinfo attendanceinfo) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        // attendanceinfo.setUserid(122);
        List<Attendanceinfo> list = attendanceinfoService.selectGetAll();
        PageInfo<Attendanceinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Attendanceinfo>>("",list,0,(int)pageinfo.getTotal());
    }

    public List<Attendanceinfo> testSelectAttendance(){
        List<Attendanceinfo> list = attendanceinfoService.selectGetAll();
        return list;
    }





    @ResponseBody
    @RequestMapping("/add")
    public String addAttendanceinfo(Attendanceinfo attendanceinfo) throws Exception {
        Date dt = new Date();
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        attendanceinfo.setUserid(123);
        attendanceinfo.setaId(8);
        System.out.println(dt);

       attendanceinfo.setaAtime(dt);
       // attendanceinfo.setaId(15);
       // attendanceinfo.setaAtime(sdf.format(dt));
        int temp = attendanceinfoService.insertSelective(attendanceinfo);
        if (temp>0){
            return "添加成功";
        }else{
            return "添加失败";
        }

    }
    @ResponseBody
    @RequestMapping("/update")
    public String updateAttendanceinfo(Attendanceinfo attendanceinfo) throws Exception {
        attendanceinfo.setaId(2);
        attendanceinfo.setUserid(122);
       int temp = attendanceinfoService.updateByPrimaryKeySelective(attendanceinfo);
       if(temp>0){
           return "修改成功";

       }else{
           return "修改失败";
       }
    }


    @ResponseBody
    @RequestMapping("/addSelect")
    public List<Attendanceinfo> addSelect(Attendanceinfo attendanceinfo) throws Exception {
        attendanceinfo.setUserid(122);
        List<Attendanceinfo> list = attendanceinfoService.selectAttendanceinfo(attendanceinfo);
        return list;
    }





}
