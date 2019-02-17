package com.huizhi.oa.controller.system;

import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Userzd;
import com.huizhi.oa.service.UserzdService;
import com.huizhi.oa.util.LayUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Object selectUserzdALL(@RequestParam("page") Integer pageNum, @RequestParam("limit") Integer pageSize) {
        PageInfo<Userzd> list = userzdService.selectUserzdALL(pageNum,pageSize);

        int count = (int) list.getTotal();

        //TODO isCommition字段数据库不存在，后期报错再改

        LayUIResult result = LayUIResult.build(0, "", list); // 这个是我返回的数据格式，可以可以自己定义
        result.setCount(count);// 尾部以把该封装类贴出来
        return result;
    }
}
