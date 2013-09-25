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
	
	@RequestMapping("listData")
	public void listData(){
		ActionValues values=getValues();
		List<Resource> resources=resourceManager.query(values);
		printJSON(resources);
	}
	
}
