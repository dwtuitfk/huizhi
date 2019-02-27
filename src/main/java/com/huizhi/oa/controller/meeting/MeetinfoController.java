package com.huizhi.oa.controller.meeting;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Houseapplyinfo;
import com.huizhi.oa.entity.Meetinfo;
import com.huizhi.oa.service.MeetinfoService;
import com.huizhi.oa.util.LayUIResult;
import com.huizhi.oa.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Function Description:  <br>
 * Writer: Administrator . <br>
 * Creating Time: 2019-02-17 18:09 <br>
 * Version:  <br>
 */

@Controller
@RequestMapping("/meeting")
public class MeetinfoController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @Autowired
    private MeetinfoService meetinfoService;

    /**
     * 显示会议记录页面
     * @return
     */
    @RequestMapping("/meetinfoShowPage")
    public String show() {
        return "pages/meetingTree/meetinfo/show";
    }

    /**
     * 添加会议记录页面
     * @return
     */
    @RequestMapping("/meetinfoAddPage")
    public String add(){
        return "pages/meetingTree/meetinfo/add";
    }

    /**
     * 删除会议记录
     * @return
     */
    @RequestMapping("/meetinfoDelPage")
    public String del(){
        return "pages/meetingTree/meetinfo/del";
    }

    public Integer mId2;
    /**
     * 更新会议记录页面
     * @return
     */
    @RequestMapping("/meetinfoUpdatePage")
    public String update(Integer mId){
        mId2 = mId;
        return "pages/meetingTree/meetinfo/update";
    }

    /**
     * 查询所有会议记录
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllMeetinfo")
    public ResultMap<List<Meetinfo>> getAllMeetinfo(Integer page, Integer limit, Meetinfo meetinfo ) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        System.out.println("时间条件："+meetinfo.getTimes());
        /*Meetinfo meetinfo = new Meetinfo();
        meetinfo.setmId(mId);//设置编号
        meetinfo.setmTitle(mTitle);//会议标题
        meetinfo.setmStarttime(mStarttime);*/
        List<Meetinfo> list=meetinfoService.seachMeetinfo(meetinfo);
        System.out.println("实体："+meetinfo+"ID:"+meetinfo.getmId()+"时间："+meetinfo.getTimes());
        PageInfo<Meetinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<>("",list,0,(int)pageinfo.getTotal());
    }

    /**
     * 查询单条会议记录
     * @return
     */
    @ResponseBody
    @RequestMapping("/getMeetinfo")
    public Meetinfo getMeetinfo(){
        Meetinfo meetinfo = meetinfoService.selectByPrimaryKey(mId2);
        return meetinfo;
    }

    /**
     * 添加会议记录
     * @param meetinfo
     * @return
     */
    @ResponseBody
    @RequestMapping("/meetinfoAdd")
    public String addMeetinfo(Meetinfo meetinfo){
        int tmp = meetinfoService.insertSelective(meetinfo);
        if (tmp>0){
            return "400";
        }else {
            return "500";
        }
    }

    /**
     * 修改会议记录
     * @param meetinfo
     * @return
     */
    @ResponseBody
    @RequestMapping("/meetinfoUpdate")
    public String updateMeetinfo(Meetinfo meetinfo){
        int tmp = meetinfoService.updateByPrimaryKeySelective(meetinfo);
        if (tmp>0){
            return "400";
        }else {
            return "500";
        }
    }

    /**
     * 删除会议记录
     * @param mId
     * @return
     */
    @ResponseBody
    @RequestMapping("/meetinfoDel")
    public String delMeetinfo(Integer mId){
        int tmp = meetinfoService.deleteByPrimaryKey(mId);
        if(tmp>0){
            return "400";
        }else {
            return "500";
        }
    }

    /**
     * 多项删除会议记录
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/meetinfoDelMore")
    public String delMoreMeetinfo(String ids){
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
        int temp=meetinfoService.delMoreMeetinfo(id);

        if (temp>0)
            return "400";
        else
            return "500";
    }

}