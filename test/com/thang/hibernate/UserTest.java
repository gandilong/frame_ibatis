package com.thang.hibernate;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.thang.service.system.UserManager;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath:SpringContext.xml"})  
@Transactional 
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)  
public class UserTest {

	
	@Autowired 
    private UserManager userService;  
	
	
}
