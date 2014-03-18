package com.thang.tools.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截非法请求
 * @author gandilong
 *
 */
public class WebInterceptor implements HandlerInterceptor{

	private long startTime=0;
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception exce)
			throws Exception {
		System.out.println("\n请求路径："+request.getRequestURI());
		System.out.println("执行时间消耗:"+(System.currentTimeMillis()-startTime)+" 毫秒");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView modelView) throws Exception {
		
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		startTime=System.currentTimeMillis();
		return true;
	}

}
