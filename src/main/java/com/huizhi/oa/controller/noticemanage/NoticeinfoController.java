package com.huizhi.oa.controller.noticemanage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Noticeinfo;
import com.huizhi.oa.service.NoticeinfoService;
import com.huizhi.oa.util.ResultMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *郭恩
 */

@Controller
@RequestMapping("/noticemanage")

public class NoticeinfoController {

    //使日期可以正常添加的初始化方法
    @InitBinder//方法在控制器处理请求方法前执行
    public  void init(WebDataBinder wdb){
        wdb.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true)
        );
    }


    @Autowired
    private NoticeinfoService noticeinfoService;

    //公告管理显示入口
    @RequiresPermissions("/notice")
    @RequestMapping("/notice")
    public String notice(){
        return "pages/noticeTree/noticeinfo";
    }

    //公告管理数据查询
    @ResponseBody
    @RequestMapping("/selectNoticeinfo")
    public List<Noticeinfo> getAllNoticeinfo(){
        List<Noticeinfo> list =noticeinfoService.getAllNoticeinfo();
        return list;
    }

    //公告管理数据分页显示
    @ResponseBody
    @RequestMapping("selectNoticeinfoALL")
    public ResultMap<List<Noticeinfo>> getallnotice(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Noticeinfo> list=noticeinfoService.getAllNoticeinfo();
        PageInfo<Noticeinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Noticeinfo>>("",list,0,(int)pageinfo.getTotal());
    }

    //公告添加入口
    @RequestMapping("/noticeAdd")
    public String noticeAdd() {
        return "pages/noticeTree/noticeAdd";
    }
    //公告添加
    @RequestMapping("/noticeAddInfo")
    @ResponseBody
    public String noticeAddinfo(Noticeinfo noticeinfo) {
        int temp=noticeinfoService.insertSelective(noticeinfo);
        if (temp>0)
            return "400";
        else
            return "500";
    }

    public Integer nId2;

    //公告修改入口
    @RequestMapping("/noticeUpdata")
    public String noticeUpdate(Integer nId) {
        nId2=nId;
        return "pages/noticeTree/noticeUpdata";
    }

    //查询单条公告记录
    @RequestMapping("getNotice")
    @ResponseBody
    public Noticeinfo getNotice(){
        Noticeinfo noticeinfo=noticeinfoService.selectByPrimaryKey(nId2);
        return noticeinfo;
    }

    //公告修改
    @RequestMapping("/noticeUpdateInfo")
    @ResponseBody
    public String noticeUpdateInfo(Noticeinfo noticeinfo) {
        int temp=noticeinfoService.updateByPrimaryKey(noticeinfo);
        if (temp>0)
            return "400";
        else
            return "500";
    }

    //公告首页显示入口
    @RequiresPermissions("/noticehp")
    @RequestMapping("/noticehp")
    public String noticehomepage(){
        return "pages/noticeTree/noticehomepage";
    }

    //公告详情显示入口
    @RequestMapping("/noticeparticulars")
    public String noticeparticulars(Integer nId) {
        nId2=nId;
        return "pages/noticeTree/noticeparticulars";
    }
}
