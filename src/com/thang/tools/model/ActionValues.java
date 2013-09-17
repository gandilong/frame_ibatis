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
    
    @SuppressWarnings("unchecked")
	public ActionValues(HttpServletRequest request){
		String name=null;
		Enumeration<String> paramNames=request.getParameterNames();
		Enumeration<String> attrNames=request.getAttributeNames();
		
		while(paramNames.hasMoreElements()){
			name=paramNames.nextElement();
			if(name.startsWith("org.springframework")||name.equals("characterEncodingFilter.FILTERED")||name.equals("shiroFilter.FILTERED")||name.equals("roles.FILTERED")){//过滤spring参数
				continue;
			}
			if(request.getParameterValues(name).length>1){
				put(name, request.getParameterValues(name));
			}else{
				put(name, request.getParameter(name));	
			}
		}
		
		while(attrNames.hasMoreElements()){
			name=attrNames.nextElement();
			if(name.startsWith("org.springframework")||name.equals("characterEncodingFilter.FILTERED")||name.equals("shiroFilter.FILTERED")||name.equals("roles.FILTERED")){//过滤spring参数
				continue;
			}
			put(name,request.getAttribute(name));
		}
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

    public void generPage(){
    	if(0==size()){
    		put("fpage", "on");
    	}else{
    		Page p=new Page();
    		p.setOrder(getStr("order"));
    		p.setOrderBy(getStr("sort"));
    		p.setPageSize(getInt("rows"));
    		p.setPageNow(getInt("page"));
    		put("fpage", p);
    	}
    }
    
}
