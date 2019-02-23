package com.huizhi.oa.controller.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Roleinfo;
import com.huizhi.oa.entity.UserRole;
import com.huizhi.oa.entity.UserRoleDep;
import com.huizhi.oa.entity.Userinfo;
import com.huizhi.oa.service.RoleinfoService;
import com.huizhi.oa.service.UserRoleService;
import com.huizhi.oa.service.UserinfoService;
import com.huizhi.oa.util.LayUIResult;
import com.huizhi.oa.util.ResultMap;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Optional;

/**
 * created by dwtuitfk on 2019/2/17.
 */

@Controller
@RequestMapping("/system")
public class UserinfoController {

    @Autowired
    private UserinfoService userinfoService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleinfoService roleinfoService;

    //档案管理入口
    @RequestMapping("/user")
    public String user() {
        return "pages/userTree/userinfo";
    }

    //档案管理数据分页显示
    @ResponseBody
    @RequestMapping("selectUserinfoALL")
    public ResultMap<List<UserRoleDep>> getallUser(Integer page, Integer limit) throws Exception {
        PageHelper.startPage(page==null?1:page, limit);
        List<UserRoleDep> list=userinfoService.getAllUserinfo();
        PageInfo<UserRoleDep> pageinfo=new PageInfo<>(list);
        return new ResultMap<List<UserRoleDep>>("",list,0,(int)pageinfo.getTotal());
    }

    //用户添加
    @RequestMapping("/userInfoAdd")
    public String userAddInfo() {
        return "pages/userTree/UserInfoAdd";
    }

    //创建新的用户
    @RequestMapping("userAdd")
    @ResponseBody
    public String userAdd(Userinfo userinfo,Integer rolename) {
       System.out.println(userinfo.getTurename());
        int temp=0;

        //添加用户对应角色
        //1.添加到角色信息表中
        Roleinfo roleinfo = new Roleinfo();
        roleinfo.setRolename(rolename);
       temp=roleinfoService.insertSelective(roleinfo);
        //2.查询角色信息表最新记录
       System.out.println("---最新一条角色信息记录---");
       System.out.println(roleinfoService.getAllRoleinfo().get(roleinfoService.getAllRoleinfo().size()-1).getRoleid());

        //3.添加到用户信息表中
       temp=temp+userinfoService.insertSelective(userinfo);

        //4.用户角色表中插入userid和roleid
       UserRole userRole = new UserRole();
       userRole.setUserid(userinfo.getUserid());
       userRole.setRoleid(roleinfoService.getAllRoleinfo().get(roleinfoService.getAllRoleinfo().size()-1).getRoleid());
       temp=temp+userRoleService.insertSelective(userRole);

        if (temp>0)
            return "400";
        else
            return "500";
    }

    public Integer userid2;

    //用户信息修改页面
    @RequestMapping("/userInfoUpdata")
    public String userUpdataInfo(Integer userid) {
        userid2=userid;
        return "pages/userTree/UserInfoUpdata";
    }


    //查询单条用户信息
    @RequestMapping("getUser")
    @ResponseBody
    public UserRoleDep getUserInfo(){

        UserRoleDep userRoleDep = userinfoService.getUserinfo(userid2);

        return userRoleDep;
    }


    //修改用户信息
    @RequestMapping("userUpdata")
    @ResponseBody
    public String userUpdata(Userinfo userinfo,Integer rolename) {

        int temp;

        //修改用户对应角色
        //1.修改用户信息
        temp=userinfoService.updateByPrimaryKeySelective(userinfo);

        //2.根据用户信息userId主键查询用户对应角色的角色表roleId
        UserRole userRole= userRoleService.getUserRoleinfo(userinfo.getUserid());

        //3.修改角色信息表
        Roleinfo roleinfo = new Roleinfo();
        roleinfo.setRoleid(userRole.getRoleid());
        roleinfo.setRolename(rolename);
        temp +=roleinfoService.updateByPrimaryKeySelective(roleinfo);

        if (temp>0)
            return "400";
        else
            return "500";
    }

    //删除角色及权限
    @RequestMapping("userDel")
    @ResponseBody
    public String userDel(Integer userid) {

        int temp = 0;
        //1.根据用户信息userId主键查询用户对应角色的角色表roleId
        UserRole userRole = userRoleService.getUserRoleinfo(userid);
        //2.解除用户对应角色关联
        temp =userRoleService.delUserRoleinfo(userid);
        //3.删除角色编号对应信息
        temp +=roleinfoService.deleteByPrimaryKey(userRole.getRoleid());
        //4.删除用户信息
        temp +=userinfoService.deleteByPrimaryKey(userid);

        if (temp>0)
            return "400";
        else
            return "500";
    }

