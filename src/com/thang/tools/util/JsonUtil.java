/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thang.tools.util;

/**
 *
 * @author Administrator
 */
public class JsonUtil {
    
    private static ObjectMapper mapper=null;
    
    public static String jsonObject(Object obj){
        try{
            return getMapperInstance(false).writeValueAsString(obj);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static void jsonObject(Object obj,HttpServletResponse response){
        try{
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out=response.getWriter();
            getMapperInstance(false.writeValue(out,obj);
            if(null!=out){
                out.close();
            }
        }catch(Exception e){
            e.printStackTrace();
            if(null!=out){
                out.close();
            }
        }
    }
    
    public static Object objectJson(String json,Class<?> cls){
         Object obj=null;
         try{
             obj=getMapperInstance(false).readValue(json,cls);
         }catch(Exception e){
             e.printStackTrace();
         }
    }
    
    public static synchronized ObjectMapper getMapperInstance(boolean isNew){
        if(isNew){
            return new ObjectMapper();
        }else if(null==mapper){
            mapper=new ObjectMapper();
        }
        return mapper;
    }
    
}
