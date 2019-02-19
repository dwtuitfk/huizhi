package com.huizhi.oa.controller.personal;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Carinfo;
import com.huizhi.oa.service.CarinfoService;
import com.huizhi.oa.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
