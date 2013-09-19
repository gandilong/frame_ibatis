package com.thang.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thang.entity.system.Resource;
import com.thang.entity.system.Role;
import com.thang.entity.system.User;
import com.thang.service.system.ResourceManager;
import com.thang.service.system.RoleManager;
import com.thang.service.system.UserManager;
import com.thang.tools.model.Action;
import com.thang.tools.model.ActionValues;

@Controller
@RequestMapping("system")
public class SystemAction extends Action{

	@Autowired
	private UserManager userManager;
	
	@Autowired
	private RoleManager roleManager;
	
	@Autowired
	private ResourceManager resourceManager;
	
	/**
	 * 系统管理的索引页面
	 * @return
	 */
	@RequestMapping
	public String system(){
		return "system/system";
	}
	
	
	/**
	 * 系统管理 -->权限-->用户管理
	 * @return
	 */
	@RequestMapping("auth/user")
	public String user(){
		return "system/auth/user";
	}
	
	@RequestMapping("auth/userData")
	public void userData(){
		ActionValues values=getValues();
		List<User> users=userManager.query(values);
		printJSON(users);
	}
	
	/**
	 * 系统管理 -->权限-->角色管理
	 * @return
	 */
	@RequestMapping("auth/role")
	public String role(){
		return "system/auth/role";
	}
	
	@RequestMapping("auth/roleData")
	public void roleData(){
		ActionValues values=getValues();
		List<Role> roles=roleManager.query(values);
		printJSON(roles);
	}
	
	/**
	 * 系统管理 -->权限-->资源管理
	 * @return
	 */
	@RequestMapping("auth/resource")
	public String resource(){
		return "system/auth/resource";
	}
	
	@RequestMapping("auth/resourceData")
	public void resourceData(){
		ActionValues values=getValues();
		List<Resource> resources=resourceManager.query(values);
		printJSON(resources);
	}
	
	/**
	 * 系统介绍
	 * @return
	 */
	@RequestMapping("about")
	public String about(){
		return "system/about";
	}
	
	/**
	 * 联系方式
	 * @return
	 */
	@RequestMapping("contact")
	public String contact(){
		return "system/contact";
	}
	
}
