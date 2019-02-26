package com.huizhi.oa.controller.personal;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.AllApply;
import com.huizhi.oa.entity.Carapplyinfo;
import com.huizhi.oa.entity.Leaveinfo;
import com.huizhi.oa.service.CarapplyinfoService;
import com.huizhi.oa.service.LeaveinfoService;
import com.huizhi.oa.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class CheckController {
    @Autowired
    private LeaveinfoService leaveinfoService;
    //根据主键获取申请单信息
    /**
     * 获取某个请假条
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("getOneLeaveInfoCheck")
    public Leaveinfo getOneLeaveInfoCheck(String lId) throws Exception {
        Leaveinfo list=leaveinfoService.selectByPrimaryKey(lId);
        return list;
    }

    /*审批请假、出差*/
    @ResponseBody
    @RequestMapping("passOrNo")
    public String passOrNo(String lId,String lCheckad,String lState) throws Exception {
        Leaveinfo leaveinfo = leaveinfoService.selectByPrimaryKey(lId);
        leaveinfo.setlCheckad(lCheckad);
        /**
         * 获取邮件状态,
         * 通过为1，
         * 不通过为2，
         */
        //String eState = request1.getParameter("lState");
        leaveinfo.setlState(Integer.parseInt(lState));
        leaveinfoService.updateByPrimaryKeySelective(leaveinfo);
        return "500";
    }

    @Autowired
    private CarapplyinfoService carapplyinfoService;
    /**
     * 获取所有车辆申请信息
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("getAllCarApplyInfoCheck")
    public ResultMap<List<Carapplyinfo>> getAllCarApplyInfoCheck(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Carapplyinfo> list=carapplyinfoService.getAllCarApplyInfoCheck();
        PageInfo<Carapplyinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Carapplyinfo>>("",list,0,(int)pageinfo.getTotal());
    }
    //根据主键获取申请单信息
    /**
     * 获取某个车辆申请
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("getOneCarInfoCheck")
    public Carapplyinfo getOneCarInfoCheck(String caId) throws Exception {
        Carapplyinfo carapplyinfo=carapplyinfoService.selectByPrimaryKey(caId);
        return carapplyinfo;
    }
    /*审批车辆申请*/
    @ResponseBody
    @RequestMapping("carPassOrNo")
    public String carPassOrNo(String caId,String caCheckad,String caState) throws Exception {
        Carapplyinfo carapplyinfo = carapplyinfoService.selectByPrimaryKey(caId);
        carapplyinfo.setCaCheckad(caCheckad);
        /**
         * 获取申请状态,
         * 通过为1，
         * 不通过为2，
         */
        carapplyinfo.setCaState(Integer.parseInt(caState));
        carapplyinfoService.updateByPrimaryKeySelective(carapplyinfo);
        return "500";
    }
    /**
     * 获取查看某个人所有申请状况
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("getAllApplyInfoCheck")
    public ResultMap<List<AllApply>> getAllApplyInfoCheck(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<AllApply> list=carapplyinfoService.getAllApplyInfoCheck(7229);
        PageInfo<AllApply> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<AllApply>>("",list,0,(int)pageinfo.getTotal());
    }

}
