package com.thang.tools.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class MybatisGener {

	private static Configuration cfg=null;
	private static File templateDir=new File("config/template");
	static{
		System.out.println(templateDir.getAbsolutePath());
		cfg=new Configuration();
		try {
			cfg.setDirectoryForTemplateLoading(templateDir);
			cfg.setObjectWrapper(new DefaultObjectWrapper());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void gener(Class<?> cls,String dir){
		
		try {
			Template template=cfg.getTemplate("mybatis.ftl");
			
			Map<String,Object> values=new HashMap<String,Object>();
			
			//values.put("fileds",Arrays.asList(ModelUtils.getFields(cls)));
			values.put("id", ModelUtils.getPrimaryKey(cls));
			values.put("fields",cls.getFields());
			values.put("fieldNames", ModelUtils.getFieldNames(cls));
			values.put("fieldNamesNoID", ModelUtils.getFieldNamesNoID(cls));
			values.put("columnNames", ModelUtils.getColumnNames(cls));
			values.put("tableName", ModelUtils.getTableName(cls));
			values.put("dir", dir);
			values.put("namespace",dir+"."+cls.getSimpleName().toLowerCase());
			
			values.put("addUnderLine", new com.thang.tools.model.AddUnderLine());
			
			Writer out=new OutputStreamWriter(System.out);
			template.process(values, out);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File entity_dir=new File("src/com/thang/entity/system");
		System.out.println(entity_dir.getAbsolutePath());
		String[] list=entity_dir.list();
		for(String f:list){
			if(f.endsWith(".java")&&"User.java".equals(f)){
				try{
				    gener(Class.forName("com.thang.entity.system."+f.substring(0,f.indexOf("."))),"system");
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
         // gener(Reception.class,"system");
	}

}
