/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thang.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author gandilong
 */
@Controller
public class IndexAction {
    
    @RequestMapping("/index")
    public String index(){
        return "main";
    }
    
}
