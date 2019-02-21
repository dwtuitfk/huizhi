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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
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
    /*http://localhost:8080/getAllEmailInfoByeSendid?page=1&limit=10测试成功*/
    /**
     * 通过寄件人id获取某个人所有邮件
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("getAllEmailInfoByeSendid")
    public ResultMap<List<Emailinfo>> getAllEmailInfoByeSendid(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Emailinfo> list=emailinfoService.getAllEmailInfoByeSendid(122);
        PageInfo<Emailinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Emailinfo>>("",list,0,(int)pageinfo.getTotal());

    }

    /*http://localhost:8080/getAllEmailInfoByeAcceptid?page=1&limit=10测试成功*/
    /**
     * 通过收件人id获取某个人所有邮件
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("getAllEmailInfoByeAcceptid")
    public ResultMap<List<Emailinfo>> getAllEmailInfoByeAcceptid(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page == null ? 1 : page, limit);
        List<Emailinfo> list = emailinfoService.getAllEmailInfoByeAcceptid(122);
        PageInfo<Emailinfo> pageinfo = new PageInfo<>(list);
        return new ResultMap<List<Emailinfo>>("", list, 0, (int) pageinfo.getTotal());
    }
    /*http://localhost:8080/getAllEmailInfoByeAcceptidDustbin?page=1&limit=10测试成功*/
    /**
     * 通过收件人id获取某个人所有垃圾箱邮件
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("getAllEmailInfoByeAcceptidDustbin")
    public ResultMap<List<Emailinfo>> getAllEmailInfoByeAcceptidDustbin(Integer page, Integer limit) throws Exception {
        List<Emailinfo> list = emailinfoService.getAllEmailInfoByeAcceptid(122);
        List<Emailinfo> dustbinList = null;
        if (list.size() > 0){
            dustbinList = list.stream().filter(item -> item.geteState() == 3).collect(Collectors.toList());
        }
        PageHelper.startPage(page == null ? 1 : page, limit);
        PageInfo<Emailinfo> pageinfo = new PageInfo<>(dustbinList);
        return new ResultMap<List<Emailinfo>>("", dustbinList, 0, (int) pageinfo.getTotal());
    }
    /*http://localhost:8080/getAllEmailInfoByeAcceptidDraft?page=1&limit=10测试成功*/
    /**
     * 通过收件人id获取某个人所有草稿邮件
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("getAllEmailInfoByeAcceptidDraft")
    public ResultMap<List<Emailinfo>> getAllEmailInfoByeAcceptidDraft(Integer page, Integer limit) throws Exception {
        List<Emailinfo> list = emailinfoService.getAllEmailInfoByeAcceptid(122);
        list.forEach((v)-> System.out.println(v.geteId()));
        List<Emailinfo> dustbinList = null;
        if (list.size() > 0){
            dustbinList = list.stream().filter(item -> item.geteState() == 0).collect(Collectors.toList());
        }
        PageHelper.startPage(page == null ? 1 : page, limit);
        dustbinList.forEach((p) -> System.out.println(p.geteId()));
        PageInfo<Emailinfo> pageinfo = new PageInfo<>(dustbinList);
        return new ResultMap<List<Emailinfo>>("", dustbinList, 0, (int) pageinfo.getTotal());
    }
}