    public boolean isDigit(String strNum) {
        return strNum.matches("[0-9]{1,}");
    }

    @RequestMapping("seachUserinfo")
    @ResponseBody
    public ResultMap<List<UserRoleDep>> getalluserinfo(Integer page, Integer limit, String userid,String turename,String address,String sex,String depName,String roleName,Integer isprohibit) throws Exception {
        PageHelper.startPage(page == null ? 1 : page, limit);
        List<UserRoleDep> list=null;
        UserRoleDep userRoleDep = new UserRoleDep();
        if (userid==null&&turename==null&&address==null&&sex==null&&depName==null&&roleName==null&&isprohibit==null){
            list=userinfoService.seachUserinfo(userRoleDep);

            /*list=userinfoService.getAllUserinfo();*/
            System.out.println(list.size());
            for (UserRoleDep user:list) {
                switch (user.getIsprohibit()){
                    case 0:
                        user.setIsprohibitinfo("离职");
                        break;
                    case 1:
                        user.setIsprohibitinfo("在职");
                        break;
                    case 2:
                        user.setIsprohibitinfo("内退");
                        break;
                    case 3:
                        user.setIsprohibitinfo("返聘");
                        break;
                    case 4:
                        user.setIsprohibitinfo("停薪留职");
                        break;
                }
            }

            PageInfo<UserRoleDep> pageinfo = new PageInfo<>(list);
            return new ResultMap<List<UserRoleDep>>("", list, 0, (int) pageinfo.getTotal());
        }else {
            if (!userid.equals("")){
                if(this.isDigit(userid))
                    userRoleDep.setUserid(Integer.parseInt(userid));
            }
            if (!turename.equals(""))
                userRoleDep.setTurename(turename);
            if (!address.equals(""))
                userRoleDep.setAddress(address);
            if (!sex.equals(""))
                userRoleDep.setSex(sex);

            if (!depName.equals(""))
                if(this.isDigit(depName)) {
                    userRoleDep.setDepName(Integer.parseInt(depName));
                }

            if (!roleName.equals(""))
                if(this.isDigit(roleName)){
                    userRoleDep.setRoleName(Integer.parseInt(roleName));
                }

            userRoleDep.setIsprohibit(isprohibit);

        }
        list = userinfoService.seachUserinfo(userRoleDep);
        for (UserRoleDep user:list) {
            switch (user.getIsprohibit()){
                case 0:
                    user.setIsprohibitinfo("离职");
                    break;
                case 1:
                    user.setIsprohibitinfo("在职");
                    break;
                case 2:
                    user.setIsprohibitinfo("内退");
                    break;
                case 3:
                    user.setIsprohibitinfo("返聘");
                    break;
                case 4:
                    user.setIsprohibitinfo("停薪留职");
                    break;
            }

        }
        PageInfo<UserRoleDep> pageinfo = new PageInfo<>(list);
        return new ResultMap<List<UserRoleDep>>("", list, 0, (int) pageinfo.getTotal());

    }

    //查询所有用户信息
    @ResponseBody
    @RequestMapping("/getUserAllInfo")
    public List<UserRoleDep> getUserAllInfo(){
        List<UserRoleDep> list = userinfoService.getAllUserinfo();
        return list;
    }

    //判断用户id是否存在
    @ResponseBody
    @RequestMapping("inspectUserid")
    public String inspectUserid (Integer userid) {

        //根据用户id主键查询 用户id是否存在 用来添加验证重复
        Userinfo userinfo = userinfoService.selectByPrimaryKey(userid);
        Optional<Userinfo> optional = Optional.ofNullable(userinfo);
        if(!optional.isPresent()){
            System.out.println("用户id为空可以使用");
            return "400";
        }
        System.out.println("500获取的用户id为:"+optional.get().getUserid());
        return "500";
    }


    //主页---修改密码页面
    @RequestMapping("/changePassword")
    public String changePassword(){
        return "pages/userTree/changePassword";
    }

    //主页---修改密码异步显示
    @ResponseBody
    @RequestMapping("/changePasswordInfo")
    public Userinfo changePasswordInfo(){
        Userinfo userinfo = (Userinfo) SecurityUtils.getSubject().getPrincipal();
        return userinfo;
    }

    //修改密码
    @ResponseBody
    @RequestMapping("/changePasswordubmit")
    public String changePasswordubmit(Userinfo userinfo){
        int temp = userinfoService.updateByPrimaryKeySelective(userinfo);
        if (temp>0)
            return "400";
        else
            return "500";
    }
}