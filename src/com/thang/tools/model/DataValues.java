/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thang.tools.model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.beanutils.BeanUtils;

import com.thang.tools.util.StrUtils;


/**
 *
 * @author gandilong
 */
public class DataValues extends HashMap<String,Object>{
    
    private static final long serialVersionUID=1L;
    
    /**
     * 获得字符串形式的值
     * @param key
     * @return
     */
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
    
    /**
     * 用自己的属性和值生成一个实体对象实例，
     * @param t
     * @return
     */
    public <T>T covertToBean(Class<T> t){
    	T obj=null;
    	try{
    	    obj=t.newInstance();
    	    Field[] fields=t.getDeclaredFields();
    	    for(Field field:fields){
    	    	BeanUtils.setProperty(obj, field.getName(),getStr(StrUtils.dropUnderline(field.getName())));	
    	    }
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return obj;
    }
    
    /**
     * 把所有Key去掉下划线
     */
    public void formatKey(){
        DataValues result=null;
        if(size()>0){
            result=new DataValues();
            Iterator<String> it=keySet().iterator();
            String key=null;
            while(it.hasNext()){
                key=it.next();
                result.put(convertToPropertyName(key),get(key));
            }
            clear();
            putAll(result);
        }
    }
    
    /**
     * 去掉下划线
     * @param name
     * @return
     */
    public String convertToPropertyName(String name){
        name=name.toLowerCase();
        String[] str=name.split("\\_");
        int size=str.length;
        for(int i=0;i<size;i++){
            if(0==i){
                name=str[i];
            }else{
                name=name+upperFirstCase(str[i]);
            }
        }
        return name;
    }
    
    /**
     * 首字母转大写
     * @param str
     * @return
     */
    private String upperFirstCase(String str){
        if(null==str||"".equals(str)){
            return "";
        }
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
    
}
