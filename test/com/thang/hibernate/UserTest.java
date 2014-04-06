package com.thang.hibernate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.thang.service.system.UserManager;
import com.thang.tools.model.ActionValues;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath:SpringContext.xml"})  
@Transactional 
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)  
public class UserTest {

	
	@Autowired 
    private UserManager userService;  
	
	@Test
	public void insert(){
		ActionValues values=new ActionValues();
		userService.insert("insert into t_user_info(:user_name,:login_name,:login_pass)values('管理员','admin','000000')", values);
	}
	
}
