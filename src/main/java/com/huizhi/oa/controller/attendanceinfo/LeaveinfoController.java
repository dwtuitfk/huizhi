package com.huizhi.oa.controller.attendanceinfo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Attendanceinfo;
import com.huizhi.oa.entity.Leaveinfo;
import com.huizhi.oa.service.LeaveinfoService;
import com.huizhi.oa.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/kaoqin/leaveinfo")
public class LeaveinfoController {
    @Autowired
    private LeaveinfoService leaveinfoService;

    @RequestMapping("leave")
    public String getLeaveinfo(Leaveinfo leaveinfo){
        return "pages/leaveinfoTree/leaveinfo";
    }

    @ResponseBody
    @RequestMapping("/getAll")
    public ResultMap<List<Leaveinfo>> getALeaveinfo(Integer page, Integer limit,Leaveinfo leaveinfo) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Leaveinfo> list = leaveinfoService.getAllLeaveInfo();
        PageInfo<Leaveinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Leaveinfo>>("",list,0,(int)pageinfo.getTotal());
    }


    public List<Leaveinfo> testLeave(){
        List<Leaveinfo> list = leaveinfoService.getAllLeaveInfo();
        return list;
    }





    /**
     * 多条件模糊查询
     * @param leaveinfo
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/test")
    public List<Leaveinfo> geAllLeaveinfo(Leaveinfo leaveinfo)throws Exception {
        leaveinfo.setlId("%11%");
        //leaveinfo.setlUserid(123);
        //leaveinfo.setlState(0);
        List<Leaveinfo> list = leaveinfoService.selectLeaveinfo(leaveinfo);
        return list;
    }

    @ResponseBody
    @RequestMapping("/update")
    public String updateLeaceinfo(Leaveinfo leaveinfo){
        leaveinfo.setlId("111");
        leaveinfo.setlUserid(122);
        leaveinfo.setlReason("sdfkjasldflkasjfdlsk");
        int temp = leaveinfoService.updateByPrimaryKeySelective(leaveinfo);
        if (temp>0){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }


}
