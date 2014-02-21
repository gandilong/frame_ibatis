package com.thang.tools.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.thang.service.system.SLogManager;
import com.thang.tools.auth.ShiroUser;
import com.thang.tools.model.Action;
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
		
		if(obj instanceof Action){
			String uri=request.getRequestURI().toLowerCase();
			ActionValues values=((Action) obj).getValues()==null?new ActionValues():((Action) obj).getValues();
			ShiroUser user=SystemUtils.getUser();
			values.put("operator", "id="+user.getId()+";loginName="+user.getLoginName()+";userName="+user.getUserName());
			values.put("action", uri);
			values.put("time",DateUtils.getSystime());
			slogManager.insert("insert into sys_slog_info(id,operator,action,time)values(0,:operator,:action,:time) ", values);
		}
		
		return true;
	}

}
