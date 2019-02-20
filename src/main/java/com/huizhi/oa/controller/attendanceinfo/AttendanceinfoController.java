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
@RequestMapping("/attendanceinfo")
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
    public ResultMap<List<Attendanceinfo>> getAllAttendanceinfo(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Attendanceinfo> list = attendanceinfoService.selectGetAll();
        PageInfo<Attendanceinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Attendanceinfo>>("",list,0,(int)pageinfo.getTotal());
    }


    public List<Attendanceinfo> getAllAttendanceinfo() throws Exception {
        List<Attendanceinfo> list = attendanceinfoService.selectAttendanceinfo();
        return list;
    }



    @RequestMapping("/add")
    public int addAttendanceinfo(Attendanceinfo attendanceinfo) throws Exception {
        Date dt = new Date();
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        attendanceinfo.setUserid(123);
        System.out.println(dt);

        attendanceinfo.setaAtime(dt);
       // attendanceinfo.setaId(15);
       // attendanceinfo.setaAtime(sdf.format(dt));
        int temp = attendanceinfoService.insertSelective(attendanceinfo);
        return temp;
    }

    @RequestMapping("/update")
    public int updateAttendanceinfo(Attendanceinfo attendanceinfo) throws Exception {
        attendanceinfo.setaId(1);
        attendanceinfo.setUserid(122);
       int temp = attendanceinfoService.updateByPrimaryKeySelective(attendanceinfo);
       return temp;
    }





}
