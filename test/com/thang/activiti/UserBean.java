package com.thang.activiti;

import org.activiti.engine.RuntimeService;
import org.springframework.transaction.annotation.Transactional;

public class UserBean {

	
	private RuntimeService runtimeService;

	
	
	
	 @Transactional
	  public void hello() {
	    // here you can do transactional stuff in your domain model
	    // and it will be combined in the same transaction as 
	    // the startProcessInstanceByKey to the Activiti RuntimeService
	    runtimeService.startProcessInstanceByKey("helloProcess");
	  }
	  
	
	
	
	
	
	
	public RuntimeService getRuntimeService() {
		return runtimeService;
	}

	public void setRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}
	
}
