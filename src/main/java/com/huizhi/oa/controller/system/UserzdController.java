package com.huizhi.oa.controller.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Bmzd;
import com.huizhi.oa.entity.Userzd;
import com.huizhi.oa.service.UserzdService;
import com.huizhi.oa.util.LayUIResult;
import com.huizhi.oa.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * created by dwtuitfk on 2019/2/18.
 */
@Controller
@RequestMapping("/system")
public class UserzdController {

    @Autowired
    private UserzdService userzdService;

    @RequestMapping("/post")
    public String post() {
        return "pages/systemTree/post";
    }

    @ResponseBody
    @RequestMapping("selectUserzdALL")
    public ResultMap<List<Userzd>> getalldep(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Userzd> list=userzdService.getAllUserzd();
        PageInfo<Userzd> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Userzd>>("",list,0,(int)pageinfo.getTotal());
    }
}
