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
@RequestMapping("system")
public class ResourceAction extends Action{

	@Autowired
	private ResourceManager resourceManager;
	
	/**
	 * 系统管理 -->权限-->资源管理
	 * @return
	 */
	@RequestMapping("auth/resourceList")
	public String resourceList(){
		return "system/auth/resourceList";
	}
	
	/**
	 * 系统管理 -->权限-->资源管理
	 * @return
	 */
	@RequestMapping("auth/resourceForm")
	public String resourceForm(){
		return "system/auth/resourceForm";
	}
	
	@RequestMapping("auth/resourceData")
	public void resourceData(){
		ActionValues values=getValues();
		List<Resource> resources=resourceManager.query(values);
		printJSON(resources);
	}
	
}
