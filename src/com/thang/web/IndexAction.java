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
	
	@RequestMapping("/header")
	public String header(){
		return "header";
	}
	
    @RequestMapping("/main")
    public String main(){
        return "main";
    }
    
}
