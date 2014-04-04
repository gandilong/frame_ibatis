package com.thang.web.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thang.service.application.PersonManager;
import com.thang.tools.model.Action;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.ResultValues;

@Controller
@RequestMapping("application/person")
public class PersonAction extends Action{

	
	@Autowired
	private PersonManager personManager;
	
	@RequestMapping("list")
	public String list(){
		return "application/person/list";
	}
	
	@RequestMapping("listData")
	public void listData(){
		ActionValues values=getValues();
		List<ResultValues> result=personManager.query(values);
		printJSON(result);
	}
	
	@RequestMapping("form")
	public String form(){
		return "application/person/form";
	}
	
}
