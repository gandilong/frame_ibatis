/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thang.tools.model;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.thang.tools.util.ModelUtils;

/**
 *
 * @author gandilong
 */
public class ActionValues extends HashMap<String,Object>{
    
    private static final long serialVersionUID=1L;
    
    private boolean page=false;//默认不分页
    
    public ActionValues(){
    	super();
    }
    
    public ActionValues(Object obj){
        String[] fieldNames=ModelUtils.getFields(obj.getClass());
        try{
            for(String fieldName:fieldNames){
        	    this.put(fieldName,BeanUtils.getProperty(obj, fieldName)==null?"":BeanUtils.getProperty(obj, fieldName));
            }
        }catch(Exception e){
        	e.printStackTrace();
        }
    }
    
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
			}else{//不加，空对象和空字符串
				if(null!=request.getParameter(name)&&!"".equals(request.getParameter(name).trim())){
					put(name, request.getParameter(name));	
				}
			}
		}
		
		while(attrNames.hasMoreElements()){
			name=attrNames.nextElement();
			if(name.startsWith("org.springframework")||name.equals("characterEncodingFilter.FILTERED")||name.equals("shiroFilter.FILTERED")||name.equals("roles.FILTERED")){//过滤spring参数
				continue;
			}
			if(null!=request.getAttribute(name)&&!"".equals(String.valueOf(request.getAttribute(name)).trim())){
				put(name,request.getAttribute(name));	
			}
		}
	}
    
    public void add(String key,Object obj){
    	this.put(key, obj);
    }
    
    @Deprecated
    public void addValues(Object obj){
    	 String[] fieldNames=ModelUtils.getFields(obj.getClass());
         try{
             for(String fieldName:fieldNames){
            	 if(null!=BeanUtils.getProperty(obj, fieldName)&&!"".equals(BeanUtils.getProperty(obj, fieldName).trim())){
            		 this.put(fieldName,BeanUtils.getProperty(obj, fieldName));
            	 }
             }
         }catch(Exception e){
         	e.printStackTrace();
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
    
    public long getLong(String key){
    	if(isNotEmpty(key)){
    		return Long.parseLong(String.valueOf(get(key)));
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

    public boolean isPage(){
    	return page;
    }

    /**
     * 打开分页功能，默认打开
     */
	public void openPage() {
		page=true;
	}
	
	/**
     * 关闭分页功能，默认打开
     */
	public void offPage(){
		page=false;
	}
	
    
}
