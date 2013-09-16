package com.thang.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("system")
public class SystemAction {

	@RequestMapping
	public String system(){
		return "system/system";
	}
	
	@RequestMapping("about")
	public String about(){
		return "system/about";
	}
	
	@RequestMapping("contact")
	public String contact(){
		return "system/contact";
	}
	
}
