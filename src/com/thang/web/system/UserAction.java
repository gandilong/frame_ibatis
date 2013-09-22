package com.thang.web.system;


import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thang.entity.system.User;
import com.thang.service.system.UserManager;
import com.thang.tools.auth.DBRealm;
import com.thang.tools.model.Action;
import com.thang.tools.model.ActionValues;

@Controller
@RequestMapping("system")
public class UserAction extends Action{

	@Autowired
	private DBRealm dbRealm;
	
	@Autowired
	private UserManager userManager;
	
	/**
	 * 跳转到登陆页面
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	/**
	 * 用户登陆系统
	 * @param uname
	 * @param upass
	 * @param remeberme
	 * @param model
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@RequestParam("username")String uname,@RequestParam("password")String upass,@RequestParam(value="remeberme",required=false)boolean remeberme,Model model){
		UsernamePasswordToken token=new UsernamePasswordToken(uname, upass);
		Subject sub=SecurityUtils.getSubject();
		if(remeberme){
			token.setRememberMe(true);
		}
		if(!sub.isAuthenticated()){
			try{
				   sub.login(token);
				}catch(UnknownAccountException unkonw){
					unkonw.printStackTrace();
					model.addAttribute("error", "1");
					return "login";
				}catch(IncorrectCredentialsException ic){
					ic.printStackTrace();
					model.addAttribute("error", "1");//用户名或密码无效！
					return "login";
				}catch(LockedAccountException lae){
					lae.printStackTrace();
					model.addAttribute("error", "2");//账户己停用！
					return "login";
				}catch(AuthenticationException ae){
					ae.printStackTrace();
					model.addAttribute("error", "3");//认证失败！
					return "login";
				}
		}
		
		return "redirect:/web/main";
	}
	
	
	/**
	 * 系统管理 -->权限-->用户管理列表页面
	 * @return
	 */
	@RequestMapping("auth/userList")
	public String userList(){
		return "system/auth/userList";
	}
	
	/**
	 * 系统管理 -->权限-->用户管理表单页面
	 * @return
	 */
	@RequestMapping("auth/userForm")
	public String userForm(){
		return "system/auth/userForm";
	}
	
	@RequestMapping("auth/userData")
	public void userData(){
		ActionValues values=getValues();
		List<User> users=userManager.query(values);
		printJSON(users);
	}
	
	
	/**
	 * 用户退出系统
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(){
		Subject sub=SecurityUtils.getSubject();
		if(sub.isAuthenticated()){
			dbRealm.clearCache(sub.getPrincipals());
			sub.logout();
		}
		return "redirect:/";
	}
	
	
	
}
