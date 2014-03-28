package com.thang.web.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thang.service.system.RoleManager;
import com.thang.tools.model.Action;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.ResultValues;

@Controller
@RequestMapping("system/role")
public class RoleAction extends Action{

	@Autowired
	private RoleManager roleManager;
	
	/**
	 * 系统管理 -->权限-->角色管理
	 * @return
	 */
	@RequestMapping("list")
	public String list(){
		return "system/role/list";
	}
	
	/**
	 * 查询角色数据
	 */
	@RequestMapping("listData")
	public void listData(){
		ActionValues values=getValues(true);
		List<ResultValues> roles=roleManager.query(values);
		printJSON(roles);
	}
	
	/**
	 * 系统管理 -->权限-->角色管理
	 * @return
	 */
	@RequestMapping("form")
	public String form(){
		return "system/role/form";
	}
	
	/**
	 * 新增或修改数据
	 */
	@RequestMapping("formSave")
	public void formSave(){
		ActionValues values=getValues(false);
		if(values.isNotEmpty("id")&&!"0".equals(values.getStr("id"))){
			roleManager.toUpate(values);
		}else{
		    roleManager.toInsert(values);
		}
		print(0);
	}
	
	/**
	 * 删除数据
	 */
	@RequestMapping("formDelete")
	public void formDelete(){
		ActionValues values=getValues(false);
		if(values.isNotEmpty("id")){
			roleManager.toDelete(values);	
		}else{
			print(1);
		}
		print(0);
	}
	
}
