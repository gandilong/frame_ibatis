package com.thang.tools.model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.thang.tools.util.JsonUtils;

public class Action {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private ActionValues values;
	private MultipartFile[] files;
	
	/**
	 * 初始化Action
	 * @param request
	 * @param response
	 * @param model
	 * @param fils
	 */
	@ModelAttribute
	public void init(HttpServletRequest request,HttpServletResponse response,@RequestParam(required=false) MultipartFile[] fils,Model model){
		this.request=request;
		this.response=response;
		this.values=new ActionValues(request);
		
		if(null!=fils&&fils.length>0){
			this.files=fils;
		}
		
		model.addAttribute("values", values);
		response.setContentType("text/html;charset=UTF-8");
		
	}
	
	/**
	 * 输出字符串
	 * @param msg
	 */
	protected void print(Object msg){
		PrintWriter out=null;
		try{
			out=response.getWriter();
			out.print(msg);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
	
	/**
	 * 以Json格式输出参数
	 * @param obj
	 */
	protected void printJSON(Object obj){
		PrintWriter out=null;
		try{
			out=response.getWriter();
			out.print(JsonUtils.toJsonStr(obj));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
	
	/**
	 * 以keyName为键名，以obj为键值，返回Json对象
	 * @param keyName
	 * @param obj
	 */
    protected void printJSON(String keyName,Object obj){
		PrintWriter out=null;
		try{
			out=response.getWriter();
			out.print(JsonUtils.toJsonStr(keyName, obj));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
    
    public HttpServletRequest getRequest() {
		return request;
	}
    
    public HttpServletResponse getResponse() {
		return response;
	}
    
    /**
     * 得到前台参数对象
     * @param page
     * @return
     */
    public ActionValues getValues() {
		return values;
	}
    
    /**
     * 得到前台参数对象
     * @param page
     * @return
     */
    public ActionValues getValues(boolean page) {
    	if(page){
    	    values.openPage();
    	}
		return values;
	}
    
    /**
     * 得到上传文件
     * @return
     */
    public MultipartFile[] getFiles() {
		return files;
	}
	
}
