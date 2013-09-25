package com.thang.web.system;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thang.service.system.UserManager;
import com.thang.tools.model.Action;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.DataValues;

@Controller
@RequestMapping("system/user")
public class UserAction extends Action{

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
	 * 系统管理 -->权限-->用户管理列表页面
	 * @return
	 */
	@RequestMapping("list")
	public String list(){
		return "system/user/list";
	}
	
	/**
	 * 系统管理 -->权限-->用户管理表单页面
	 * @return
	 */
	@RequestMapping("form")
	public String form(){
		return "system/user/form";
	}
	
	/**
	 * 获得列表数据
	 */
	@RequestMapping("listData")
	public void listData(){
		ActionValues values=getValues();
		List<DataValues> users=userManager.query(values);
		printJSON(users);
	}
	
	/**
	 * 保存表单数据
	 */
	@RequestMapping("formSave")
	public void formSave(){
		ActionValues values=getValues();
		userManager.toInsert(values);
		printJSON("0");
	}
	
}
