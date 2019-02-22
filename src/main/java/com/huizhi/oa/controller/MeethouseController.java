/**
 * System Name： SDN Platform
 * <p>
 * File Name： MeethouseController
 * <p>
 * Creating Time： 2019-02-18 09:18
 * <p>
 * Copyright (c) 2015-2025 Fiberhome Technologies.
 * 88,YouKeYuan Road, Hongshan District.,Wuhan,P.R.China,
 * Wuhan Research Institute of Post & Telecommunication.
 * <p>
 * All rights reserved.
 */

package com.huizhi.oa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Bmzd;
import com.huizhi.oa.entity.Houseapplyinfo;
import com.huizhi.oa.entity.Meethouse;
import com.huizhi.oa.service.MeethouseService;
import com.huizhi.oa.util.LayUIResult;
import com.huizhi.oa.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * Function Description:  <br>
 * Writer: Administrator . <br>
 * Creating Time: 2019-02-18 09:18 <br>
 * Version:  <br>
 */

@Controller
@RequestMapping("/meeting")
public class MeethouseController {

    @Autowired
    private MeethouseService meethouseService;

    /**
     * 显示会议室页面
     * @return
     */
    @RequestMapping("/meethouseShowPage")
    public String show() {
        return "pages/meetingTree/meethouse/show";
    }

    /**
     * 添加会议室页面
     * @return
     */
    @RequestMapping("/meethouseAddPage")
    public String add(){
        return "pages/meetingTree/meethouse/add";
    }

    public Integer mhId2;
    /**
     * 更新会议室页面
     * @return
     */
    @RequestMapping("/meethouseUpdatePage")
    public String update(Integer mhId){
        mhId2 = mhId;
        return "pages/meetingTree/meethouse/update";
    }

    /**
     * 删除会议室页面
     * @return
     */
    @RequestMapping("/meethouseDelPage")
    public String del(){
        return "pages/meetingTree/meethouse/del";
    }
    /**
     * 查询所有会议室信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllMeethouse")
    public ResultMap<List<Meethouse>> getAllMeethouse(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Meethouse> list= meethouseService.getAllMeethouse();
        PageInfo<Meethouse> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Meethouse>>("", list, 0, (int)pageinfo.getTotal());
    }
    /*public Object getAllMeethouse(@RequestParam("page") Integer pageNum, @RequestParam("limit") Integer pageSize){
        PageInfo<Meethouse> list = meethouseService.getAllMeethouse(pageNum, pageSize);
        int count = (int) list.getTotal();
        LayUIResult result = LayUIResult.build(0, "", list); // 这个是我返回的数据格式，可以可以自己定义
        result.setCount(count); // 尾部以把该封装类贴出来
        return result;
    }*/

    /**
     * 查询单条会议室
     * @return
     */
    @ResponseBody
    @RequestMapping("/getMeethouse")
    public Meethouse getMeethouse(){
        Meethouse meethouse = meethouseService.selectByPrimaryKey(mhId2);
        return meethouse;
    }

    /**
     * 添加会议室
     * @param mhId
     * @param mhName
     * @param mhAddress
     * @return
     */
    @ResponseBody
    @RequestMapping("/meethouseAdd")
    public String addMeethouse(@RequestParam("mhId") String mhId,
                               @RequestParam("mhName") String mhName,
                               @RequestParam("mhAddress") String mhAddress){
        Meethouse meethouse = new Meethouse();
        meethouse.setMhId(Integer.valueOf(mhId));
        meethouse.setMhName(mhName);
        meethouse.setMhAddress(mhAddress);
        meethouse.setMhState(1);//会议室初始状态
        int tmp = meethouseService.insertSelective(meethouse);
        if(tmp>0){
            return "400";
        }else {
            return "500";
        }
    }

    /**
     * 修改会议室
     * @param meethouse
     * @return
     */
    @ResponseBody
    @RequestMapping("/meethouseUpdate")
    public String updateMeethouse(Meethouse meethouse){
        //System.out.println("编号"+meethouse.getMhId()+"地址"+meethouse.getMhAddress()+"状态"+meethouse.getMhState());
        int tmp = meethouseService.updateByPrimaryKeySelective(meethouse);
        if (tmp>0)
            return "400";
        else
            return "500";
    }

    /**
     * 多项删除会议室
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/meethouseDelMore")
    public String delMoreMeethouse(String ids){
        List<Integer> id=null;
        if(ids.contains(",")){
            String []arr=ids.split(",");
            id=new ArrayList<>();
            for (String a:arr) {
                id.add(Integer.parseInt(a));
            }
        }else{
            id=new ArrayList<>();
            id.add(Integer.parseInt(ids));
        }
        int temp=meethouseService.delMoreMeethouse(id);

        if (temp>0)
            return "400";
        else
            return "500";
    }

    /**
     * 删除单条会议室信息
     * @param mhId
     * @return
     */
    @ResponseBody
    @RequestMapping("/meethouseDel")
    public String delMeethouse(Integer mhId){
        int tmp = meethouseService.deleteByPrimaryKey(mhId);
        if(tmp>0){
            return "400";
        }else {
            return "500";
        }

    }


    //获取会议室编号
    @RequestMapping("/selectMeethouse")
    @ResponseBody
    public List<Meethouse> selectDep(){
        List<Meethouse> list =meethouseService.getAllMeethouse();
        return list;
    }
}