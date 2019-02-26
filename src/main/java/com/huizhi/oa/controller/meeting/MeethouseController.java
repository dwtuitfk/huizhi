package com.huizhi.oa.controller.meeting;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.*;
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
    public ResultMap<List<Meethouse>> getAllMeethouse(Integer page, Integer limit,String stateName,Integer mhId) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        Meethouse meethouse = new Meethouse();
        meethouse.setMhId(mhId);
        meethouse.setStateName(stateName);
        List<Meethouse> list=meethouseService.seachMeethouse(meethouse);
        PageInfo<Meethouse> pageinfo=new PageInfo<>(list);
        return new ResultMap<>("",list,0,(int)pageinfo.getTotal());
    }


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
     * @param meethouse
     * @return
     */
    @ResponseBody
    @RequestMapping("/meethouseAdd")
    public String addMeethouse(Meethouse meethouse){
        /*Meethouse meethouse = new Meethouse();
        meethouse.setMhId(Integer.valueOf(mhId));
        meethouse.setMhName(mhName);
        meethouse.setMhAddress(mhAddress);*/
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