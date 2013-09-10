/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thang.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thang.service.system.TestManager;
import com.thang.tools.model.DataValues;

/**
 *
 * @author gandilong
 */
@Controller
public class TestAction {
    
	@Autowired
	TestManager testManager;
    
	@RequestMapping("/test")
    public void test(){
    	DataValues data=testManager.getTest(1);
    	System.out.println(data.get("name"));
    }
    
    
}
