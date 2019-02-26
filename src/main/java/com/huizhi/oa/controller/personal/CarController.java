package com.huizhi.oa.controller.personal;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Carapplyinfo;
import com.huizhi.oa.entity.Carinfo;
import com.huizhi.oa.service.CarapplyinfoService;
import com.huizhi.oa.service.CarinfoService;
import com.huizhi.oa.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarinfoService carinfoService;
    @Autowired
    private CarapplyinfoService carapplyinfoService;


    /*http://localhost:8080/getAllCarInfo?page=1&limit=10测试成功*/
    /*获取了所有车辆信息*/
    @ResponseBody
    @RequestMapping("getAllCarInfo")
    public ResultMap<List<Carinfo>> getAllCarInfo(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Carinfo> list=carinfoService.getAllCarinfo();
        PageInfo<Carinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Carinfo>>("",list,0,(int)pageinfo.getTotal());
    }
    /*http://localhost:8080/getAllLicensePlate测试成功*/
    /*获取了所有车辆牌照*/
    @ResponseBody
    @RequestMapping("getAllLicensePlate")
    public List getAllLicensePlate() throws Exception {

        List<Carinfo> list=carinfoService.getAllCarinfo();
        List list1 = new ArrayList();
        list.forEach((p) -> list1.add(p.getcId()));
        return list1;
    }
    /*添加车辆申请*/
    @ResponseBody
    @RequestMapping("/addCarApply")
    public void addCarApply(HttpServletRequest request) throws Exception {
        Carapplyinfo carapplyinfo = new Carapplyinfo();

        /*申请单单号*/
        String caId=request.getParameter("caId");
        carapplyinfo.setCaId(caId);
        /*申请人*/
        String userid=request.getParameter("userid");
        carapplyinfo.setUserid(122);
        /*caCId*/
        String caCId=request.getParameter("caCId");
        carapplyinfo.setCaCId(caCId);
        /*开始时间*/
        String caStarttime=request.getParameter("caStarttime");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        carapplyinfo.setCaStarttime(sdf.parse(caStarttime));
        /*结束时间*/
        String caOvertime=request.getParameter("caOvertime");
        carapplyinfo.setCaOvertime(sdf.parse(caOvertime));
        /*原因*/
        String caReason=request.getParameter("caReason");
        carapplyinfo.setCaReason(caReason);
        /*检查人*/
        String caUserid=request.getParameter("caUserid");
        carapplyinfo.setCaUserid(122);
        /*申请单状态*/
        carapplyinfo.setCaState(0);
        /*审核建议*/
        carapplyinfo.setCaCheckad("");
        /*添加申请*/
        carapplyinfoService.insert(carapplyinfo);
    }
    /*系统自动生成申请单单号*/
    @ResponseBody
    @RequestMapping("getCaID")
    public List getCaID() throws Exception {
        List list = new ArrayList();
        list.add("T"+ System.currentTimeMillis());
        return list;
    }
}
