package com.thang.tools.util;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
	
    private static Properties props = null;    
    private static String dir="config";
    
    static{
    	/**
    	 * 得到config文件夹下所有property文件
    	 */
    	props = new Properties();
    	File config_dir=new File(dir);
    	if(config_dir.isDirectory()){
    		File[] fs=config_dir.listFiles(new FileFilter(){
				@Override
				public boolean accept(File f) {
					if(f.exists()&&f.isFile()&&f.getName().endsWith(".properties")){
						return true;
					}
					return false;
				}
    			
    		});
    		
    		
    		/**
    		 * 加载数据到props里
    		 */
    		try{
    			FileInputStream fis=null;
    		    for(File f:fs){
    		    	fis=new FileInputStream(f);
    			    props.load(fis);
    			    fis.close();
        	    }
    		}catch(IOException e){
				 e.printStackTrace();
			}
        	
    	}
    }
    

    public static String getConfig(String key) { 
        return props.getProperty(key); 
    } 
    
    
    public static void main(String[] args){
        getConfig("region.code"); 
    }
}