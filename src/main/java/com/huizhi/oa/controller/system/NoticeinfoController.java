package com.huizhi.oa.controller.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Noticeinfo;
import com.huizhi.oa.service.NoticeinfoService;
import com.huizhi.oa.util.LayUIResult;
import com.huizhi.oa.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 *郭恩
 */

@Controller
@RequestMapping("/system")
public class NoticeinfoController {

    @Autowired
    private NoticeinfoService noticeinfoService;

    //公告管理显示入口
    @RequestMapping("notice")
    public String notice(){
        return "pages/noticeTree/noticeinfo";
    }

    @ResponseBody
    @RequestMapping("noticeinfo")
    public List<Noticeinfo> getAllNoticeinfo(){
        List<Noticeinfo> list =noticeinfoService.getAllNoticeinfo();
        return list;
    }

    //公告管理数据分页显示
    @ResponseBody
    @RequestMapping("selectNoticeinfoALL")
    public ResultMap<List<Noticeinfo>> getalldep(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Noticeinfo> list=noticeinfoService.getAllNoticeinfo();
        PageInfo<Noticeinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Noticeinfo>>("",list,0,(int)pageinfo.getTotal());
    }

    //公告添加入口
    @RequestMapping("/noticeAdd")
    public String noticeAdd() {
        return "pages/systemTree/noticeAdd";
    }
    //公告添加
    @RequestMapping("/noticeAddInfo")
    @ResponseBody
    public String noticeAddinfo(Integer nId,Integer userid,String nTitle, Date nTime, String nContent) {
        System.out.println(nTitle+nTime+nContent);

        Noticeinfo noticeinfo=new Noticeinfo();
        noticeinfo.setnId(nId);
        noticeinfo.setUserid(userid);
        noticeinfo.setnTitle(nTitle);
        noticeinfo.setnTime(nTime);
        noticeinfo.setnContent(nContent);

        int temp=noticeinfoService.insertSelective(noticeinfo);
        if (temp>0)
            return "400";
        else
            return "500";
    }


}
