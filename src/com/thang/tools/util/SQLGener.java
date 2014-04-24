package com.thang.tools.util;

import com.thang.entity.client.Info;
import com.thang.tools.mate.Table;
import com.thang.tools.model.ActionValues;

public class SQLGener {

	
	/**
	 * 生成新增语句
	 * @param cls
	 * @return
	 */
	public static String insertSQL(Class<?> cls){
		StringBuilder sber=new StringBuilder();
		sber.append(" insert into ");
		sber.append(cls.getAnnotation(Table.class).value());
		sber.append("(");
		sber.append(StrUtils.join(ModelUtils.getColumnNames(cls),","));
		sber.append(")values(");
		sber.append(":"+StrUtils.join(ModelUtils.getColumnNames(cls),",:"));
		sber.append(")");
		return sber.toString();
	}
	
	/**
	 * 生成删除语句
	 * @return
	 */
	public static String deleteSQL(Class<?> cls,long id){
		StringBuilder sber=new StringBuilder();
		sber.append(" delete from ");
		sber.append(cls.getAnnotation(Table.class).value());
		sber.append(" where ");
		sber.append(ModelUtils.getPrimaryKey(cls));
		sber.append("=");
		sber.append(id);
		return sber.toString();
	}
	
	/**
	 * 生成删除语句
	 * @return
	 */
	public static String deleteSQL(Class<?> cls,String id){
		StringBuilder sber=new StringBuilder();
		sber.append(" delete from ");
		sber.append(cls.getAnnotation(Table.class).value());
		sber.append(" where ");
		sber.append(ModelUtils.getPrimaryKey(cls));
		sber.append("='");
		sber.append(id);
		sber.append("'");
		return sber.toString();
	}
	
	/**
	 * 生成删除语句
	 * @return
	 */
	public static String deleteSQL(Class<?> cls,ActionValues values){
		StringBuilder sber=new StringBuilder();
		sber.append(" delete from ");
		sber.append(cls.getAnnotation(Table.class).value());
		sber.append(" where id='");
		sber.append("'");
		return sber.toString();
	}
	
	public static String updateSQL(Class<?> cls,ActionValues values){
		return null;
	}
	
	public static String selectSQL(Class<?> cls){
		return null;
	}
	
	public static String selectSQL(Class<?> cls,long id){
		return null;
	}
	
	public static String selectSQL(Class<?> cls,String id){
		return null;
	}
	
	public static String selectSQL(Class<?> cls,ActionValues values){
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(insertSQL(Info.class));
	}
}
