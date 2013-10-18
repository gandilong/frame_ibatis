package com.thang.tools.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class ConfigUtils {
	
    private static Properties props = null;    
    private static File configFile = null; 
    private static long fileLastModified = 0L; 
    
    private static String configFileName = "system.properties";
    
    private static void init() { 
        URL url = ConfigUtils.class.getClassLoader().getResource(configFileName); 
        configFile = new File(url.getFile()); 
        fileLastModified = configFile.lastModified();      
        props = new Properties(); 
        load(); 
    } 
    
    private static void load() { 
        try { 
            props.load(new FileInputStream(configFile)); 
            fileLastModified = configFile.lastModified(); 
        } catch (IOException e) {            
            throw new RuntimeException(e); 
        } 
    } 

    public static String getConfig(String key) { 
        if ((configFile == null) || (props == null)) init(); 
        if (configFile.lastModified() > fileLastModified) load(); 
        return props.getProperty(key); 
    } 
    
    public static String getConfig(String configFileName,String key){
        URL url = ConfigUtils.class.getClassLoader().getResource(configFileName); 
        File config = new File(url.getFile()); 
        Properties properties = new Properties();
        try{
            properties.load(new FileInputStream(config)); 
        }catch (IOException e) {            
            e.printStackTrace();
        } 
        return properties.getProperty(key); 
    }
    
    public static void main(String[] args){
        System.out.println(getConfig("region.code")); 
    }
}