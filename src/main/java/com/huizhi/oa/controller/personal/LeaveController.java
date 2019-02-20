package com.huizhi.oa.controller.personal;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Leaveinfo;
import com.huizhi.oa.service.LeaveinfoService;
import com.huizhi.oa.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LeaveController {

    @Autowired
    private LeaveinfoService leaveinfoService;

    /*http://localhost:8080/getAllLeaveInfo?page=1&limit=10测试成功*/
    /**
     * 获取所有请假条
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("getAllLeaveInfo")
    public ResultMap<List<Leaveinfo>> getAllLeaveInfo(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Leaveinfo> list=leaveinfoService.getAllLeaveInfo();
        PageInfo<Leaveinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Leaveinfo>>("",list,0,(int)pageinfo.getTotal());
    }

}
