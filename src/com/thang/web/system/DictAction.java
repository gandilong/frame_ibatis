package com.thang.web.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thang.service.system.DictManager;
import com.thang.tools.model.Action;
import com.thang.tools.model.ActionValues;

@Controller
@RequestMapping("system/dict")
public class DictAction extends Action{

	@Autowired
	private DictManager dictManager;
	
	/**
	 * 系统管理 -->权限-->资源管理
	 * @return
	 */
	@RequestMapping("list")
	public String list(){
		return "system/dict/list";
	}
	
	@RequestMapping("treeData")
	public void treeData(){
		ActionValues values=getValues();
		dictManager.queryResult("", values);
	}
	
}
