package com.thang.tools.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.thang.service.system.SLogManager;
import com.thang.tools.auth.ShiroUser;
import com.thang.tools.model.ActionValues;
import com.thang.tools.util.DateUtils;
import com.thang.tools.util.SystemUtils;

/**
 * 记录系统日志
 * @author gandilong
 *
 */
public class LogInterceptor implements HandlerInterceptor{

	@Autowired
	private SLogManager slogManager;
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception ex)
			throws Exception {
		
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView mv) throws Exception {
		
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object obj) throws Exception {
		
		String uri=request.getRequestURI().toLowerCase();
		
		if(logAction(uri)){//只有需要执行Action的请求，才会被拦截
			ActionValues values=new ActionValues(request);
			ShiroUser user=SystemUtils.getUser();
			if(null!=user){
				values.put("operator", "ID="+user.getId()+"\t账号="+user.getLoginName()+"\t姓名="+user.getUserName());
				values.put("action", analyzeAction(uri));
				values.put("time",DateUtils.getSystime());
				slogManager.insert("insert into sys_slog_info(id,operator,action,time)values(0,:operator,:action,:time) ", values);
			}
		}
		
		return true;
	}
	
	private boolean logAction(String uri){
		if(uri.endsWith("web/header")){
			return false;
		}
		return true;
	}
	
	private String analyzeAction(String uri){
		String action=null;
		if(uri.endsWith("web/system/user/login")){
			action="登陆系统";
		}else if(uri.endsWith("web/system/user/logout")){
			action="退出系统";
		}else if(uri.endsWith("web/system")){
			action="系统管理";
		}else if(uri.endsWith("web/system/slog/list")){
			action="查看系统日志";
		}else if(uri.endsWith("web/system/user/list")){
			action="查看系统用户";
		}else if(uri.endsWith("web/system/role/list")){
			action="查看系统角色";
		}else if(uri.endsWith("web/system/resource/list")){
			action="查看系统资源";
		}else if(uri.endsWith("web/system/dict/list")){
			action="查看系统字典";
		}else{
			action=uri;
		}
		
		return action;
	}

}
