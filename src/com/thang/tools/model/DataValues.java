/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thang.tools.model;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.beanutils.BeanUtils;


/**
 *
 * @author Administrator
 */
public class DataValues extends HashMap<String,Object>{
    
    private static final long serialVersionUID=1L;
    
    
    /**
     * 用自己的属性和值生成一个实体对象实例，
     * @param t
     * @return
     */
    public <T>T covertToBean(Class<T> t){
    	T obj=null;
    	try{
    	    obj=t.newInstance();
    	    BeanUtils.copyProperties(obj, this);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return obj;
    }
    
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
    
    private String upperFirstCase(String str){
        if(null==str||"".equals(str)){
            return "";
        }
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
    
}
