package com.thang.web.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thang.tools.model.Action;

@Controller
@RequestMapping("application/person")
public class PersonAction extends Action{

	
	@RequestMapping("list")
	public String list(){
		return "application/person/list";
	}
	
}
