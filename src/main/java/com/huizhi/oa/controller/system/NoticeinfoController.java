package com.huizhi.oa.controller.system;

import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Noticeinfo;
import com.huizhi.oa.service.NoticeinfoService;
import com.huizhi.oa.util.LayUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *郭恩
 */

@Controller
@RequestMapping("/system")
public class NoticeinfoController {

    @Autowired
    private NoticeinfoService noticeinfoService;

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

    @ResponseBody
    @RequestMapping("selectNoticeinfoALL")
    public Object selectNoticeinfoALL(@RequestParam("page") Integer pageNum,@RequestParam("limit") Integer pageSize){
        PageInfo<Noticeinfo> list=noticeinfoService.selectNoticeinfoALL(pageNum,pageSize);
        int count=(int)list.getTotal();
        LayUIResult result=LayUIResult.build(0,"",list);
        result.setCode(count);
        return result;
    }

}
