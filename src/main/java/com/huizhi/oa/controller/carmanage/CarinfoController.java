package com.huizhi.oa.controller.carmanage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Carinfo;
import com.huizhi.oa.service.CarinfoService;
import com.huizhi.oa.util.ResultMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Controller
@RequestMapping("/carmanage")
public class CarinfoController {
    //使日期可以正常添加的初始化方法
    @InitBinder//方法在控制器处理请求方法前执行
    public  void init(WebDataBinder wdb){
        wdb.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true)
        );
    }

    @Autowired
    private CarinfoService carinfoService;



    //显示网页车辆管理入口
    @RequiresPermissions("/car")//权限管理;
    @RequestMapping("car")
    public String car(){

        return "pages/carTree/car";
    }


    /**显示车辆信息
     * 宋畅
     * @return
     */

    @ResponseBody
    @RequestMapping("selectCarinfo")
    public List<Carinfo> getAllCarinfo(){

        List<Carinfo> list=carinfoService.getAllCarinfo();
        return list;
    }






    /*获取了所有车辆信息*/
    @ResponseBody
    @RequestMapping("getAllCarInfo")
    public ResultMap<List<Carinfo>> getAllCarInfo(Integer page, Integer limit,String input1,String input2,String input3) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Carinfo> list=null;
        if (input1==null&& input2==null && input3==null){
            list=carinfoService.getAllCarinfo();
            PageInfo<Carinfo> pageinfo=new PageInfo<>(list);
            // System.out.println("ddddddddd");
            return new ResultMap<List<Carinfo>>("",list,0,(int)pageinfo.getTotal());
        }else {
            //创建一辆车辆存放下面信息
            // System.out.println("ttt");
            Carinfo creatCar = new Carinfo();
            if (!input1.equals("")) {
                // System.out.println("t1");

                // System.out.println(input1);

                creatCar.setcId(input1);
            }
            if (!input2.equals("")) {
                // System.out.println("t2");

                //System.out.println(input2);
                creatCar.setcType(input2);
            }
            if (!input3.equals("")) {
                // System.out.println("t3");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date DATE = sdf.parse(input3);
                creatCar.setcMaintaintime(DATE);
            }
            System.out.println(input1+input2+input3);
            list = carinfoService.seachCarinfo(creatCar);
            // System.out.println(input1+input2+input3+"22222");
            PageInfo<Carinfo> pageinfo = new PageInfo<>(list);
            // System.out.println("a:"+list.size());
            //System.out.println("b"+new ResultMap<List<Carinfo>>("", list, 0, (int) pageinfo.getTotal()).getMsg());
            return new ResultMap<List<Carinfo>>("", list, 0, (int) pageinfo.getTotal());

        }
    }



    //车辆添加
    @RequestMapping("/carAdd")
    public String carAdd() {
        return "pages/carTree/carAdd";
    }

    @RequestMapping("/carAddInfo")
    @ResponseBody
    public int carAddInfo(String cId,String cType,Integer cState,String cInsurance,String cMaintaintime) throws Exception {

        Carinfo car=new Carinfo();
        car.setcId(cId);
        car.setcType(cType);
        car.setcState(cState);
        car.setcInsurance(cInsurance);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date DATE=sdf.parse(cMaintaintime);
        car.setcMaintaintime(DATE);
        int temp=carinfoService.insertSelective(car);
        System.out.println(car.getcId()+car.getcType());
        if (temp>0)
            return 400;
        else
            return 500;
    }





    public String  cId2;

    //车辆修改
    @RequestMapping("/update")
    public String update(String cId) {
        System.out.println("测试修改"+2354523);
        cId2=cId;
        System.out.println("测试修改"+cId2);
        return "pages/carTree/carUpdata";
    }


    //查询单条部门记录
    @RequestMapping("getCar")
    @ResponseBody
    public Carinfo getCar(){
        System.out.println("------------");
        System.out.println("ajax得到：信息收回");
        System.out.println(cId2);
        Carinfo car = carinfoService.selectByPrimaryKey(cId2);
        return car;
    }


    //车辆修改信息
    @RequestMapping("/carUpdateInfo")
    @ResponseBody
    public String carUpdateInfo(String cId,String cType,Integer cState,String cInsurance,String cMaintaintime) throws Exception {
        System.out.println(cId+cType+cState+cInsurance+cMaintaintime);
        Carinfo carinfo=new Carinfo();
        carinfo.setcId(cId);
        carinfo.setcType(cType);
        carinfo.setcState(cState);
        carinfo.setcInsurance(cInsurance);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date DATE=sdf.parse(cMaintaintime);
        carinfo.setcMaintaintime(DATE);
        int temp=carinfoService.updateByPrimaryKey(carinfo);
        if (temp>0)
            return "400";
        else
            return "500";
    }

    //车辆多项删除
    @RequestMapping("delMoreCar")
    @ResponseBody
    public String delMoreCar(String ids) throws Exception{
        List<String> id=null;
        if(ids.contains(",")){
            String []arr=ids.split(",");
            id=new ArrayList<>();
            for (String a:arr) {
                id.add(a);
            }
        }else{
            id=new ArrayList<>();
            id.add(ids);
        }
        int temp=carinfoService.delMoreCar(id);
        if (temp>0)
            return "400";
        else
            return "500";
    }


    //单项删去
    @RequestMapping("delCar")
    @ResponseBody
    public  int  delCar(String cId){
        int temp=carinfoService.deleteByPrimaryKey(cId);
        if (temp>0)
            return 400;
        else
            return 500;
    }





    //获取查询车牌号信息
    @ResponseBody
    @RequestMapping("getCarLicensePlate")
    public List getCarLicensePlate() throws Exception {

        List<Carinfo> list=carinfoService.getAllCarinfo();
        List list1 = new ArrayList();
        list.forEach((p) -> list1.add(p.getcId()));
        return list1;
    }



















    /*后面的不用看后面的不用看后面的不用看后面的不用看后面的不用看后面的不用看后面的不用看后面的不用看后面的不用看后面的不用看后面的不用看*/
    /**
     * 添加车辆信息
     * @return
     */
/*
    @ResponseBody
    @RequestMapping("car_add")
    public int  add(Carinfo carinfo){
        return carinfoService.insert(carinfo);
    }
*/




    /**
     * 删去车辆信息
     */
 /*   @ResponseBody
    @RequestMapping("car_del")
    public  int  delCar(String cId){
        return carinfoService.deleteByPrimaryKey(cId);
    }
*/


    /**
     * 修改车辆信息
     * @return
     */
  /*  @ResponseBody
    @RequestMapping("car_update")
    public int  update(Carinfo carinfo){

      return carinfoService.updateByPrimaryKey(carinfo);
       }
*/



    //车辆车看
    @RequestMapping("look")
    public String look() {
        return "pages/carTree/carinfo";
    }


    @ResponseBody
    @RequestMapping("LookCar")
    public Carinfo Look() throws Exception {

        System.out.println("------------");
        System.out.println("ajax得到：信息收回");
        System.out.println(cId2);
        Carinfo car = carinfoService.selectByPrimaryKey(cId2);
        return car;
    }



}


