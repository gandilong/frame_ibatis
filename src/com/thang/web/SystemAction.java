package com.thang.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thang.tools.model.Action;

@Controller
@RequestMapping("system")
public class SystemAction extends Action{

	
	/**
	 * 系统介绍
	 * @return
	 */
	@RequestMapping("about")
	public String about(){
		return "system/about";
	}
	
	/**
	 * 联系方式
	 * @return
	 */
	@RequestMapping("contact")
	public String contact(){
		return "system/contact";
	}
	
}
