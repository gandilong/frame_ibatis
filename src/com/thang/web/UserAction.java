package com.thang.web;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thang.tools.model.Action;

@Controller
@RequestMapping("user")
public class UserAction extends Action{

	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
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
	
	@RequestMapping("logout")
	public String logout(){
		Subject sub=SecurityUtils.getSubject();
		if(sub.isAuthenticated()){
			sub.logout();
		}
		return "redirect:/";
	}
	
	
	
}
