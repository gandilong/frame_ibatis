package com.thang.service.system;

import org.springframework.stereotype.Component;

import com.thang.entity.system.User;
import com.thang.tools.dao.Dao;
import com.thang.tools.model.ActionValues;

@Component
public class UserManager extends Dao{

	
	public User login(String login_name,String login_pass){
		ActionValues values=new ActionValues();
		values.put("login_name", login_name);
		values.put("login_pass", login_pass);
		return getSqlSession().selectOne("system.user.login", values);
	}
	
}
