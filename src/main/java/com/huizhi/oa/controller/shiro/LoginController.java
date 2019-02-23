package com.huizhi.oa.controller.shiro;

import com.huizhi.oa.entity.Userinfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class LoginController {

		@Autowired
		private StringRedisTemplate stringRedisTemplate;

		//用户登录次数计数  redisKey 前缀
		private String SHIRO_LOGIN_COUNT = "shiro-login-count";
		//用户登录是否被锁定    一小时 redisKey 前缀
		private String SHIRO_IS_LOCK = "shiro-is-lock";
		//用户登录剩余次数
		private String SHIRO_LOGIN_LEFTCOUNT="shiro-login-left-count";

		@RequestMapping({"/","/index"})//,"/error"
		public String index(Model model){
			Userinfo userinfo = (Userinfo) SecurityUtils.getSubject().getPrincipal();
			System.out.print("当前用户编号"+userinfo.getUserid());
			System.out.print("当前用户姓名"+userinfo.getTurename());
			model.addAttribute("userinfo", userinfo);
			return "index";
		}
		@RequestMapping(value="/lock",method= RequestMethod.GET)
		public String lock(){
			return "/lock";
		}

		@RequestMapping(value="/logout",method= RequestMethod.GET)
		public String logout(){
			Session session = SecurityUtils.getSubject().getSession();
			session.stop();
			return "login";
		}
		//每次登陆都对用户进行判断，如果被锁定了，直接跳转到lock
		@RequestMapping(value="/login",method= RequestMethod.GET)
		public String login(){
			Session session = SecurityUtils.getSubject().getSession();
			String islockString=(String) session.getAttribute("user");
			if(islockString==null){
				return "login";
			}else{
			return "lock";
			}
		}

		@RequestMapping(value="/ajaxLogin",method= RequestMethod.POST)
		@ResponseBody
		public Map<String,Object> submitLogin(@RequestParam("userid")String userid, @RequestParam("password") String password, @RequestParam("vcode")String vcode, @RequestParam("rememberMe")Boolean rememberMe) {
		    Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		    Map<String, String> map=new HashMap<String, String>();

		    if(vcode==null||vcode==""){
		        resultMap.put("status", 500);
		        resultMap.put("message", "验证码不能为空！");
		        return resultMap;
		    }

		    Session session = SecurityUtils.getSubject().getSession();
		    //转化成小写字母
		    vcode = vcode.toLowerCase();
		    String v = (String) session.getAttribute("verCode");
		    v.toLowerCase();
		    //还可以读取一次后把验证码清空，这样每次登录都必须获取验证码
		    session.removeAttribute("codeTime");
		    if(!vcode.equals(v)){
		        resultMap.put("status", 500);
		        resultMap.put("message", "验证码错误！");
		        return resultMap;
		    }




		    ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
		    if(stringRedisTemplate.hasKey(SHIRO_LOGIN_COUNT+userid)){
	        //计数大于5时，设置用户被锁定一小时  
	        if(Integer.parseInt(opsForValue.get(SHIRO_LOGIN_COUNT+userid))>=4){
	            opsForValue.set(SHIRO_IS_LOCK+userid, "LOCK");
	            stringRedisTemplate.expire(SHIRO_IS_LOCK+userid, 1, TimeUnit.HOURS);
	            
	        }  
		    }
	        opsForValue.increment(SHIRO_LOGIN_COUNT+userid, 1);
	        int leftcount=5-Integer.parseInt(opsForValue.get(SHIRO_LOGIN_COUNT+userid));
	        opsForValue.set(SHIRO_LOGIN_LEFTCOUNT+userid, String.valueOf(leftcount));
	        stringRedisTemplate.expire(SHIRO_LOGIN_LEFTCOUNT+userid, 1, TimeUnit.HOURS);



		    try {
		        if ("LOCK".equals(opsForValue.get(SHIRO_IS_LOCK+userid))){
		        	session.setAttribute("user", "lock");
		        	session.setTimeout(60);
		            throw new LockedAccountException();
		        }

		        UsernamePasswordToken token = new UsernamePasswordToken(userid, password,rememberMe);
		        SecurityUtils.getSubject().login(token);

		        resultMap.put("status", 200);
		        resultMap.put("message", "登录成功");
		        opsForValue.set(SHIRO_LOGIN_COUNT+userid, "0");
		        opsForValue.set(SHIRO_IS_LOCK+userid, "UNLOCK");
		        map.put("user",userid);
		        
		    }catch (LockedAccountException e) {
		        resultMap.put("status", 400);
		        resultMap.put("message", "您已经被锁定1小时！");
			}catch (UnknownAccountException e) {
		        resultMap.put("status", 300);
		        resultMap.put("message", opsForValue.get(SHIRO_LOGIN_LEFTCOUNT+userid));
		    }catch(IncorrectCredentialsException e1){
		        resultMap.put("status", 100);
		        resultMap.put("message", opsForValue.get(SHIRO_LOGIN_LEFTCOUNT+userid));
		    }catch (Exception e) {
		        resultMap.put("status", 600);
		        resultMap.put("message", opsForValue.get(SHIRO_LOGIN_LEFTCOUNT+userid));
			}
		    return resultMap;
		}
	
}
