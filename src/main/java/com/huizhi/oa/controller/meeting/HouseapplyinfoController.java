package com.huizhi.oa.controller.meeting;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Houseapplyinfo;
import com.huizhi.oa.entity.Meethouse;
import com.huizhi.oa.entity.Userinfo;
import com.huizhi.oa.service.HouseapplyinfoService;
import com.huizhi.oa.util.LayUIResult;
import com.huizhi.oa.util.ResultMap;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Function Description:  <br>
 * Writer: Administrator . <br>
 * Creating Time: 2019-02-18 10:12 <br>
 * Version:  <br>
 */

@Controller
@RequestMapping("/meeting")
public class HouseapplyinfoController {
    @Autowired
    private HouseapplyinfoService houseapplyinfoService;

    /**
     * 显示会议申请页面
     * @return
     */
    @RequestMapping("/houseapplyinfoShowPage")
    public String show() {
        return "pages/meetingTree/houseapplyinfo/show";
    }

    /**
     * 添加会议申请页面
     * @return
     */
    @RequestMapping("/houseapplyinfoAddPage")
    public String add(){
        return "pages/meetingTree/houseapplyinfo/add";
    }

    private Integer haId2;
    /**
     * 更新会议申请页面
     * @return
     */
    @RequestMapping("/houseapplyinfoUpdatePage")
    public String update(Integer haId){
        haId2 = haId;
        return "pages/meetingTree/houseapplyinfo/update";
    }

    /**
     * 删除会议申请页面
     * @return
     */
    @RequestMapping("/houseapplyinfoDelPage")
    public String del(){
        return "pages/meetingTree/houseapplyinfo/del";
    }

    /**
     * 查询所有会议申请表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllHouseapplyinfo")
    public ResultMap<List<Houseapplyinfo>> getAllHouseapplyinfo(Integer page, Integer limit,String state,Integer haId) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        Houseapplyinfo houseapplyinfo = new Houseapplyinfo();
        houseapplyinfo.setHaId(haId);//设置编号
        houseapplyinfo.setState(state);//设置状态
        List<Houseapplyinfo> list=houseapplyinfoService.seachHouseapplyinfo(houseapplyinfo);
        PageInfo<Houseapplyinfo> pageinfo=new PageInfo<>(list);
        return new ResultMap<>("",list,0,(int)pageinfo.getTotal());
    }


    /**
     * 查询单条会议申请表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getHouseapplyinfo")
    public Houseapplyinfo getHouseapplyinfo(){
        Houseapplyinfo houseapplyinfo = houseapplyinfoService.selectByPrimaryKey(haId2);
        return houseapplyinfo;
        //return houseapplyinfoService.getAllHouseapplyinfo();
    }

    /**
     * 添加会议申请
     * @param houseapplyinfo
     * @return
     */
    @ResponseBody
    @RequestMapping("/houseapplyinfoAdd")
    public String addHouseapplyinfo(Houseapplyinfo houseapplyinfo){
        //houseapplyinfo.setHaStarttime(new Date());//会议申请时间
        //获取当前用户
        Userinfo userinfo = (Userinfo) SecurityUtils.getSubject().getPrincipal();
        houseapplyinfo.setUserid(userinfo.getUserid());//用户id
        //System.out.println("用户"+userinfo.getUserid());
        houseapplyinfo.setHaState(0);//会议状态
        houseapplyinfo.setHaMId(houseapplyinfo.getHaId());//会议记录编号
        int tmp = houseapplyinfoService.insertSelective(houseapplyinfo);
        if(tmp>0){
            return "400";
        }else {
            return "500";
        }
    }


    /**
     * 修改会议申请
     * @param houseapplyinfo
     * @return
     */
    @ResponseBody
    @RequestMapping("/houseapplyinfoUpdate")
    public String updateHouseapplyinfo(Houseapplyinfo houseapplyinfo){
        int tmp = houseapplyinfoService.updateByPrimaryKeySelective(houseapplyinfo);
        if (tmp>0){
            return "400";
        }else {
            return "500";
        }
    }

    /**
     * 删除会议申请
     * @param haId
     * @return
     */
    @ResponseBody
    @RequestMapping("/houseapplyinfoDel")
    public String delHouseapplyinfo(Integer haId){
        int tmp = houseapplyinfoService.deleteByPrimaryKey(haId);
        if(tmp>0){
            return "400";
        }else {
            return "500";
        }
    }

    /**
     * 多项删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/houseapplyinfoDelMore")
    public String delMoreHouseapplyinfo(String ids){
        List<Integer> id=null;
        if(ids.contains(",")){
            String []arr=ids.split(",");
            id=new ArrayList<>();
            for (String a:arr) {
                id.add(Integer.parseInt(a));
            }
        }else{
            id=new ArrayList<>();
            id.add(Integer.parseInt(ids));
        }
        int temp=houseapplyinfoService.delMoreHouseapplyinfo(id);

        if (temp>0)
            return "400";
        else
            return "500";
    }
}