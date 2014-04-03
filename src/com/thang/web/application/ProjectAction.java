package com.thang.web.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thang.service.application.ProjectManager;
import com.thang.tools.model.Action;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.ResultValues;

@Controller
@RequestMapping("application/project")
public class ProjectAction extends Action{

	@Autowired
	private ProjectManager projectManager;
	
	@RequestMapping("list")
	public String list(){
		return "application/project/list";
	}
	
	@RequestMapping("listData")
	public void listData(){
		ActionValues values=getValues(true);
		List<ResultValues> projects=projectManager.query(values);
		printJSON(projects);
	}
	
	@RequestMapping("form")
	public String form(){
	    return "application/project/form";
	}
	
}
