package com.huizhi.oa.controller.shiro;


import com.huizhi.oa.dao.*;
import com.huizhi.oa.entity.*;
import com.huizhi.oa.service.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;


/**
 *  身份校验核心类;
 * @author dwtuitfk
 * @version v.0.1
 */
public class MyShiroRealm extends AuthorizingRealm{

	

	//用户信息
	@Resource
	private UserinfoService userInfoService;
	//角色
	@Resource
	private RoleinfoService roleinfoService;
	//用户角色
	@Resource
	private UserRoleService userRoleDaoService;
	//角色权限
	@Resource
	private RoleJurService roleJurService;
	//职位字典
	@Resource
	private UserzdService userzdService;
	//权限信息
	@Resource
	private JurinfoService jurinfoService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String user =(String) token.getPrincipal();
		Integer userid = Integer.parseInt(user);
		//通过userid从数据库中查找User对象，如果找到，没找到.
		//这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
		Userinfo userInfo = userInfoService.selectByPrimaryKey(userid);
		System.out.println(userInfo);
		System.out.println("----->>userInfo="+userInfo.getUserid()+"---"+userInfo.getPassword());
		if(userInfo == null){
			return null;
		}
		

      SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
    		 userInfo, //用户名
    		 userInfo.getPassword(), //密码
             getName()  //realm name
      );
		
		return authenticationInfo;
	}
	
	

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Userinfo userinfo  = (Userinfo)principals.getPrimaryPrincipal();
		int userid=userinfo.getUserid();
		List<UserRole> list=userRoleDaoService.getAllUserRoleinfo(userid);
		for(UserRole userrole:list){
			int roleid=userrole.getRoleid();
			authorizationInfo.addRole(userzdService.getRoleName(roleinfoService.getRoleinfo(roleid).getRolename()).getRolenamemc());
			System.out.println(userzdService.getRoleName(roleinfoService.getRoleinfo(roleid).getRolename()).getRolenamemc());
			List<RoleJur> list1=roleJurService.getJurinfo(roleid);
			for(RoleJur p:list1){
				
				authorizationInfo.addStringPermission(jurinfoService.selectByPrimaryKey(p.getJurid()).getFname());
				System.out.println(jurinfoService.selectByPrimaryKey(p.getJurid()).getFname());
			}
		}


		
		return authorizationInfo;
	}
	

	
}
