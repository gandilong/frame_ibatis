package com.thang.web.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thang.entity.system.Resource;
import com.thang.service.system.ResourceManager;
import com.thang.tools.model.Action;
import com.thang.tools.model.ActionValues;

@Controller
@RequestMapping("system/resource")
public class ResourceAction extends Action{

	@Autowired
	private ResourceManager resourceManager;
	
	/**
	 * 系统管理 -->权限-->资源管理
	 * @return
	 */
	@RequestMapping("list")
	public String list(){
		return "system/resource/list";
	}
	
	/**
	 * 系统管理 -->权限-->资源管理
	 * @return
	 */
	@RequestMapping("form")
	public String resourceForm(){
		return "system/resource/form";
	}
	
	/**
	 * 查询资源
	 */
	@RequestMapping("listData")
	public void listData(){
		ActionValues values=getValues();
		List<Resource> resources=resourceManager.query(values);
		printJSON(resources);
	}
	
	/**
	 * 查询指定用户的资源
	 */
	@RequestMapping("listUserResources")
	public void listUserResources(){
		ActionValues values=getValues();//必须包含uid
		List<String> user_resources=resourceManager.listObj("getResourceNameByUser", values);
		printJSON(user_resources);
	}
	
	/**
	 * 查询指定用户的资源
	 */
	@RequestMapping("listRoleResources")
	public void listRoleResources(){
		ActionValues values=getValues();//必须包含rid
		List<String> user_resources=resourceManager.listObj("getResourceNameByRole", values);
		printJSON(user_resources);
	}
	
	
	
	/**
	 * 新增或修改数据
	 */
	@RequestMapping("formSave")
	public void formSave(){
		ActionValues values=getValues();
		if(values.isNotEmpty("id")&&!"0".equals(values.getStr("id"))){
			resourceManager.toUpate(values);
		}else{
			resourceManager.toInsert(values);
		}
		print(0);
	}
	
	/**
	 * 删除数据
	 */
	@RequestMapping("formDelete")
	public void formDelete(){
		ActionValues values=getValues();
		if(values.isNotEmpty("id")){
			resourceManager.toDelete(values);	
		}else{
			print(1);
		}
		print(0);
	}
	
}
