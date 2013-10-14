package com.thang.tools.filter;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.thang.entity.system.SLog;
import com.thang.executor.DBExecutor;
import com.thang.tools.auth.ShiroUser;
import com.thang.tools.util.SystemUtils;
import com.thang.utils.lang.DateUtils;

public class SLogFilter implements Filter {

	private static Properties pros=null;
	private static DBExecutor dbe=null;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		ShiroUser user=SystemUtils.getUser();
		String uri=req.getRequestURI().toLowerCase();
		
		StringBuilder logContent=new StringBuilder();
		SLog slog=new SLog();
		slog.setTime(DateUtils.getSystime());
		
		if(uri.contains("slog")){
			filterChain.doFilter(request, response);
			return;
		}
		
		if(uri.contains("system")){
			logContent.append("系统管理:");
            if(uri.contains("user")){
            	logContent.append("用户管理");
            }else if(uri.contains("role")){
            	logContent.append("角色管理");
            }else if(uri.contains("resource")){
            	logContent.append("资源管理");
            }
		}else if(uri.contains("thang")){
			logContent.append("应用模块");
		}else if(uri.contains("client")){
			logContent.append("前端模块");
		}
		
		
		if(uri.contains("save")){
			slog.setAction("保存或更新"+logContent);
		}else if(uri.contains("delete")){
			slog.setAction("删除"+logContent);
		}else if(uri.contains("list")){
			slog.setAction("查看"+logContent);
		}else if(uri.contains("login")){
			slog.setAction("登陆系统");
		}else if(uri.contains("logout")){
			slog.setAction("退出系统");
		}else{
			filterChain.doFilter(request, response);
			return;
		}
		
		slog.setOperator(user.getId()+":"+user.getUserName());
		dbe.insert(slog);
        filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		try{
			pros=new Properties();
			pros.clear();
		    pros.load(SLogFilter.class.getClassLoader().getResourceAsStream("dbconfig.properties"));
		    pros.setProperty("driverClassName", pros.getProperty("jdbc.driverClassName"));
		    pros.setProperty("url", pros.getProperty("jdbc.url"));
		    pros.setProperty("username", pros.getProperty("jdbc.username"));
		    pros.setProperty("password", pros.getProperty("jdbc.password"));
		    DataSource dataSource=BasicDataSourceFactory.createDataSource(pros);
		    dbe=new DBExecutor(dataSource,"mysql");
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	/**
	 * Constructor of the object.
	 */
	public SLogFilter() {
		super();
	}

	@Override
	public void destroy() {
		dbe=null;
		pros.clear();
		pros=null;
	}


}
