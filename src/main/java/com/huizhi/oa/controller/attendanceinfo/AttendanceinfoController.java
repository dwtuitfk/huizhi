package com.huizhi.oa.controller.attendanceinfo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Attendanceinfo;
import com.huizhi.oa.service.AttendanceinfoService;
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
@RequestMapping("/kaoqin/attendanceinfo")
public class AttendanceinfoController {
    @Autowired
    private AttendanceinfoService attendanceinfoService;

    //@ResponseBody
    @RequiresPermissions("/attendance")//权限管理;
    @RequestMapping("/attendance")
    public String showAttendance() {
       // return "kdjflajladl";
        return "pages/attendanceTree/dateAttendanceinfo";
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


    @ResponseBody
    @RequestMapping("/searchAttendanceinfo")
    public ResultMap<List<Attendanceinfo>> searchAttendanceinfo(Attendanceinfo attendanceinfo, Integer page, Integer limit, String userid,String tureName,String oneMonth,String oneDate) throws Exception {
        PageHelper.startPage(page == null ? 1 : page, limit);
        List<Attendanceinfo> list = null;
        System.out.println(userid);
        System.out.println(tureName);
        System.out.println(oneMonth);
        System.out.println(oneDate);
        if(userid == null&& tureName == null && oneDate==null && oneMonth==null){
            list = attendanceinfoService.searchSelect(attendanceinfo);
            list = attendanceinfoService.searchSelect(attendanceinfo);

            for (Attendanceinfo att:list) {
                Date date = new Date();
                System.out.println(att.getaMtime());
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String mtimeTemp = sdf.format(att.getaMtime());
                String atimeTemp = sdf.format(att.getaAtime());
                if(mtimeTemp.compareTo("09:00:00")>0){
                    att.setMtimeRemarkes("迟到");
                }else{
                    att.setMtimeRemarkes("正常上班");
                }
                if(atimeTemp.compareTo("17:30:00")<0){
                    att.setAtimeRemarkes("早退");
                }else{
                    att.setAtimeRemarkes("正常下班");
                }
                System.out.println(att.getMtimeRemarkes());
                System.out.println(att.getAtimeRemarkes());
            }

            PageInfo<Attendanceinfo> pageinfo=new PageInfo<>(list);
            return new ResultMap<List<Attendanceinfo>>("",list,0,(int)pageinfo.getTotal());
        }else{
            if (!userid.equals("")){
                attendanceinfo.setUserid(Integer.parseInt(userid));
            }

            if(!tureName.equals("")){
                attendanceinfo.setTureName(tureName);
            }

            if(!oneMonth.equals("")){
                attendanceinfo.setSelectTime(oneMonth);
                System.out.println(attendanceinfo.getSelectTime());
                if(!oneDate.equals("")){
                    attendanceinfo.setSelectTime(oneDate);
                }
                System.out.println(attendanceinfo.getSelectTime());
            }

            list = attendanceinfoService.searchSelect(attendanceinfo);
            for (Attendanceinfo att:list) {
                Date date = new Date();
                System.out.println(att.getaMtime());
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String mtimeTemp = sdf.format(att.getaMtime());
                String atimeTemp = sdf.format(att.getaAtime());
                if(mtimeTemp.compareTo("09:00:00")>0){
                    att.setMtimeRemarkes("迟到");
                }else{
                    att.setMtimeRemarkes("正常上班");
                }
                if(atimeTemp.compareTo("17:30:00")<0){
                    att.setAtimeRemarkes("早退");
                }else{
                    att.setAtimeRemarkes("正常下班");
                }
                System.out.println(att.getMtimeRemarkes());
                System.out.println(att.getAtimeRemarkes());
            }

            PageInfo<Attendanceinfo> pageinfo=new PageInfo<>(list);
            return new ResultMap<List<Attendanceinfo>>("",list,0,(int)pageinfo.getTotal());
        }


    }





}
