package com.thang.web.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thang.service.system.ResourceManager;
import com.thang.service.system.RoleManager;
import com.thang.tools.model.Action;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.ResultValues;
import com.thang.tools.util.JsonUtils;

@Controller
@RequestMapping("system/role")
public class RoleAction extends Action{

	@Autowired
	private RoleManager roleManager;
	@Autowired
	private ResourceManager resourceManager;
	
	/**
	 * 系统管理 -->权限-->角色管理
	 * @return
	 */
	@RequestMapping("list")
	public String list(){
		//得到所有资源数据
		ActionValues values=getValues();
		List<ResultValues> resources=resourceManager.list("system.resource.query", values);
		values.add("resources", JsonUtils.toJsonStr(resources));
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
	 * 查询指定用户的角色
	 */
	@RequestMapping("listUserRoles")
	public void listUserRoles(){
		ActionValues values=getValues();//必须包含uid
		List<String> user_roles=roleManager.listObj("getRoleNameByUser", values);
		printJSON(user_roles);
	}
	
	@RequestMapping("updateRole")
	public void updateRole(){
		ActionValues values=getValues();//必须包含rid 和 resId,opt
		if(values.isNotEmpty("opt")&&"insert".equals(values.getStr("opt"))){
			roleManager.insert("insert into sys_role_resource_info(role,resource)values(:rid,:resId) ", values);	
		}else{
			roleManager.insert("delete from sys_role_resource_info where role=:rid and resource=:resId ", values);
		}
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
			roleManager.update("delete from sys_role_info where id=:id", values);
			roleManager.update("delete from sys_role_resource_info where role=:id", values);
		}else{
			print(1);
		}
		print(0);
	}
	
}
