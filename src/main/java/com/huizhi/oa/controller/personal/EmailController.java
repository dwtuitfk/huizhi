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

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
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

    /*http://localhost:8080/getAllByeAcceptidBox?page=1&limit=10测试成功*/
    /**
     * 通过收件人、邮件状态state为1或者2，获取他的所有未读、已读邮件
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("getAllByeAcceptidBox")
    public ResultMap<List<Emailinfo>> getAllByeAcceptidBox(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Emailinfo> list=emailinfoService.getAllByeAcceptidBox(122);
        PageInfo<Emailinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Emailinfo>>("",list,0,(int)pageinfo.getTotal());
    }
    /*http://localhost:8080/getAllByeAcceptidDustbin?page=1&limit=10测试成功*/
    /**
     * 通过收件人、邮件状态state为3，获取他的垃圾箱
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("getAllByeAcceptidDustbin")
    public ResultMap<List<Emailinfo>> getAllByeAcceptidDustbin(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<Emailinfo> list=emailinfoService.getAllByeAcceptidDustbin(122);
        PageInfo<Emailinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<Emailinfo>>("",list,0,(int)pageinfo.getTotal());
    }
    /*http://localhost:8080/getAllByeSendididDraft?page=1&limit=10测试成功*/
    /**
     * 通过寄件人、邮件状态state为0，获取他的草稿邮件
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("getAllByeSendididDraft")
    public ResultMap<List<Emailinfo>> getAllByeSendididDraft(Integer page, Integer limit) throws Exception {
        List<Emailinfo> list = emailinfoService.getAllByeSendididDraft(122);
        List<Emailinfo> dustbinList = null;
        if (list.size() > 0){
            dustbinList = list.stream().filter(item -> item.geteState() == 0).collect(Collectors.toList());
        }
        PageHelper.startPage(page == null ? 1 : page, limit);
        PageInfo<Emailinfo> pageinfo = new PageInfo<>(dustbinList);
        return new ResultMap<List<Emailinfo>>("", dustbinList, 0, (int) pageinfo.getTotal());
    }
    /*发邮件*/
    @ResponseBody
    @RequestMapping("/sendEmail")
    public void sendEmail(HttpServletRequest request) throws Exception {
        Emailinfo emailinfo = new Emailinfo();

        /*邮件编号*/
        String uuid = UUID.randomUUID().toString();//生成UUID作为邮件编号
        uuid = uuid.replaceAll("-", "");//去除-
        //String eId=request.getParameter("eId");
        emailinfo.seteId(uuid);
        /*邮件标题*/
        String eTitle=request.getParameter("eTitle");
        if (eTitle.isEmpty()){
            eTitle = "";
            emailinfo.seteTitle(eTitle);
        }else{
            emailinfo.seteTitle(eTitle);
        }
        /*发送时间*/
        //String eTime=request.getParameter("eTime");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        emailinfo.seteTime(sdf.parse(sdf.format(new Date())));
        /*发送人员*/
        String eSendid=request.getParameter("eSendid");
        emailinfo.seteSendid(122);
        /*接收人员*/
        String eAcceptid=request.getParameter("eAcceptid");
        if (eAcceptid.isEmpty()){
            //接收人员为空时，默认为00000
            eAcceptid = "0000";
            emailinfo.seteAcceptid(Integer.valueOf(eAcceptid).intValue());
        }else{
            emailinfo.seteAcceptid(Integer.parseInt(eAcceptid));
        }
        /*转抄人员*/
        /*String eCopyid=request.getParameter("eCopyid");
        if (eCopyid.isEmpty()){
            eCopyid = "";
            emailinfo.seteCopyid(eCopyid);
        }else{
            emailinfo.seteCopyid(eCopyid);
        }*/

        /*邮件内容*/
        String eContent=request.getParameter("eContent");
        if (eContent.isEmpty()){
            eContent = "";
            emailinfo.seteContent(eContent);
        }else{
            emailinfo.seteContent(eContent);
        }
        /**
         * 邮件状态,
         * 草稿为0，
         * 发送为1，未读状态
         */
        String eState = request.getParameter("eState");
        emailinfo.seteState(Integer.parseInt(eState));
        emailinfoService.insertSelective(emailinfo);
    }
}
