package com.thang.tools.task;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;


public class StartUp implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext arg0) throws ServletException {
		System.out.println("======================================");
		System.out.println("=========      启动系统...      =======");
		System.out.println("======================================");
		//new Task();
	}

}
