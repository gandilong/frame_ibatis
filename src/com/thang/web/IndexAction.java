/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thang.web;

/**
 *
 * @author Administrator
 */
@Controller
public class IndexAction {
    
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    
}
