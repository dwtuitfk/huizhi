package com.huizhi.oa.controller.attendanceinfo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Tiaoxiuinfo;
import com.huizhi.oa.service.TiaoxiuinfoService;
import com.huizhi.oa.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/kaoqin/tiaoxiuinfo")
public class TiaoxiuinfoController {
    @Autowired
    private TiaoxiuinfoService tiaoxiuinfoService;

    @RequestMapping("/tiaoxiu")
    public String dep() {
        return "pages/tiaoxiuinfoTree/tiaoxiuinfo";
    }

    @ResponseBody
    @RequestMapping("/selectInfo")
    public ResultMap<List<Tiaoxiuinfo>> getTiaoxiuinfo(Tiaoxiuinfo tiaoxiuinfo, Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Tiaoxiuinfo> list = tiaoxiuinfoService.selectGetAll();
        PageInfo<Tiaoxiuinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Tiaoxiuinfo>>("",list,0,(int)pageinfo.getTotal());
    }


    public List<Tiaoxiuinfo> getTiao(){
        List<Tiaoxiuinfo> list = tiaoxiuinfoService.selectGetAll();
        return list;
    }



    public List<Tiaoxiuinfo> getTiaoxiuinfo(Tiaoxiuinfo tiaoxiuinfo) throws Exception {
        //tiaoxiuinfo.setTxReason("%adwad%");
        List<Tiaoxiuinfo> list = tiaoxiuinfoService.selectTiaoxiuinfo(tiaoxiuinfo);
        return list;
    }



}
