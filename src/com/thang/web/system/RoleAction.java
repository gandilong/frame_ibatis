package com.thang.web.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thang.entity.system.Role;
import com.thang.service.system.RoleManager;
import com.thang.tools.model.Action;
import com.thang.tools.model.ActionValues;

@Controller
@RequestMapping("system")
public class RoleAction extends Action{

	@Autowired
	private RoleManager roleManager;
	
	/**
	 * 系统管理 -->权限-->角色管理
	 * @return
	 */
	@RequestMapping("auth/roleList")
	public String roleList(){
		return "system/auth/roleList";
	}
	
	/**
	 * 系统管理 -->权限-->角色管理
	 * @return
	 */
	@RequestMapping("auth/roleForm")
	public String roleForm(){
		return "system/auth/roleForm";
	}
	
	@RequestMapping("auth/roleData")
	public void roleData(){
		ActionValues values=getValues();
		List<Role> roles=roleManager.query(values);
		printJSON(roles);
	}
	
}
