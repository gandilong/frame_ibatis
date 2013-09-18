package com.thang.activiti;

import static org.junit.Assert.assertEquals;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:activiti.cfg.xml")
public class MyProcessTest {

	@Rule
	@Autowired
	public ActivitiRule activitiRule;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	
	
	
	@Deployment(resources="com/thang/activiti/my-process.bpmn20.xml")
	public void ruleUsageExample(){
		RuntimeService runtimeService=activitiRule.getRuntimeService();
		
		runtimeService.startProcessInstanceByKey("my-process");
		
		TaskService taskService=activitiRule.getTaskService();
		Task task=taskService.createTaskQuery().singleResult();
		assertEquals("Activiti is awesome!",task.getName());
		
		taskService.complete(task.getId());
		assertEquals(0,runtimeService.createProcessInstanceQuery().count());
	}
	
	@Test
	@Deployment(resources="com/thang/activiti/my-process.bpmn20.xml")
	public void PrintMessageTest(){
      //RuntimeService runtimeService=activitiRule.getRuntimeService();
		
		runtimeService.startProcessInstanceByKey("hello");
		
		//TaskService taskService=activitiRule.getTaskService();
	}
}
