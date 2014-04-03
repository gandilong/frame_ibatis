/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thang.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thang.tools.model.Action;

/**
 * 索引Action
 * @author gandilong
 */
@Controller
public class IndexAction extends Action{
    
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	/**
	 * 头部页面
	 * @return
	 */
	@RequestMapping("/header")
	public String header(){
		return "header";
	}
	
	/**
	 * 系统主页面
	 * @return
	 */
    @RequestMapping("/main")
    public String main(){
        return "main";
    }
    
    /**
	 * 系统管理的索引页面
	 * @return
	 */
	@RequestMapping("/system")
	public String system(){
		return "system/system";
	}
    
	/**
	 * 项目应用管理模块的索引页面
	 * @return
	 */
    @RequestMapping("/application")
    public String project(){
        return "application/application";
    }
    
    @RequestMapping("/users")
    public String users(){
    	return "common/users";
    }
}
