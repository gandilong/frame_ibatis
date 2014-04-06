package com.thang.web.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thang.service.system.DictManager;
import com.thang.tools.model.Action;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.ResultValues;

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
	
	@RequestMapping("data")
	public void data(){
		ActionValues values=getValues();
		if(!values.isNotEmpty("parent")){//如果parent参数为空
			values.add("parent", 0);
		}
		List<ResultValues> dicts=dictManager.query(values);
		if(null==dicts){
			print(values.getInt("parent"));
		}else{
		    printJSON(dicts);
		}
	}
	
	@RequestMapping("form")
	public String form(){
		ActionValues values=getValues(false);
		if(values.isNotEmpty("id")){
			ResultValues rv=dictManager.getResult("select * from sys_dict_info where id=:id", values);
			values.putAll(rv);
		}
		return "system/dict/form";
	}
	
	@RequestMapping("formSave")
	public void formSave(){
		ActionValues values=getValues(false);
		if(values.isNotEmpty("id")){
			dictManager.toUpate(values);
		}else{
		    dictManager.toInsert(values);
		}
	}
	
	@RequestMapping("formDelete")
	public void formDelete(){
		ActionValues values=getValues(false);
		if(values.isNotEmpty("id")){
			dictManager.update("delete from sys_dict_info where id=:id or parent=:id", values);
		}
		
	}
	
	/**
	 * 判断字典是否存在
	 * @return
	 */
	@ResponseBody
	@RequestMapping("exist")
	public String exist(){
		ActionValues values=getValues(false);
		if(values.isNotEmpty("id")&&!"0".equals(values.getStr("id"))){//假如id不为空就不用验证
			return "true";
		}else{
			ResultValues rvs=dictManager.getResult("select * from sys_dict_info where name=:name", values);
			if(null!=rvs){
				return "false";
			}
		}
		return "true";
	}
	
	
}
