package com.huizhi.oa.controller.personal;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Carinfo;
import com.huizhi.oa.service.CarinfoService;
import com.huizhi.oa.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarinfoService carinfoService;

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
    /*http://localhost:8080/getAllLicensePlate测试成功*/
    /*获取了所有车辆牌照*/
    @ResponseBody
    @RequestMapping("/addCarApply")
    public void addCarApply(HttpServletRequest request) throws Exception {
        String caId=request.getParameter("caId");
        System.out.println("申请单单号:"+caId);
        String userid=request.getParameter("userid");
        System.out.println("申请人:"+userid);
        String caCId=request.getParameter("caCId");
        System.out.println("车牌:"+caCId);
        String caStarttime=request.getParameter("caStarttime");
        System.out.println("开始时间:"+caStarttime);
        String caOvertime=request.getParameter("caOvertime");
        System.out.println("结束时间:"+caOvertime);
        String caReason=request.getParameter("caReason");
        System.out.println("原因:"+caReason);
        String check=request.getParameter("check");
        System.out.println("检查人:"+check);
    }
}
