package com.thang.tools.util;

import java.lang.reflect.Field;

import com.thang.tools.mate.Column;
import com.thang.tools.mate.Primary;

public class ModelUtils {

	/**
	 * 得到实体对象中指定字段名字
	 * @param cls
	 * @return
	 */
    public static String getField(Class<?> cls,String name){
    	String filedName=null;
    	try{
    	    filedName=cls.getDeclaredField(name).getName();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		return filedName;
	}
    
    /**
	 * 得到实体实体中的主键
	 * @param cls
	 * @return
	 */
    public static String getPrimaryKey(Class<?> cls){
    	Field[] fields=cls.getDeclaredFields();
    	for(Field field:fields){
    		if(field.isAnnotationPresent(Primary.class)){
    			String column=field.getAnnotation(Primary.class).value();
    			if(null!=column&&!"".equals(column.trim())){
    				return column;
    			}
    			return field.getName();
    		}
    	}
		return null;
	}
	
    /**
	 * 得到实体对象中，每个字段的名字
	 * @param cls
	 * @return
	 */
	public static String[] getFields(Class<?> cls){
		Field[] fields=cls.getDeclaredFields();
		String[] strs=new String[fields.length];
		try{
			int i=0;
			for(Field field:fields){
				strs[i++]=field.getName();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return strs;
	}
	
	/**
	 * 得到实体对象中，每个字段所以应的列名
	 * @param cls
	 * @return
	 */
	public static String[] getColumns(Class<?> cls){
		Field[] fields=cls.getDeclaredFields();
		String[] strs=new String[fields.length];
		try{
			int i=0;
			for(Field field:fields){
				if(field.isAnnotationPresent(Column.class)){
					strs[i++]=field.getAnnotation(Column.class).value();
				}else{
				    strs[i++]=field.getName();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return strs;
	}
	
}
