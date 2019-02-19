package com.huizhi.oa.controller.personal;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Emailinfo;
import com.huizhi.oa.service.EmailinfoService;
import com.huizhi.oa.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmailController {

    @Autowired
    private EmailinfoService emailinfoService;


    /*http://localhost:8080/getAllEmailInfo?page=1&limit=10测试成功*/
    /**
     * 获取所有邮件
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("getAllEmailInfo")
    public ResultMap<List<Emailinfo>> getAllEmailInfo(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Emailinfo> list=emailinfoService.getAllEmailInfo();
        PageInfo<Emailinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Emailinfo>>("",list,0,(int)pageinfo.getTotal());
    }
}
