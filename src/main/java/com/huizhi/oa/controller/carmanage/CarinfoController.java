package com.huizhi.oa.controller.carmanage;

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
@RequestMapping("/carmanage")
public class CarinfoController {

    @Autowired
    private CarinfoService carinfoService;



    //显示网页车辆管理入口
    @RequestMapping("/car")
    public String car(){

        return "pages/carTree/carinfo";
    }


    /**显示车辆信息
     * 宋畅
     * @return
     */

    @ResponseBody
    @RequestMapping("carinfo")
    public List<Carinfo> getAllCarinfo(){

        List<Carinfo> list=carinfoService.getAllCarinfo();
        return list;
    }


    /*获取了所有车辆信息*/
    @ResponseBody
    @RequestMapping("getAllCarInfo")
    public ResultMap<List<Carinfo>> getAllCarInfo(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Carinfo> list=carinfoService.getAllCarinfo();
        PageInfo<Carinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Carinfo>>("",list,0,(int)pageinfo.getTotal());
    }



    /**
     * 通过车牌号删去车辆信息
     */

    /**
     * 添加车辆信息
     * @return
     */
    @ResponseBody
    @RequestMapping("car_add")
    public String  add(){
        return null;
    }

    /**
     * 修改车辆信息
     * @return
     */
    @ResponseBody
    @RequestMapping("car_update")
    public String update(){
        return null;
    }

}
