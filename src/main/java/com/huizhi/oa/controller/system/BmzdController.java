package com.huizhi.oa.controller.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Bmzd;
import com.huizhi.oa.service.BmzdService;
import com.huizhi.oa.util.LayUIResult;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * created by dwtuitfk on 2019/2/17.
 */
@Controller
@RequestMapping("/system")
public class BmzdController {

    @Autowired
    private BmzdService bmzdService;

    @RequestMapping("/dep")
    public String department() {
        return "pages/systemTree/department";
    }

    @ResponseBody
    @RequestMapping("selectBmzdALL")
    public Object selectBmzdALL(@RequestParam("page") Integer pageNum, @RequestParam("limit") Integer pageSize) {
        PageInfo<Bmzd> list = bmzdService.selectBmzdALL(pageNum,pageSize);

        int count = (int) list.getTotal();

        //TODO isCommition字段数据库不存在，后期报错再改

        LayUIResult result = LayUIResult.build(0, "", list); // 这个是我返回的数据格式，可以可以自己定义
        result.setCount(count);// 尾部以把该封装类贴出来
        return result;
    }

}
