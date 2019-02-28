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

    /**
     * 添加上班打卡时间
     * @param
     * @return
     * @throws Exception
     */

    @ResponseBody
    @RequestMapping("/addMtime")
    public String addMtime(String userid) throws Exception {
        System.out.println(userid);
        System.out.println("进入上班打卡");
        Date dt = new Date();
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Attendanceinfo attendanceinfo = new Attendanceinfo();
        attendanceinfo.setSelectTime(sdf.format(dt));
        attendanceinfo.setUserid(Integer.parseInt(userid));
//        attendanceinfo.setUserid(userid);
        System.out.println(attendanceinfo.getUserid());
        System.out.println(attendanceinfo.getSelectTime());
        List<Attendanceinfo> list = attendanceinfoService.selectAddTime(attendanceinfo);
        for (Attendanceinfo att:list) {
           // System.out.println(att.getTureName());
            System.out.println(att.getUserid());
        }
        if(list.size()>0){
            return "您已打卡";
        }else{
            System.out.println("准备上班打卡");
            attendanceinfo.setaMtime(dt);
            int temp = attendanceinfoService.insertSelective(attendanceinfo);
            if(temp>0){
                return "打卡成功，祝你工作愉快！";
            }else{
                return "打卡失败，请重新打卡";
            }
        }
    }

    /**
     * 添加下班打卡时间
     * @param attendanceinfo
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/addAtime")
    public String addAtime(Attendanceinfo attendanceinfo,String userid) throws Exception {
        System.out.println(userid);
        System.out.println("进入下班打卡");
        Date dt = new Date();
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        attendanceinfo.setSelectTime(sdf.format(dt));
        attendanceinfo.setUserid(Integer.parseInt(userid));
        List<Attendanceinfo> list = attendanceinfoService.selectAddTime(attendanceinfo);
        if(list.size()>0){
            Attendanceinfo att = list.get(0);
            System.out.println("进入下班打卡");
            att.setaAtime(dt);
            System.out.println(att.getaAtime());
            int temp = attendanceinfoService.updateByPrimaryKeySelective(att);
            if(temp>0){
                return "打卡成功，祝你回家愉快！";
            }else{
                return "打卡失败，请重新打卡";
            }
        }else{
            return "您上班未打卡，请到行政核实！";
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

        List<Attendanceinfo> list = null;
        System.out.println(userid);
        System.out.println(tureName);
        System.out.println(oneMonth);
        System.out.println(oneDate);
        if(userid == null&& tureName == null && oneDate==null && oneMonth==null){
            PageHelper.startPage(page == null ? 1 : page, limit);

            list = attendanceinfoService.searchSelect(attendanceinfo);

            for (Attendanceinfo att:list) {
                Date date = new Date();
                System.out.println(att.getaMtime());
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String mtimeTemp = sdf.format(att.getaMtime());
                String atimeTemp = null;
                if(att.getaAtime()!=null){
                    atimeTemp = sdf.format(att.getaAtime());
                    if(atimeTemp.compareTo("17:30:00")<0){
                        att.setAtimeRemarkes("早退");
                    }else{
                        att.setAtimeRemarkes("正常下班");
                    }
                }else{
                    att.setAtimeRemarkes("尚未打卡");
                }

                if(mtimeTemp.compareTo("09:00:00")>0){
                    att.setMtimeRemarkes("迟到");
                }else{
                    att.setMtimeRemarkes("正常上班");
                }

                System.out.println(att.getMtimeRemarkes());
                System.out.println(att.getAtimeRemarkes());
            }

            PageInfo<Attendanceinfo> pageinfo=new PageInfo<>(list);
            return new ResultMap<List<Attendanceinfo>>("",list,0,(int)pageinfo.getTotal());
        }else{
            PageHelper.startPage(page == null ? 1 : page, limit);
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
            }else{
                if(!oneDate.equals("")){
                    attendanceinfo.setSelectTime(oneDate);
                }
            }

            list = attendanceinfoService.searchSelect(attendanceinfo);
            for (Attendanceinfo att:list) {
                Date date = new Date();
                System.out.println(att.getaMtime());
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String mtimeTemp = sdf.format(att.getaMtime());
                String atimeTemp = null;
                if(att.getaAtime()!=null){
                    atimeTemp = sdf.format(att.getaAtime());
                    if(atimeTemp.compareTo("17:30:00")<0){
                        att.setAtimeRemarkes("早退");
                    }else{
                        att.setAtimeRemarkes("正常下班");
                    }
                }else{
                    att.setAtimeRemarkes("尚未打卡");
                }
                if(mtimeTemp.compareTo("09:00:00")>0){
                    att.setMtimeRemarkes("迟到");
                }else{
                    att.setMtimeRemarkes("正常上班");
                }

                System.out.println(att.getMtimeRemarkes());
                System.out.println(att.getAtimeRemarkes());
            }

            PageInfo<Attendanceinfo> pageinfo=new PageInfo<>(list);
            return new ResultMap<List<Attendanceinfo>>("",list,0,(int)pageinfo.getTotal());
        }


    }




}
