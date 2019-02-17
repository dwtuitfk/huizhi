package com.huizhi.oa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Bmzd;
import com.huizhi.oa.service.BmzdService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * created by dwtuitfk on 2019/2/17.
 */
@Controller
@MapperScan("/system")
public class BmzdController {

    @Autowired
    private BmzdService bmzdService;

/*    @RequestMapping("/getalldep")
    @ResponseBody
    public ResultMap<List<Bmzd>> getalldep(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Bmzd> list=bmzdService.getAllBmzd();
        PageInfo<Bmzd> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Bmzd>>("",list,0,(int)pageinfo.getTotal());
    }*/
}
