package com.thang.activiti;

import org.activiti.engine.RepositoryService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Startup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext applicationContext =   new ClassPathXmlApplicationContext("activiti.cfg.xml");
		
		applicationContext.start();
		
		RepositoryService repositoryService = (RepositoryService) applicationContext.getBean("repositoryService");
		String deploymentId = repositoryService
		  .createDeployment()
		  .addClasspathResource("com/thang/activiti/MyProcess.bpmn")
		  .deploy()
		  .getId();

		
		UserBean userBean = (UserBean) applicationContext.getBean("userBean");
		userBean.hello();
		
		System.out.println(deploymentId);
		
	}

}
