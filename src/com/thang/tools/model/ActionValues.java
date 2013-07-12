/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thang.tools.model;

import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class ActionValues extends HashMap<String,Object>{
    
    private static final long serialVersionUID=1L;
    
    public ActionValues(){}
    
    public ActionValues(Map<String,Object> values){
        this.putAll(values);
    }
    
    public String getStr(String key){
        if(null!=get(key)){
            return String.valueOf(get(key));
        }
        return null;
    }
    
    public boolean isNotEmpty(String key){
        Object obj=get(key);
        if(null!=obj&&!"".equals(String.valueOf(obj).trim())){
             return true;
        }
        return false;
    }
    
    public boolean isNotNull(String key){
        if(null!=get(key)){
            return true;
        }
        return false;
    }
}
