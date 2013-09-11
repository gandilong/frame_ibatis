/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thang.tools.model;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author gandilong
 */
public class ActionValues extends HashMap<String,Object>{
    
    private static final long serialVersionUID=1L;
    
    public ActionValues(){super();}
    
    public ActionValues(Map<String,Object> values){
        this.putAll(values);
    }
    
    public String getStr(String key){
        if(null!=get(key)){
            return String.valueOf(get(key));
        }
        return null;
    }
    
    public int getInt(String key){
    	if(isNotEmpty(key)){
    		return Integer.parseInt(String.valueOf(get(key)));
    	}
    	return -1;
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
    
    @SuppressWarnings("unchecked")
    public static ActionValues parseRequest(HttpServletRequest request){
    	ActionValues values=new ActionValues();
    	
    	String name=null;
    	Enumeration<String> paramNames=request.getParameterNames();
    	while(paramNames.hasMoreElements()){
    		name=paramNames.nextElement();
    		if(name.contains("org.springframework")){
    			continue;
    		}
    		values.put(name, request.getParameter(name));
    	}
    	
    	Enumeration<String> attrNames=request.getAttributeNames();
    	while(attrNames.hasMoreElements()){
    		name=attrNames.nextElement();
    		if(name.contains("org.springframework")){
    			continue;
    		}
    		values.put(name, request.getAttribute(name));
    	}
    	
    	return values;
    }
}
