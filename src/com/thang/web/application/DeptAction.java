package com.thang.web.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thang.service.application.DeptManager;
import com.thang.service.application.PersonManager;
import com.thang.tools.model.Action;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.ResultValues;

@Controller
@RequestMapping("application/dept")
public class DeptAction extends Action{

	@Autowired
	private DeptManager deptManager;
	
	@Autowired
	private PersonManager personManager;
	
	@RequestMapping("list")
	public String list(){
		return "application/dept/list";
	}
	
	@RequestMapping("tree")
	public void tree(){
		ActionValues values=getValues();
		ResultValues result=deptManager.queryTop();
		
		values.put("parent", result.getInt("id"));
		List<ResultValues> subResult=deptManager.querySub(values);
		
		
		List<ResultValues> persons=null;
		for(ResultValues rv:subResult){
			persons=personManager.queryResult("select title from t_person_info where dept=:id", rv);
			rv.put("children", persons);
		}
		
		result.put("children", subResult);
		
		printObjectAsList(result);
	}
	
	@RequestMapping("form")
	public String form(){
		return "application/dept/form";
	}
	
}
